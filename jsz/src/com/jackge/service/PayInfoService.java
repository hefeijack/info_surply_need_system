package com.jackge.service;

import java.util.ArrayList;
import java.sql.*;

import com.jackge.domain.PageBean;
import com.jackge.domain.PayInfo;
import com.jackge.utils.DBUtil;

public class PayInfoService {

	//��ҳ
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	//�õ�������Ϣ
	public void getPayInfo(PageBean pb){
		
		int pageSize = pb.getPageSize();
		int pageNow = pb.getPageNow();
		ArrayList al = pb.getAl();
		int rowCount = 0;
		int pageCount = 0;
		
		try {
			
			ct = DBUtil.getConnection();
			ps = ct.prepareStatement("select * from (select t1.*, rownum rn from (select * from payInfo) t1 where rownum<=?) where rn>=?");
			
			int start = (pageNow-1) * pageSize + 1;
			int end = pageNow * pageSize;
			ps.setInt(1, end);
			ps.setInt(2, start);
			rs = ps.executeQuery();
			while(rs.next()){
				PayInfo payInfo = new PayInfo();
				payInfo.setId(rs.getInt("id"));
				payInfo.setTitle(rs.getString("title"));
				payInfo.setCheckState(rs.getShort("checkState"));
				payInfo.setContent(rs.getString("content"));
				payInfo.setDate(rs.getDate("date"));
				payInfo.setKeepDays(rs.getShort("keepDays"));
				payInfo.setLinkman(rs.getString("linkman"));
				payInfo.setTel(rs.getString("tel"));
				
				al.add(payInfo);
			}
			
			//���㹲�ж���ҳ
			ps = ct.prepareStatement("select count(*) from payInfo");
			rs = ps.executeQuery();
			if(rs.next()){
				rowCount = rs.getInt(1);
			}

			pageCount = (rowCount-1)/pageSize+1;
			
			//�Ѽ���������pageBean
			pb.setPageCount(pageCount);
			pb.setRowCount(rowCount);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			DBUtil.close(rs, ps, ct);
		}
	}
	
}
