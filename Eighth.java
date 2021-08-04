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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eighth extends JFrame {

	private JPanel contentPane;
	private  ResultSet rs=null ;
    static Connection connection ;
    static Statement stmt  ;
    private JTextField side;
    private JTextField strv;
    private JTextField mide;
    private JTextField mnom;
    private JTextField atrav;
    private JTextField ntrav;
    private JTextField mprix;
    private JTextField ptrav;
    private JTextField ide1;
    private JTextField pnom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eighth frame = new Eighth(connection, stmt);
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
	public Eighth(Connection connection,Statement stmt) {
		setTitle("Mise a jour");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Downloads\\maison-dessin-anime_11460-1609.jpg"));
		 this.connection= connection ;
         this.stmt = stmt ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suppression d un participant?");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 208, 14);
		contentPane.add(lblNewLabel);

		side = new JTextField();
		side.setEnabled(false);
		side.setText("...");
		side.setBackground(new Color(255, 245, 238));
		side.setBounds(10, 95, 89, 20);
		contentPane.add(side);
		side.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Donner le ide du participant");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 70, 192, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Done");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String i=side.getText();
				stmt.execute("delete from participant where ide="+i);
				stmt.execute("delete from travaille where ide="+i);
				stmt.execute("delete from paiement where ide="+i);
				side.setText("");
			}
				  catch(Exception ex) {
	                    ex.printStackTrace(); 
	                }
				}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1.setBounds(109, 94, 89, 23);
		contentPane.add(btnNewButton_1);
	
		JButton btnNewButton = new JButton("Oui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				side.setEnabled(true);
				lblNewLabel_1.setEnabled(true);
				btnNewButton_1.setEnabled(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 245, 238));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.setBounds(10, 36, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSuppressionDUn = new JLabel("Suppression d un travaille?");
		lblSuppressionDUn.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblSuppressionDUn.setBounds(10, 126, 208, 14);
		contentPane.add(lblSuppressionDUn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Donner le nom du travaille");
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_1.setEnabled(false);
		lblNewLabel_1_1.setBounds(10, 185, 192, 14);
		contentPane.add(lblNewLabel_1_1);
		
		strv = new JTextField();
		strv.setText("...");
		strv.setEnabled(false);
		strv.setColumns(10);
		strv.setBackground(new Color(255, 245, 238));
		strv.setBounds(10, 210, 89, 20);
		contentPane.add(strv);
		
		JButton btnNewButton_1_1 = new JButton("Done");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String i="'"+strv.getText()+"'";
					stmt.execute("delete from travaille where nomt="+i);
					side.setText("");
				}
					  catch(Exception ex) {
		                    ex.printStackTrace(); 
		                }
			}
		});
		btnNewButton_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setBounds(109, 209, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Oui");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1_1.setEnabled(true);
				strv.setEnabled(true);
				lblNewLabel_1_1.setEnabled(true);
			}
			
		});
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(255, 245, 238));
		btnNewButton_2.setBounds(10, 151, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Modification d un participant?");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2.setBounds(244, 11, 208, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Donner le ide du participant et son nouveau nom");
		lblNewLabel_1_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2.setEnabled(false);
		lblNewLabel_1_2.setBounds(244, 68, 330, 14);
		contentPane.add(lblNewLabel_1_2);
		
		mide = new JTextField();
		mide.setText("ide");
		mide.setEnabled(false);
		mide.setColumns(10);
		mide.setBackground(new Color(255, 245, 238));
		mide.setBounds(244, 95, 68, 20);
		contentPane.add(mide);
		mnom = new JTextField();
		mnom.setEnabled(false);
		mnom.setText("nom");
		mnom.setBackground(new Color(255, 245, 238));
		mnom.setBounds(339, 95, 98, 20);
		contentPane.add(mnom);
		mnom.setColumns(10);
		
		JButton btnNewButton_1_2 = new JButton("Done");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String i=mide.getText();
					String m="'"+mnom.getText()+"'";
					stmt.execute("update participant set nom="+m+"where ide="+i);
					stmt.execute("update travaille set nom="+m+"where ide="+i);
					stmt.execute("update paiement set nom="+m+"where ide="+i);
					side.setText("");
					mnom.setText("");
				}
					  catch(Exception ex) {
		                    ex.printStackTrace(); 
		                }
				
			}
		});
		btnNewButton_1_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1_2.setEnabled(false);
		btnNewButton_1_2.setBounds(472, 95, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_3 = new JButton("Oui");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1_2.setEnabled(true);
				mide.setEnabled(true);
				lblNewLabel_1_2.setEnabled(true);
				mnom.setEnabled(true);
			}
			
		});
		btnNewButton_3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(255, 245, 238));
		btnNewButton_3.setBounds(244, 34, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Second s=new Second(connection,stmt);
				s.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(new Color(255, 240, 245));
		btnNewButton_4.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_4.setBounds(10, 377, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modification d un travaille?");
		lblNewLabel_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(244, 126, 208, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Donner l ancien et le nouveau nom du travaille");
		lblNewLabel_1_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2_1.setEnabled(false);
		lblNewLabel_1_2_1.setBounds(244, 185, 330, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		atrav = new JTextField();
		atrav.setText("ancien");
		atrav.setEnabled(false);
		atrav.setColumns(10);
		atrav.setBackground(new Color(255, 245, 238));
		atrav.setBounds(244, 210, 89, 20);
		contentPane.add(atrav);
		
		ntrav = new JTextField();
		ntrav.setText("nouveau");
		ntrav.setEnabled(false);
		ntrav.setColumns(10);
		ntrav.setBackground(new Color(255, 245, 238));
		ntrav.setBounds(354, 210, 98, 20);
		contentPane.add(ntrav);
		
		JButton btnNewButton_1_2_1 = new JButton("Done");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String i="'"+ntrav.getText()+"'";
					String m="'"+atrav.getText()+"'";
					
					stmt.execute("update travaille set nomt="+i+"where nomt="+m);
				
					ntrav.setText("");
					atrav.setText("");
				}
					  catch(Exception ex) {
		                    ex.printStackTrace(); 
		                }
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1_2_1.setEnabled(false);
		btnNewButton_1_2_1.setBounds(472, 209, 89, 23);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Oui");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atrav.setEnabled(true);
				ntrav.setEnabled(true);
				btnNewButton_1_2_1.setEnabled(true);

			}
		});
		btnNewButton_3_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3_1.setBackground(new Color(255, 245, 238));
		btnNewButton_3_1.setBounds(244, 149, 89, 23);
		contentPane.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Modification du prix du paiement?");
		lblNewLabel_2_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(10, 257, 237, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Donner le prix que vous voulez");
		lblNewLabel_1_2_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2_2.setEnabled(false);
		lblNewLabel_1_2_2.setBounds(10, 314, 220, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		mprix = new JTextField();
		mprix.setText("...");
		mprix.setEnabled(false);
		mprix.setColumns(10);
		mprix.setBackground(new Color(255, 245, 238));
		mprix.setBounds(10, 333, 89, 20);
		contentPane.add(mprix);
		
		JButton btnNewButton_1_1_1 = new JButton("Done");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String i=mprix.getText();
					
					
					stmt.execute("update paiement set somme="+i);
				
					mprix.setText("");
					
				}
					  catch(Exception ex) {
		                    ex.printStackTrace(); 
		                }
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1_1_1.setEnabled(false);
		btnNewButton_1_1_1.setBounds(109, 332, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_3_2 = new JButton("Oui");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1_2_2.setEnabled(true);
				mprix.setEnabled(true);
				btnNewButton_1_1_1.setEnabled(true);
			}
		});
		btnNewButton_3_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3_2.setBackground(new Color(255, 245, 238));
		btnNewButton_3_2.setBounds(10, 279, 89, 23);
		contentPane.add(btnNewButton_3_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("permutation du travaille?");
		lblNewLabel_2_1_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(244, 255, 237, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Donner le travaille a permute");
		lblNewLabel_1_2_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2_2_1.setEnabled(false);
		lblNewLabel_1_2_2_1.setBounds(244, 312, 220, 14);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		ptrav = new JTextField();
		ptrav.setText("...");
		ptrav.setEnabled(false);
		ptrav.setColumns(10);
		ptrav.setBackground(new Color(255, 245, 238));
		ptrav.setBounds(448, 309, 113, 20);
		contentPane.add(ptrav);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Donner le  participant");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2_2_1_1.setEnabled(false);
		lblNewLabel_1_2_2_1_1.setBounds(244, 336, 220, 14);
		contentPane.add(lblNewLabel_1_2_2_1_1);
		
		ide1 = new JTextField();
		ide1.setText("ide ");
		ide1.setEnabled(false);
		ide1.setColumns(10);
		ide1.setBackground(new Color(255, 245, 238));
		ide1.setBounds(244, 357, 89, 20);
		contentPane.add(ide1);
		
		pnom = new JTextField();
		pnom.setText("nom");
		pnom.setEnabled(false);
		pnom.setColumns(10);
		pnom.setBackground(new Color(255, 245, 238));
		pnom.setBounds(348, 357, 89, 20);
		contentPane.add(pnom);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Done");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String i="'"+ptrav.getText()+"'";
				String id=ide1.getText();
				String n="'"+pnom.getText()+"'";
				stmt.execute("update travaille set ide="+id+" and nom="+n+" where nomt="+i);}
				catch (Exception e1) {
					e1.printStackTrace();
			}
		}});
		btnNewButton_1_1_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_1_1_1_1.setEnabled(false);
		btnNewButton_1_1_1_1.setBounds(472, 358, 89, 23);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_3_2_1 = new JButton("Oui");
		btnNewButton_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1_1_1_1.setEnabled(true);
				pnom.setEnabled(true);
				ide1.setEnabled(true);
				lblNewLabel_1_2_2_1_1.setEnabled(true);
				ptrav.setEnabled(true);
				lblNewLabel_1_2_2_1.setEnabled(true);
			}
		});
		btnNewButton_3_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton_3_2_1.setBackground(new Color(255, 245, 238));
		btnNewButton_3_2_1.setBounds(244, 280, 89, 23);
		contentPane.add(btnNewButton_3_2_1);
	
		
		
		
	
		
	
		
		
		
		
		
	}	
}
