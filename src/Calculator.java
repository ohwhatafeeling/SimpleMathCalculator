import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, negButton, delButton, clrButton, equButton;
	JPanel panel;
	double num1, num2, result;
	char operator;
	Font myFont = new Font("Monospaced", Font.BOLD, 25);
	
	Calculator() {
		frame = new JFrame();
		frame.setTitle("Mick's Basic Calculator");
		frame.setSize(400, 550);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0xa9c6f5));
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("\u00F7");
		decButton = new JButton(".");
		negButton = new JButton("(-)");
		delButton = new JButton("del");
		clrButton = new JButton("clr");
		equButton = new JButton("=");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = negButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = equButton;
		
		for (int i = 0; i < functionButtons.length; i++ ) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50, 425, 100, 50);
		clrButton.setBounds(150, 425, 100, 50);
		equButton.setBounds(250, 425, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(new Color(0xa9c6f5));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(negButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(divButton);
		
		frame.add(textField);
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(equButton);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < numberButtons.length; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			if (!textField.getText().contains(".")) {
				textField.setText(textField.getText().concat("."));
			}
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			switch(operator) {
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
					result = num1 - num2;
					break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			textField.setText("");
		}
		if (e.getSource() == delButton) {
			String tempString = textField.getText();
			textField.setText("");
			for (int i = 0; i < tempString.length() - 1; i++) {
				textField.setText(textField.getText() + tempString.charAt(i));
			}
		}
		if (e.getSource() == negButton) {
			if (!textField.getText().isEmpty()) {
				double temp = Double.parseDouble(textField.getText());
				temp *= -1;
				textField.setText(String.valueOf(temp));
			}
		}
	}
	
}
