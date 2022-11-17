package com.activity.track;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

//import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField evn_name_txt;
	private JTextField event_d_hr;
	private JTextField event_d_min;
	private JTable table_event;
	String user_cha_naav="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public void loadTable()
//	{
////		JDBC +JTable
//		ResultSet rs=null;
//		String dbName = "activity_manager";
//	    String dbUserName = "root";
//	    String dbPassword = "syk@2003";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
//			Connection con=DriverManager.getConnection(connectionString);
//			String dquery = "SELECT eventName, eventDate, eventTime, eventDuration FROM event_schedule";
//			PreparedStatement ps = con.prepareStatement(dquery);
//			rs =ps.executeQuery();
//			table.setModel(DbUtils.resultSetToTableModel(rs));
//			ps.close();
//			con.close();
//		}
//		catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	
	public Dashboard() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome_l = new JLabel("Daily Activity Tracker");
		welcome_l.setBounds(330, 10, 352, 73);
		welcome_l.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_l.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(welcome_l);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 139, 896, 503);
		panel.setBorder(new TitledBorder(null, "CREATE NEW EVENT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEventName = new JLabel("Event Name : ");
		lblEventName.setVerticalAlignment(SwingConstants.TOP);
		lblEventName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEventName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEventName.setBounds(48, 78, 141, 34);
		panel.add(lblEventName);
		
		evn_name_txt = new JTextField();
		evn_name_txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		evn_name_txt.setBounds(229, 73, 468, 34);
		panel.add(evn_name_txt);
		evn_name_txt.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setVerticalAlignment(SwingConstants.TOP);
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDate.setBounds(48, 143, 98, 25);
		panel.add(lblDate);
		
		JComboBox comboBox_date = new JComboBox();
		comboBox_date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_date.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_date.setBounds(229, 139, 70, 34);
		panel.add(comboBox_date);
		
		JComboBox comboBox_month = new JComboBox();
		comboBox_month.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_month.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_month.setBounds(354, 139, 70, 34);
		panel.add(comboBox_month);
		
		JComboBox comboBox_year = new JComboBox();
		comboBox_year.setModel(new DefaultComboBoxModel(new String[] {"", "2022"}));
		comboBox_year.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_year.setBounds(477, 139, 122, 34);
		panel.add(comboBox_year);
		
		JComboBox comboBox_month_1 = new JComboBox();
		comboBox_month_1.setModel(new DefaultComboBoxModel(new String[] {"", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "31", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_month_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_month_1.setBounds(356, 201, 68, 34);
		panel.add(comboBox_month_1);
		
		JComboBox comboBox_date_1 = new JComboBox();
		comboBox_date_1.setModel(new DefaultComboBoxModel(new String[] {"", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_date_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_date_1.setBounds(230, 201, 69, 34);
		panel.add(comboBox_date_1);
		
		JLabel lblEventTime = new JLabel("Event Time : ");
		lblEventTime.setVerticalAlignment(SwingConstants.TOP);
		lblEventTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblEventTime.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEventTime.setBounds(48, 205, 133, 25);
		panel.add(lblEventTime);
		
		JLabel lblEventDuration = new JLabel("Event Duration : ");
		lblEventDuration.setVerticalAlignment(SwingConstants.TOP);
		lblEventDuration.setHorizontalAlignment(SwingConstants.LEFT);
		lblEventDuration.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEventDuration.setBounds(48, 269, 141, 25);
		panel.add(lblEventDuration);
		
		event_d_hr = new JTextField();
		event_d_hr.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		event_d_hr.setColumns(10);
		event_d_hr.setBounds(229, 265, 70, 34);
		panel.add(event_d_hr);
		
		event_d_min = new JTextField();
		event_d_min.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		event_d_min.setColumns(10);
		event_d_min.setBounds(354, 265, 70, 34);
		panel.add(event_d_min);
		
		JButton add_evnt = new JButton("Add Event");
		add_evnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JDBC
				ResultSet rs=null;
				String dbName = "activity_manager";
			    String dbUserName = "root";
			    String dbPassword = "syk@2003";
				try {
					String date = (String) comboBox_date.getSelectedItem();
					String month = (String) comboBox_month.getSelectedItem();
					String year = (String) comboBox_year.getSelectedItem();
					Class.forName("com.mysql.cj.jdbc.Driver");
					String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
					Connection con=DriverManager.getConnection(connectionString);
					String query ="insert into event_schedule(username,eventName,eventDate,eventTime,eventDuration) values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, Login_Form_1.user_name);
					ps.setString(2, evn_name_txt.getText());
					ps.setString(3, date+"-"+month+"-"+year);
					ps.setString(4, comboBox_date_1.getSelectedItem()+":"+comboBox_month_1.getSelectedItem());
					ps.setString(5, event_d_hr.getText()+"hr "+event_d_min.getText()+"min");
					ps.executeUpdate();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Event added Successfully!");
					
					evn_name_txt.setText("");
					comboBox_date.setSelectedIndex(0);
					comboBox_month.setSelectedIndex(0);
					comboBox_year.setSelectedIndex(0);
					comboBox_date_1.setSelectedIndex(0);
					comboBox_month_1.setSelectedIndex(0);
					event_d_hr.setText("");
					event_d_min.setText("");
					evn_name_txt.requestFocus();
					ps.close();
					con.close();
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add_evnt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add_evnt.setBounds(340, 345, 155, 47);
		panel.add(add_evnt);
		
		
		JButton add_evnt_1 = new JButton("Reset");
		add_evnt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evn_name_txt.setText("");
				comboBox_date.setSelectedIndex(0);
				comboBox_month.setSelectedIndex(0);
				comboBox_year.setSelectedIndex(0);
				comboBox_date_1.setSelectedIndex(0);
				comboBox_month_1.setSelectedIndex(0);
				event_d_hr.setText("");
				event_d_min.setText("");
				evn_name_txt.requestFocus();
			}
		});
		add_evnt_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add_evnt_1.setBounds(575, 345, 141, 47);
		panel.add(add_evnt_1);
		
		JButton show_events = new JButton("Show My Events");
		show_events.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				TrackingEvent.main(null);
			}
		});
		show_events.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		show_events.setBounds(315, 415, 227, 47);
		panel.add(show_events);
		
		JButton pop_up = new JButton("Set Timer");
		pop_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pop_up1.main(null);
			}
		});
		pop_up.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		pop_up.setBounds(133, 345, 155, 47);
		panel.add(pop_up);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(620, 553, 337, -413);
//		contentPane.add(scrollPane);
//		
//		table_event = new JTable();
//		scrollPane.add(table_event);
//		scrollPane.setViewportView(table_event);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(296, 82, 148, 35);
		contentPane.add(lblNewLabel);
		
		//Fetch name of user from user_table
		ResultSet rs = null;
		String dbName = "activity_manager";
	    String dbUserName = "root";
	    String dbPassword = "syk@2003";
		try {
			String date = (String) comboBox_date.getSelectedItem();
			String month = (String) comboBox_month.getSelectedItem();
			String year = (String) comboBox_year.getSelectedItem();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
			Connection con=DriverManager.getConnection(connectionString);
			String query1 ="select name from user_data where username='"+Login_Form_1.user_name+"'";
			Statement stm = con.createStatement();
			rs=stm.executeQuery(query1);
			while(rs.next())
			{
				user_cha_naav += rs.getString("name");
			}
			rs.close();
			con.close();
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel label_usernm = new JLabel(user_cha_naav);
		label_usernm.setHorizontalAlignment(SwingConstants.CENTER);
		label_usernm.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label_usernm.setBounds(396, 82, 337, 35);
		contentPane.add(label_usernm);
	}
	
	
}
