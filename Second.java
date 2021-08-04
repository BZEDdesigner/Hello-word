package menage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;


import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Toolkit;

public class Second extends JFrame {

	private JPanel contentPane;
	static Connection connection ;
    static Statement stmt  ;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Second frame = new Second(connection, stmt);
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
	public Second(Connection connection,Statement stmt) {
		setTitle("Menu");
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
		
		JButton btnNewButton = new JButton("Participant");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Table t=new Table(connection, stmt);
				t.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.setBounds(188, 76, 196, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Travaille a faire");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Third th=new Third(connection, stmt);
				th.setVisible(true);
						
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setBounds(188, 135, 196, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Rapport");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Fourth f=new Fourth(connection, stmt);
				f.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(255, 240, 245));
		btnNewButton_3.setBounds(188, 194, 196, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principale p=new principale();
				p.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setBounds(240, 308, 89, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3_1 = new JButton("Mise a jour");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Eighth e1=new Eighth(connection,stmt);
				e1.setVisible(true);
				
			}
		});
		btnNewButton_3_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3_1.setBackground(new Color(255, 240, 245));
		btnNewButton_3_1.setBounds(188, 255, 196, 36);
		contentPane.add(btnNewButton_3_1);
	}
}
