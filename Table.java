package menage;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class Table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField enom;
	private  ResultSet rs=null ;
    static Connection connection ;
    static Statement stmt  ;
    private JTextField eide;
    private JTextField som;
    private JTable table_2;
    private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table(connection, stmt);
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
	public Table(Connection connection,Statement stmt) {
		setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		setTitle("Participant");
		 this.connection= connection ;
         this.stmt = stmt ;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\maison-dessin-anime_11460-1609.jpg"));
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(5, 5, 424, 0);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("les participants sont comme suite:");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel.setBounds(47, 30, 338, 28);
		contentPane.add(lblNewLabel);
		
		table_1 = new JTable();
		table_1.setBounds(105, 152, 174, -40);
		contentPane.add(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Pour ajouter un nouveau participant:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(47, 250, 338, 14);
		contentPane.add(lblNewLabel_1);
		
		enom = new JTextField();
		enom.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		enom.setText("Entrez le nom svp");
		enom.setBackground(new Color(255, 239, 213));
		enom.setBounds(47, 272, 156, 24);
		contentPane.add(enom);
		enom.setColumns(10);
		
		
		eide = new JTextField();
		eide.setText("Entrez le ide svp");
		eide.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		eide.setColumns(10);
		eide.setBackground(new Color(255, 239, 213));
		eide.setBounds(47, 307, 156, 28);
		contentPane.add(eide);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(255, 239, 213));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				try {
                  
					//String max="select MAX(ide) from participant";
                   // i=stmt.executeUpdate(max)+1;
					String nom = "'"+enom.getText()+"'";
					String i="'"+eide.getText()+"'";
					//stmt.execute("insert into participant values ('HABIBI',0,0);");
					String sql = "insert into participant values ("+nom+","+i+",0)" ;
                    stmt.execute(sql);
                    
                    String sql1 = "insert into paiement values ("+i+","+i+","+nom+",0,"+som.getText()+")" ;
                    stmt.execute(sql1);
                    
                    rs = stmt.executeQuery("select * from participant") ;
                    table_2.setModel(DbUtils.resultSetToTableModel(rs));
                    
                   
                }
                catch(Exception ex) {
                    ex.printStackTrace(); 
                }
				
				enom.setText("");
				eide.setText("");
				som.setText("");
			}
		});
		btnNewButton.setBounds(232, 347, 61, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Second s1=new Second(connection, stmt);
			s1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 239, 213));
		btnNewButton_1.setBounds(459, 347, 83, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("AFFICHAGE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			    rs = stmt.executeQuery("select * from participant") ;
                table_2.setModel(DbUtils.resultSetToTableModel(rs));}
				 catch(Exception ex) {
	                    ex.printStackTrace(); 
	                }
			}
		});
		btnNewButton_2.setBackground(new Color(255, 239, 213));
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnNewButton_2.setBounds(320, 347, 129, 23);
		contentPane.add(btnNewButton_2);
		
		som = new JTextField();
		som.setText("Entrez le paiement");
		som.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		som.setColumns(10);
		som.setBackground(new Color(255, 239, 213));
		som.setBounds(47, 346, 156, 28);
		contentPane.add(som);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 77, 493, 124);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setForeground(Color.BLACK);
		table_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_2.setBackground(new Color(255, 240, 245));
	
	}
}
