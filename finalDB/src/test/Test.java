package test;
//package demo;
////ctrl shift o �����
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
//
//import tables.Guide;
//
///*
// * jdbc:mysql://localhost:3306/finalassignment?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8"
// */
//public class Demo {
//	private static String url="jdbc:mysql://localhost:3306/finalassignment"; 
//	private static String user="root"; 
//	private static String password="root";
//	
//	
//	public static void main(String[] args) {
//		Guide g=new Guide(7,"�ﶫ",20,"��","512454255885453252","13526547895",5);
//		update(g);
////		insert(g);
//		select();
//	}
//	
//	
//	
//	//��ѯ����
//	public static void select() {
//		try {
//			//��������
//			Class.forName("com.mysql.cj.jdbc.Driver");
//	
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//���Ӷ���
//		Statement stat=null;//������� ����ִ��SQL����
//		ResultSet res=null;
//		
//		try {
//			//��ȡ����
//			conn = DriverManager.getConnection(url, user, password);
//			//��ѯ����
//			String sql="Select * from guide";
//			stat=conn.createStatement();
//			res=stat.executeQuery(sql);
//			while(res.next()) {
//				String guideID =res.getString("guideID");
//				String name =res.getString("name");
//				String age =res.getString("age");
//				String gender =res.getString("gender");
//				String IDnum =res.getString("IDnum");
//				String phone =res.getString("phone");
//				String rank =res.getString("rank");
//				
//				Guide gd=new Guide(Integer.parseInt(guideID), name, Integer.parseInt(age), gender, IDnum, phone, Integer.parseInt(rank));
//				System.out.println(gd);
//			}		
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally{
//			
//			//�ر�conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//			//�ر�stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//			//�ر�res
//			try {
//				res.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}	
//		}
//	}
//	
//	
//	//ɾ������
//	public static void delete(Guide guide) {
//		try {
//			//��������
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//���Ӷ���
//		PreparedStatement stat=null;
//		
//		try {
//			//��ȡ����
//			conn = DriverManager.getConnection(url, user, password);
//			String sql="Delete from guide where guideID=?";
//			stat=conn.prepareStatement(sql);
//			stat.setInt(1, guide.getGuideID());//�������Ŵ�1��ʼ��
//			stat.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}finally{
//			
//			//�ر�conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//			//�ر�stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//		}
//		
//	}
//	
//		
//	//�������
//	public static void insert(Guide guide) {
//		try {
//			//��������
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//���Ӷ���
//		PreparedStatement stat=null;
//		
//		try {
//			//��ȡ����
//			conn = DriverManager.getConnection(url, user, password);
//			String sql="INSERT INTO guide(`guideID`,`name`,`age`,`gender`,`IDnum`,`phone`,`rank`) VALUES(?,?,?,?,?,?,?);";
//			stat=conn.prepareStatement(sql);
//			//����Ŀ����
//			stat.setInt(1, guide.getGuideID());//�������Ŵ�1��ʼ��
//			stat.setString(2, guide.getName());
//			stat.setInt(3, guide.getAge());
//			stat.setString(4, guide.getGender());
//			stat.setString(5, guide.getIDnum());
//			stat.setString(6, guide.getPhone());
//			stat.setInt(7, guide.getRank());
//			//ִ�в���
//			stat.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}finally{
//			
//			//�ر�conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//			//�ر�stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	//�������
//	public static void update(Guide guide) {
//		try {
//			//��������
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//���Ӷ���
//		PreparedStatement stat=null;
//		
//		try {
//			//��ȡ����
//			conn = DriverManager.getConnection(url, user, password);
//			String sql="UPDATE guide SET `name`=?, `age`=?, `gender`=?, `IDnum`=?, `phone`=?,`rank`=? WHERE `guideID`= ?;";
//			stat=conn.prepareStatement(sql);
//			//����Ŀ����
//			stat.setString(1, guide.getName());
//			stat.setInt(2, guide.getAge());
//			stat.setString(3, guide.getGender());
//			stat.setString(4, guide.getIDnum());
//			stat.setString(5, guide.getPhone());
//			stat.setInt(6, guide.getRank());
//			stat.setInt(7, guide.getGuideID());//�������Ŵ�1��ʼ��
//			//ִ�в���
//			stat.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}finally{
//			
//			//�ر�conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//			//�ر�stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//		}
//	}
//		
//		
//}


























