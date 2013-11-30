package com.jackge.service;

import java.util.ArrayList;
import java.sql.*;

import com.jackge.domain.PageBean;
import com.jackge.domain.PayInfo;
import com.jackge.utils.DBUtil;

public class PayInfoService {

	//分页
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	//得到付费信息
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
			
			//计算共有多少页
			ps = ct.prepareStatement("select count(*) from payInfo");
			rs = ps.executeQuery();
			if(rs.next()){
				rowCount = rs.getInt(1);
			}

			pageCount = (rowCount-1)/pageSize+1;
			
			//把计算结果交给pageBean
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
