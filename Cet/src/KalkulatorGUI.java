import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class KalkulatorGUI extends JFrame {
	
	private JPanel contentPane;
	private double x;
	private double y;
	private String znak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KalkulatorGUI frame = new KalkulatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KalkulatorGUI() {
		setResizable(false);
		setTitle("Kalkulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 11, 238, 42);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"1");
			}
		});
		btn1.setBounds(35, 64, 45, 35);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"2");
			}
		});
		btn2.setBounds(90, 64, 45, 35);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"3");
			}
		});
		btn3.setBounds(145, 64, 45, 35);
		contentPane.add(btn3);
		
		JButton btnDeljenje = new JButton("/");
		btnDeljenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				znak="/";
				x=Double.parseDouble(a);
				textArea.setText(a+"/\n");
			}
		});
		btnDeljenje.setBounds(228, 64, 45, 35);
		contentPane.add(btnDeljenje);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"4");
			}
		});
		btn4.setBounds(35, 110, 45, 35);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"5");
			}
		});
		btn5.setBounds(90, 110, 45, 35);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"6");
			}
		});
		btn6.setBounds(145, 110, 45, 35);
		contentPane.add(btn6);
		
		JButton btnMnozenje = new JButton("*");
		btnMnozenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				znak="*";
				x=Double.parseDouble(a);
				textArea.setText(a+"*\n");
			}
		});
		btnMnozenje.setBounds(228, 110, 45, 35);
		contentPane.add(btnMnozenje);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"7");
			}
		});
		btn7.setBounds(35, 156, 45, 35);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"8");
			}
		});
		btn8.setBounds(90, 156, 45, 35);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"9");
			}
		});
		btn9.setBounds(145, 156, 45, 35);
		contentPane.add(btn9);
		
		JButton btnOduzimanje = new JButton("-");
		btnOduzimanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				znak="-";
				x=Double.parseDouble(a);
				textArea.setText(a+"-\n");
			}
		});
		btnOduzimanje.setBounds(228, 156, 45, 35);
		contentPane.add(btnOduzimanje);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+"0");
			}
		});
		btn0.setBounds(35, 202, 100, 35);
		contentPane.add(btn0);
		
		JButton btnZarez = new JButton(",");
		btnZarez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textArea.getText();
				textArea.setText(s+".");
			}
		});
		btnZarez.setBounds(145, 202, 45, 35);
		contentPane.add(btnZarez);
		
		JButton btnSabiranje = new JButton("+");
		btnSabiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				znak="+";
				x=Double.parseDouble(a);
				textArea.setText(a+"+\n");
			}
		});
		btnSabiranje.setBounds(228, 202, 45, 35);
		contentPane.add(btnSabiranje);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				znak="";
				textArea.setText("");
				x=0;
				y=0;
			}
		});
		
		btnC.setBounds(294, 13, 45, 35);
		contentPane.add(btnC);
		
		JButton btnJednako = new JButton("=");
		btnJednako.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String b = textArea.getText();
				int d = b.length();
				int i= b.indexOf(znak);
				String c = b.substring(i+1,d);
				y=Double.parseDouble(c);
				switch(znak){
				case "+":
					double zbir = x+y;
					textArea.setText(""+zbir);
					break;
				case "-":
					double razlika = x-y;
					textArea.setText(""+razlika);
					break;
				case "*":
					double proizvod = x*y;
					textArea.setText(""+proizvod);
					break;
				case "/":
					double kolicnik = x/y;
					textArea.setText(""+kolicnik);
					break;
				}
			}
		});
		btnJednako.setBounds(35, 253, 238, 35);
		contentPane.add(btnJednako);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(294, 64, 197, 224);
		contentPane.add(scrollPane_1);
		
		JTextArea Konzola = new JTextArea();
		scrollPane_1.setViewportView(Konzola);
	}
}
