package com.activity.track;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class TrackingEvent extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackingEvent frame = new TrackingEvent();
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
	public TrackingEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Event Schedule");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(42, 104, 165, 35);
		contentPane.add(lblNewLabel);
//		//JDBC + JTable
//			//JDBC
//			ResultSet rs=null;
//			String dbName = "activity_manager";
//		    String dbUserName = "root";
//		    String dbPassword = "syk@2003";
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
//				Connection con=DriverManager.getConnection(connectionString);
//				String dquery = "SELECT eventName, eventDate, eventTime, eventDuration FROM event_schedule";
//				Statement ps = con.createStatement();
//				rs =ps.executeQuery(dquery);
//				ResultSetMetaData rsmd = rs.getMetaData();
//				int cols = rsmd.getColumnCount();
//				String arr[] = new String[cols];
//				for(int i=0;i<cols;i++)
//				{
//					arr[i] = rsmd.getColumnName(i+1);
//				}
//				model.setColumnIdentifiers(arr);
////				table.setModel(DbUtils.resultSetToTableModel(rs));
//				ps.close();
//				con.close();
//			}
//			catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(39, 138, 868, 495);
			contentPane.add(scrollPane);
			
			table_1 = new JTable();
			scrollPane.setViewportView(table_1);
			
			JLabel date_label = new JLabel("Enter Date :");
			date_label.setHorizontalAlignment(SwingConstants.LEFT);
			date_label.setFont(new Font("Times New Roman", Font.PLAIN, 21));
			date_label.setBounds(162, 16, 136, 34);
			contentPane.add(date_label);
			
			JComboBox comboBox_date = new JComboBox();
			comboBox_date.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBox_date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBox_date.setBounds(162, 60, 55, 34);
			contentPane.add(comboBox_date);
			
			JComboBox comboBox_month = new JComboBox();
			comboBox_month.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			comboBox_month.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBox_month.setBounds(243, 60, 55, 34);
			contentPane.add(comboBox_month);
			
			JComboBox comboBox_year = new JComboBox();
			comboBox_year.setModel(new DefaultComboBoxModel(new String[] {"", "2022"}));
			comboBox_year.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			comboBox_year.setBounds(321, 60, 99, 34);
			contentPane.add(comboBox_year);
			
			JButton show_events = new JButton("Show Events");
			show_events.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResultSet rs = null;
					String dbName = "activity_manager";
				    String dbUserName = "root";
				    String dbPassword = "syk@2003";
					try {
						String date = (String) comboBox_date.getSelectedItem();
						String month = (String) comboBox_month.getSelectedItem();
						String year = (String) comboBox_year.getSelectedItem();
						String ip_date = date+"-"+month+"-"+year;
						Class.forName("com.mysql.cj.jdbc.Driver");
						String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
						Connection con=DriverManager.getConnection(connectionString);
						String dquery = "SELECT eventName, eventTime, eventDuration FROM event_schedule WHERE (username = '"+Login_Form_1.user_name+"' and eventDate = '"+ip_date+"')";
						PreparedStatement ps = con.prepareStatement(dquery);
						rs =ps.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						rs.close();
						con.close();
					}
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			show_events.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			show_events.setBounds(496, 59, 127, 35);
			contentPane.add(show_events);
			
			JButton back_btn = new JButton("Back");
			back_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Dashboard.main(null);
				}
			});
			back_btn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			back_btn.setBounds(665, 59, 127, 35);
			contentPane.add(back_btn);
	

}	
}
