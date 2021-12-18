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
	
//	public int write(String bbsTitle, String userID, String bbsContent) {
//		String SQL = "INSERT INTO RESERVATION_BBS VALUES (?, ?, ?, ?, ?, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, getNext());
//			pstmt.setString(2, bbsTitle);
//			pstmt.setString(3, userID);
//			pstmt.setDate(4, getDate());
//			pstmt.setString(5, bbsContent);
//			pstmt.setInt(6, 1);
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
	
//	public boolean nextPage(int pageNumber) {
//		String SQL = "SELECT * FROM RESERVATION_TICKET WHERE ticketID;";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, getNext() - (pageNumber) * 10);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
//		}
//		return false; // 데이터베이스 오류
//	}
	
	
//	public ArrayList<TicketDTO> getList(int pageNumber) {
//		String SQL = "SELECT * FROM RESERVATION_TICKET WHERE ticketID < ? ORDER BY ticketID DESC LIMIT 10";
//		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				TicketDTO ticket = new TicketDTO();
//				ticket.setTicketID(rs.getInt(1));
//				ticket.setMovieID(rs.getInt(2));
//				ticket.setUserID(rs.getString(3));
//				ticket.setSeatID(rs.getInt(4));
//				ticket.setTicket_payment(rs.getString(5));
//				ticket.setTicket_time(rs.getDate(6));
//				list.add(ticket);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace();}
//			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
//		}
//		return list; // 데이터베이스 오류
//	}
	
	public  ArrayList<TicketDTO> getList(int pageNumber) {
		String SQL = "SELECT * FROM RESERVATION_TICKET WHERE ticketID < ? ORDER BY ticketID DESC LIMIT 10";
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TicketDTO ticket = new TicketDTO();
				ticket.setTicketID(rs.getInt(1));
				ticket.setMovieID(rs.getInt(2));
				ticket.setUserID(rs.getString(3));
				ticket.setSeatID(rs.getInt(4));
				ticket.setTicket_payment(rs.getString(5));
				ticket.setTicket_time(rs.getDate(6));
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
				ticket.setMovieID(rs.getInt(2));
				ticket.setUserID(rs.getString(3));
				ticket.setSeatID(rs.getInt(4));
				ticket.setTicket_payment(rs.getString(5));
				ticket.setTicket_time(rs.getDate(6));
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
