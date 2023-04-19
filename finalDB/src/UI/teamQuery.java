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

public class teamQuery extends JFrame implements ActionListener {
	JFrame frame = new JFrame("队伍信息查询");
	private JScrollPane scrollPane;
	private JTable teamTable;
	private Object[][] info;
	private String[] title = { "teamID", "scheduleID", "name", "count", "leader", "phone" };
	private JButton btn_back;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background5.jpg");
	private JLabel nameQueryLabel;
	private JTextField nameQueryText;
	private JButton nameQueryBt, refreshBt;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet res = null;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == btn_back) {
			setVisible(false);
			new Mainhome();
		} else if (e.getSource() == refreshBt) {
			showdata();
		} else if (e.getSource() == nameQueryBt) {
			namequery();
		}
	}

	public teamQuery() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		// 框体
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);
		setLayout(null);
		setLocation(180, 80);// 100 50
		Font font = new Font("黑体", Font.BOLD, 22);

		// 标题
		showinfo = new JLabel("路线信息");
		showinfo.setFont(font);
		showinfo.setBounds(550, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		// 显示框
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);// 25 80 550 200

		btn_back = new JButton("返回");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(590, 500, 100, 40);

		nameQueryBt = new JButton("检索队名");
		nameQueryBt.setFont(font);
		nameQueryBt.setBounds(250, 500, 160, 40);
		nameQueryBt.addActionListener(this);

		refreshBt = new JButton("刷新");
		refreshBt.setFont(font);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		nameQueryLabel = new JLabel("队名");
		nameQueryLabel.setFont(font);
		nameQueryLabel.setBounds(250, 550, 80, 25);
		nameQueryLabel.setForeground(Color.RED);
		nameQueryText = new JTextField(10);
		nameQueryText.setBounds(300, 550, 100, 20);

		backLayout.add(scrollPane);
		backLayout.add(btn_back);
		backLayout.add(showinfo);
		backLayout.add(nameQueryBt);
		backLayout.add(nameQueryLabel);
		backLayout.add(nameQueryText);
		backLayout.add(refreshBt);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new teamQuery();
	}

	public void showdata() {
		String sql = "select `teamID`,`scheduleID`,`name`,`count`,`leader`,`phone` from `team`";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				count++;
			}
			info = new Object[count][6];
			count = 0;
			res = preparedStatement.executeQuery();
			while (res.next()) {
				info[count][0] = res.getString("teamID");
				info[count][1] = res.getString("scheduleID");
				info[count][2] = res.getString("name");
				info[count][3] = res.getString("count");
				info[count][4] = res.getString("leader");
				info[count][5] = res.getString("phone");
				count++;
			}
			teamTable = new JTable(info, title);
			scrollPane.getViewport().add(teamTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void namequery() {
//    	showInput(true);
		String starting = nameQueryText.getText().toString().trim();
		String sql = "select `teamID`,`scheduleID`,`name`,`count`,`leader`,`phone` from `team` where `name` IN (?)";
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
				info = new Object[count][6];
				count = 0;
				res = preparedStatement.executeQuery();
				while (res.next()) {
					info[count][0] = res.getString("teamID");
					info[count][1] = res.getString("scheduleID");
					info[count][2] = res.getString("name");
					info[count][3] = res.getString("count");
					info[count][4] = res.getString("leader");
					info[count][5] = res.getString("phone");
					count++;
				}
				teamTable = new JTable(info, title);
				scrollPane.getViewport().add(teamTable);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(teamQuery.this, "输入框不能为空！");
		}
	}

}
