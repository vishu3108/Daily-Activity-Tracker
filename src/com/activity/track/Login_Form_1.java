package com.activity.track;

/** Login Form Daily Activity Tracker */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JScrollPane;


public class Login_Form_1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t_login_u;
	private JPasswordField pass_login;
	public static String user_name ;
	public static String password;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form_1 frame = new Login_Form_1();
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
	public Login_Form_1() {
		setType(Type.POPUP);
		setResizable(false);
		setFont(new Font("Arial", Font.BOLD, 16));
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 604, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 239, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel j_login_p = new JLabel("Password :-"); //JAlbel password for login
		j_login_p.setFont(new Font("Arial", Font.BOLD, 16));
		j_login_p.setBounds(66, 164, 102, 33);
		contentPane.add(j_login_p);
		
		JLabel j_login_u = new JLabel("Username :- "); // Username for login
		j_login_u.setFont(new Font("Arial", Font.BOLD, 16));
		j_login_u.setBounds(66, 94, 102, 33);
		contentPane.add(j_login_u);
		
		JButton b_login = new JButton("Login"); //Submit Button of Login
		b_login.setSelectedIcon(new ImageIcon("C:\\Users\\Vikas\\Downloads\\41-412856_b-avatar-for-login-form.png"));
		b_login.setForeground(new Color(64, 0, 64));
		b_login.setBackground(new Color(255, 255, 0));
		b_login.setFont(new Font("Arial", Font.BOLD, 16));
		b_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				String dbName = "activity_manager";
			    String dbUserName = "root";
			    String dbPassword = "syk@2003";
				try {
					String uname = t_login_u.getText();
					user_name = uname;
					password = pass_login.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
					Connection con=DriverManager.getConnection(connectionString);
					String query ="select username from user_data where (username='"+uname+"' and password ='"+ password +"')";
					Statement ps = con.createStatement();
					rs=ps.executeQuery(query);
					if(rs.isBeforeFirst())
					{
						//dashboard show
						dispose();
						Dashboard.main(null);
					}
					else
					{
						JFrame f=new JFrame();  
					    JOptionPane.showMessageDialog(f,"User does not exist!!!","Alert",JOptionPane.WARNING_MESSAGE); 
					}
//					JFrame f = new JFrame();
//					JOptionPane.showMessageDialog(f, "Registration Successful");
					rs.close();
					con.close();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b_login.setBounds(290, 259, 151, 45);
		contentPane.add(b_login);
		
		//Register button
		
		JButton b_register = new JButton("Register Here"); //Register Button of Login
		b_register.setBackground(new Color(255, 255, 0));
		b_register.setFont(new Font("Arial", Font.BOLD, 16));
//		b_login.setSelectedIcon(new ImageIcon("C:\\Users\\Vikas\\Downloads\\41-412856_b-avatar-for-login-form.png"));
		b_register.setForeground(new Color(64, 0, 64));
//		b_login.setBackground(new Color(255, 255, 0));
//		b_login.setFont(new Font("Arial", Font.BOLD, 16));
		b_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Signup_Form.main(null);
			}
		});
		b_register.setBounds(290, 392, 151, 45);
		contentPane.add(b_register);
		
		t_login_u = new JTextField();  // Textfield for username
		t_login_u.setFont(new Font("Arial", Font.BOLD, 14));
		t_login_u.setHorizontalAlignment(SwingConstants.LEFT);
		t_login_u.setBounds(190, 95, 364, 33);
		contentPane.add(t_login_u);
		t_login_u.setColumns(20);
		
		JLabel j_login_1 = new JLabel("Activity Tracker Login"); //Login Label
		j_login_1.setFont(new Font("Arial", Font.BOLD, 20));
		j_login_1.setBounds(244, 46, 226, 21);
		contentPane.add(j_login_1);
		
		pass_login = new JPasswordField(); // to take Password of login
		pass_login.setFont(new Font("Arial", Font.BOLD, 14));
		pass_login.setBounds(190, 165, 364, 33);
		contentPane.add(pass_login);
		
		JLabel lblNewLabel_3 = new JLabel(""); //Image
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Vikas\\Downloads\\41-412856_b-avatar-for-login-form.jpg"));
		lblNewLabel_3.setBounds(151, 12, 50, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Not Registered? ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setBounds(289, 361, 158, 21);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
		setSize(737,608);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
