package com.activity.track;

/** Signup Form Daily Activity Tracker */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Signup_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t_signup_fn;
	private JTextField t_signup_ln;
	private JTextField t_signup_u;
	private JTextField t_signup_e;
	private JTextField t_age_signup;
	private JPasswordField p_signup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_Form frame = new Signup_Form();
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
	public Signup_Form() {
		setAlwaysOnTop(true);
		setForeground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Vikas\\Downloads\\41-412856_b-avatar-for-login-form (1).jpg"));
		setBackground(new Color(0, 0, 0));
		setTitle("Sign Up Form ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 670);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel j_signup_1 = new JLabel("Activity Tracker Sign Up"); // Form Heading
		j_signup_1.setFont(new Font("Cambria", Font.BOLD, 24));
		j_signup_1.setBounds(237, 21, 289, 35);
		contentPane.add(j_signup_1);
		
		JLabel j_signup_u = new JLabel("Username"); //Label username
		j_signup_u.setFont(new Font("Arial", Font.BOLD, 16));
		j_signup_u.setBounds(54, 157, 102, 13);
		contentPane.add(j_signup_u);
		
		JLabel j_signup_fn = new JLabel("First Name"); //Label  First Name
		j_signup_fn.setFont(new Font("Arial", Font.BOLD, 16));
		j_signup_fn.setBounds(56, 78, 82, 13);
		contentPane.add(j_signup_fn);
		
		JButton b_signup_s = new JButton("Submit"); // Submit Button
		b_signup_s.setBackground(new Color(255, 255, 0));
		b_signup_s.setFont(new Font("Arial", Font.BOLD, 16));
		b_signup_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JDBC
				dispose();
				String dbName = "activity_manager";
			    String dbUserName = "root";
			    String dbPassword = "syk@2003";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
					Connection con=DriverManager.getConnection(connectionString);
					String query ="insert into user_data(username,name,email,password,age) values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, t_signup_u.getText());
					ps.setString(2, t_signup_fn.getText()+" "+t_signup_ln.getText());
					ps.setString(3, t_signup_e.getText());
					ps.setString(4, p_signup.getText());
					ps.setInt(5, Integer.parseInt(t_age_signup.getText()));
					ps.executeUpdate();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Registration Successful");
					ps.close();
					con.close();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Login_Form_1.main(null);
			}
		});
		b_signup_s.setBounds(335, 439, 148, 35);
		contentPane.add(b_signup_s);
		
		JLabel j_signup_ln = new JLabel("Last Name"); //Label last Name
		j_signup_ln.setFont(new Font("Arial", Font.BOLD, 16));
		j_signup_ln.setBounds(444, 78, 82, 13);
		contentPane.add(j_signup_ln);
		
		JLabel j_signup_e = new JLabel("Email"); //Label Email
		j_signup_e.setFont(new Font("Arial", Font.BOLD, 16));
		j_signup_e.setBounds(54, 237, 102, 13);
		contentPane.add(j_signup_e);
		
		JLabel j_signup_pass = new JLabel("Password"); // Label Password
		j_signup_pass.setFont(new Font("Arial", Font.BOLD, 16));
		j_signup_pass.setBounds(55, 305, 102, 26);
		contentPane.add(j_signup_pass);
		
		t_signup_fn = new JTextField(); // TextField FirstName
		t_signup_fn.setFont(new Font("Arial", Font.BOLD, 14));
		t_signup_fn.setBounds(54, 101, 259, 35);
		contentPane.add(t_signup_fn);
		t_signup_fn.setColumns(10);
		
		t_signup_ln = new JTextField();  // TextField Last name
		t_signup_ln.setFont(new Font("Arial", Font.BOLD, 14));
		t_signup_ln.setColumns(10);
		t_signup_ln.setBounds(444, 101, 265, 35);
		contentPane.add(t_signup_ln);
		
		t_signup_u = new JTextField();  // TextField Username
		t_signup_u.setFont(new Font("Arial", Font.BOLD, 14));
		t_signup_u.setColumns(10);
		t_signup_u.setBounds(54, 180, 655, 35);
		contentPane.add(t_signup_u);
		
		t_signup_e = new JTextField();  // TextField Email
		t_signup_e.setFont(new Font("Arial", Font.BOLD, 14));
		t_signup_e.setColumns(10);
		t_signup_e.setBounds(54, 260, 655, 35);
		contentPane.add(t_signup_e);
		
		JLabel j_signup_age = new JLabel("Age");  // Label Age
		j_signup_age.setFont(new Font("Arial", Font.BOLD, 16));
		j_signup_age.setBounds(460, 305, 102, 26);
		contentPane.add(j_signup_age);
		
		t_age_signup = new JTextField();  // TextField Age
		t_age_signup.setFont(new Font("Arial", Font.BOLD, 14));
		t_age_signup.setColumns(10);
		t_age_signup.setBounds(460, 344, 119, 35);
		contentPane.add(t_age_signup);
		
		p_signup = new JPasswordField(); // Password Field to take pass
		p_signup.setFont(new Font("Arial", Font.BOLD, 14));
		p_signup.setBounds(55, 344, 333, 35);
		contentPane.add(p_signup);
		
		
		
		
	}

} 
