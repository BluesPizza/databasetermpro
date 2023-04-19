package UI;

import connector.Connect;
import connector.UserInfo;
import tables.Tourist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class scheduleQuery extends JFrame implements ActionListener {
	JFrame frame = new JFrame("班次信息查询");
	private JScrollPane scrollPane;
	private JTable scheduleTable;
	private Object[][] info;
	private String[] title = { "scheduleID", "routeID", "departure_date", "return_date", "price" };
	private String[] title1 = { "scheduleID", "routeID", "departure_date", "return_date", "price", "guideID",
			"hotelName" };
	String s = "select * from schedule";
	private JButton btn_back;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background4.jpg");
	private JLabel routeIDQueryLabel;
	private JTextField scheduleIDQueryText;
	private JButton routeIDQueryBt, refreshBt;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet res = null;

	public scheduleQuery() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// 框体
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);
		setLayout(null);
		setLocation(180, 80);
		Font font = new Font("黑体", Font.BOLD, 23);

		// 标题
		showinfo = new JLabel("班次信息");
		showinfo.setFont(font);
		showinfo.setBounds(550, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		// 显示框
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);

		btn_back = new JButton("返回");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(590, 500, 100, 40);

		routeIDQueryBt = new JButton("检索路线详情");
		routeIDQueryBt.setFont(font);
		routeIDQueryBt.setBounds(240, 500, 180, 40);
		routeIDQueryBt.addActionListener(this);

		refreshBt = new JButton("刷新");
		refreshBt.setFont(font);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		routeIDQueryLabel = new JLabel("路线ID");
		routeIDQueryLabel.setFont(font);
		routeIDQueryLabel.setBounds(239, 541, 80, 40);
		routeIDQueryLabel.setForeground(Color.RED);
		scheduleIDQueryText = new JTextField(10);
		scheduleIDQueryText.setBounds(315, 550, 100, 20);

		backLayout.add(scrollPane);
		backLayout.add(btn_back);
		backLayout.add(showinfo);
		backLayout.add(routeIDQueryLabel);
		backLayout.add(routeIDQueryBt);
		backLayout.add(scheduleIDQueryText);
		backLayout.add(refreshBt);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn_back) {
			setVisible(false);
			new Mainhome();
		} else if (e.getSource() == refreshBt) {
			showdata();
		} else if (e.getSource() == routeIDQueryBt) {
			routeIDquery();
		}

	}

	public static void main(String[] args) {
		new scheduleQuery();
	}

	public void showdata() {
		String sql = "select `scheduleID`,`routeID`,`departure_date`,`return_date`,`price` from `schedule`";
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
				info[count][0] = res.getString("scheduleID");
				info[count][1] = res.getString("routeID");
				info[count][2] = res.getString("departure_date");
				info[count][3] = res.getString("return_date");
				info[count][4] = res.getString("price");
				count++;
			}
			scheduleTable = new JTable(info, title);
			scrollPane.getViewport().add(scheduleTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void routeIDquery() {
//    	showInput(true);
		String starting = scheduleIDQueryText.getText().toString().trim();
		String sql = "select schedule.`scheduleID`,`routeID`,`departure_date`,`return_date`,`price`,`guideID`, hotel.`name` from `schedule`,`leading`,`accommodation`,`hotel` where "
				+ "schedule.scheduleID = leading.scheduleID2 and `schedule`.scheduleID =accommodation.scheduleID3 and accommodation.`hotelID`=hotel.`hotelID` and `routeID` IN (?)";
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
				info = new Object[count][7];
				count = 0;
				res = preparedStatement.executeQuery();
				while (res.next()) {
					info[count][0] = res.getString("scheduleID");
					info[count][1] = res.getString("routeID");
					info[count][2] = res.getString("departure_date");
					info[count][3] = res.getString("return_date");
					info[count][4] = res.getString("price");
					info[count][5] = res.getString("guideID");
					info[count][6] = res.getString("name");
					count++;
				}
				scheduleTable = new JTable(info, title1);
				scrollPane.getViewport().add(scheduleTable);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(scheduleQuery.this, "输入框不能为空！");
		}
	}

}
