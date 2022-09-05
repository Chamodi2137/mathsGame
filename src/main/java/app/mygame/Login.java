package app.mygame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import app.mygame.authenticate.AppLogin;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private static final Log LOG = LogFactory.getLog(Login.class);
	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 515, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Game Login");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(176, 25, 95, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(176, 79, 95, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(119, 104, 177, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(176, 135, 67, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.setVisible(true);
		pass = new JPasswordField();
		pass.setBounds(119, 160, 177, 20);
		frame.getContentPane().add(pass);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(AppLogin.authenticate(user.getText(), pass.getText())) {
					LOG.info("Login is successful");
					JOptionPane.showMessageDialog(null, "Login Sucessfully...");
					LevelOne n = new LevelOne();
					//level2 n = new level2();
				} else {
					LOG.info("Login failed");
					JOptionPane.showMessageDialog(null, "Incorrect username and password...");
				}		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(95, 158, 160));
		btnNewButton.setBounds(170, 205, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
