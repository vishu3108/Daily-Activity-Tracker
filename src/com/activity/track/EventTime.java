package com.activity.track;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EventTime extends JFrame {

	private JPanel contentPane;
	public static int hr;
	public static int min;
	private JTextField hour_tf;
	private JTextField min_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventTime frame = new EventTime();
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
	public EventTime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton pop_up = new JButton("Select Time");
		pop_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pop_up1.main(null);
			}
		});
		pop_up.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		pop_up.setBounds(170, 169, 155, 47);
		contentPane.add(pop_up);
		
		JLabel lblNewLabel = new JLabel("Hr :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 107, 35, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblMin = new JLabel("Min :");
		lblMin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMin.setBounds(259, 107, 46, 22);
		contentPane.add(lblMin);
		
		hour_tf = new JTextField();
		hour_tf.setBounds(124, 102, 96, 34);
		contentPane.add(hour_tf);
		hour_tf.setColumns(10);
		
		min_tf = new JTextField();
		min_tf.setColumns(10);
		min_tf.setBounds(315, 102, 96, 34);
		contentPane.add(min_tf);
		
		hr = Integer.valueOf(hour_tf.getText());
		min = Integer.valueOf(min_tf.getText());
	}
}
