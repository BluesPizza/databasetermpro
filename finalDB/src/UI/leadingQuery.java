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

public class leadingQuery extends JFrame implements ActionListener {
	JFrame frame = new JFrame("导游安排查询");
	private JScrollPane scrollPane;
	private JTable leadingTable;
	private Object[][] info;
	private String[] title = { "scheduleID2", "guideID", "guideID1"};
	private JButton btn_back;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background10.png");
	private JLabel scheduleID2QueryLabel;
	private JTextField scheduleID2Text;
	private JButton nameQuery, refreshBt;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet res = null;

	public leadingQuery() {
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
		showinfo = new JLabel("导游安排信息");
		showinfo.setFont(font);
		showinfo.setBounds(550, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);// 25 80 550 200

		btn_back = new JButton("返回");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(590, 500, 100, 40);

		nameQuery = new JButton("检索班次");
		nameQuery.setFont(font);
		nameQuery.setBounds(250, 500, 160, 40);
		nameQuery.addActionListener(this);

		refreshBt = new JButton("刷新");
		refreshBt.setFont(font);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		scheduleID2QueryLabel = new JLabel("schedule");
		scheduleID2QueryLabel.setFont(font);
		scheduleID2QueryLabel.setBounds(220, 550, 100, 20);
		scheduleID2QueryLabel.setForeground(Color.RED);
		scheduleID2Text = new JTextField(10);
		scheduleID2Text.setBounds(320, 550, 100, 20);

		backLayout.add(scrollPane);
		backLayout.add(btn_back);
		backLayout.add(showinfo);
		backLayout.add(nameQuery);
		backLayout.add(scheduleID2QueryLabel);
		backLayout.add(scheduleID2Text);
		backLayout.add(refreshBt);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new leadingQuery();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_back) {
			setVisible(false);
			new Mainhome();
		} else if (e.getSource() == nameQuery) {
			namequery();
		} else if (e.getSource() == refreshBt) {
			showdata();
		}
	}

	public void showdata() {
		String sql = "select `scheduleID2`,`guideID`,`guideID1` from `leading`";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				count++;
			}
			info = new Object[count][3];
			count = 0;
			res = preparedStatement.executeQuery();
			while (res.next()) {
				info[count][0] = res.getString("scheduleID2");
				info[count][1] = res.getString("guideID");
				info[count][2] = res.getString("guideID1");
				count++;
			}
			leadingTable = new JTable(info, title);
			scrollPane.getViewport().add(leadingTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void namequery() {
		String scheduleID2 = scheduleID2Text.getText().toString().trim();
		String sql = "select `scheduleID2`,`guideID`,`guideID1` from `leading` where `scheduleID2` IN(?)";
		if (!scheduleID2.isEmpty()) {
			int count = 0;
			connection = Connect.getConn();
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, scheduleID2);
				res = preparedStatement.executeQuery();
				while (res.next()) {
					count++;
				}
				info = new Object[count][3];
				count = 0;
				res = preparedStatement.executeQuery();
				while (res.next()) {
					info[count][0] = res.getString("scheduleID2");
					info[count][1] = res.getString("guideID");
					info[count][2] = res.getString("guideID1");
					count++;
				}
				leadingTable = new JTable(info, title);
				scrollPane.getViewport().add(leadingTable);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(leadingQuery.this, "输入框不能为空！");
		}

	}
}
