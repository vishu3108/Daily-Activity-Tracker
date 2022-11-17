package com.activity.track;

/** FeedBack Form Daily Activity Trackr */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Feedback_form extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback_form frame = new Feedback_form();
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
	public Feedback_form() {
		setTitle("Feedback Form");                  // heading on frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 341);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel L_feed_1 = new JLabel("Congratulations ...");   // Title of form
		L_feed_1.setBounds(101, 10, 202, 24);
		L_feed_1.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(L_feed_1);
		
		JCheckBox ch_box_1 = new JCheckBox("1");  // Checkbox 1
		buttonGroup.add(ch_box_1);
		ch_box_1.setFont(new Font("Arial", Font.BOLD, 16));
		ch_box_1.setSelected(true);
		ch_box_1.setBounds(37, 74, 39, 21);
		contentPane.add(ch_box_1);
		
		JCheckBox ch_box_2 = new JCheckBox("2");  // Checkbox 2
		buttonGroup.add(ch_box_2);
		ch_box_2.setFont(new Font("Arial", Font.BOLD, 16));
		ch_box_2.setBounds(91, 74, 39, 21);
		contentPane.add(ch_box_2);
		
		JCheckBox ch_box_3 = new JCheckBox("3");  // Checkbox 3
		buttonGroup.add(ch_box_3);
		ch_box_3.setFont(new Font("Arial", Font.BOLD, 16));
		ch_box_3.setBounds(151, 74, 39, 21);
		contentPane.add(ch_box_3);
		
		JCheckBox ch_box_4 = new JCheckBox("4");   // Checkbox 4
		buttonGroup.add(ch_box_4);
		ch_box_4.setFont(new Font("Arial", Font.BOLD, 16));
		ch_box_4.setBounds(213, 74, 39, 21);
		contentPane.add(ch_box_4);
		
		JCheckBox ch_box_5 = new JCheckBox("5");  // Checkbox 5
		buttonGroup.add(ch_box_5);
		ch_box_5.setFont(new Font("Arial", Font.BOLD, 16));
		ch_box_5.setBounds(278, 74, 39, 21);
		contentPane.add(ch_box_5);
		
		JLabel j_feed_2 = new JLabel("Rate Yourself"); //Label 1 rate yourself
		j_feed_2.setFont(new Font("Arial", Font.BOLD, 18));
		j_feed_2.setBounds(37, 44, 216, 24);
		contentPane.add(j_feed_2);
		
		JLabel j_feed_3 = new JLabel("Write Feedback"); //Label 2 Write feedback
		j_feed_3.setFont(new Font("Arial", Font.BOLD, 18));
		j_feed_3.setBounds(37, 101, 216, 24);
		contentPane.add(j_feed_3);
		
		JTextArea Tarea_feed = new JTextArea();  // Text area to take input which is feedback
		Tarea_feed.setFont(new Font("Arial", Font.BOLD, 14));
		Tarea_feed.setBounds(37, 134, 309, 81);
		contentPane.add(Tarea_feed);
		
		JButton b_feed = new JButton("Submit");  // Submit Button on Feedback
		b_feed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String dbName = "activity_manager";
			    String dbUserName = "root";
			    String dbPassword = "syk@2003";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
					Connection con=DriverManager.getConnection(connectionString);
					String query ="insert into feedback (username,rating,details) values(?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, Login_Form_1.user_name);
					ps.setInt(2, Integer.parseInt("5"));
					ps.setString(3, Tarea_feed.getText());
					ps.executeUpdate();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Congratulations....you've completed the event:)");
					ps.close();
					con.close();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b_feed.setBackground(new Color(255, 255, 0));
		b_feed.setFont(new Font("Arial", Font.BOLD, 16));
		b_feed.setBounds(151, 244, 101, 27);
		contentPane.add(b_feed);
	}
}