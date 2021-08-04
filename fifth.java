package menage;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fifth extends JFrame {

	private JPanel contentPane;
	private JTextField dpart;
	private  ResultSet rs=null ;
    static Connection connection ;
    static Statement stmt  ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fifth frame = new fifth(connection, stmt);
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
	public fifth(Connection connection,Statement stmt) {
		setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		setTitle("Validation");
		 this.connection= connection ;
         this.stmt = stmt ;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\maison-dessin-anime_11460-1609.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dpart = new JTextField();
		dpart.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		dpart.setBackground(new Color(255, 240, 245));
		dpart.setText("...");
		dpart.setBounds(150, 147, 272, 33);
		contentPane.add(dpart);
		dpart.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ecq le participant a bien fait son travaille?");
		lblNewLabel.setBackground(new Color(255, 240, 245));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel.setBounds(150, 191, 272, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("oui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			dpart.setText("");	
			}
		});
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.setBounds(150, 248, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("non");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				
				
				String i=dpart.getText();
				String s="update participant set points=points+1 where ide="+i;
				stmt.execute(s);
				String s1="update paiement set prix=prix+somme where ide="+i;
				stmt.execute(s1);
				
				}
                catch(Exception ex) {
                    ex.printStackTrace(); 
                }
				dpart.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBounds(310, 248, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Third th=new Third(connection, stmt);
				th.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setBounds(485, 365, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Donner le ide du participant :");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1.setBounds(150, 103, 285, 33);
		contentPane.add(lblNewLabel_1);
		
		
	}

}
