package reservation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import reservation.dto.TicketDTO;
import reservation.util.DatabaseUtil;

public class TicketDAO {
	
	public Date getDate() {
		String SQL = "SELECT now()";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getDate(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return null; // 데이터베이스 오류
	}
	
	public int getNext() {
		String SQL = "SELECT ticketID FROM RESERVATION_TICKET ORDER BY ticketID DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; // 데이터베이스 오류
	}
	
	public String getMoiveTitle(int movieID) {
		String SQL = "SELECT movieTitle FROM RESERVATION_MOVIE WHERE movieID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, movieID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			    String movietitle=rs.getString(1);
				return movietitle;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return null; // 데이터베이스 오류
	}
	
	public int ticketing(int movieID, String userID, int seatID) {
		String SQL = "INSERT INTO RESERVATION_TICKET VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, getMoiveTitle(movieID));
//			pstmt.setString(2, String.valueOf(movieID));
			pstmt.setString(3, userID);
			pstmt.setInt(4, seatID);
			pstmt.setDate(5, getDate());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; // 데이터베이스 오류
	}	
	
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM RESERVATION_TICKET;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber) * 10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return false; // 데이터베이스 오류
	}
	
	
	public  ArrayList<TicketDTO> getList(int pageNumber,String userID) {
		//String SQL = "SELECT * FROM RESERVATION_TICKET WHERE ticketID < ? ORDER BY ticketID DESC LIMIT 10";
		String SQL = "SELECT * FROM RESERVATION_TICKET WHERE ticketID < ?  AND userID = ? ORDER BY ticketID DESC LIMIT 10";
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//System.out.println(userID+"test입니다");
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			pstmt.setString(2, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TicketDTO ticket = new TicketDTO();
				ticket.setTicketID(rs.getInt(1));
				ticket.setMovieTitle(rs.getString(2));
				ticket.setUserID(rs.getString(3));
				ticket.setSeatID(rs.getInt(4));
				ticket.setTicket_time(rs.getDate(5));
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return list; // 데이터베이스 오류
	}
	
	public TicketDTO getTicket(int ticketID) {
		String SQL = "SELECT * FROM RESERVATION_TICKET WHERE ticketID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, ticketID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TicketDTO ticket = new TicketDTO();
				ticket.setTicketID(rs.getInt(1));
				ticket.setMovieTitle(rs.getString(2));
				ticket.setUserID(rs.getString(3));
				ticket.setSeatID(rs.getInt(4));
				ticket.setTicket_time(rs.getDate(5));
				return ticket;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return null; // 데이터베이스 오류
	}
	
//	public int update(int bbsID, String bbsTitle, String bbsContent) {
//		String SQL = "UPDATE RESERVATION_BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;		
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, bbsTitle);
//			pstmt.setString(2, bbsContent);
//			pstmt.setInt(3, bbsID);
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
//		}
//		return -1; // 데이터베이스 오류
//	}
//	
//	public int delete(int bbsID) {
//		String SQL = "UPDATE RESERVATION_BBS SET bbsAvailable = 0 WHERE bbsID = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, bbsID);
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
//		}
//		return -1; // 데이터베이스 오류
//	}	
	
	
}
