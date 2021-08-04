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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class Fourth extends JFrame {

	private JPanel contentPane;
    private  ResultSet rs=null ;
    static Connection connection ;
    static Statement stmt  ;
    private JLabel lblNewLabel;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JTable table;
    private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fourth frame = new Fourth(connection, stmt);
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
	public Fourth(Connection connection,Statement stmt) {
		setTitle("Rapport");
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
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Second s=new Second(connection, stmt);
				s.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.setBounds(412, 319, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Les participants qui ont des points superieur a 0:");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel.setBounds(66, 81, 435, 23);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Afficher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
				rs = stmt.executeQuery("select * from participant where points>0") ;
                table.setModel(DbUtils.resultSetToTableModel(rs));}
				catch(Exception ex) {
                    ex.printStackTrace(); 
                }
			}
		});
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBounds(66, 319, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("paiement");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Seventh sv=new Seventh(connection, stmt);
				sv.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_2.setBounds(180, 319, 96, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("initialiser");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				stmt.execute("update participant set points=0");
				rs = stmt.executeQuery("select * from participant where points>0") ;
                table.setModel(DbUtils.resultSetToTableModel(rs));}
				catch(Exception ex) {
                    ex.printStackTrace(); 
                }
			}
		});
		btnNewButton_3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(255, 240, 245));
		btnNewButton_3.setBounds(286, 319, 104, 23);
		contentPane.add(btnNewButton_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 132, 403, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(Color.BLACK);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(new Color(255, 240, 245));
	}
}
