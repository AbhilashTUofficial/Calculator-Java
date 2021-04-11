package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements Variables, ActionListener {

    long num1 = 0;
    long num2 = 0;
    char operator = ' ';
    String value;
    int numStartIndex = 0;
    JFrame win;
    JFrame help;
    JPanel inputPanel = new JPanel();
    TextField resultDisplay;
    JButton[] numBtn = new JButton[10];
    JButton[] funcBtn = new JButton[11];
    JButton QBtn, clearAllBtn, signBtn, clrBtn, divBtn, mulBtn, subBtn, addBtn, equalBtn, decBtn;

    Main() {
        /************************** Frame Section ******************************/
        win = new JFrame("Calculator");
        win.setBounds(300, 100, windowWidth, windowHeight);
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setLayout(null);
        win.setAlwaysOnTop(true);

        /************************* Display Section *****************************/
        resultDisplay = new TextField();
        resultDisplay.setBounds(12, 12, resultDisplayWidth, resultDisplayHeight);
        resultDisplay.setFont(customDisplayFont);
        resultDisplay.setForeground(Color.white);
        resultDisplay.setBackground(Color.DARK_GRAY);
        resultDisplay.setEditable(false);
        resultDisplay.setFocusable(false);

        /************************* Button Section *****************************/
        clearAllBtn = new JButton("CE");
        signBtn = new JButton("+/-");
        clrBtn = new JButton("Clear");
        divBtn = new JButton("/");
        mulBtn = new JButton("x");
        subBtn = new JButton("-");
        addBtn = new JButton("+");
        equalBtn = new JButton("=");
        decBtn = new JButton(".");
        QBtn = new JButton("?");

        funcBtn[1] = divBtn;
        funcBtn[2] = mulBtn;
        funcBtn[3] = subBtn;
        funcBtn[4] = addBtn;
        funcBtn[5] = equalBtn;
        funcBtn[6] = decBtn;
        funcBtn[7] = clearAllBtn;
        funcBtn[8] = signBtn;
        funcBtn[9] = clrBtn;
        funcBtn[10] = QBtn;

        for (int i = 1; i < 11; i++) {
            funcBtn[i].addActionListener(this);
            funcBtn[i].setFont(customButtonFont);
            funcBtn[i].setForeground(Color.darkGray);
            funcBtn[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {

            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(customButtonFont);
            numBtn[i].setFocusable(false);

        }

        /********************** Input Panel Section **************************/
        inputPanel.setBounds(12, 122, resultDisplayWidth, 420);
        inputPanel.setLayout(new GridLayout(5, 4, 15, 15));
        inputPanel.add(funcBtn[7]);
        inputPanel.add(funcBtn[8]);
        inputPanel.add(funcBtn[9]);
        inputPanel.add(funcBtn[1]);

        inputPanel.add(numBtn[9]);
        inputPanel.add(numBtn[8]);
        inputPanel.add(numBtn[7]);
        inputPanel.add(funcBtn[2]);

        inputPanel.add(numBtn[6]);
        inputPanel.add(numBtn[5]);
        inputPanel.add(numBtn[4]);
        inputPanel.add(funcBtn[3]);

        inputPanel.add(numBtn[3]);
        inputPanel.add(numBtn[2]);
        inputPanel.add(numBtn[1]);
        inputPanel.add(funcBtn[4]);

        inputPanel.add(numBtn[0]);
        inputPanel.add(funcBtn[6]);
        inputPanel.add(funcBtn[10]);
        inputPanel.add(funcBtn[5]);


        win.add(resultDisplay);
        win.add(inputPanel);
        win.setVisible(true);
    }
    public void Help(){
        /************************** Frame Section ******************************/
        help = new JFrame("Calculator Help");
        help.setBounds(700, 100, 600, windowHeight);
        help.setDefaultCloseOperation(EXIT_ON_CLOSE);
        help.setResizable(false);
        help.setLayout(null);
        help.setAlwaysOnTop(true);
        help.setVisible(true);

    }


    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numBtn[i]) {
                if (resultDisplay.getText().length() < 8) {
                    resultDisplay.setText(resultDisplay.getText().concat(String.valueOf(i)));
                }
            }
        }


        /******************************** Operation Button Insert **********************************/
        if (e.getSource() == addBtn) {
            try {
                if (resultDisplay.getText().charAt(resultDisplay.getText().length() - 1) != '+') {
                    resultDisplay.setText(resultDisplay.getText().concat("+"));

                }
            } catch (Exception x) {
            }
        }
        if (e.getSource() == subBtn) {
            try {
                if (resultDisplay.getText().charAt(resultDisplay.getText().length() - 1) != '-') {
                    resultDisplay.setText(resultDisplay.getText().concat("-"));
                }
            } catch (Exception x) {
            }
        }
        if (e.getSource() == mulBtn) {
            try {
                if (resultDisplay.getText().charAt(resultDisplay.getText().length() - 1) != '*') {
                    resultDisplay.setText(resultDisplay.getText().concat("x"));

                }
            } catch (Exception x) {
            }
        }
        if (e.getSource() == divBtn) {
            try {
                if (resultDisplay.getText().charAt(resultDisplay.getText().length() - 1) != '/') {
                    resultDisplay.setText(resultDisplay.getText().concat("/"));

                }
            } catch (Exception x) {
            }
        }
        /********************************************************************************************/


        if (e.getSource() == equalBtn) {
            try {
                System.out.println(resultDisplay.getText());
                int len = resultDisplay.getText().length();
                String math = resultDisplay.getText();
                for (int i = 0; i <= len; i++) {
                    if (math.charAt(i) == '+' || math.charAt(i) == '-' || math.charAt(i) == '/' || math.charAt(i) == 'x') {
                        operator = math.charAt(i);
                        System.out.println(operator);
                        num1 = Long.parseLong(math.substring(numStartIndex, i));
                        num2 = Long.parseLong(math.substring(i + 1, len));
                        switch (operator) {
                            case '+':
                                value = String.valueOf(num1 + num2);
                                resultDisplay.setText(value);
                                break;
                            case '-':
                                value = String.valueOf(num1 - num2);
                                System.out.println(num2);
                                resultDisplay.setText(value);
                                break;

                            case '/':
                                value = String.valueOf(num1 / num2);
                                resultDisplay.setText(value);
                                break;
                            case 'x':
                                value = String.valueOf(num1 * num2);
                                resultDisplay.setText(value);
                                break;
                        }

                    }

                }
            } catch (Exception x) {

            }
        }
        if (e.getSource() == QBtn) {
            Help();

        }
        if (e.getSource() == clearAllBtn) {
            resultDisplay.setText("");

        }
        if (e.getSource() == clrBtn) {
            try {
                String str=resultDisplay.getText().substring(0,resultDisplay.getText().length()-1);
                resultDisplay.setText(str);
            } catch (Exception x) {
            }
        }

    }
}

interface Variables {
    int windowWidth = 400;
    int windowHeight = 600;
    int resultDisplayWidth = windowWidth - 40;
    int resultDisplayHeight = 100;
    Font customDisplayFont = new Font("airal", Font.BOLD, 48);
    Font customButtonFont = new Font("airal", Font.BOLD, 16);
}

