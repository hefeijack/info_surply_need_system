package com.jackge.utils;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SqlHelper {

	//������Ҫ�ı���
	private static Connection ct=null;
	//���������£�����ʹ�õ���PreparedStatement�����Statement�����Է�ֹsqlע��
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static CallableStatement cs=null;

	//���ô洢���̣��ַ���Result
	//sql call���̣���������
	public static CallableStatement callPro2(String sql,String[] inparameters,Integer[] outparameters){
		try{
			ct=DBUtil.getConnection();
			cs=ct.prepareCall(sql);
			if(inparameters!=null){
				for(int i=0;i<inparameters.length;i++){
					cs.setObject(i+1, inparameters[i]);
				}
			}
		
		//��out������ֵ
		if(outparameters!=null){
			for(int i=0;i<outparameters.length;i++){
				cs.registerOutParameter(inparameters.length+1+i,outparameters[i] );
			}
		}
		cs.execute();
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		return cs;
	}
	//���ô洢����
	//sql��{sql���̣���������}
	public static void callProl(String sql,String[] parameters){
		try{
			ct=DBUtil.getConnection();
			cs=ct.prepareCall(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					cs.setObject(i+1, parameters[i]);
				}
			}
			cs.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,cs,ct);
		}
	}
	
	//�Ѳ�ѯ��װ��һ������
	//sql=select  ?,?,?from ? where ?=?.
	public ArrayList executeQuery(String sql,String []parameters){
		ArrayList al=new ArrayList();
		try{
			ct=DBUtil.getConnection();
			ps=ct.prepareStatement(sql);
			//��sql���ʺŸ�ֵ
			for(int i=0;i<parameters.length;i++){
				ps.setString(i+1, parameters[i]);
			}
			rs=ps.executeQuery();
			//��仰�ǳ�����
			ResultSetMetaData rsmd=rs.getMetaData();
			//ͨ��rsmd���Եõ��ý�����ж�����
			int columnNum=rsmd.getColumnCount();
			//ѭ���Ĵ�al��ȡ�����ݣ�����װ��ArrayList��
			while(rs.next()){
				Object []objects=new Object[columnNum];
				for( int i=0;i<objects.length;i++){
					objects[i]=rs.getObject(i+1);
				}
				al.add(objects);
			}
			return al;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			DBUtil.close(rs, ps, ct);
		}
	}
	//����ж��update/delete/insert[��Ҫ��������]
	public static void executeUpdate2(String sql[],String[][] parameters){
		try{
			//����
			//1.�������
			ct=DBUtil.getConnection();
			//��Ϊ��ʱ���û�����Ŀ����Ƕ��Sql���
			ct.setAutoCommit(false);
			for(int i=0;i<sql.length;i++){
				if(parameters[i]!=null){
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;i++){
						ps.setString(j+1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
			ct.commit();
		}catch(Exception e){
			e.printStackTrace();
			//�ع�
			try{
				ct.rollback();
			}catch(Exception e1){
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}
		finally{
			DBUtil.close(rs,ps,ct);
		}
	}
	//��дһ��update/delete/insert
	//sql��ʽ�� update ���� set �ֶ���=�� where �ֶ�=��
	//parametersӦ����{��abc",23};
	public boolean executeUpdate(String sql,String[] parameters){
		boolean b=false;
		//1.����һ��ps
		try{
			ct=DBUtil.getConnection();
			ps=ct.prepareStatement(sql);
			//������ֵ
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			//ִ��
			int num=ps.executeUpdate();
			if(num==1){
				b=true;
			}

		}catch(Exception e){
			e.printStackTrace();//�����׶�
			//�׳��쳣���׳������쳣�����Ը����øú����ĺ���һ��ѡ��
			//���Դ���Ҳ���Է�������
			throw new RuntimeException(e.getMessage());
		}finally{
			//�ر���Դ
			DBUtil.close(rs,ps,ct);
		}
		return b;
	}
}
