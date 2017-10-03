import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//calculate the sum of two numbers
public class SimpleCalculator {
	private JFrame frame;
	private JPanel panelTop;
	private JPanel panelBottom;
	private JButton calcButton;
	private JButton resetButton;
	private JTextField numText1 = new JTextField("", 10);
	private JTextField numText2 = new JTextField("", 10);
	private JLabel resultNumLabel;
	
	public static void main(String[] args) {
		SimpleCalculator calc = new SimpleCalculator();
		calc.go();
	}
	
	public void go() {
		JLabel labelNum1 = new JLabel("加数1:");
		JLabel labelNum2 = new JLabel("			加数2:");
		JLabel resultLabel = new JLabel("相加之和：");
		calcButton = new JButton("计算 (快捷键Enter)");
		resetButton = new JButton("清空 (快捷键Esc)");
		resultNumLabel = new JLabel("");
		resultNumLabel.setMinimumSize(new Dimension(150, 20));
		resultNumLabel.setPreferredSize(new Dimension(150, 20));
		resultNumLabel.setMaximumSize(new Dimension(150, 20));
		
		frame = new JFrame("宇宙级弱智计算器");	
		panelTop = new JPanel();
		panelBottom = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER, panelTop);	
		frame.getContentPane().add(BorderLayout.SOUTH, panelBottom);	
		panelTop.add(labelNum1);
		panelTop.add(numText1);
		panelTop.add(labelNum2);
		panelTop.add(numText2);
		panelTop.add(calcButton);
		panelTop.add(resetButton);
		panelBottom.add(resultLabel);
		panelBottom.add(resultNumLabel);
		
		calcButton.addActionListener(new calcListener());
		resetButton.addActionListener(new resetListener());
		numText1.addKeyListener(new otherKeyListener());
		numText2.addKeyListener(new otherKeyListener());
		
		frame.setSize(400, 200);
		frame.setVisible(true);	//PUT THE WINDOW VISIBILITY AT LAST PLACE!!!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public static double calcSum(double x, double y) {
		return x+y;
	}
	
	public void resultNumIntoLabel() {
		try {
			double num1 = Double.parseDouble(numText1.getText());
			double num2 = Double.parseDouble(numText2.getText());
			resultNumLabel.setText(Double.toString(calcSum(num1, num2)));
		} catch(NumberFormatException ex) {
			Component subFrame = new JFrame();
			JOptionPane.showMessageDialog(subFrame, "请输入数字！");
		}		
	}
	
	public void reset() {
		numText1.setText("");
		numText2.setText("");
		resultNumLabel.setText("");	
	}
	
	class calcListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			resultNumIntoLabel();
		}
	}
	
	class resetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			reset();
		}		
	}
	
	class otherKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				resultNumIntoLabel();
			}		
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				reset();
			}
		}
 
		public void keyReleased(KeyEvent e) {}		
	}

}
