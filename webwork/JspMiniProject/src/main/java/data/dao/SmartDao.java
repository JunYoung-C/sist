package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.GuestDto;
import data.dto.SmartDto;
import mysql.db.DbConnect;

public class SmartDao {

	DbConnect db=new DbConnect();
	
	//insert
		public void insertSmart(SmartDto dto)
		{
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			String sql="insert into smartboard (writer,subject,content,writeday) values (?,?,?,now())";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		//totalCount
		public int getTotalCount()
		{
			int n=0;
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select count(*) from smartboard";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next())
					n=rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			
			return n;
		}
		
		//전체출력...페이지에서 필요한 만큼만 리턴
		public List<SmartDto> getList(int start,int perpage)
		{
			List<SmartDto> list=new Vector<SmartDto>();
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from smartboard order by num desc limit ?,?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(1, start);
				pstmt.setInt(2, perpage);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					SmartDto dto=new SmartDto();
					
					dto.setNum(rs.getString("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			
			return list;
		}
		
		//num에해당하는 dto반환
		public SmartDto getData(String num)
		{
			SmartDto dto=new SmartDto();
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from smartboard where num=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setNum(rs.getString("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setWriteday(rs.getTimestamp("writeday"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			
			return dto;
		}
		
	
	
	//조회수증가
		public void updateReadCount(String num)
		{
			String sql="update smartboard set readcount="
					+ "readcount+1 where num=?";
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, num);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
	
	
	
}
