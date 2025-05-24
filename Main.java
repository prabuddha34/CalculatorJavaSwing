import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton addButton, minusButton, mulButton, divButton, clrButton, dltButton, eqlButton, negButton;
    JButton numberOfButtons[] = new JButton[10];
    JButton functionOfButton[] = new JButton[8]; // should be 8 (you used only 8 functions)
    JPanel panel;
    char Operator;
    Double num1,num2,result;
    Main() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("Calculator App");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setBackground(Color.GRAY);
        textField.setEditable(false);

        addButton = new JButton("+");
        minusButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("Clr");
        dltButton = new JButton("DEL");
        eqlButton = new JButton("=");
        negButton = new JButton("(-)");

        functionOfButton[0] = addButton;
        functionOfButton[1] = minusButton;
        functionOfButton[2] = mulButton;
        functionOfButton[3] = divButton;
        functionOfButton[4] = clrButton;
        functionOfButton[5] = eqlButton;
        functionOfButton[6] = negButton;
        functionOfButton[7] = dltButton;

        for (int i = 0; i < 8; i++) {
            functionOfButton[i].addActionListener(this);
            functionOfButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberOfButtons[i] = new JButton(String.valueOf(i));
            numberOfButtons[i].addActionListener(this);
            numberOfButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));


        panel.add(numberOfButtons[1]);
        panel.add(numberOfButtons[2]);
        panel.add(numberOfButtons[3]);
        panel.add(addButton);
        panel.add(numberOfButtons[4]);
        panel.add(numberOfButtons[5]);
        panel.add(numberOfButtons[6]);
        panel.add(minusButton);
        panel.add(numberOfButtons[7]);
        panel.add(numberOfButtons[8]);
        panel.add(numberOfButtons[9]);
        panel.add(mulButton);
        panel.add(negButton);
        panel.add(numberOfButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);
        panel.setBackground(Color.BLACK);


        clrButton.setBounds(370, 100, 80, 40);
        dltButton.setBounds(370, 150, 80, 40);

        frame.add(clrButton);
        frame.add(dltButton);
        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberOfButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            Operator = '+';
            textField.setText("");
        }
        if (e.getSource() == minusButton) {
            num1 = Double.parseDouble(textField.getText());
            Operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            Operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            Operator = '/';
            textField.setText("");
        }
        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (Operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == dltButton) {
            String str = textField.getText();
            if (str.length() > 0) {
                textField.setText(str.substring(0, str.length() - 1));
            }
        }

        if (e.getSource() == negButton) {
            String str = textField.getText();
            if (!str.equals("")) {
                double temp = Double.parseDouble(str);
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        }
    }

}
