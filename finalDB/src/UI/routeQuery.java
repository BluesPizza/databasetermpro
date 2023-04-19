package UI;

import connector.Connect;
import connector.UserInfo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class routeQuery extends JFrame implements ActionListener {
	JFrame frame = new JFrame("·����Ϣ��ѯ");
	private JScrollPane scrollPane;
	private JTable routeTable;
	private Object[][] info;
	private String[] title = { "routeID", "starting", "terminal", "day", "scenic_point" };
	String s = "select * from route";
	private JButton btn_back;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background2.jpg");
	private JLabel startingQueryLabel;
	private JTextField startingQueryText;
	private JButton startingQuery, refreshBt, scheduleQBt;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet res = null;

	public routeQuery() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// ����
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);
		setLayout(null);
		setLocation(180, 80);// 100 50
		Font font = new Font("����", Font.BOLD, 22);
		Font font1 = new Font("����", Font.BOLD, 19);

		// ����
		showinfo = new JLabel("·����Ϣ");
		showinfo.setFont(font);
		showinfo.setBounds(550, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		// ��ʾ��
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);// 25 80 550 200

		btn_back = new JButton("����");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(590, 500, 100, 40);

		startingQuery = new JButton("����������");
		startingQuery.setFont(font);
		startingQuery.setBounds(250, 500, 160, 40);
		startingQuery.addActionListener(this);

		refreshBt = new JButton("ˢ��");
		refreshBt.setFont(font);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		scheduleQBt = new JButton("��ѯ���");
		scheduleQBt.setFocusPainted(false);
		scheduleQBt.setFont(font);
		scheduleQBt.setBounds(575, 550, 130, 40);
		scheduleQBt.addActionListener(this);

		startingQueryLabel = new JLabel("������");
		startingQueryLabel.setFont(font1);
		startingQueryLabel.setBounds(250, 550, 80, 20);
		startingQueryLabel.setForeground(Color.RED);
		startingQueryText = new JTextField(10);
		startingQueryText.setBounds(310, 550, 100, 20);

		backLayout.add(scrollPane);
		backLayout.add(btn_back);
		backLayout.add(showinfo);
		backLayout.add(startingQuery);
		backLayout.add(startingQueryLabel);
		backLayout.add(startingQueryText);
		backLayout.add(refreshBt);
		backLayout.add(scheduleQBt);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() == btn_back) {
			setVisible(false);
			new Mainhome();
		} else if (e.getSource() == refreshBt) {
			showdata();
		} else if (e.getSource() == startingQuery) {
			namequery();
		} else if (e.getSource() == scheduleQBt) {
			setVisible(false);
			new scheduleQuery();
		}
	}

	public static void main(String[] args) {
		new routeQuery();
	}

	public void showdata() {
		String sql = "select `routeID`,`starting`,`terminal`,`day`,`scenic_point` from `route`";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				count++;
			}
			info = new Object[count][5];
			count = 0;
			res = preparedStatement.executeQuery();
			while (res.next()) {
				info[count][0] = res.getString("routeID");
				info[count][1] = res.getString("starting");
				info[count][2] = res.getString("terminal");
				info[count][3] = res.getString("day");
				info[count][4] = res.getString("scenic_point");
				count++;
			}
			routeTable = new JTable(info, title);
			scrollPane.getViewport().add(routeTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void namequery() {
//    	showInput(true);
		String starting = startingQueryText.getText().toString().trim();
		//����ʹ��ͨ���ʵ��ģ������
		String sql = "select `routeID`,`starting`,`terminal`,`day`,`scenic_point` from `route` where `starting` like ?";
		if (!starting.isEmpty()) {
			int count = 0;
			connection = Connect.getConn();
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, starting);
				res = preparedStatement.executeQuery();
				while (res.next()) {
					count++;
				}
				info = new Object[count][5];
				count = 0;
				res = preparedStatement.executeQuery();
				while (res.next()) {
					info[count][0] = res.getString("routeID");
					info[count][1] = res.getString("starting");
					info[count][2] = res.getString("terminal");
					info[count][3] = res.getString("day");
					info[count][4] = res.getString("scenic_point");
					count++;
				}
				routeTable = new JTable(info, title);
				scrollPane.getViewport().add(routeTable);
				startingQueryText.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(routeQuery.this, "�������Ϊ�գ�");
		}
	}

}
