package menage;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Seventh extends JFrame {

	private JPanel contentPane;
	private JTable table;
	  private  ResultSet rs=null ;
	    static Connection connection ;
	    static Statement stmt  ;
	    private JButton btnAfficherParIde;
	    private JTextField pide;
	    private JLabel lblNewLabel_1;
	    private JButton btnPayerParTranche;
	    private JButton btnPayerTouts;
	    private JLabel lblNewLabel_2;
	    private JTextField pri;
	    private JButton btnNewButton_1;
	    private JButton btnNewButton_2;
	    private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seventh frame = new Seventh(connection, stmt);
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
	public Seventh(Connection connection,Statement stmt) {
	
		
		setTitle("Paiement");
		this.connection= connection ;
        this.stmt = stmt ;
        
    	try {
			 stmt.execute("update paiement set prix=0 where prix<0 ") ;
            }
			catch(Exception ex) {
                ex.printStackTrace(); 
            }
        
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\maison-dessin-anime_11460-1609.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(336, 86, -266, 71);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Le rapport d une semaine de traville");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 28, 296, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				rs = stmt.executeQuery("select idep,ide,nom,prix from paiement where prix>0 ") ;
                table_1.setModel(DbUtils.resultSetToTableModel(rs));}
				catch(Exception ex) {
                    ex.printStackTrace(); 
                }
			}
		});
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.setBounds(24, 190, 110, 23);
		contentPane.add(btnNewButton);
		
		pide = new JTextField();
		pide.setBackground(new Color(255, 240, 245));
		pide.setText("...");
		pide.setBounds(23, 249, 86, 20);
		contentPane.add(pide);
		pide.setColumns(10);
		
		btnAfficherParIde = new JButton(" Afficher par ide");
		btnAfficherParIde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String i=pide.getText();
				rs=stmt.executeQuery("select * from paiement where ide="+i);
				 table_1.setModel(DbUtils.resultSetToTableModel(rs));}
				 catch(Exception ex) {
	                    ex.printStackTrace(); 
	                }
				
				}
				
			}
		);
		btnAfficherParIde.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnAfficherParIde.setBackground(new Color(255, 240, 245));
		btnAfficherParIde.setBounds(24, 353, 158, 23);
		contentPane.add(btnAfficherParIde);
		
		
		
		lblNewLabel_1 = new JLabel("Donner le ide pour afficher un participant");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 224, 286, 14);
		contentPane.add(lblNewLabel_1);
		
		pri = new JTextField();
		pri.setEnabled(false);
		pri.setText("...");
		pri.setColumns(10);
		pri.setBackground(new Color(255, 240, 245));
		pri.setBounds(24, 305, 86, 20);
		contentPane.add(pri);
		

		lblNewLabel_2 = new JLabel("Donner une somme");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2.setBounds(24, 280, 135, 14);
		contentPane.add(lblNewLabel_2);
		
		btnPayerParTranche = new JButton("payer par tranche");
		btnPayerParTranche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblNewLabel_2.setEnabled(true);
				pri.setEnabled(true);	
			/*	String i=pide.getText();
				String p=pri.getText();
				String s="update paiement set prix=prix-"+p+"where ide="+i;
				stmt.execute(s);
				 rs = stmt.executeQuery("select idep,ide,nom,prix from paiement") ;
	                table_1.setModel(DbUtils.resultSetToTableModel(rs));*/
				}
                catch(Exception ex) {
                    ex.printStackTrace(); 
                }
			}
		});
		btnPayerParTranche.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnPayerParTranche.setBackground(new Color(255, 240, 245));
		btnPayerParTranche.setBounds(308, 353, 151, 23);
		contentPane.add(btnPayerParTranche);
		
		btnPayerTouts = new JButton("payer touts");
		btnPayerTouts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String i=pide.getText();
					stmt.execute("update  paiement set prix=0 where ide="+i);
				    rs = stmt.executeQuery("select idep,ide,nom,prix from paiement") ;
	                table_1.setModel(DbUtils.resultSetToTableModel(rs));}
					 catch(Exception ex) {
		                    ex.printStackTrace(); 
		                }
			}
		});
		btnPayerTouts.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnPayerTouts.setBackground(new Color(255, 240, 245));
		btnPayerTouts.setBounds(192, 353, 106, 23);
		contentPane.add(btnPayerTouts);
		
		
		btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Fourth s=new Fourth(connection, stmt);
				s.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setBounds(469, 353, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Done");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String i=pide.getText();
				String p=pri.getText();
				String s="update paiement set prix=prix-"+p+"where ide="+i;
				stmt.execute(s);
				 rs = stmt.executeQuery("select idep,ide,nom,prix from paiement where prix>0") ;
	                table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
                catch(Exception ex) {
                    ex.printStackTrace(); 
                }
			}
		});
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_2.setBounds(131, 304, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 53, 493, 115);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setForeground(Color.BLACK);
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setBackground(new Color(255, 240, 245));
		
	
	}
}
