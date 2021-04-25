import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame jFrame = new JFrame();

    JPanel jPanel_Title = new JPanel();
    JPanel jPanel_Button = new JPanel();

    JPanel jPanel_Button_Again = new JPanel();

    JLabel textfield = new JLabel();

    JButton[] jButtons = new JButton[9];

    JButton again = new JButton();

    boolean playerOneTurns;
    boolean playerTwoTurns;

    // Constructor for the object
    TicTacToe() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 800);
        jFrame.getContentPane().setBackground(Color.green);
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        textfield.setBackground(Color.darkGray);
        textfield.setForeground(Color.blue);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC TAC TOE");
        textfield.setOpaque(true);

        jPanel_Title.setLayout(new BorderLayout());
        jPanel_Title.setBounds(0, 0, 100, 100);

        jPanel_Button.setLayout(new GridLayout(3, 3));
        jPanel_Button.setBackground(new Color(25, 25, 25));

        //again.setSize(100,100);
        //again.setBackground(new Color(25, 25, 25));
        //again.setSize(100, 100);

        // For loop for the buttons as we have array for the elements
        for (int i = 0; i < 9; i++) {
            jButtons[i] = new JButton();
            jPanel_Button.add(jButtons[i]);
            jButtons[i].setFont(new Font("MV Bolt", Font.BOLD, 80));
            jButtons[i].setFocusable(false);
            jButtons[i].addActionListener(this);
        }

        jPanel_Title.add(textfield);

        jFrame.add(jPanel_Title, BorderLayout.NORTH);

        jFrame.add(jPanel_Button);
        //jFrame.add(again);

        // Which Player will be first
        firstMove();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == jButtons[i]) {
                if (playerOneTurns) {
                    if (jButtons[i].getText() == "") {
                        jButtons[i].setForeground(new Color(255, 0, 0));
                        jButtons[i].setText("X");
                        playerOneTurns = false;
                        textfield.setText("O Turn");

                        // check if we have winner in the game
                        check();
                    }
                } else {
                    jButtons[i].setForeground(new Color(0, 0, 255));
                    jButtons[i].setText("O");
                    playerOneTurns = true;
                    textfield.setText("X Turn");

                    check();
                }
            }

        }

    }

    // Who will play first x or o?!
    public void firstMove() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            playerOneTurns = true;
            textfield.setText("X Turn");
        } else {
            playerTwoTurns = true;
            textfield.setText("O Turn");
        }

    }

    public void check() {

        // check X with condition
        if ((jButtons[0].getText() == "X") && (jButtons[1].getText() == "X") && (jButtons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((jButtons[3].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((jButtons[6].getText() == "X") && (jButtons[7].getText() == "X") && (jButtons[9].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((jButtons[0].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((jButtons[2].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        if ((jButtons[0].getText() == "X") && (jButtons[3].getText() == "X") && (jButtons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((jButtons[0].getText() == "X") && (jButtons[3].getText() == "X") && (jButtons[6].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((jButtons[0].getText() == "X") && (jButtons[3].getText() == "X") && (jButtons[6].getText() == "X")) {
            xWins(2, 5, 8);
        }

        // check o with condition
        if ((jButtons[0].getText() == "O") && (jButtons[1].getText() == "O") && (jButtons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if ((jButtons[3].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((jButtons[6].getText() == "O") && (jButtons[7].getText() == "O") && (jButtons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((jButtons[0].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((jButtons[2].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        if ((jButtons[0].getText() == "O") && (jButtons[3].getText() == "O") && (jButtons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((jButtons[0].getText() == "O") && (jButtons[3].getText() == "O") && (jButtons[6].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((jButtons[0].getText() == "O") && (jButtons[3].getText() == "O") && (jButtons[6].getText() == "O")) {
            oWins(2, 5, 8);
        }
    }

    public void xWins(int a, int b, int c) {
        jButtons[a].setBackground(Color.green);
        jButtons[b].setBackground(Color.green);
        jButtons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            jButtons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        jButtons[a].setBackground(Color.green);
        jButtons[b].setBackground(Color.green);
        jButtons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            jButtons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }

}