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

public class fastqueryView extends JFrame implements ActionListener {
	private JScrollPane scrollPane;
	private JTable viewTable;
	private Object[][] info;
	private String[] title = { "touristname", "teamname", "scheduleID", "routeID"};
	private JButton btn_back;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background8.png");
	private JLabel touristnameQueryLabel;
	private JTextField touristnameQueryText;
	private JButton touristnameQuery, refreshBt, scheduleQBt;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet res = null;
	
	public fastqueryView() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// 框体
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);
		setLayout(null);
		setLocation(180, 80);// 100 50
		Font font = new Font("黑体", Font.BOLD, 22);
		Font font1 = new Font("黑体", Font.BOLD, 19);

		// 标题
		showinfo = new JLabel("快速查询");
		showinfo.setFont(font);
		showinfo.setBounds(540, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		// 显示框
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);// 25 80 550 200

		btn_back = new JButton("返回");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(590, 500, 100, 40);

		touristnameQuery = new JButton("检索姓名");
		touristnameQuery.setFont(font);
		touristnameQuery.setBounds(250, 500, 160, 40);
		touristnameQuery.addActionListener(this);

		refreshBt = new JButton("刷新");
		refreshBt.setFont(font);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		scheduleQBt = new JButton("查询班次");
		scheduleQBt.setFocusPainted(false);
		scheduleQBt.setFont(font);
		scheduleQBt.setBounds(575, 550, 130, 40);
		scheduleQBt.addActionListener(this);

		touristnameQueryLabel = new JLabel("姓名");
		touristnameQueryLabel.setFont(font1);
		touristnameQueryLabel.setBounds(250, 550, 80, 20);
		touristnameQueryLabel.setForeground(Color.RED);
		touristnameQueryText = new JTextField(10);
		touristnameQueryText.setBounds(310, 550, 100, 20);

		backLayout.add(scrollPane);
		backLayout.add(btn_back);
		backLayout.add(showinfo);
		backLayout.add(touristnameQuery);
		backLayout.add(touristnameQueryLabel);
		backLayout.add(touristnameQueryText);
		backLayout.add(refreshBt);
		backLayout.add(scheduleQBt);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new fastqueryView();
	}

	public void showdata() {
		String sql = "select `touristname`,`teamname`,`scheduleID`,`routeID` from `fastqueryview`";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				count++;
			}
			info = new Object[count][4];
			count = 0;
			res = preparedStatement.executeQuery();
			while (res.next()) {
				info[count][0] = res.getString("touristname");
				info[count][1] = res.getString("teamname");
				info[count][2] = res.getString("scheduleID");
				info[count][3] = res.getString("routeID");
				count++;
			}
			viewTable = new JTable(info, title);
			scrollPane.getViewport().add(viewTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void namequery() {
		String name = touristnameQueryText.getText().toString().trim();
		String sql = "select `touristname`,`teamname`,`scheduleID`,`routeID` from `fastqueryview` where `touristname` like ?";
		if (!name.isEmpty()) {
			int count = 0;
			connection = Connect.getConn();
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, name);
				res = preparedStatement.executeQuery();
				while (res.next()) {
					count++;
				}
				info = new Object[count][4];
				count = 0;
				res = preparedStatement.executeQuery();
				while (res.next()) {
					info[count][0] = res.getString("touristname");
					info[count][1] = res.getString("teamname");
					info[count][2] = res.getString("scheduleID");
					info[count][3] = res.getString("routeID");
					count++;
				}
				viewTable = new JTable(info, title);
				scrollPane.getViewport().add(viewTable);
				touristnameQueryText.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(fastqueryView.this, "输入框不能为空！");
		}
	}

	
	

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == btn_back) {
			setVisible(false);
			new Mainhome();
		} else if (e.getSource() == refreshBt) {
			showdata();
		} else if (e.getSource() == touristnameQuery) {
			namequery();
		} else if (e.getSource() == scheduleQBt) {
			setVisible(false);
			new scheduleQuery();
		}
	}
	
	
	
	
	
	
	
	
	
}
