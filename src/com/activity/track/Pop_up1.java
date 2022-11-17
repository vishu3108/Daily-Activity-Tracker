package com.activity.track;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Pop_up1 extends JFrame {

	private JPanel panel = new JPanel();;

	public Pop_up1() {
		setTitle("Notification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		panel.setBackground(new Color(255, 255, 230));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Reminder"); //Label
		l1.setFont(new Font("Arial", Font.BOLD, 20));
		l1.setBounds(144, 0, 140, 48);
		panel.add(l1);
		
		JButton b1 = new JButton("Timer"); //timer
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String query = " insert LocalTime.now() into database"
				 * PrepareStatement s = c.p(query);
				 * note - handle the exception
				 */
				dispose();
			}
		});
		b1.setBackground(new Color(255, 255, 128)); 
		b1.setFont(new Font("Arial", Font.BOLD, 16));
		b1.setBounds(0, 100, 200, 50);
		panel.add(b1);
		
		JLabel l2 = new JLabel("name from database"); //EVent Name
		l2.setFont(new Font("Arial", Font.BOLD, 16));
		l2.setBounds(100, 38, 94, 28);
		panel.add(l2);
		
		JButton b2 = new JButton("Close"); //Close Button
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pop_up2.main(null);
			}
		});
		b2.setBackground(new Color(255, 255, 128));
		b2.setFont(new Font("Arial", Font.BOLD, 16));
		b2.setBounds(200, 100, 200, 50);
		panel.add(b2);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		/*
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL="";
			String uname = "";
			String password = "";
			//show global variable like 'port'
			DriverManager.getConnection(dbURL, uname, password);
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		*/
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Pop_up1 p = new Pop_up1();
				System.out.println("hello");
				
			}
		};
		Calendar time = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY,15);//add hour from database instead of 16
		time.set(Calendar.MINUTE,9);//add min from database instead of 50
		time.set(Calendar.MILLISECOND, 0);//don't change
		timer.schedule(task, time.getTime());
		
	}
}