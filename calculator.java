/*
 * @author:Rohit Rokade
 * @Date:30 sept 2023
 * 
 */

import java.awt.*;
import java.awt.event.*;

public class calculator extends Frame implements ActionListener {
    TextField tf;
    double num1, num2, result;
    int operator;
    String[] operators = { "+", "-", "*", "/" };
    Button[] buttons = new Button[17];

    public calculator() {
        tf = new TextField();
        tf.setBounds(30, 40, 280, 30);
        add(tf);

        int x = 30, y = 80;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button();
            buttons[i].setBounds(x, y, 50, 50);
            buttons[i].addActionListener(this);
            add(buttons[i]);
            x += 60;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }

        buttons[0].setLabel("7");
        buttons[1].setLabel("8");
        buttons[2].setLabel("9");
        buttons[3].setLabel("/");
        buttons[4].setLabel("4");
        buttons[5].setLabel("5");
        buttons[6].setLabel("6");
        buttons[7].setLabel("*");
        buttons[8].setLabel("1");
        buttons[9].setLabel("2");
        buttons[10].setLabel("3");
        buttons[11].setLabel("-");
        buttons[12].setLabel(".");
        buttons[13].setLabel("0");
        buttons[14].setLabel("+/-");
        buttons[15].setLabel("+");
        buttons[16].setLabel("=");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setTitle("Calculator");
        setSize(350, 400);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("+")) {
            num1 = Double.parseDouble(tf.getText());
            operator = 1;
            tf.setText("");
        } else if (s.equals("-")) {
            num1 = Double.parseDouble(tf.getText());
            operator = 2;
            tf.setText("");
        } else if (s.equals("*")) {
            num1 = Double.parseDouble(tf.getText());
            operator = 3;
            tf.setText("");
        } else if (s.equals("/")) {
            num1 = Double.parseDouble(tf.getText());
            operator = 4;
            tf.setText("");
        } else if (s.equals("=")) {
            num2 = Double.parseDouble(tf.getText());
            switch (operator) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;
                default:
                    break;
            }
            tf.setText("" + result);
        } else if (s.equals("+/-")) {
            double temp = Double.parseDouble(tf.getText());
            temp *= -1;
            tf.setText("" + temp);
        } else if (s.equals(".")) {
            String temp = tf.getText();
            temp += ".";
            tf.setText(temp);
        } else {
            String temp = tf.getText();
            temp += s;
            tf.setText(temp);
        }
    }

    public static void main(String[] args) {
        new calculator();

    }
}
