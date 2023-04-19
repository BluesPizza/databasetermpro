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

public class touristQuery extends JFrame implements ActionListener {
	JFrame frame = new JFrame("游客信息查询");
	private JScrollPane scrollPane;
	private JTable touristTable;
	private Object[][] info;
	private String[] title = { "touristID", "teamID", "name", "age", "gender", "IDnum", "phone" };
	private JButton btn_back;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background1.jpg");
	private JLabel nameQueryLabel;
	private JTextField nameQueryText;
	private JButton nameQuery, refreshBt;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet res = null;

	public touristQuery() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// 框体
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);
		setLayout(null);
		setLocation(180, 80);
		Font font = new Font("黑体", Font.BOLD, 22);

		// 标题
		showinfo = new JLabel("游客信息");
		showinfo.setFont(font);
		showinfo.setBounds(550, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);

		btn_back = new JButton("返回");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(590, 500, 100, 40);

		nameQuery = new JButton("检索姓名");
		nameQuery.setFont(font);
		nameQuery.setBounds(250, 500, 160, 40);
		nameQuery.addActionListener(this);

		refreshBt = new JButton("刷新");
		refreshBt.setFont(font);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		nameQueryLabel = new JLabel("name");
		nameQueryLabel.setFont(font);
		nameQueryLabel.setBounds(250, 550, 80, 20);
		nameQueryLabel.setForeground(Color.RED);
		nameQueryText = new JTextField(10);
		nameQueryText.setBounds(300, 550, 100, 20);

		backLayout.add(scrollPane);
		backLayout.add(btn_back);
		backLayout.add(showinfo);
		backLayout.add(nameQuery);
		backLayout.add(nameQueryLabel);
		backLayout.add(nameQueryText);
		backLayout.add(refreshBt);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new touristQuery();
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
		String sql = "select `touristID`,`teamID`,`name`,`age`,`gender`,`IDnum`,`phone` from tourist";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				count++;
			}
			info = new Object[count][7];
			count = 0;
			res = preparedStatement.executeQuery();
			while (res.next()) {
				info[count][0] = res.getString("touristID");
				info[count][1] = res.getString("teamID");
				info[count][2] = res.getString("name");
				info[count][3] = res.getString("age");
				info[count][4] = res.getString("gender");
				info[count][5] = res.getString("IDnum");
				info[count][6] = res.getString("phone");
				count++;
			}
			touristTable = new JTable(info, title);
			scrollPane.getViewport().add(touristTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void namequery() {
		String name = nameQueryText.getText().toString().trim();
		String sql = "select `touristID`,`teamID`,`name`,`age`,`gender`,`IDnum`,`phone` from `tourist` where `name` IN(?)";
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
				info = new Object[count][7];
				count = 0;
				res = preparedStatement.executeQuery();
				while (res.next()) {
					info[count][0] = res.getString("touristID");
					info[count][1] = res.getString("teamID");
					info[count][2] = res.getString("name");
					info[count][3] = res.getString("age");
					info[count][4] = res.getString("gender");
					info[count][5] = res.getString("IDnum");
					info[count][6] = res.getString("phone");
					count++;
				}
				touristTable = new JTable(info, title);
				scrollPane.getViewport().add(touristTable);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(touristQuery.this, "输入框不能为空！");
		}

	}
    
    
    
    
    
    
    
    
	
	
	
}
