package app.mygame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import app.mygame.controller.LogicControllder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelOne {
	private static final Log LOG = LogFactory.getLog(LevelOne.class);
	private JFrame frame;	
	String value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelOne window = new LevelOne();
					window.frame.setVisible(true);
				} catch (Exception e) {
					LOG.error("Exception occurred:" + e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LevelOne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LOG.info("LevelOne frame is being initialized");
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What is the value of circle?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(61, 11, 406, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\temp\\MyMathsGameV2\\MyMathsGame\\images\\gimg1.PNG"));
		lblNewLabel_1.setBounds(48, 50, 268, 241);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("16");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = "16";
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBounds(369, 75, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("8");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = "8";
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setBounds(369, 127, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("32");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = "32";
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setBounds(369, 178, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		frame.setVisible(true);
		LOG.info("LevelOne frame is initialized");
		
		JButton btnNewButton = new JButton("Submit Answer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LOG.info("LevelOne button action to perform");
					
					LogicControllder controller = new LogicControllder();
					controller.updateAnswer(value);
					
					JOptionPane.showInputDialog(this, "Your answer is submitted successfully");
					controller.updateCompare(value);
					
					LOG.info("LevelOne button action performed");
				} catch(Exception ex) {
					JOptionPane.showInputDialog(this, ex.getMessage());
					LOG.error("Exception occured::" + e);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(139, 321, 155, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(357, 321, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			LOG.info("LevelTwo page is called");
			new LevelTwo();
		}
	});
	}
}
