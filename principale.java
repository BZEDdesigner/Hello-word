package menage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class principale extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private java.sql.Connection connection=null ;  //connection bdd
    private java.sql.Statement stmt= null ;       //etet de connection
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
 //   private ResultSet rs=null ;         // resultat d un requete
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principale frame = new principale();
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
	public principale() {
		setBackground(new Color(255, 153, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\maison-dessin-anime_11460-1609.jpg"));
		setTitle("Organisation Menage de la Maison");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(205, 165, 67, 0);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(271, 255, 153, -27);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(58, 52, 126, -19);
		contentPane.add(table_2);
		
		JLabel lblNewLabel = new JLabel("Organisation Menage de la Maison");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 21));
		lblNewLabel.setBounds(108, 134, 338, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue");
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_1.setBounds(228, 201, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Debut");
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//--------------------------------------------------------------//
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver") ;
				String user="system";
				String psw="0903200200";
				connection = DriverManager.getConnection("jdbc:oracle:thin:"+user+"/"+psw+"@localhost");
                stmt = connection.createStatement();}
				catch (Exception ex ){ ex.printStackTrace();}

				
				setVisible(false);
				Second s=new Second(connection, stmt);
				s.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setBounds(228, 226, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("<<OMM>>");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2.setBounds(231, 176, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("HINI Aya Rayane");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		lblNewLabel_3.setBounds(482, 386, 92, 14);
		contentPane.add(lblNewLabel_3);
		
	}
}
