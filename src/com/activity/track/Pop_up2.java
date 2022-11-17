package com.activity.track;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Pop_up2 extends JFrame {

	private JPanel panel = new JPanel();;

	public Pop_up2() {
		setTitle("Notification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 100);
		panel.setBackground(new Color(255, 255, 230));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Timer started for"); //Label
		l1.setFont(new Font("Arial", Font.BOLD, 20));
		l1.setBounds(100, 0, 400, 30);
		panel.add(l1);
		
		JButton b1 = new JButton("Stop Timer"); //timer
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String query = " insert LocalTime.now() into database"
				 * PrepareStatement s = c.p(query);
				 * note - handle the exception
				 */
				dispose();
				Feedback_form.main(null);
			}
		});
		b1.setBackground(new Color(255, 255, 128)); 
		b1.setFont(new Font("Arial", Font.BOLD, 16));
		b1.setBounds(0, 70, 400, 31);
		panel.add(b1);
		
		JLabel l2 = new JLabel("name from database"); //EVent Name
		l2.setFont(new Font("Arial", Font.BOLD, 16));
		l2.setBounds(100, 30, 400, 30);
		panel.add(l2);
		
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Pop_up2 p = new Pop_up2();
		//call Pop_up2 from actionlistener of timer button of Pop_up1
		
	}
}