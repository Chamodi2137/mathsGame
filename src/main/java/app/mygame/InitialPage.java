package app.mygame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author chamodi samarakoon
 *
 */
public class InitialPage {

	private static final Log LOG = LogFactory.getLog(InitialPage.class);
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("C:\\tmp\\MyMathsGame\\MyMathsGame\\src\\main\\resources\\log4j.properties");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialPage window = new InitialPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					LOG.error("Exception occured::" + e);
				} 
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LOG.info("Opening initial page.");
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 484, 289);
		lblNewLabel.setIcon(new ImageIcon("C:\\temp\\MyMathsGameV2\\MyMathsGame\\images\\homepic.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOG.info("Login page is called.");
				new Login();				
			}
		});
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(283, 207, 115, 40);
		frame.getContentPane().add(btnNewButton);
	}
}
