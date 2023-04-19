package UI;

import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Mainhome extends JFrame implements ActionListener {
    private JMenuBar menuBar;//������
    
    private JMenu menuRoute,menuTourist,menuTeam,menuSchedule,menuGuide,menuHotel,menuUsers,menuQuickQuery ;//�������˵�
    //�������˵���
    private JMenuItem routeUpdate,touristUpdate,teamUpdate;
    private JMenuItem teamQuery,userUpdate,guideQuery,leadingQuery;
    private JMenuItem hotelQuery ,hotelUpdate,guideUpdate,touristQuery;
    private JMenuItem routeQuery,scheduleQuery,scheduleUpdate,fastQuery;
    //�ͻ���
    private JLabel label,titleLabel;
    //����δ��Ч��
    private JFrame frame=new JFrame("���������ϵͳ");
    private Font font=new Font("����",Font.BOLD,22);
    private Font font1=new Font("����",Font.BOLD,15);
    private JButton exitBt;
 

    public Mainhome(){
    	//���ò˵�����
        menuTourist=new JMenu("�ο͹���");
        menuRoute=new JMenu("·�߹���");
        menuTeam=new JMenu("�����Ź���");
        menuSchedule=new JMenu("��ι���");//�г�
        menuGuide= new JMenu("���ι���");
        menuHotel=new JMenu("ס�޹���");
        menuUsers =new JMenu("�û��˺�");
        menuQuickQuery=new JMenu("��ݲ�ѯ");
        
        exitBt=new JButton("ע��");
        exitBt.setFont(font1);
        exitBt.setFocusPainted(false);
        exitBt.setBounds(300,150,70,30);
        
        touristUpdate=new JMenuItem("�ο���Ϣ�޸�*");
        touristQuery=new JMenuItem("�ο���Ϣ��ѯ");
        routeQuery=new JMenuItem("·����Ϣ��ѯ");
        routeUpdate=new JMenuItem("·����Ϣ�޸�");
        teamUpdate=new JMenuItem("��������Ϣ�޸�*");
        teamQuery=new JMenuItem("��������Ϣ��ѯ");
        scheduleQuery=new JMenuItem("�����Ϣ��ѯ");
        scheduleUpdate=new JMenuItem("�����Ϣ�޸�*");
        guideQuery=new JMenuItem("������Ϣ��ѯ");
        guideUpdate=new JMenuItem("������Ϣ�޸�");
//        hotelQuery=new JMenuItem("ס����Ϣ��ѯ");
        hotelUpdate=new JMenuItem("ס����Ϣ����*");
        userUpdate=new JMenuItem("�˺���Ϣ����*");
        fastQuery =new JMenuItem("��ݲ�ѯ��ͼ");
        leadingQuery=new JMenuItem("���ΰ��Ų�ѯ");

        //�������
    	this.setResizable(false);
        label=new JLabel(new ImageIcon("res/background3.jpg"));
        add(label);
        titleLabel=new JLabel("��ӭʹ�����ι���ϵͳV2.0");
        titleLabel.setBounds(200,40,300,80);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        label.add(titleLabel);
        label.add(exitBt);
        //ͼ��
    	setIconImage(frame.getToolkit().getImage("res/ICON.png"));
        
        //newһ��������
        menuBar=new JMenuBar();
        //�����߲˵���Ӹ��ԵĹ�����
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

      //���ָ���Ķ������������Խ��շ��Դ˰�ť�Ķ����¼������û��ڴ˰�ť�ϰ��»��ͷ����ʱ�����������¼�

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

        //������������µĹ��߲˵�
        menuBar.add(menuRoute);
        menuBar.add(menuTourist);
        menuBar.add(menuTeam);
        menuBar.add(menuSchedule);
        menuBar.add(menuGuide);
        menuBar.add(menuHotel);
        menuBar.add(menuUsers);
        menuBar.add(menuQuickQuery);
        
        //��������Ч
        setJMenuBar(menuBar);
        
        setVisible(true);
        setBounds(400,150,700,500);//350 100 800 600
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
   //main����
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
