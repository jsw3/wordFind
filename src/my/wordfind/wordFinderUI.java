package my.wordfind;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoeWallace
 */
public class wordFinderUI extends javax.swing.JFrame implements ActionListener {
    
    // class variables
    static LinkedList<String> selected = new LinkedList(); // holds letters selected during the game
    static String results = ""; // to show the user the words that have been played
    static String currentSelection = ""; // displays letters selected when forming a word
    static String randomLetters = ""; // holds the string of random letters generated to form the board
    int gameCounter = 0; // how many games have been played
    int userScore = 0;
    int possibleScore = 0;
    static LinkedList<String> masterWordList = new LinkedList();
    static LinkedList<String> playedWords = new LinkedList();
    static boolean gameInProgress = false;
    static boolean[] visited = new boolean[16]; // randomLetters will always be 16 letters
    wordTrie wt = new wordTrie();
    static long startTime;
    javax.swing.Timer t = new javax.swing.Timer(1000, this); // timer to regulate the game clock
    static LinkedList<LinkedList<Integer>> adjacent = new LinkedList(); // keeps track of which squares are touching which others
    static LinkedList<Integer> currentSquares = new LinkedList<>(); // keeps track of which squares are selected
    javax.swing.JTextPane squares[] = new javax.swing.JTextPane[16]; // array to hold the JTextPane variables
    
    /** Creates new form wordFinderUI
     * @throws java.lang.Exception */
    public wordFinderUI() throws Exception {
        initComponents();
        assignSquares();
        assignAdjacent();
        setText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextPane timer = jTextPane2;
        long elapsed = (System.currentTimeMillis() - startTime);
        long elapsedSeconds = elapsed / 1000;
        long time = 180 - elapsedSeconds;
        long minute = time/60;
        long seconds = (time-(minute*60));
        timer.setText(String.format("%d", minute)+":"+String.format("%02d", seconds));
        if (timer.getText().equals("0:00")) {
            endGame();
        }
    }

    private class wordTrie {
        
        /*
        This class implements a Trie to compress all the words in the dictionary.
        It allows fast searching and retrieval.
        */
    
        private static final int R = 26;

        private final  Node root = new Node();
        private int n;
        private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        private class Node {
            private String val;
            private final Node[] next = new Node[R];
        }

        public wordTrie() throws Exception {
            createTrie();
        }

        private void createTrie() throws Exception {
            String line;
            BufferedReader bufferreader = new BufferedReader(new FileReader("src/my/wordFind/words.txt"));
            line = bufferreader.readLine();
            while (line != null) {
                put(line, root);
                line = bufferreader.readLine();
            }
        }

        private void put(String key, Node x) {

            int d = 0;
            while (d != key.length()) {
                int c = alphabet.indexOf(key.charAt(d));
                if (x.next[c] == null) {
                    x.next[c] = new Node();
                }
                x = x.next[c];
                d++;
            }
            if (x.val == null) {
                n++;
                x.val = key;
            }
        }

        private boolean contains(String word, Node x) {
            int d = 0;
            while (d != word.length()) {
                int c = alphabet.indexOf(word.charAt(d));
                if (x.next[c] != null) x = x.next[c];
                d++;
            }
            if (x.val != null) return (x.val.equals(word));
            else return false;
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane11 = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane12 = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextPane13 = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextPane14 = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane15 = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextPane16 = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextPane17 = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextPane18 = new javax.swing.JTextPane();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTextPane19 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextPane20 = new javax.swing.JTextPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextPane21 = new javax.swing.JTextPane();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 100));

        jScrollPane4.setBorder(null);

        jTextPane4.setEditable(false);
        jTextPane4.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane4.setBorder(null);
        jTextPane4.setContentType("text/html"); // NOI18N
        jTextPane4.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane4.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane4.setViewportView(jTextPane4);
        jTextPane4.getAccessibleContext().setAccessibleName("0");

        jScrollPane5.setBorder(null);

        jTextPane5.setEditable(false);
        jTextPane5.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane5.setBorder(null);
        jTextPane5.setContentType("text/html"); // NOI18N
        jTextPane5.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane5.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane5.setViewportView(jTextPane5);
        jTextPane5.getAccessibleContext().setAccessibleName("2");

        jScrollPane6.setBorder(null);

        jTextPane6.setEditable(false);
        jTextPane6.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane6.setBorder(null);
        jTextPane6.setContentType("text/html"); // NOI18N
        jTextPane6.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane6.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane6.setViewportView(jTextPane6);
        jTextPane6.getAccessibleContext().setAccessibleName("3");

        jScrollPane7.setBorder(null);

        jTextPane7.setEditable(false);
        jTextPane7.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane7.setBorder(null);
        jTextPane7.setContentType("text/html"); // NOI18N
        jTextPane7.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane7.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane7.setViewportView(jTextPane7);
        jTextPane7.getAccessibleContext().setAccessibleName("4");

        jScrollPane8.setBorder(null);

        jTextPane8.setEditable(false);
        jTextPane8.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane8.setBorder(null);
        jTextPane8.setContentType("text/html"); // NOI18N
        jTextPane8.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane8.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane8.setViewportView(jTextPane8);
        jTextPane8.getAccessibleContext().setAccessibleName("5");

        jScrollPane9.setBorder(null);

        jTextPane9.setEditable(false);
        jTextPane9.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane9.setBorder(null);
        jTextPane9.setContentType("text/html"); // NOI18N
        jTextPane9.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane9.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane9.setViewportView(jTextPane9);
        jTextPane9.getAccessibleContext().setAccessibleName("1");

        jScrollPane10.setBorder(null);

        jTextPane10.setEditable(false);
        jTextPane10.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane10.setBorder(null);
        jTextPane10.setContentType("text/html"); // NOI18N
        jTextPane10.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane10.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane10.setViewportView(jTextPane10);
        jTextPane10.getAccessibleContext().setAccessibleName("7");

        jScrollPane11.setBorder(null);

        jTextPane11.setEditable(false);
        jTextPane11.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane11.setBorder(null);
        jTextPane11.setContentType("text/html"); // NOI18N
        jTextPane11.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane11.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane11.setViewportView(jTextPane11);
        jTextPane11.getAccessibleContext().setAccessibleName("14");

        jScrollPane12.setBorder(null);

        jTextPane12.setEditable(false);
        jTextPane12.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane12.setBorder(null);
        jTextPane12.setContentType("text/html"); // NOI18N
        jTextPane12.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane12.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane12.setViewportView(jTextPane12);
        jTextPane12.getAccessibleContext().setAccessibleName("9");

        jScrollPane13.setBorder(null);

        jTextPane13.setEditable(false);
        jTextPane13.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane13.setBorder(null);
        jTextPane13.setContentType("text/html"); // NOI18N
        jTextPane13.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane13.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane13.setViewportView(jTextPane13);
        jTextPane13.getAccessibleContext().setAccessibleName("15");

        jScrollPane14.setBorder(null);

        jTextPane14.setEditable(false);
        jTextPane14.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane14.setBorder(null);
        jTextPane14.setContentType("text/html"); // NOI18N
        jTextPane14.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane14.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane14.setViewportView(jTextPane14);
        jTextPane14.getAccessibleContext().setAccessibleName("11");

        jScrollPane15.setBorder(null);

        jTextPane15.setEditable(false);
        jTextPane15.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane15.setBorder(null);
        jTextPane15.setContentType("text/html"); // NOI18N
        jTextPane15.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane15.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane15.setViewportView(jTextPane15);
        jTextPane15.getAccessibleContext().setAccessibleName("10");

        jScrollPane16.setBorder(null);

        jTextPane16.setEditable(false);
        jTextPane16.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane16.setBorder(null);
        jTextPane16.setContentType("text/html"); // NOI18N
        jTextPane16.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane16.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane16.setViewportView(jTextPane16);
        jTextPane16.getAccessibleContext().setAccessibleName("12");

        jScrollPane17.setBorder(null);

        jTextPane17.setEditable(false);
        jTextPane17.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane17.setBorder(null);
        jTextPane17.setContentType("text/html"); // NOI18N
        jTextPane17.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane17.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane17.setViewportView(jTextPane17);
        jTextPane17.getAccessibleContext().setAccessibleName("8");

        jScrollPane18.setBorder(null);

        jTextPane18.setEditable(false);
        jTextPane18.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane18.setBorder(null);
        jTextPane18.setContentType("text/html"); // NOI18N
        jTextPane18.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane18.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane18.setViewportView(jTextPane18);
        jTextPane18.getAccessibleContext().setAccessibleName("13");

        jScrollPane19.setBorder(null);

        jTextPane19.setEditable(false);
        jTextPane19.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane19.setBorder(null);
        jTextPane19.setContentType("text/html"); // NOI18N
        jTextPane19.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jTextPane19.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p>\n    </p>\n  </body>\n</html>\n");
        jTextPane19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectLetters(evt);
            }
        });
        jScrollPane19.setViewportView(jTextPane19);
        jTextPane19.getAccessibleContext().setAccessibleName("6");

        jButton1.setText("Submit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitSelection(evt);
            }
        });

        jButton2.setText("Reset letters");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unselectLetters(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane1.setContentType("text/html"); // NOI18N
        jTextPane1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jButton3.setText("Start");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startGame(evt);
            }
        });

        jButton4.setText("Stop");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopGame(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(238, 238, 238));
        jScrollPane2.setBorder(null);

        jTextPane2.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(jTextPane2);

        jScrollPane3.setBorder(null);

        jTextPane3.setEditable(false);
        jTextPane3.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane3.setBorder(null);
        jTextPane3.setContentType("text/html"); // NOI18N
        jScrollPane3.setViewportView(jTextPane3);

        jScrollPane20.setBackground(new java.awt.Color(238, 238, 238));
        jScrollPane20.setBorder(null);

        jTextPane20.setEditable(false);
        jTextPane20.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane20.setBorder(null);
        jTextPane20.setContentType("text/html"); // NOI18N
        jScrollPane20.setViewportView(jTextPane20);

        jScrollPane21.setBackground(new java.awt.Color(238, 238, 238));
        jScrollPane21.setBorder(null);

        jTextPane21.setEditable(false);
        jTextPane21.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane21.setBorder(null);
        jTextPane21.setContentType("text/html"); // NOI18N
        jScrollPane21.setViewportView(jTextPane21);

        jButton5.setText("All Possible Words");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayResults(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jScrollPane20))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4)))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void assignSquares() {
        //assign the squares to "squares" array
        squares[0] = jTextPane4;
        squares[1] = jTextPane9;
        squares[2] = jTextPane5;
        squares[3] = jTextPane6;
        squares[4] = jTextPane7;
        squares[5] = jTextPane8;
        squares[6] = jTextPane19;
        squares[7] = jTextPane10;
        squares[8] = jTextPane17;
        squares[9] = jTextPane12;
        squares[10] = jTextPane15;
        squares[11] = jTextPane14;
        squares[12] = jTextPane16;
        squares[13] = jTextPane18;
        squares[14] = jTextPane11;
        squares[15] = jTextPane13;
    }
    
    private void assignAdjacent() {
        
        //create vertices, an array of arrays with buffers
        int[][] vertices = new int[6][6];
        for (int i = 0; i < 6; i++) {
            vertices[0][i] = -1;
            vertices[5][i] = -1;
        }
        for (int i = 1; i < 5; i++) {
            vertices[i][0] = -1;
            vertices[i][(vertices[i].length-1)] = -1;
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                vertices[i][j] = ((i-1)*4) + (j-1);
            }
        }
        //now populate adjacent
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int v1 = vertices[i-1][j-1];
                int v2 = vertices[i-1][j+1];
                int v3 = vertices[i-1][j];
                int v4 = vertices[i+1][j-1];
                int v5 = vertices[i+1][j+1];
                int v6 = vertices[i+1][j];
                int v7 = vertices[i][j-1];
                int v8 = vertices[i][j+1];
                int[] potential = {v1, v2, v3, v4, v5, v6, v7, v8};
                LinkedList<Integer> next_to = new LinkedList<>();
                for (int k : potential) {
                    if (k != -1) next_to.add(k);
                }
                adjacent.add(next_to);
            }
        }
    }
    
    private void setText() {
        
        // This method is called in the constructor to set up the game board. It is also called at the start of a new game.
        
        String[] cubes = {"AAEEGN", "ELRTTY", "AOOTTW", "ABBJOO", "EHRTVW", "CIMOTU", "DISTTY", "EIOSST", "DELRVY", "ACHOPS", "HIMNQU", "EEINSU", "EEGHNW", "AFFKPS", "HLNNRZ", "DEILRX"};
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            int index = r.nextInt(16);
            String a1 = cubes[i];
            cubes[i] = cubes[index];
            cubes[index] = a1;
        }
        // make sure that the variable randomLetters is reset
        randomLetters = "";
        for (String cube : cubes) {
            int index = r.nextInt(6);
            randomLetters = randomLetters + cube.charAt(index);
        }
        for (int i = 0; i < 16; i++) {
            char c = randomLetters.toCharArray()[i];
            squares[i].setText("<html><p style=\"margin-top:35; margin-left:45; font-family: Lucida Grande; font-size:20pt\">"+c+"</p></html>");
            String name = String.valueOf(c);
            squares[i].getAccessibleContext().setAccessibleName(String.format("%d", i));
        }
        JTextPane timer = jTextPane2;
        timer.setText("3:00");
        
        findWords(); // this searches the trie, using adjacent, for all possible words in the randomLetters string
    }
    
    private void selectLetters(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectLetters
        
        // This method controls the selection of letters by the user.
        // It makes sure the selection is legal.
        if (gameInProgress) {
            JTextPane selectionWindow = jTextPane20;
            JTextPane tp = (JTextPane)evt.getSource();
            int square = Integer.valueOf(tp.getAccessibleContext().getAccessibleName());
            String letter = String.valueOf(randomLetters.toCharArray()[square]);
            Color c1 = new Color(238,238,238);
            Color c2 = new Color(251,51,51);
            Color background = tp.getBackground();
            if (currentSelection.equals("")) {
                if (background.equals(c1)) {
                    tp.setBackground(c2);
                    selected.add(letter);
                    currentSquares.add(square);
                    currentSelection = currentSelection + letter;
                    selectionWindow.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\">Selected: "+currentSelection+"</p></html>");
                }
            }
            else if (!currentSelection.equals("")) {
                int previousSquare = currentSquares.get(currentSquares.size()-1);
                if (isAdjacent(previousSquare, square)) {
                    if (background.equals(c1)) {
                    tp.setBackground(c2);
                    selected.add(letter);
                    currentSquares.add(square);
                    currentSelection = currentSelection + letter;
                    selectionWindow.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\">Selected: "+currentSelection+"</p></html>");
                    }
                }
            }
        }
    }//GEN-LAST:event_selectLetters

    private boolean isAdjacent(int a, int b) {
        return adjacent.get(a).contains(b);
    }
    
    private void submitSelection(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitSelection
        
        String word = "";
        for (String s : selected) {
            word = word + s;
        }
        JTextPane j = jTextPane1;
        JTextPane error = jTextPane3;
        // Test the submitted word. If it's a word, add to results; if not, display an error message
        if (wt.contains(word.toLowerCase(), wt.root)) {
            if (!playedWords.contains(word)) {
                playedWords.add(word);
                results = results + word + "<br>";
                j.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\">"+results+"</p></html>");
            } else {
                error.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\">"+word+" has already been played</p></html>");
                
            }
        } else {
            error.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\">"+word+" is not a word</p></html>");
        }
    }//GEN-LAST:event_submitSelection
        
    private void unselectLetters(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unselectLetters
        
        Color c = new Color(238, 238, 238);
        for (JTextPane j : squares) {
            j.setBackground(c);
        }
        selected.clear();
        currentSelection = "";
        JTextPane clearWindow = jTextPane20;
        clearWindow.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\"></p></html>");
        JTextPane e = jTextPane3;
        e.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\"></p></html>");
    }//GEN-LAST:event_unselectLetters

    private void startGame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startGame
        
        // This method starts a new game. It uses the timer to display the game clock, which counts down from 3 minutes.
        if (gameInProgress == false) gameInProgress = true;
        gameCounter++;
        JTextPane j1 = jTextPane3;
        JTextPane j2 = jTextPane20;
        JTextPane j3 = jTextPane21;
        j1.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\"></p></html>");
        j2.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\"></p></html>");
        j3.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\"></p></html>");
        
        Color c = new Color(238, 238, 238);
        for (JTextPane j : squares) {
            j.setBackground(c);
        }
        
        userScore = 0;
        possibleScore = 0;
        JTextPane timer = jTextPane2;
        timer.setText("3:00");
        JTextPane words = jTextPane1;
        results = "";
        words.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\"></p></html>");
        if (gameCounter > 1) setText();
        startTime = System.currentTimeMillis();
        t.start();
    }//GEN-LAST:event_startGame

    private void stopGame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopGame
        endGame();
    }//GEN-LAST:event_stopGame
    
    private void displayResults(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayResults
        
        // When the "All Possible Words" button is pressed, display all possible words
        JTextPane display = jTextPane21;
        Collections.sort(masterWordList);
        String allWords = "";
        for (String word : masterWordList) {
            allWords = allWords + word + "<br>";
        }
        display.setText("<html><p style=\"font-family: Lucida Grande; font-size:14pt\">"+allWords+"</p></html>");
    }//GEN-LAST:event_displayResults

    private void endGame() {
        
        gameInProgress = false;
        t.stop();
        JTextPane displayScore = jTextPane3;
        // The code below calculates and displays the user's score and the potential score
        // Scores: 3/4 letters = 1; 5 letters = 2; 6 letters = 3; 7 letters = 5; 8 or more letters = 11;
        playedWords.forEach((word) -> {
            if (word.length() <= 4) userScore += 1;
            else if (word.length() == 5) userScore += 2;
            else if (word.length() == 6) userScore += 3;
            else if (word.length() == 7) userScore += 5;
            else if (word.length() >= 8) userScore += 11;
        });
        masterWordList.forEach((word) -> {
            if (word.length() <= 4) possibleScore += 1;
            else if (word.length() == 5) possibleScore += 2;
            else if (word.length() == 6) possibleScore += 3;
            else if (word.length() == 7) possibleScore += 5;
            else if (word.length() >= 8) possibleScore += 11;
        });
        String score1;
        String score2;
        score1 = String.valueOf(userScore);
        score2 = String.valueOf(possibleScore);
        displayScore.setText("<html><p style=\"margin-top:35; margin-left:45; font-family: Lucida Grande; font-size:13pt\">Your score: "+score1+"<br>Possible score: "+score2+"</p></html>");
    }
    
    private boolean isPrefix(String prefix) {
        int d = 0;
        wordFinderUI.wordTrie.Node r = wt.root;
        while (d < prefix.length()) {
            int c = wt.alphabet.indexOf(String.valueOf(prefix.charAt(d)));
            r = r.next[c];
            if (r == null) return false;
            d++;
        }
        return true;
    }
    
    private void findWords() {
        
        // This method cycles through every combination of letters, using the LinkedList called "adjacent." 
        // If a prefix is not valid, the code breaks and starts searching the next possible combination.
        String lw = randomLetters.toLowerCase();
        for (int i = 0; i < 16; i++) {
            String prefix = String.valueOf(lw.charAt(i));
            visited[i] = true;
            for (int vertex: adjacent.get(i)) {
                prefix = prefix + String.valueOf(lw.charAt(vertex));
                if (isPrefix(prefix)) {
                    visited[vertex] = true;
                    recurseWords(prefix, vertex);
                    visited[vertex] = false;
                }
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
    }
    
    private void recurseWords(String prefix, int vertex) {
        
        // This a recursive helper method for findWords
        String lw = randomLetters.toLowerCase();
        if (wt.contains(prefix, wt.root) && prefix.length() > 2) {
            if (!masterWordList.contains(prefix)) masterWordList.add(prefix);
        }
        for (int val : adjacent.get(vertex)) {
            if (visited[val] == false) {
                prefix = prefix + String.valueOf(lw.charAt(val));
                if (isPrefix(prefix)) {
                    visited[val] = true;
                    recurseWords(prefix, val);
                    prefix = prefix.substring(0, prefix.length()-1);
                    visited[val] = false;
                } else prefix = prefix.substring(0, prefix.length()-1);
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new wordFinderUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(wordFinderUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane11;
    private javax.swing.JTextPane jTextPane12;
    private javax.swing.JTextPane jTextPane13;
    private javax.swing.JTextPane jTextPane14;
    private javax.swing.JTextPane jTextPane15;
    private javax.swing.JTextPane jTextPane16;
    private javax.swing.JTextPane jTextPane17;
    private javax.swing.JTextPane jTextPane18;
    private javax.swing.JTextPane jTextPane19;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane20;
    private javax.swing.JTextPane jTextPane21;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    // End of variables declaration//GEN-END:variables

}
