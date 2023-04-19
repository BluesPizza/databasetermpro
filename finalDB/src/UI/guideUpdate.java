package UI;

import connector.Connect;
import connector.UserInfo;
import tables.Tourist;
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

public class guideUpdate extends JFrame implements ActionListener {
	JFrame frame = new JFrame("导游信息管理");
	private JScrollPane scrollPane;
	private JButton btn_insert, btn_delete, btn_update,btn_transaction;
	private JPanel panel;
	private JTable guideTable;
	private DefaultTableModel defaultTableModel;
	private int size = 0;
	private Object[][] info;
	private String[] title = { "guideID", "name", "age", "gender", "IDnum", "phone", "rank" };
	private JLabel addguideID, addname, addage, addgender, addIDnum, addphone, addrank, mytitle;
	private JTextField addguideIDText, addnameText, addageText, addgenderText, addIDnumText, addphoneText, addrankText;
	private JButton btn_query,btn_toleading;
	private Background backLayout = new Background("res/background13.jpg");

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public guideUpdate() {
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// 框体
		backLayout.setLayout(null);
		add(backLayout);
		setSize(1200, 700);// 600*600
		setLayout(null);
		setLocation(180, 80);// 400 400

		Font font = new Font("黑体", Font.BOLD, 15);
		Font font1 = new Font("黑体", Font.BOLD, 22);

		// 标题
		mytitle = new JLabel("导游信息(管理员)");
		mytitle.setFont(font1);
		mytitle.setBounds(520, 40, 200, 40);
		mytitle.setForeground(Color.RED);

		// 控件
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 80, 800, 300);
		defaultTableModel = new DefaultTableModel();

		// 按钮
		btn_insert = new JButton("添加");
		btn_insert.setFocusable(false);
		btn_delete = new JButton("删除");
		btn_update = new JButton("修改");
		btn_query = new JButton("转到查询");
		btn_transaction =new JButton("事务演示");
		btn_toleading =new JButton("转到安排表");
		btn_insert.setFont(font);
		btn_delete.setFont(font);
		btn_update.setFont(font);
		btn_query.setFont(font);
		btn_toleading.setFont(font);
		btn_transaction.setFont(font);
		btn_insert.setBounds(400, 550, 100, 40);
		btn_delete.setBounds(500, 550, 100, 40);
		btn_update.setBounds(600, 550, 100, 40);
		btn_query.setBounds(700, 550, 100, 40);
		btn_transaction.setBounds(500,600,100,40);
		btn_toleading.setBounds(600,600,115,40);


		// 输入框
		addname = new JLabel("name:");
		addname.setBounds(450, 430, 150, 20);
		addname.setFont(font);
		addnameText = new JTextField(30);
		addnameText.setBounds(500, 430, 80, 20);

		addage = new JLabel("age:");
		addage.setFont(font);
		addage.setBounds(610, 430, 50, 20);
		addageText = new JTextField(30);
		addageText.setBounds(660, 430, 80, 20);

		addguideID = new JLabel("guideID:");
		addguideID.setFont(font);
		addguideID.setBounds(260, 430, 100, 20);
		addguideIDText = new JTextField(30);
		addguideIDText.setBounds(340, 430, 80, 20);

		addgender = new JLabel("gender:");
		addgender.setFont(font);
		addgender.setBounds(780, 430, 80, 20);
		addgenderText = new JTextField(30);
		addgenderText.setBounds(850, 430, 80, 20);

		addIDnum = new JLabel("IDnum:");
		addIDnum.setFont(font);
		addIDnum.setBounds(320,500,100,20);
		addIDnumText= new JTextField(30);
		addIDnumText.setBounds(380,500,100,20);
		
		addphone = new JLabel("phone:");
		addphone.setFont(font);
		addphone.setBounds(490, 500, 100, 20);
		addphoneText=new JTextField(30);
		addphoneText.setBounds(550,500,100,20);
		
		addrank =new JLabel("rank:");
		addrank.setFont(font);
		addrank.setBounds(670, 500, 100, 20);
		addrankText =new JTextField(30);
		addrankText.setBounds(720, 500, 100, 20);
		

		btn_insert.addActionListener(this);
		btn_delete.addActionListener(this);
		btn_update.addActionListener(this);
		btn_update.addActionListener(this);
		btn_query.addActionListener(this);
		btn_query.addActionListener(this);
		btn_transaction.addActionListener(this);
		btn_toleading.addActionListener(this);

		backLayout.add(scrollPane);
		backLayout.add(btn_insert);
		backLayout.add(btn_delete);
		backLayout.add(btn_update);
		backLayout.add(addguideID);
		backLayout.add(addguideIDText);
		backLayout.add(addname);
		backLayout.add(addnameText);
		backLayout.add(addage);
		backLayout.add(addageText);
		backLayout.add(addgender);
		backLayout.add(addgenderText);
		backLayout.add(btn_query);
		backLayout.add(mytitle);
		backLayout.add(addIDnum);
		backLayout.add(addIDnumText);
		backLayout.add(addphone);
		backLayout.add(addphoneText);
		backLayout.add(addrank);
		backLayout.add(addrankText);
		backLayout.add(btn_transaction);
		backLayout.add(btn_toleading);
		showView(false, false, false, false, false, false, false);
		showData();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new guideUpdate();
	}

	public void showData() {
		String sql = "select * from `guide`";
		int count = 0;
		connection = Connect.getConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
			}
			size = count;
			info = new Object[count][7];
			count = 0;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				info[count][0] = resultSet.getString("guideID");
				info[count][1] = resultSet.getString("name");
				info[count][2] = resultSet.getString("age");
				info[count][3] = resultSet.getString("gender");
				info[count][4] = resultSet.getString("IDnum");
				info[count][5] = resultSet.getString("phone");
				info[count][6] = resultSet.getString("rank");
				count++;
			}
			guideTable = new JTable(info, title);
			scrollPane.getViewport().add(guideTable);
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
			new guideQuery();
		}
		else if(e.getSource() == btn_insert) {
			//插入数据
			int flag=1;//指示是否操作成功,默认为成功1;
			showView(true, true, true, true, true, true, true);
            String guideIDText=addguideIDText.getText().toString().trim();
            String nameText=addnameText.getText().toString().trim();
            String ageText=addageText.getText().toString().trim();
            String genderText=addgenderText.getText().toString().trim();
            String IDnumText=addIDnumText.getText().toString().trim();
            String phoneText=addphoneText.getText().toString().trim();
            String rankText=addrankText.getText().toString().trim();
            Integer age=0;
            Integer rank=0;
            age=age.parseInt(ageText);
            rank=rank.parseInt(rankText);
            if(!guideIDText.isEmpty()&&!nameText.isEmpty()&&!ageText.isEmpty()&&!genderText.isEmpty()
            		&&!IDnumText.isEmpty()&&!phoneText.isEmpty()&&!rankText.isEmpty()) {
            	if(17<age && age<=75 && rank>0 && rank<=5)
            		{           		
            		Guide guide=new Guide();
            		guide.setGuideID(Integer.parseInt(guideIDText));
            		guide.setName(nameText);
            		guide.setAge(Integer.parseInt(ageText));
            		guide.setGender(genderText);
            		guide.setIDnum(IDnumText);
            		guide.setPhone(phoneText);
            		guide.setRank(Integer.parseInt(rankText));
            		try {
            			String sql="insert into `guide` values('"+guide.getGuideID()+"',"+"'"+guide.getName()+
            					"',"+"'"+guide.getAge()+"',"+"'"+guide.getGender()+"',"+"'"+guide.getIDnum()+"',"+"'"+guide.getPhone()+"',"+"'"+
            					guide.getRank()+"')";
            			try {
            				Connect.jdbcExecuteUpdate(sql);
            			}catch(SQLException e2) {
            				e2.printStackTrace();
            				flag=0;
            				JOptionPane.showMessageDialog(guideUpdate.this,"添加失败！");
            			}
            			//清零输入框
            			addguideIDText.setText("");
            			addageText.setText("");
            			addgenderText.setText("");
            			addnameText.setText("");
            			addphoneText.setText("");
            			addIDnumText.setText("");
            			addrankText.setText("");
            			if(flag==1)
            			{
            				JOptionPane.showMessageDialog(guideUpdate.this,"添加成功！");
            				showView(false, false, false, false, false, false, false);
            			}
            			showData();
            		}catch(Exception e1) {
            			JOptionPane.showMessageDialog(guideUpdate.this,"添加失败！");
            		}
            	}else {
            		JOptionPane.showMessageDialog(guideUpdate.this,"请输入合法数据!");
            	}
            } else {
            	JOptionPane.showMessageDialog(guideUpdate.this,"请输入非空数据!");
            }
            showData();
			//需要考虑外键？
            //删除操作(事务)
		} else if (e.getSource() == btn_delete) {
			int flag=1;
			showView(true, false, false, false, false, false, false);
			Guide guide = new Guide();
			if (addguideIDText.getText().toString().trim().matches("[0-9]+")) {
				guide.setGuideID(Integer.parseInt(addguideIDText.getText().toString()));
				try {
			        String sql="delete from guide where `guideID`="+guide.getGuideID()+"";	
			        
                    //////////隔离带			        
//			        try {
//			        	Connect.jdbcExecuteUpdate(sql);
//			        }catch(SQLException e2) {
//			        	e2.printStackTrace();
//			        	flag=0;
//						JOptionPane.showMessageDialog(guideUpdate.this, "删除失败");
//			        }
			        flag= Connect.jdbcTransaction(sql,flag);
			        if(flag==0) {
			        	JOptionPane.showMessageDialog(guideUpdate.this, "删除失败");
			        }			        
			        //////////隔离带		
			        
					addguideIDText.setText("");
					if(flag==1)
					{
						JOptionPane.showMessageDialog(guideUpdate.this, "删除成功");
						showView(false, false, false, false, false, false, false);
					}
					showData();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(guideUpdate.this, "删除失败");
				}

			} else {
				JOptionPane.showMessageDialog(guideUpdate.this, "请输入合法guideID!");
			}
			//更新
		}else if(e.getSource()==btn_update) {
			showView(true, true, true, true, true, true, true);
            String guideIDText=addguideIDText.getText().toString().trim();
            String nameText=addnameText.getText().toString().trim();
            String ageText=addageText.getText().toString().trim();
            String genderText=addgenderText.getText().toString().trim();
            String IDnumText=addIDnumText.getText().toString().trim();
            String phoneText=addphoneText.getText().toString().trim();
            String rankText=addrankText.getText().toString().trim();
            Integer age=0;
            int flag=1;
            age=age.parseInt(ageText);
            if(!guideIDText.isEmpty()&&!nameText.isEmpty()&&!ageText.isEmpty()&&!genderText.isEmpty()
            		&&!IDnumText.isEmpty()&&!phoneText.isEmpty()&&!rankText.isEmpty()) {
            	if(guideIDText.matches("[0-9]+") && ageText.matches("[0-9]+") &&17<age && age<=80 && IDnumText.matches("[0-9]+") &&
             			phoneText.matches("[0-9]+") && rankText.matches("[1-5]")) 
            	{
            		Guide guide=new Guide();
            		guide.setGuideID(Integer.parseInt(guideIDText));
            		guide.setName(nameText);
            		guide.setAge(Integer.parseInt(ageText));
            		guide.setGender(genderText);
            		guide.setIDnum(IDnumText);
            		guide.setPhone(phoneText);
            		guide.setRank(Integer.parseInt(rankText));
            		try {
            			String sql="update `guide` set `name`= '"+guide.getName()+"',"+"`age`="+guide.getAge()+","+"`gender`='"+guide.getGender()+"',"+"`IDnum`='"+guide.getIDnum()+"',"+"`phone`='"+guide.getPhone()+"',"+"`rank`="+
            					guide.getRank()+ " where `guideID` = "+ guide.getGuideID();
            			try {
            				Connect.jdbcExecuteUpdate(sql);
            			}catch(SQLException e2) {
            				e2.printStackTrace();
            				flag=0;
            				JOptionPane.showMessageDialog(guideUpdate.this,"修改失败！");
            			}
            			//清零输入框
            			addguideIDText.setText("");
            			addageText.setText("");
            			addgenderText.setText("");
            			addnameText.setText("");
            			addphoneText.setText("");
            			addIDnumText.setText("");
            			addrankText.setText("");
            			if(flag==1)
            			{
                			JOptionPane.showMessageDialog(guideUpdate.this,"修改成功！");
                			showView(false, false, false, false, false, false, false);
            			}           			
            			showData();
            		}catch(Exception e1) {
            			JOptionPane.showMessageDialog(guideUpdate.this,"修改失败！");
            		}          
            	}else {
            		JOptionPane.showMessageDialog(guideUpdate.this,"请输入合法数据!");
            	}
            }else {
            	JOptionPane.showMessageDialog(guideUpdate.this,"请输入非空数据!");
            }
            showData();		
            
		}else if(e.getSource()==btn_toleading) {
			setVisible(false);
			new leadingQuery();
		}else if (e.getSource()==btn_transaction) {
			int flag=1;
			showView(true, false, false, false, false, false, false);
			Guide guide = new Guide();
			if (addguideIDText.getText().toString().trim().matches("[0-9]+")) {
				guide.setGuideID(Integer.parseInt(addguideIDText.getText().toString()));
				try {
			        String sql="delete from `leading` where `guideID`="+guide.getGuideID();
			        String sql1="delete from `guide`  where `guideID`="+guide.getGuideID();
			        String[] sqls= new String[2];
			        sqls[0]=sql;
			        sqls[1]=sql1;
			        
                    //////////隔离带			        
			        flag= Connect.jdbcTransaction(sqls,2,flag);
			        if(flag==0) {
			        	JOptionPane.showMessageDialog(guideUpdate.this, "删除失败");
			        }			        
			        //////////隔离带		
			        
					addguideIDText.setText("");
					if(flag==1)
					{
						JOptionPane.showMessageDialog(guideUpdate.this, "删除成功");
						showView(false, false, false, false, false, false, false);
					}
					showData();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(guideUpdate.this, "删除失败");
				}

			} else {
				JOptionPane.showMessageDialog(guideUpdate.this, "请输入合法guideID!");
			}	
		}
		
	}
	

	public void showView(boolean add_guideID,boolean add_name, boolean add_age, boolean add_gender, boolean add_IDnum, boolean add_phone, boolean add_rank){
		addguideID.setVisible(add_guideID);
		addguideIDText.setVisible(add_guideID);
		addname.setVisible(add_name);
		addnameText.setVisible(add_name);
		addage.setVisible(add_age);
		addageText.setVisible(add_age);
		addgender.setVisible(add_gender);
		addgenderText.setVisible(add_gender);
		addIDnum.setVisible(add_IDnum);
		addIDnumText.setVisible(add_IDnum);
		addphone.setVisible(add_phone);
		addphoneText.setVisible(add_phone);
		addrank.setVisible(add_rank);
		addrankText.setVisible(add_rank);
	}

	
	
	
	
	
	
}
