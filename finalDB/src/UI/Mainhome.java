package UI;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Mainhome extends JFrame implements ActionListener {
    private JMenuBar menuBar;//工具栏
    
    private JMenu menuRoute,menuTourist,menuTeam,menuSchedule,menuGuide,menuHotel,menuUsers,menuQuickQuery ;//工具栏菜单
    //工具栏菜单项
    private JMenuItem routeUpdate,touristUpdate,teamUpdate;
    private JMenuItem teamQuery,userUpdate,guideQuery,leadingQuery;
    private JMenuItem hotelQuery ,hotelUpdate,guideUpdate,touristQuery;
    private JMenuItem routeQuery,scheduleQuery,scheduleUpdate,fastQuery;
    //客户区
    private JLabel label,titleLabel;
    //标题未生效？
    private JFrame frame=new JFrame("旅行社管理系统");
    private Font font=new Font("宋体",Font.BOLD,22);
    private Font font1=new Font("宋体",Font.BOLD,15);
    private JButton exitBt;
 

    public Mainhome(){
    	//设置菜单名称
        menuTourist=new JMenu("游客管理");
        menuRoute=new JMenu("路线管理");
        menuTeam=new JMenu("旅行团管理");
        menuSchedule=new JMenu("班次管理");//行程
        menuGuide= new JMenu("导游管理");
        menuHotel=new JMenu("住宿管理");
        menuUsers =new JMenu("用户账号");
        menuQuickQuery=new JMenu("快捷查询");
        
        exitBt=new JButton("注销");
        exitBt.setFont(font1);
        exitBt.setFocusPainted(false);
        exitBt.setBounds(300,150,70,30);
        
        touristUpdate=new JMenuItem("游客信息修改*");
        touristQuery=new JMenuItem("游客信息查询");
        routeQuery=new JMenuItem("路线信息查询");
        routeUpdate=new JMenuItem("路线信息修改");
        teamUpdate=new JMenuItem("旅行团信息修改*");
        teamQuery=new JMenuItem("旅行团信息查询");
        scheduleQuery=new JMenuItem("班次信息查询");
        scheduleUpdate=new JMenuItem("班次信息修改*");
        guideQuery=new JMenuItem("导游信息查询");
        guideUpdate=new JMenuItem("导游信息修改");
//        hotelQuery=new JMenuItem("住宿信息查询");
        hotelUpdate=new JMenuItem("住宿信息管理*");
        userUpdate=new JMenuItem("账号信息管理*");
        fastQuery =new JMenuItem("快捷查询视图");
        leadingQuery=new JMenuItem("导游安排查询");

        //界面调整
    	this.setResizable(false);
        label=new JLabel(new ImageIcon("res/background3.jpg"));
        add(label);
        titleLabel=new JLabel("欢迎使用旅游管理系统V2.0");
        titleLabel.setBounds(200,40,300,80);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        label.add(titleLabel);
        label.add(exitBt);
        //图标
    	setIconImage(frame.getToolkit().getImage("res/ICON.png"));
        
        //new一个工具栏
        menuBar=new JMenuBar();
        //给工具菜单添加各自的工具项
        menuRoute.add(routeUpdate);
        menuRoute.add(routeQuery);
        menuTourist.add(touristUpdate);
        menuTourist.add(touristQuery);
        menuTeam.add(teamUpdate);
        menuTeam.add(teamQuery);
        menuSchedule.add(scheduleQuery);
        menuSchedule.add(scheduleUpdate);
        menuUsers.add(userUpdate);
        menuGuide.add(guideUpdate);
        menuGuide.add(guideQuery);
//        menuHotel.add(hotelQuery);
        menuHotel.add(hotelUpdate);
        menuQuickQuery.add(fastQuery);
        menuGuide.add(leadingQuery);

      //添加指定的动作侦听器，以接收发自此按钮的动作事件。当用户在此按钮上按下或释放鼠标时，发生动作事件

        routeUpdate.addActionListener(this);
        routeQuery.addActionListener(this);
        touristUpdate.addActionListener(this);
        touristQuery.addActionListener(this);
        teamUpdate.addActionListener(this);
        teamQuery.addActionListener(this);
        scheduleQuery.addActionListener(this);
        scheduleUpdate.addActionListener(this);
        guideQuery.addActionListener(this);
        guideUpdate.addActionListener(this);
//        hotelQuery.addActionListener(this);
        hotelUpdate.addActionListener(this);
        userUpdate.addActionListener(this);
        exitBt.addActionListener(this);
        fastQuery.addActionListener(this);
        leadingQuery.addActionListener(this);

        //给工具栏添加新的工具菜单
        menuBar.add(menuRoute);
        menuBar.add(menuTourist);
        menuBar.add(menuTeam);
        menuBar.add(menuSchedule);
        menuBar.add(menuGuide);
        menuBar.add(menuHotel);
        menuBar.add(menuUsers);
        menuBar.add(menuQuickQuery);
        
        //工具栏生效
        setJMenuBar(menuBar);
        
        setVisible(true);
        setBounds(400,150,700,500);//350 100 800 600
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
   //main函数
    public static void main(String[] args) {
    	new Mainhome();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==touristQuery){
    	   setVisible(false);
           new touristQuery();
       }else if(e.getSource()==exitBt){
    	   setVisible(false);
    	   new Login();
       }else if(e.getSource()==scheduleQuery){
    	   setVisible(false);
           new scheduleQuery();
       }else if(e.getSource()== routeQuery){
    	   setVisible(false);
           new routeQuery();
       }else if(e.getSource()==guideQuery) {
    	   setVisible(false);
    	   new guideQuery();
       }else if(e.getSource()==teamQuery) {
    	   setVisible(false);
    	   new teamQuery();
       }else if(e.getSource()==guideUpdate) {
    	   setVisible(false);
    	   new guideUpdate();
       }else if(e.getSource()==fastQuery) {
    	   setVisible(false);
    	   new fastqueryView();
       }else if(e.getSource()==leadingQuery) {
    	   setVisible(false);
    	   new leadingQuery();
       }else if(e.getSource()==routeUpdate) {
    	   setVisible(false);
    	   new routeUpdate();
       }
      }
    	
}
