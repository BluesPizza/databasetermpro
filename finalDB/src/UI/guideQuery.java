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

public class guideQuery extends JFrame implements ActionListener {
	JFrame frame = new JFrame("导游信息查询");
	private JScrollPane scrollPane;
	private JTable guideTable;
	private Object[][] info;
	private String[] title = { "guideID", "name", "age", "gender", "IDnum", "phone", "rank" };
	private JButton btn_back,btn_update;
	private JLabel showinfo;
	private Background backLayout = new Background("res/background6.jpg");
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
		}else if(e.getSource()==btn_update) {
			setVisible(false);
			new guideUpdate();
		}
	}

	public guideQuery() {
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
		showinfo = new JLabel("导游信息");
		showinfo.setFont(font);
		showinfo.setBounds(550, 50, 150, 40);
		showinfo.setForeground(Color.RED);

		// 显示框
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 120, 800, 300);// 25 80 550 200

		btn_back = new JButton("返回");
		btn_back.addActionListener(this);
		btn_back.setFont(font);
		btn_back.setBounds(670, 500, 100, 40);
		
		btn_update= new JButton("修改数据");
		btn_update.addActionListener(this);
		btn_update.setFont(font);
		btn_update.setBounds(460,500,140,40);

		nameQueryBt = new JButton("检索导游名");
		nameQueryBt.setFont(font);
		nameQueryBt.setBounds(250, 500, 160, 40);
		nameQueryBt.addActionListener(this);

		refreshBt = new JButton("刷新");
		refreshBt.setFont(font);
		refreshBt.setFocusPainted(false);
		refreshBt.setBounds(850, 500, 100, 40);
		refreshBt.addActionListener(this);

		nameQueryLabel = new JLabel("导游名");
		nameQueryLabel.setFont(font);
		nameQueryLabel.setBounds(230, 546, 80, 30);
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
		backLayout.add(btn_update);

		showdata();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new guideQuery();
	}

	public void showdata() {
		String sql = "select `guideID`,`name`,`age`,`gender`,`IDnum`,`phone`,`rank` from `guide`";
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
				info[count][0] = res.getString("guideID");
				info[count][1] = res.getString("name");
				info[count][2] = res.getString("age");
				info[count][3] = res.getString("gender");
				info[count][4] = res.getString("IDnum");
				info[count][5] = res.getString("phone");
				info[count][6] = res.getString("rank");
				count++;
			}
			guideTable = new JTable(info, title);
			scrollPane.getViewport().add(guideTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void namequery() {
		String starting = nameQueryText.getText().toString().trim();
		String sql = "select `guideID`,`name`,`age`,`gender`,`IDnum`,`phone`,`rank` from `guide` where `name` IN (?)";
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
					info[count][0] = res.getString("guideID");
					info[count][1] = res.getString("name");
					info[count][2] = res.getString("age");
					info[count][3] = res.getString("gender");
					info[count][4] = res.getString("IDnum");
					info[count][5] = res.getString("phone");
					info[count][6] = res.getString("rank");
					count++;
				}
				guideTable = new JTable(info, title);
				scrollPane.getViewport().add(guideTable);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(guideQuery.this, "输入框不能为空！");
		}
	}

}
