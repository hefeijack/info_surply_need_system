package com.jackge.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
public class DBUtil {
	//�������
	private static Connection ct=null;
	//������������preparedstatement���atatement
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	//�������ݿ�Ĳ���
	private  static String url="";
	private static String username="";
	private static String driver="";
	private static String password="";
	//�������ļ�
	private static Properties pp=null;
	private static InputStream fis=null;
	
	//����������ֻ��Ҫһ�Σ��þ�̬�����
	static{
		try{
			//��dbinfo.properties�ļ��ж�ȡ������Ϣ
			pp=new Properties();
			//fis=new FileInputStream("dbinfo.properties");//=>tomcat����Ŀ¼��
			//������ʹ��java web��ʱ�򣬶�ȡ�ļ�Ҫʹ���������[��Ϊ�������ȥ��ȡ��Դ��ʱ��Ĭ�ϵ���Ŀ¼��srcĿ¼
			fis=DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			
			pp.load(fis);
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			driver=pp.getProperty("driver");
			password=pp.getProperty("password");
			//1.��������
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fis.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			fis=null;    //��������վ����ʰ
		}
	}
	//�õ�����
	public static Connection getConnection(){
		try{
			//��������
			ct=DriverManager.getConnection(url,username,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
	//�ر���Դ�ĺ���
	public static void close(ResultSet rs,Statement ps,Connection ct){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			rs=null;
		}
		if(ps!=null){
			try{
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			ps=null;
		}
		if(ct!=null){
			try{
				ct.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			ct=null;
		}
	}
}
