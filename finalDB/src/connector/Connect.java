/**
 * 登录
 */
package connector;
import java.sql.*;

import javax.swing.JOptionPane;
import UI.guideUpdate;

public class Connect {
    static Connection connection=null;
    static Statement statement=null;
    //多条声明使用
    static Statement statement2=null;
    static Statement statements[];
    //调用函数
    static CallableStatement callStatment=null;
    static ResultSet resultSet=null;
    static ResultSet resultSet2=null;
    static String username=null;
    static String password=null;
    static String url=null;
    static String driverClass=null;
    static PreparedStatement preparedStatement=null;
    static PreparedStatement preparedStatement2=null;
    

    //加载数据
    static {
        username=UserInfo.username;
        password=UserInfo.password;
        url=UserInfo.url;
        driverClass=UserInfo.driverClass;
    }

    //连接数据库
    public static Connection getConn(){
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭
    public static void closeAll(Connection connection,Statement statement,ResultSet resultSet){
        closeConn(connection);
        closeSt(statement);
        closeRe(resultSet);
    }

    //关闭connection,statement,result
    public static void closeConn(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection=null;
            }
        }
    }

    public static void closeConn(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void closeSt(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                statement=null;
            }
        }
    }

    public static void closeRe(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                resultSet=null;
            }
        }
    }

    //更新
    public static void jdbcExecuteUpdate(String s) throws SQLException{
        connection=getConn();
        statement=connection.createStatement();
        statement.executeUpdate(s);
    }
    
    public static void jdbcExecuteUpdate(String s, Integer routeID, Integer day) throws SQLException{
        connection=getConn();
        statement=connection.createStatement();
        callStatment=connection.prepareCall("{call my_process(?,?)}");
        callStatment.setInt(1, routeID);
        callStatment.setInt(2, day);
        callStatment.executeUpdate();
        statement.executeUpdate(s);
        callStatment.close();
    }
    public static void jdbcExecuteUpdate(Integer routeID, Integer day, String starting, String terminal, String scenic) throws SQLException{
        connection=getConn();
        callStatment=connection.prepareCall("{call my_process(?,?,?,?,?)}");
        callStatment.setInt(1, routeID);
        callStatment.setInt(2, day);
        callStatment.setString(3, starting);
        callStatment.setString(4, terminal);
        callStatment.setString(5, scenic);
        callStatment.executeUpdate();
        callStatment.close();
    }

    //查询
    public static void jdbcExecuteQuery(String s) throws SQLException{
        connection=getConn();
        preparedStatement=connection.prepareStatement(s);
        resultSet=preparedStatement.executeQuery();
    }


    public static int jdbcTransaction(String s, String s1, int flag) throws SQLException {
    	try{
        connection=getConn();
        connection.setAutoCommit(false);
        statement=connection.createStatement();
        statement2=connection.createStatement();
        statement.executeUpdate(s);
        //手动异常
//        int i=3/0;
        statement2.executeUpdate(s1);
        connection.commit();

    	}catch(Exception e) {
    		flag=0;
    		try {
    			if(connection!=null) {
    				connection.rollback();
    			}
    		}catch(SQLException e1) {
    			e1.printStackTrace();
    			flag=0;
    		}
    		e.printStackTrace();
    	}finally {
    		closeConn(connection);
    		closeSt(statement);
    		closeSt(statement2);
    	}
    	return flag;
    }
    
    public static int jdbcTransaction(String s,int flag) throws SQLException {
    	try{
        connection=getConn();
        connection.setAutoCommit(false);
        statement=connection.createStatement();
        statement.executeUpdate(s);
        //手动异常
//        int i=3/0;
        connection.commit();
    	}catch(Exception e) {
    		flag=0;
    		try {
    			if(connection!=null) {
    				connection.rollback();
    			}
    		}catch(SQLException e1) {
    			e1.printStackTrace();
    		}
    		e.printStackTrace();
    	}finally {
    		closeConn(connection);
    		closeSt(statement);
    	}
    	return flag;
    }
    

    public static int jdbcTransaction(String[] sqls,int count, int flag) throws SQLException {
    	try{
        connection=getConn();
        connection.setAutoCommit(false);
        statements=new Statement[count];
        for(int i=0; i<count;i++) {
        	statements[i]=connection.createStatement();
        }
        for(int i=0;i<count;i++) {
            //手动异常用于测试
//        	if(i==1) {
//        		int j=3/0;
//        	}
        	statements[i].executeUpdate(sqls[i]);
        }
  
        connection.commit();

    	}catch(Exception e) {
    		flag=0;
    		try {
    			if(connection!=null) {
    				connection.rollback();
    			}
    		}catch(SQLException e1) {
    			e1.printStackTrace();
    			flag=0;
    		}
    		e.printStackTrace();
    	}finally {
    		closeConn(connection);
    		for(int i=0;i<count;i++) {
        		closeSt(statements[i]);
    		}

    	}
    	return flag;
    }
}
