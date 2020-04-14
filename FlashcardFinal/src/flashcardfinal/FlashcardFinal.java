/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcardfinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class FlashcardFinal extends javax.swing.JFrame {

    Flashcard aCard;
    Flashcard userMarkedCard;
    String line;
    FileSystem fs;
    Path pathToFile;
    String selectedFile;
    InputStream cardln = null;
    BufferedReader cardReader;
    JFileChooser saveChooser = new JFileChooser();
    File saveFile = null;
    File displayFile = null;
    ArrayList<Flashcard> displayCards = new ArrayList<Flashcard>();
    ArrayList<Flashcard> saveCards = new ArrayList<Flashcard>();
    ArrayList<Flashcard> markedCards = new ArrayList<Flashcard>();
    int index = 0;
    int index2 = 0;

    /**
     * Creates new form FlashcardFinal
     */
    //Count the indices of commas in the given string and return them as an arraylist
    public ArrayList<Integer> countCommaIndex(String string) {
        //create arraylist
        ArrayList<Integer> commaList = new ArrayList<>();
        //loop through characters
        for (int x = 0; x < string.length(); x++) {
            //if current character is a comma
            if (Character.toString(string.charAt(x)).equals(",")) {
                //add the current index
                commaList.add(x);
            }
        }
        //return arraylist
        return commaList;
    }

    //removes commas from the given string
    public String removeCommas(String string) {
        //create temporary string builder
        StringBuilder tempString = new StringBuilder(string);
        //loop through characters.
        for (int x = 0; x < tempString.length(); x++) {
            //if the current character is a comma
            if (Character.toString(tempString.charAt(x)).equals(",")) {
                //remove it
                tempString.replace(x, x + 1, "");
                //reduce index by one to retain consistency
                x -= 1;
            }
        }
        //convert stringBuilder to string
        string = tempString.toString();
        //return string sans commas
        return string;
    }

    //add commas to the given string given the positions of them in period-separated format
    public String addCommas(String string, String commaString) {
        try {
            //split string at periods
            String commaIndicesAsString[] = commaString.split("\\.");
            //create arraylist.
            ArrayList<Integer> commaIndicesAsInt = new ArrayList<Integer>();
            //convert string arraylist to int arraylist
            for (int x = 0; x < commaIndicesAsString.length; x++) {
                commaIndicesAsInt.add(Integer.parseInt(commaIndicesAsString[x]));
            }
            //create temporary stringbuilder
            StringBuilder tempString = new StringBuilder(string);
            //add commas at their respective positions
            for (int x = 0; x < commaIndicesAsInt.size(); x++) {
                tempString.insert(commaIndicesAsInt.get(x).intValue(), ',');
            }
            //convert stringbuilder to string
            string = tempString.toString();
            //ignore NumberFormatExceptions.
        } catch (NumberFormatException nfe) {

        }
        //return string with commas added
        return string;
    }

    //show the record at the current index of Display Cards
    public void showRecord() {
        TextAreaField.setText(displayCards.get(index).getTerm());
        this.TermLabel.setText("Card # " + (index + 1));
    }

    public void showMarkedRecord() {
        markedTextArea.setText(markedCards.get(index2).getTerm());
        this.markedTermLabel.setText("Card # " + (index2 + 1));
    }

    public void updateRecord() {
        saveCards.add(new Flashcard(termField.getText(), defField.getText()));

    }

    public void markCard() {
        userMarkedCard.setTerm(displayCards.get(index).getTerm());
        userMarkedCard.setDefinition(displayCards.get(index).getDefinition());
        markedCards.add(userMarkedCard);
    }

    public void viewMarkedCards() {
        try {

            //read the file
            while ((line = cardReader.readLine()) != null) {
                String data[] = line.split(",");

                try {

                } catch (NumberFormatException numberFormatException) {
                }
            }//end of while

            cardln.close();
        } catch (IOException ex) {
            System.out.println("Cannont open " + pathToFile.getFileName());
            System.exit(1);
        }
        showMarkedRecord();
    }

    public void writeToFile() {
        String outputLine = "";

        try {
            FileWriter fileOut = new FileWriter(saveFile);

            for (int x = 0; x < saveCards.size(); x++) {
                outputLine = String.format("%s,%s\n", saveCards.get(x).getTerm(), saveCards.get(x).getDefinition());
                fileOut.write(outputLine);
            }
            fileOut.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Cannot write flashcards\n" + ex.getMessage(), "File IO Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public FlashcardFinal() {
        initComponents();
        this.TermLabel.setText("Card # " + (index + 1));
        this.setTitle("Flashcards");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MarkedCardPanel = new javax.swing.JTabbedPane();
        displayPanel = new javax.swing.JPanel();
        displayCardPanel = new javax.swing.JPanel();
        TermLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaField = new javax.swing.JTextArea();
        prevButton = new javax.swing.JButton();
        nextCard = new javax.swing.JButton();
        chooseDisplay = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        currentDisplayFileField = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        markCurrentButton = new javax.swing.JButton();
        savePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        termField = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        defField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cardAddButton = new javax.swing.JButton();
        chooseButton = new javax.swing.JButton();
        saveListButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        saveListTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        currentSaveFileField = new javax.swing.JTextArea();
        MarkedCardsPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        markedTextArea = new javax.swing.JTextArea();
        markedNextButton = new javax.swing.JButton();
        markedPrevButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        markedTermLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayPanelMouseClicked(evt);
            }
        });

        TermLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TermLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TermLabel.setText("Card #1");

        TextAreaField.setEditable(false);
        TextAreaField.setColumns(20);
        TextAreaField.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TextAreaField.setLineWrap(true);
        TextAreaField.setRows(5);
        TextAreaField.setWrapStyleWord(true);
        TextAreaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextAreaFieldMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TextAreaField);

        prevButton.setText("Previous Card");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextCard.setText("Next Card");
        nextCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextCardActionPerformed(evt);
            }
        });

        chooseDisplay.setText("Choose File for Displayed Cards");
        chooseDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDisplayActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Left-Click for Definition, Right-Click for term!");

        currentDisplayFileField.setEditable(false);
        currentDisplayFileField.setColumns(20);
        currentDisplayFileField.setLineWrap(true);
        currentDisplayFileField.setRows(5);
        currentDisplayFileField.setWrapStyleWord(true);
        jScrollPane5.setViewportView(currentDisplayFileField);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Current FIle");

        markCurrentButton.setText("Mark Current Card");
        markCurrentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markCurrentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayCardPanelLayout = new javax.swing.GroupLayout(displayCardPanel);
        displayCardPanel.setLayout(displayCardPanelLayout);
        displayCardPanelLayout.setHorizontalGroup(
            displayCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TermLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(displayCardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooseDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(displayCardPanelLayout.createSequentialGroup()
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(markCurrentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextCard, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        displayCardPanelLayout.setVerticalGroup(
            displayCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayCardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TermLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(displayCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(markCurrentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(displayCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextCard, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayCardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayCardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MarkedCardPanel.addTab("Flashcard Display", displayPanel);

        termField.setColumns(20);
        termField.setLineWrap(true);
        termField.setRows(5);
        termField.setWrapStyleWord(true);
        jScrollPane1.setViewportView(termField);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Term");

        defField.setColumns(20);
        defField.setLineWrap(true);
        defField.setRows(5);
        defField.setWrapStyleWord(true);
        jScrollPane3.setViewportView(defField);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Definition");
        jLabel2.setToolTipText("");

        cardAddButton.setText("Add Card to List");
        cardAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardAddButtonActionPerformed(evt);
            }
        });

        chooseButton.setText("Choose File");
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
            }
        });

        saveListButton.setText("Save List to File");
        saveListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveListButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Created Cards");

        saveListTextArea.setEditable(false);
        saveListTextArea.setColumns(20);
        saveListTextArea.setLineWrap(true);
        saveListTextArea.setRows(5);
        saveListTextArea.setWrapStyleWord(true);
        jScrollPane4.setViewportView(saveListTextArea);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Current File");

        currentSaveFileField.setEditable(false);
        currentSaveFileField.setColumns(20);
        currentSaveFileField.setLineWrap(true);
        currentSaveFileField.setRows(5);
        currentSaveFileField.setWrapStyleWord(true);
        jScrollPane6.setViewportView(currentSaveFileField);

        javax.swing.GroupLayout savePanelLayout = new javax.swing.GroupLayout(savePanel);
        savePanel.setLayout(savePanelLayout);
        savePanelLayout.setHorizontalGroup(
            savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(savePanelLayout.createSequentialGroup()
                        .addGroup(savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chooseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cardAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)))
                    .addGroup(savePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        savePanelLayout.setVerticalGroup(
            savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(savePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(savePanelLayout.createSequentialGroup()
                        .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(savePanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        MarkedCardPanel.addTab("Create and Save Flashcards", savePanel);

        MarkedCardsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MarkedCardsPanelMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("Marked Cards");

        markedTextArea.setEditable(false);
        markedTextArea.setColumns(20);
        markedTextArea.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        markedTextArea.setRows(5);
        markedTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                markedTextAreaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(markedTextArea);

        markedNextButton.setText("Next Card");
        markedNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markedNextButtonActionPerformed(evt);
            }
        });

        markedPrevButton.setText("Previous Card");
        markedPrevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markedPrevButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Left-Click for Definition, Right-Click for term!");

        markedTermLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        markedTermLabel.setText("Card # 1");

        javax.swing.GroupLayout MarkedCardsPanelLayout = new javax.swing.GroupLayout(MarkedCardsPanel);
        MarkedCardsPanel.setLayout(MarkedCardsPanelLayout);
        MarkedCardsPanelLayout.setHorizontalGroup(
            MarkedCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MarkedCardsPanelLayout.createSequentialGroup()
                .addGroup(MarkedCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MarkedCardsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(markedPrevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(markedNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MarkedCardsPanelLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(MarkedCardsPanelLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(markedTermLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MarkedCardsPanelLayout.setVerticalGroup(
            MarkedCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MarkedCardsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(markedTermLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MarkedCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(markedPrevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(markedNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        MarkedCardPanel.addTab("Marked Cards", MarkedCardsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MarkedCardPanel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MarkedCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed
        // TODO add your handling code here:
        //initialize integer to hold user input
        int fileSelection = 0;
        //get user input
        try {
            fileSelection = saveChooser.showSaveDialog(this);
        } catch (Exception e) {

        }
        //If user approves save
        if (fileSelection == JFileChooser.APPROVE_OPTION) {
            //set saveFile to the selected file
            saveFile = saveChooser.getSelectedFile();
            if (!saveFile.getPath().substring(saveFile.getPath().lastIndexOf(".") + 1).equals("csv")) {
                JOptionPane.showMessageDialog(this, "File is not a CSV!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //If the file does not exist
            if (!saveFile.exists()) {
                //Create new file
                try {
                    saveFile.createNewFile();
                    //Obligatory catch
                } catch (IOException ex) {
                    //Error message
                    JOptionPane.showMessageDialog(this, "Couldn't create file: " + saveFile.getPath()
                            + "\nException Method:\n" + ex.getMessage(), "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            currentSaveFileField.setText(saveFile.getPath());
        } else {
            return;
        }
    }//GEN-LAST:event_chooseButtonActionPerformed

    private void displayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayPanelMouseClicked

    }//GEN-LAST:event_displayPanelMouseClicked

    private void TextAreaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextAreaFieldMouseClicked
        // TODO add your handling code here:
        if (displayCards.size() != 0) {
            if (evt.getButton() == evt.BUTTON1) {
                //this.TermLabel.setText("Definition");
                this.TextAreaField.setText(displayCards.get(index).getDefinition());

            } else if (evt.getButton() == evt.BUTTON3) {
                //this.TermLabel.setText("Term");
                this.TextAreaField.setText(displayCards.get(index).getTerm());
            }
        }
    }//GEN-LAST:event_TextAreaFieldMouseClicked

    private void chooseDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDisplayActionPerformed
        // TODO add your handling code here:
        //initialize integer to hold user input
        int fileSelection = 0;
        //get user input
        try {
            fileSelection = saveChooser.showOpenDialog(this);
        } catch (Exception e) {

        }
        //If user approves save
        if (fileSelection == JFileChooser.APPROVE_OPTION) {
            //set saveFile to the selected file
            displayFile = saveChooser.getSelectedFile();
            if (!displayFile.getPath().substring(displayFile.getPath().lastIndexOf(".") + 1).equals("csv")) {
                JOptionPane.showMessageDialog(this, "File is not a CSV!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //If the file does not exist
            if (!displayFile.exists()) {
                JOptionPane.showMessageDialog(this, "File " + displayFile.getPath() + " does not exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            currentDisplayFileField.setText(displayFile.getPath());
        } else {
            return;
        }
        try {
            //clear display cards
            displayCards.clear();
            //get selected file
            selectedFile = displayFile.toString();
            //get default filesystem
            fs = FileSystems.getDefault();
            //get path
            pathToFile = fs.getPath(selectedFile);
            //create inputstream
            cardln = Files.newInputStream(pathToFile);
            //create buffered reader
            cardReader = new BufferedReader(new InputStreamReader(cardln));

            //read the file
            while ((line = cardReader.readLine()) != null) {
                String data[] = line.split(",");
                if (data.length != 4) {
                    JOptionPane.showMessageDialog(this, "Malformed Line detected, skipping line! \nLine:\n" + line, "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                aCard = new Flashcard();

                try {
                    //if there are at least 3 data entries
                    if (data.length >= 3) {
                        //add commas
                        aCard.setTerm(addCommas(data[0], data[2]));
                        // else
                    } else {
                        //add base term
                        aCard.setTerm(data[0]);
                    }
                    //if at least 4 data entries
                    if (data.length >= 4) {
                        //add commas
                        aCard.setDefinition(addCommas(data[1], data[3]));
                        //else
                    } else {
                        //add base term
                        aCard.setDefinition(data[1]);
                    }
                    // add card to list
                    displayCards.add(aCard);

                } catch (NumberFormatException numberFormatException) {
                    //do nothing - skip the error
                    //eliminate problems with bad ids
                    //in reality you would fix this
                }
            }//end of while
            cardReader.close();
            cardln.close();
            //JOptionPane.showMessageDialog(this, "Records read = " + contactList.size());
        } catch (IOException ex) {
            System.out.println("Cannont open " + pathToFile.getFileName());
            System.exit(1);
        }
        //show first record

        //
        //
        //Additional Feature Right here 
        //
        //
        Collections.shuffle(displayCards);
        index = 0;
        showRecord();

    }//GEN-LAST:event_chooseDisplayActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        if (displayCards.size() != 0) {
            index = Math.max(index - 1, 0);
            showRecord();
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextCardActionPerformed
        // TODO add your handling code here:
        if (displayCards.size() != 0) {
            index = Math.min(index + 1, displayCards.size() - 1);
            showRecord();
        }
    }//GEN-LAST:event_nextCardActionPerformed

    private void saveListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveListButtonActionPerformed
        //if file is selected
        if (saveFile != null) {
            try {
                FileWriter fileOut = new FileWriter(saveFile, true);
                String outputLine;
                //loop through saveCards
                for (int x = 0; x < saveCards.size(); x++) {
                    //if displayFile isnt null
                    if (displayFile != null) {
                        //and both files have the same path
                        if (displayFile.getPath().equals(saveFile.getPath())) {
                            //add a copy of the card to displayCards. This avoids the card being modified when saveCards is changed later.
                            displayCards.add(new Flashcard(saveCards.get(x).getTerm(), saveCards.get(x).getDefinition()));

                            //
                            //
                            //Additional Feature Right here 
                            //
                            //
                            Collections.shuffle(displayCards);
                            index = 0;
                            showRecord();
                        }
                    }
                    //get the positions of the commas in the term
                    saveCards.get(x).setTermCommas(countCommaIndex(saveCards.get(x).getTerm()));
                    //remove commas from term
                    saveCards.get(x).setTerm(removeCommas(saveCards.get(x).getTerm()));
                    // get comma positions in definition
                    saveCards.get(x).setDefCommas(countCommaIndex(saveCards.get(x).getDefinition()));
                    // remove commas from definition
                    saveCards.get(x).setDefinition(removeCommas(saveCards.get(x).getDefinition()));
                    //create base line for output
                    outputLine = String.format("%s,%s,",
                            saveCards.get(x).getTerm(),
                            saveCards.get(x).getDefinition());
                    //if there are commas in the term
                    if (saveCards.get(x).getTermCommas().size() != 0) {
                        //loop through comma positions
                        for (int y = 0; y < saveCards.get(x).getTermCommas().size(); y++) {
                            //if current index isnt the last one
                            if (y < (saveCards.get(x).getTermCommas().size() - 1)) {
                                //add postion separated with a period
                                outputLine += saveCards.get(x).getTermCommas().get(y) + ".";
                                //else
                            } else {
                                //add position separated with a comma
                                outputLine += saveCards.get(x).getTermCommas().get(y) + ".,";
                            }
                        } // end of for
                        //else
                    } else {
                        //add comma at the end
                        outputLine += " ,";
                    }
                    //if there are some commas
                    if (saveCards.get(x).getDefCommas().size() != 0) {
                        //start of for, looping through def commas
                        for (int y = 0; y < saveCards.get(x).getDefCommas().size(); y++) {
                            //add def comma separated by period
                            outputLine += saveCards.get(x).getDefCommas().get(y) + ".";
                        }
                    }
                    if (saveCards.get(x).getDefCommas().size() == 0) {
                        outputLine += " ";
                    }
                    //add newline at the end
                    outputLine += "\n";
                    //Write the line
                    fileOut.write(outputLine);
                }
                //flush writer
                fileOut.flush();
                //close stream
                fileOut.close();
                //catch io exception
            } catch (IOException ex) {
                //error message
                JOptionPane.showMessageDialog(this, "Cannot write company file \n"
                        + ex.getMessage(), "File IO Error", JOptionPane.ERROR_MESSAGE);
            }
            //clear saveList text
            saveListTextArea.setText("");
            //clear saveCards list
            saveCards.clear();

        } else {
            //error message
            JOptionPane.showMessageDialog(this, "Please make sure you have chosen a file!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveListButtonActionPerformed

    private void MarkedCardsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkedCardsPanelMouseClicked
        if (displayCards.size() != 0) {
            if (evt.getButton() == evt.BUTTON1) {
                //this.TermLabel.setText("Definition");
                this.TextAreaField.setText(displayCards.get(index).getDefinition());

            } else if (evt.getButton() == evt.BUTTON3) {
                //this.TermLabel.setText("Term");
                this.TextAreaField.setText(displayCards.get(index).getTerm());
            }
        }

    }//GEN-LAST:event_MarkedCardsPanelMouseClicked

    private void markedNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markedNextButtonActionPerformed
        // TODO add your handling code here:
        if (markedCards.size() != 0) {
            index2 = Math.min(index2 + 1, markedCards.size() - 1);
            showMarkedRecord();
        }
    }//GEN-LAST:event_markedNextButtonActionPerformed

    private void markedPrevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markedPrevButtonActionPerformed
        // TODO add your handling code here:
        if (markedCards.size() != 0) {
            index2 = Math.max(index2 - 1, 0);
            showMarkedRecord();
        }
    }//GEN-LAST:event_markedPrevButtonActionPerformed

    private void markedTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markedTextAreaMouseClicked
        // TODO add your handling code here:
        if (markedCards.size() != 0) {
            if (evt.getButton() == evt.BUTTON1) {
                //this.TermLabel.setText("Definition");
                this.markedTextArea.setText(markedCards.get(index2).getDefinition());

            } else if (evt.getButton() == evt.BUTTON3) {
                //this.TermLabel.setText("Term");
                this.markedTextArea.setText(markedCards.get(index2).getTerm());
            }
        }
    }//GEN-LAST:event_markedTextAreaMouseClicked

    private void cardAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardAddButtonActionPerformed
        // TODO add your handling code here:
        //if a term and definition are entered
        if (!"".equals(termField.getText()) && !"".equals(defField.getText())) {
            //create new flashcard with respective text fields
            aCard = new Flashcard(termField.getText(), defField.getText());
            //add it to saveCards
            saveCards.add(aCard);
            //get the current text of the saveList text area
            String listText = saveListTextArea.getText();
            //add new card to the end of it
            listText += "Card: Term: " + aCard.getTerm() + ", Definition: " + aCard.getDefinition() + "\n";
            //set the text to new text
            saveListTextArea.setText(listText);
            //clear term field
            termField.setText("");
            //clear def field.
            defField.setText("");
        }
    }//GEN-LAST:event_cardAddButtonActionPerformed

    private void markCurrentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markCurrentButtonActionPerformed
        // TODO add your handling code here:
        if (displayCards.size() > 0) {
            markedCards.add(displayCards.get(index));

            //
            //
            //Additional Feature Right here 
            //
            //
            Collections.shuffle(markedCards);
            showMarkedRecord();
        }
    }//GEN-LAST:event_markCurrentButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlashcardFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashcardFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashcardFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashcardFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashcardFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane MarkedCardPanel;
    private javax.swing.JPanel MarkedCardsPanel;
    private javax.swing.JLabel TermLabel;
    private javax.swing.JTextArea TextAreaField;
    private javax.swing.JButton cardAddButton;
    private javax.swing.JButton chooseButton;
    private javax.swing.JButton chooseDisplay;
    private javax.swing.JTextArea currentDisplayFileField;
    private javax.swing.JTextArea currentSaveFileField;
    private javax.swing.JTextArea defField;
    private javax.swing.JPanel displayCardPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton markCurrentButton;
    private javax.swing.JButton markedNextButton;
    private javax.swing.JButton markedPrevButton;
    private javax.swing.JLabel markedTermLabel;
    private javax.swing.JTextArea markedTextArea;
    private javax.swing.JButton nextCard;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton saveListButton;
    private javax.swing.JTextArea saveListTextArea;
    private javax.swing.JPanel savePanel;
    private javax.swing.JTextArea termField;
    // End of variables declaration//GEN-END:variables
}
