package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements Variables, ActionListener {

    long num1=0;
    long num2=0;
    char operator= ' ';
    int opIndex;
    int numStartIndex=0;
    JFrame win;
    JPanel inputPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
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

    public int calc(int n1,int n2,int i){

        return n1;
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
        if (e.getSource() == addBtn) {
            try {
                if (resultDisplay.getText().charAt(resultDisplay.getText().length() - 1) != '+') {
                    opIndex=resultDisplay.getText().length();
                    System.out.println(resultDisplay.getText().indexOf('+'));
                    num1= Long.parseLong(resultDisplay.getText().substring(0,resultDisplay.getText().indexOf('+')-1));
                    resultDisplay.setText(resultDisplay.getText().concat("+"));
                    System.out.println(num1);

                }
            } catch (Exception x) {
            }
        }
        if (e.getSource() == clearAllBtn) {
            resultDisplay.setText("");

        }
        if (e.getSource() == clrBtn) {
            try {
                System.out.println(resultDisplay.getText().charAt(resultDisplay.getText().length()-1));
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

