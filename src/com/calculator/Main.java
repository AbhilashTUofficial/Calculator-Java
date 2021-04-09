package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        new Window();
    }
}
interface Variables {
    int windowWidth=400;
    int windowHeight=800;
    int resultDisplayWidth=windowWidth-40;
    int resultDisplayHeight=100;
    int normBtnSize=86;
}
class Window extends JFrame implements ActionListener,Variables{
    Window(){
        /************************** Frame Section ******************************/
        setBounds(300,100,windowWidth,windowHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(new GridLayout(7,0));
        setAlwaysOnTop(true);
        /***********************************************************************/
        add(new Display());
        add(new LayerOne());
        add(new LayerTwo());
        add(new LayerThree());
        add(new LayerFour());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
class Display extends JPanel implements Variables{
    TextField resultDisplay;
    Display(){
        /************************* Display Screen ******************************/
        setFont(new Font("Arial",Font.BOLD,48));
        setForeground(Color.WHITE);
        resultDisplay=new TextField();
        resultDisplay.setBackground(Color.DARK_GRAY);
        resultDisplay.setPreferredSize(new Dimension(resultDisplayWidth,resultDisplayHeight));
        resultDisplay.setText("0");
        add(resultDisplay);

        /***********************************************************************/
    }
}
class LayerOne extends JPanel implements Variables{
    Button numC,numSign, numDel, numDiv;
    LayerOne(){
        /************************* Number Buttons ******************************/
        setFont(new Font("Arial",Font.BOLD,18));
        setForeground(Color.GRAY);
        numC=new Button("C");
        numSign=new Button("+/-");
        numDel =new Button("Del");
        numDiv =new Button("/");
        numC.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        numSign.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        numDel.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        numDiv.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        /***********************************************************************/
        add(numC);
        add(numSign);
        add(numDel);
        add(numDiv);
    }
}
class LayerTwo extends JPanel implements Variables{
    Button num1, num2, num3, numMultiply;
    LayerTwo(){
        /************************* Number Buttons ******************************/
        setFont(new Font("Arial",Font.BOLD,18));
        setForeground(Color.GRAY);
        num1 =new Button("1");
        num2 =new Button("2");
        num3 =new Button("3");
        numMultiply =new Button("X");
        num1.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        num2.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        num3.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        numMultiply.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        /***********************************************************************/
        add(num1);
        add(num2);
        add(num3);
        add(numMultiply);
    }
}
class LayerThree extends JPanel implements Variables{
    Button num4, num5, num6, numDivide;
    LayerThree(){
        /************************* Number Buttons ******************************/
        setFont(new Font("Arial",Font.BOLD,18));
        setForeground(Color.GRAY);
        num4 =new Button("4");
        num5 =new Button("5");
        num6 =new Button("6");
        numDivide =new Button("-");
        num4.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        num5.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        num6.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        numDivide.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        /***********************************************************************/
        add(num4);
        add(num5);
        add(num6);
        add(numDivide);
    }
}
class LayerFour extends JPanel implements Variables{
    Button num1, num2, num3, numMultiply;
    LayerFour(){
        /************************* Number Buttons ******************************/
        setFont(new Font("Arial",Font.BOLD,18));
        setForeground(Color.GRAY);
        num1 =new Button("1");
        num2 =new Button("2");
        num3 =new Button("3");
        numMultiply =new Button("X");
        num1.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        num2.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        num3.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        numMultiply.setPreferredSize(new Dimension(normBtnSize,normBtnSize));
        /***********************************************************************/
        add(num1);
        add(num2);
        add(num3);
        add(numMultiply);
    }
}