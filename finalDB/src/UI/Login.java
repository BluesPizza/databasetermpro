package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import connector.Connect;

public class Login extends JFrame implements ActionListener {
	JFrame frame = new JFrame("�û���¼");

	private JLabel userNameLabel, passwordLabel, titleLable;
	private JTextField userNameText, passwordText;

	private Background loginPanel;
	private JButton loginButton, exitButton;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public Login() {

		// ���ƿ���
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setIconImage(frame.getToolkit().getImage("res/ICON.png"));

		Font font = new Font("����", Font.BOLD, 16);
		Font font1 = new Font("����", Font.BOLD, 20);
		setLayout(null);
		setBounds(350, 100, 800, 600);
		loginPanel = new Background("res/Login.jpg");
		loginPanel.setLayout(null);
		add(loginPanel);

		titleLable = new JLabel("���ι���ϵͳ��¼����");
		titleLable.setBounds(560, 10, 250, 80);
		titleLable.setForeground(Color.RED);
		loginPanel.add(titleLable);

		userNameLabel = new JLabel("�û���:");
		userNameLabel.setBounds(300, 220, 80, 20);
		loginPanel.add(userNameLabel);

		userNameText = new JTextField();
		userNameText.setBounds(360, 220, 150, 20);
		loginPanel.add(userNameText);

		passwordLabel = new JLabel("����:");
		passwordLabel.setBounds(300, 270, 80, 20);
		loginPanel.add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(360, 270, 150, 20);
		loginPanel.add(passwordText);

		loginButton = new JButton("��¼");
		loginButton.setBounds(350, 320, 80, 18);
		loginPanel.add(loginButton);

		exitButton = new JButton("�˳�");
		exitButton.setBounds(440, 320, 80, 18);
		loginPanel.add(exitButton);

		userNameLabel.setFont(font);
		passwordLabel.setFont(font);
		loginButton.setFont(font);
		exitButton.setFont(font);
		titleLable.setFont(font1);

		loginButton.addActionListener(this);
		exitButton.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			setVisible(false);
		} else if (e.getSource() == loginButton) {
			String ID = userNameText.getText().toString().trim();
			String pass = passwordText.getText().toString().trim();
			String sql = "select * from users WHERE ID=? and pass=?";
			if (!ID.isEmpty() && !pass.isEmpty()) {
				connection = Connect.getConn();
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, ID);
					preparedStatement.setString(2, pass);
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						setVisible(false);
						new Mainhome();
					} else {
						JOptionPane.showMessageDialog(Login.this, "�û������������");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(Login.this, "�������Ϊ�գ�");
			}
		}
	}
}
