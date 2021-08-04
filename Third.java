package menage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class Third extends JFrame {

	private JPanel contentPane;
	private  ResultSet rs=null ;
    static Connection connection ;
    static Statement stmt  ;
    private JTextField tpart;
    private JTextField trav;
    private JTextField tnom;
    private JTextField idepart;
    private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Third frame = new Third(connection, stmt);
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
	public Third(Connection connection,Statement stmt) {
		setTitle("Travaille");
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
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Second s=new Second(connection, stmt);
				s.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setBounds(443, 360, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Le travaille a faire pour chaque participant:");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel.setBounds(63, 34, 414, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Validation");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				fifth f1=new fifth(connection, stmt);
				f1.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_2.setBounds(311, 360, 113, 23);
		contentPane.add(btnNewButton_2);
		
		tpart = new JTextField();
		tpart.setText("...");
		tpart.setColumns(10);
		tpart.setBackground(new Color(255, 240, 245));
		tpart.setBounds(63, 263, 201, 20);
		contentPane.add(tpart);
		
		trav = new JTextField();
		trav.setText("...");
		trav.setColumns(10);
		trav.setBackground(new Color(255, 240, 245));
		trav.setBounds(63, 314, 201, 20);
		contentPane.add(trav);
		
		JLabel lblNewLabel_1 = new JLabel("Saisir un traville:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(63, 294, 173, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Le ide du participant :");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2.setBounds(63, 234, 201, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
	                  
					String nom="'"+tnom.getText()+"'";
					String travaille = "'"+trav.getText()+"'";
					String i=tpart.getText();
				
					String sql = "insert into travaille values ("+travaille+","+nom+","+i+")" ;
					
                    stmt.execute(sql);
                    
                    rs = stmt.executeQuery("select * from travaille ") ;
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                   
                }
                catch(Exception ex) {
                    ex.printStackTrace(); 
                }
                tpart.setText("");
                trav.setText("");
                tnom.setText("");
			}
		});
		btnAjouter.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnAjouter.setBackground(new Color(255, 240, 245));
		btnAjouter.setBounds(63, 360, 89, 23);
		contentPane.add(btnAjouter);
		
		JButton btnNewButton_3 = new JButton("Afficher touts");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                  
					
					
                    
					  rs = stmt.executeQuery("select * from travaille") ;
				                    table.setModel(DbUtils.resultSetToTableModel(rs));
				                    
				                   
				                }
				                catch(Exception ex) {
				                    ex.printStackTrace(); 
				                }
			}
		});
		btnNewButton_3.setBackground(new Color(255, 239, 213));
		btnNewButton_3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3.setBounds(308, 209, 188, 23);
		contentPane.add(btnNewButton_3);
		
		idepart = new JTextField();
		idepart.setEnabled(false);
		idepart.setText("...");
		idepart.setBackground(new Color(255, 239, 213));
		idepart.setBounds(311, 263, 188, 20);
		contentPane.add(idepart);
		idepart.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("afficher par participant");
		btnNewButton_4.setBackground(new Color(255, 239, 213));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                  
					
					
                    String ch=idepart.getText();
					  rs = stmt.executeQuery("select * from travaille where "+ch+"=ide") ;
				                    table.setModel(DbUtils.resultSetToTableModel(rs));
				                    
				                   
				                }
				                catch(Exception ex) {
				                    ex.printStackTrace(); 
				                }
			}
		});
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_4.setBounds(308, 315, 188, 23);
		contentPane.add(btnNewButton_4);
		
		
		
		JLabel labelide = new JLabel("le ide du participant:");
		labelide.setEnabled(false);
		labelide.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		labelide.setBounds(311, 238, 188, 14);
		contentPane.add(labelide);
		
		JButton btnNewButton_1 = new JButton("Affichage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setEnabled(true);
				btnNewButton_4.setEnabled(true);
				idepart.setEnabled(true);
				labelide.setEnabled(true);
				btnNewButton_1.setVisible(false);

			}
		});
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBounds(183, 360, 109, 23);
		contentPane.add(btnNewButton_1);
		
		tnom = new JTextField();
		tnom.setBackground(new Color(255, 240, 245));
		tnom.setText("...");
		tnom.setBounds(63, 208, 200, 20);
		contentPane.add(tnom);
		tnom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Le nom du participant:");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_3.setBounds(63, 183, 226, 14);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 68, 434, 104);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(Color.BLACK);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(new Color(255, 240, 245));
		
		
		
		
	}
}
