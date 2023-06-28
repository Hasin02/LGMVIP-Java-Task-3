import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private JButton equalsButton, decimalButton, clearButton, deleteButton;
    private JButton sinButton, cosButton, tanButton, logButton, sqrtButton, piButton;
    private JButton degreeButton, radianButton;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean isDegreeMode = true;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[6];
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        decimalButton = new JButton(".");
        clearButton = new JButton("C");
        deleteButton = new JButton("DEL");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        sqrtButton = new JButton("sqrt");
        piButton = new JButton("π");
        degreeButton = new JButton("Degree");
        radianButton = new JButton("Radian");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = equalsButton;
        functionButtons[5] = piButton;

        JButton[] scientificButtons = {sinButton, cosButton, tanButton, logButton, sqrtButton};

        for (JButton button : scientificButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.addActionListener(this);
        }

        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
        }

        decimalButton.setFont(new Font("Arial", Font.BOLD, 20));
        decimalButton.addActionListener(this);
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.addActionListener(this);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteButton.addActionListener(this);
        degreeButton.setFont(new Font("Arial", Font.BOLD, 12));
        degreeButton.addActionListener(this);
        radianButton.setFont(new Font("Arial", Font.BOLD, 12));
        radianButton.addActionListener(this);

        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(sqrtButton);
        panel.add(clearButton);
        panel.add(deleteButton);
        panel.add(divideButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(piButton);
        panel.add(degreeButton);
        panel.add(radianButton);

        setLayout(new BorderLayout());
        add(inputField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                inputField.setText(inputField.getText().concat(String.valueOf(i)));
            }
        }
        if (source == decimalButton) {
            inputField.setText(inputField.getText().concat("."));
        }
        if (source == addButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '+';
            inputField.setText("");
        }
        if (source == subtractButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '-';
            inputField.setText("");
        }
        if (source == multiplyButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '*';
            inputField.setText("");
        }
        if (source == divideButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '/';
            inputField.setText("");
        }
        if (source == equalsButton) {
            num2 = Double.parseDouble(inputField.getText());

            switch (operator) {
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

            inputField.setText(String.valueOf(result));
        }
        if (source == clearButton) {
            inputField.setText("");
        }
        if (source == deleteButton) {
            String currentText = inputField.getText();
            if (!currentText.isEmpty()) {
                inputField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
        if (source == sinButton) {
            double value = Double.parseDouble(inputField.getText());
            if (isDegreeMode) {
                value = Math.toRadians(value);
            }
            double result = Math.sin(value);
            inputField.setText(String.valueOf(result));
        }
        if (source == cosButton) {
            double value = Double.parseDouble(inputField.getText());
            if (isDegreeMode) {
                value = Math.toRadians(value);
            }
            double result = Math.cos(value);
            inputField.setText(String.valueOf(result));
        }
        if (source == tanButton) {
            double value = Double.parseDouble(inputField.getText());
            if (isDegreeMode) {
                value = Math.toRadians(value);
            }
            double result = Math.tan(value);
            inputField.setText(String.valueOf(result));
        }
        if (source == logButton) {
            double value = Double.parseDouble(inputField.getText());
            double result = Math.log10(value);
            inputField.setText(String.valueOf(result));
        }
        if (source == sqrtButton) {
            double value = Double.parseDouble(inputField.getText());
            double result = Math.sqrt(value);
            inputField.setText(String.valueOf(result));
        }
        if (source == piButton) {
            inputField.setText(String.valueOf(Math.PI));
        }
        if (source == degreeButton) {
            isDegreeMode = true;
            degreeButton.setEnabled(false);
            radianButton.setEnabled(true);
        }
        if (source == radianButton) {
            isDegreeMode = false;
            radianButton.setEnabled(false);
            degreeButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScientificCalculator();
            }
        });
    }
}
