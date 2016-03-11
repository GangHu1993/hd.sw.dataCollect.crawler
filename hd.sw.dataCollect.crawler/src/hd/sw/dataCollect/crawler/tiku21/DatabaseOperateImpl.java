package hd.sw.dataCollect.crawler.tiku21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:数据库操作。
*/ 

public class DatabaseOperateImpl implements DatabaseOperateInterface{
	public int insert(Metadata row){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/mathcrawler?useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(dburl, "root", "123456");
			//System.out.println("connection built");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(conn==null){
			System.out.println("database does not connect!");
			return 0;
		}
		String sql=null;
		//String url = frontpage;
		Statement stmt = null;

		sql = "CREATE DATABASE IF NOT EXISTS crawler";
		try {
			//if the database does not exist, create
			sql = "CREATE DATABASE IF NOT EXISTS mathcrawler";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			//use the database
			sql = "USE mathcrawler";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		
			sql = "insert into tiku21(title,description,webUrl) values('"+row.title+"','"+row.description+"','"+row.webUrl+"');";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = null;

		return 1;
	}

}
