package UI;

import connector.Connect;
import connector.UserInfo;
import tables.Route;
import connector.Connect;
import connector.UserInfo;
import tables.Guide;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
public class routeUpdate extends JFrame implements ActionListener {
	JFrame frame = new JFrame("路线信息管理");
	private JScrollPane scrollPane;
	private JLabel roomLabel;
	private JButton btn_insert, btn_delete, btn_update,btn_transaction;
	private JPanel panel;
	private JTable routeTable;
	private JTableHeader bedHeader;
	private int size = 0;
	private Object[][] info;
	private String[] title = { "routeID", "starting", "terminal", "day", "senic_point"};
	private JLabel addrouteID, addstart, addterminal, addday, addscenic, addphone, addrank, mytitle;
	private JTextField addrouteIDText, addstartText, addterminalText, adddayText, addscenicText, addphoneText, addrankText;
	private JButton btn_query;
	private Background backLayout = new Background("res/background1.jpg");

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public routeUpdate() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// 框体
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);
		setLayout(null);
		setLocation(180, 80);

		Font font = new Font("黑体", Font.BOLD, 16);
		Font font1 = new Font("黑体", Font.BOLD, 22);

		// 标题
		mytitle = new JLabel("路线信息(管理员)");
		mytitle.setFont(font1);
		mytitle.setBounds(520, 40, 200, 40);
		mytitle.setForeground(Color.RED);

		// 控件
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 80, 800, 300);

		// 按钮
		btn_insert = new JButton("添加");
		btn_insert.setFocusable(false);
		btn_delete = new JButton("删除");
		btn_update = new JButton("修改");
		btn_query = new JButton("转到查询");
//		btn_transaction =new JButton("事务演示");
		btn_insert.setFont(font);
		btn_delete.setFont(font);
		btn_update.setFont(font);
		btn_query.setFont(font);
//		btn_transaction.setFont(font);
		btn_insert.setBounds(400, 550, 100, 40);
		btn_delete.setBounds(500, 550, 100, 40);
		btn_update.setBounds(600, 550, 100, 40);
		btn_query.setBounds(700, 550, 100, 40);
//		btn_transaction.setBounds(500,600,100,40);



		// 输入框
		addstart = new JLabel("start");
		addstart.setBounds(450, 430, 150, 20);
		addstart.setFont(font);
		addstart.setForeground(Color.RED);
		addstartText = new JTextField(30);
		addstartText.setBounds(500, 430, 80, 20);

		addterminal = new JLabel("terminal");
		addterminal.setFont(font);
		addterminal.setBounds(620, 430, 70, 20);
		addterminal.setForeground(Color.RED);
		addterminalText = new JTextField(30);
		addterminalText.setBounds(690, 430, 80, 20);

		addrouteID = new JLabel("routeID");
		addrouteID.setFont(font);
		addrouteID.setBounds(270, 430, 100, 20);
		addrouteID.setForeground(Color.RED);
		addrouteIDText = new JTextField(30);
		addrouteIDText.setBounds(340, 430, 80, 20);

		addday = new JLabel("day");
		addday.setFont(font);
		addday.setBounds(820, 430, 80, 20);
		addday.setForeground(Color.RED);
		adddayText = new JTextField(30);
		adddayText.setBounds(850, 430, 80, 20);

		addscenic = new JLabel("scenic_point");
		addscenic.setFont(font);
		addscenic.setBounds(270,500,120,20);
		addscenic.setForeground(Color.RED);
		addscenicText= new JTextField(30);
		addscenicText.setBounds(380,500,100,20);
//		
//		addphone = new JLabel("phone:");
//		addphone.setFont(font);
//		addphone.setBounds(490, 500, 100, 20);
//		addphone.setForeground(Color.RED);
//		addphoneText=new JTextField(30);
//		addphoneText.setBounds(550,500,100,20);
//		
//		addrank =new JLabel("rank:");
//		addrank.setFont(font);
//		addrank.setBounds(670, 500, 100, 20);
//		addrank.setForeground(Color.RED);
//		addrankText =new JTextField(30);
//		addrankText.setBounds(720, 500, 100, 20);
		

		btn_insert.addActionListener(this);
		btn_delete.addActionListener(this);
		btn_update.addActionListener(this);
		btn_update.addActionListener(this);
		btn_query.addActionListener(this);
		btn_query.addActionListener(this);
//		btn_transaction.addActionListener(this);


		backLayout.add(scrollPane);
		backLayout.add(btn_insert);
		backLayout.add(btn_delete);
		backLayout.add(btn_update);
		backLayout.add(addrouteID);
		backLayout.add(addrouteIDText);
		backLayout.add(addstart);
		backLayout.add(addstartText);
		backLayout.add(addterminal);
		backLayout.add(addterminalText);
		backLayout.add(addday);
		backLayout.add(adddayText);
		backLayout.add(btn_query);
		backLayout.add(mytitle);
		backLayout.add(addscenic);
		backLayout.add(addscenicText);
//		backLayout.add(addphone);
//		backLayout.add(addphoneText);
//		backLayout.add(addrank);
//		backLayout.add(addrankText);
//		backLayout.add(btn_transaction);

		showView(false, false, false, false, false);
		showData();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new routeUpdate();
	}

	public void showData() {
		String sql = "select * from `route`";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
			}
			size = count;
			info = new Object[count][5];
			count = 0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				info[count][0] = resultSet.getString("routeID");
				info[count][1] = resultSet.getString("starting");
				info[count][2] = resultSet.getString("terminal");
				info[count][3] = resultSet.getString("day");
				info[count][4] = resultSet.getString("scenic_point");
				count++;
			}
			routeTable = new JTable(info, title);
			scrollPane.getViewport().add(routeTable);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据查询错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == btn_query) {
			setVisible(false);
			new routeQuery();
		}
		else if(e.getSource() == btn_insert) {
			//插入数据
			int flag=1;//指示是否操作成功,默认为成功1;
			showView(true, true, true, true, true);
            String routeIDText=addrouteIDText.getText().toString().trim();
            String startText=addstartText.getText().toString().trim();
            String terminalText=addterminalText.getText().toString().trim();
            String dayText=adddayText.getText().toString().trim();
            String scenicText=addscenicText.getText().toString().trim();
            Integer day=0;
            day=day.parseInt(dayText);
            if(!routeIDText.isEmpty()&&!startText.isEmpty()&&!terminalText.isEmpty()&&!dayText.isEmpty()
            		&&!scenicText.isEmpty()) {
            	if(routeIDText.matches("[0-9]+") && 0<day && day<=30)
            		{           		
            		Route route=new Route();
            		route.setRouteID(Integer.parseInt(routeIDText));
            		route.setStarting(startText);
            		route.setTerminal(terminalText);
            		route.setDay(Integer.parseInt(dayText));
            		route.setScenic_point(scenicText);
            		try {
            			String sql="insert into `route` values("+route.getRouteID()+","+"'"+route.getStarting()+
            					"',"+"'"+route.getTerminal()+"',"+route.getDay()+","+"'"+route.getScenic_point()+"')";
            			try {
            				Connect.jdbcExecuteUpdate(sql);
            			}catch(SQLException e2) {
            				e2.printStackTrace();
            				flag=0;
            				JOptionPane.showMessageDialog(routeUpdate.this,"添加失败！");
            			}
            			//清零输入框
            			addrouteIDText.setText("");
            			addterminalText.setText("");
            			adddayText.setText("");
            			addstartText.setText("");
            			addscenicText.setText("");
            			if(flag==1)
            			{
            				JOptionPane.showMessageDialog(routeUpdate.this,"添加成功！");
            				showView(false, false, false, false, false);
            			}
            			showData();
            		}catch(Exception e1) {
            			JOptionPane.showMessageDialog(routeUpdate.this,"添加失败！");
            		}
            	}else {
            		JOptionPane.showMessageDialog(routeUpdate.this,"请输入合法数据!");
            	}
            } else {
            	JOptionPane.showMessageDialog(routeUpdate.this,"请输入非空数据!");
            }
            showData();
			//需要考虑外键？
            //删除操作(事务)
		} else if (e.getSource() == btn_delete) {
			int flag=1;
			showView(true, false, false, false, false);
			Route route = new Route();
			if (addrouteIDText.getText().toString().trim().matches("[0-9]+")) {
				route.setRouteID(Integer.parseInt(addrouteIDText.getText().toString()));
				try {
			        String sql="delete from `route` where `routeID`="+route.getRouteID()+"";	
			       
			        flag= Connect.jdbcTransaction(sql,flag);
			        if(flag==0) {
			        	JOptionPane.showMessageDialog(routeUpdate.this, "删除失败");
			        }			        
			        //////////隔离带		
			        
					addrouteIDText.setText("");
					if(flag==1)
					{
						JOptionPane.showMessageDialog(routeUpdate.this, "删除成功");
						showView(false, false, false, false, false);
					}
					showData();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(routeUpdate.this, "删除失败");
				}

			} else {
				JOptionPane.showMessageDialog(routeUpdate.this, "请输入合法guideID!");
			}
			//更新
		}else if(e.getSource()==btn_update) {
			showView(true, true, true, true, true);
            String routeIDText=addrouteIDText.getText().toString().trim();
            String startText=addstartText.getText().toString().trim();
            String terminalText=addterminalText.getText().toString().trim();
            String dayText=adddayText.getText().toString().trim();
            String scenicText=addscenicText.getText().toString().trim();
            Integer day=0;
            day=day.parseInt(dayText);
            int flag=1;
            if(!routeIDText.isEmpty()&&!startText.isEmpty()&&!terminalText.isEmpty()&&!dayText.isEmpty()&&!scenicText.isEmpty()) {
            	//限制范围 如果还想限制输入可以考虑正则匹配如match函数这样的
            	if(0<day && day<=30) 
            	{
            		Route route=new Route();
            		route.setRouteID(Integer.parseInt(routeIDText));
            		route.setStarting(startText);
            		route.setTerminal(terminalText);
            		route.setDay(Integer.parseInt(dayText));
            		route.setScenic_point(scenicText);
            		try {
//            			String sql="update `route` set `starting`= '"+route.getStarting()+"',"+"`terminal`= '"+route.getTerminal()+"',"+"`day`="+route.getDay()
//            			+","+"`scenic_point`='"+route.getScenic_point()+ "' where `routeID` = "+ route.getRouteID();
            			try {
//            				Connect.jdbcExecuteUpdate(sql, Integer.parseInt(routeIDText),Integer.parseInt(dayText));
//            				Connect.jdbcExecuteUpdate(sql);
            				Connect.jdbcExecuteUpdate(Integer.parseInt(routeIDText), Integer.parseInt(dayText), startText, terminalText, scenicText);
            			}catch(SQLException e2) {
            				e2.printStackTrace();
            				flag=0;
            				JOptionPane.showMessageDialog(routeUpdate.this,"修改失败！");
            			}
            			//清零输入框
            			addrouteIDText.setText("");
            			addterminalText.setText("");
            			adddayText.setText("");
            			addstartText.setText("");
            			addscenicText.setText("");
            			if(flag==1)
            			{
                			JOptionPane.showMessageDialog(routeUpdate.this,"修改成功！");
                			showView(false, false, false, false, false);
            			}           			
            			showData();
            		}catch(Exception e1) {
            			JOptionPane.showMessageDialog(routeUpdate.this,"修改失败！");
            		}          
            	}else {
            		JOptionPane.showMessageDialog(routeUpdate.this,"请输入合法数据!");
            	}
            }else {
            	JOptionPane.showMessageDialog(routeUpdate.this,"请输入非空数据!");
            }
            showData();		
            
		}
			
		
		
			
	}
	
	
	
	
	
	
	
	
	
	
	public void showView(boolean add_guideID,boolean add_name, boolean add_age, boolean add_gender, boolean add_IDnum){
		addrouteID.setVisible(add_guideID);
		addrouteIDText.setVisible(add_guideID);
		addstart.setVisible(add_name);
		addstartText.setVisible(add_name);
		addterminal.setVisible(add_age);
		addterminalText.setVisible(add_age);
		addday.setVisible(add_gender);
		adddayText.setVisible(add_gender);
		addscenic.setVisible(add_IDnum);
		addscenicText.setVisible(add_IDnum);
//		addphone.setVisible(add_phone);
//		addphoneText.setVisible(add_phone);
//		addrank.setVisible(add_rank);
//		addrankText.setVisible(add_rank);
	}

}
