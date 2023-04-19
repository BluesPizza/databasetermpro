package test;
//package demo;
////ctrl shift o 导入包
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
//		Guide g=new Guide(7,"孙东",20,"男","512454255885453252","13526547895",5);
//		update(g);
////		insert(g);
//		select();
//	}
//	
//	
//	
//	//查询函数
//	public static void select() {
//		try {
//			//加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//	
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//连接对象
//		Statement stat=null;//声明语句 用于执行SQL操作
//		ResultSet res=null;
//		
//		try {
//			//获取连接
//			conn = DriverManager.getConnection(url, user, password);
//			//查询功能
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
//			//关闭conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//			//关闭stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//			//关闭res
//			try {
//				res.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}	
//		}
//	}
//	
//	
//	//删除操作
//	public static void delete(Guide guide) {
//		try {
//			//加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//连接对象
//		PreparedStatement stat=null;
//		
//		try {
//			//获取连接
//			conn = DriverManager.getConnection(url, user, password);
//			String sql="Delete from guide where guideID=?";
//			stat=conn.prepareStatement(sql);
//			stat.setInt(1, guide.getGuideID());//这里的序号从1开始排
//			stat.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}finally{
//			
//			//关闭conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//			//关闭stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//		}
//		
//	}
//	
//		
//	//插入操作
//	public static void insert(Guide guide) {
//		try {
//			//加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//连接对象
//		PreparedStatement stat=null;
//		
//		try {
//			//获取连接
//			conn = DriverManager.getConnection(url, user, password);
//			String sql="INSERT INTO guide(`guideID`,`name`,`age`,`gender`,`IDnum`,`phone`,`rank`) VALUES(?,?,?,?,?,?,?);";
//			stat=conn.prepareStatement(sql);
//			//载入目标行
//			stat.setInt(1, guide.getGuideID());//这里的序号从1开始排
//			stat.setString(2, guide.getName());
//			stat.setInt(3, guide.getAge());
//			stat.setString(4, guide.getGender());
//			stat.setString(5, guide.getIDnum());
//			stat.setString(6, guide.getPhone());
//			stat.setInt(7, guide.getRank());
//			//执行插入
//			stat.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}finally{
//			
//			//关闭conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//			//关闭stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	//插入操作
//	public static void update(Guide guide) {
//		try {
//			//加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;//连接对象
//		PreparedStatement stat=null;
//		
//		try {
//			//获取连接
//			conn = DriverManager.getConnection(url, user, password);
//			String sql="UPDATE guide SET `name`=?, `age`=?, `gender`=?, `IDnum`=?, `phone`=?,`rank`=? WHERE `guideID`= ?;";
//			stat=conn.prepareStatement(sql);
//			//载入目标行
//			stat.setString(1, guide.getName());
//			stat.setInt(2, guide.getAge());
//			stat.setString(3, guide.getGender());
//			stat.setString(4, guide.getIDnum());
//			stat.setString(5, guide.getPhone());
//			stat.setInt(6, guide.getRank());
//			stat.setInt(7, guide.getGuideID());//这里的序号从1开始排
//			//执行插入
//			stat.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}finally{
//			
//			//关闭conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//			//关闭stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//		}
//	}
//		
//		
//}


























