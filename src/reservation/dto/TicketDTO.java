package reservation.dto;

import java.sql.Date;

public class TicketDTO {

	private int ticketID;
	private String movieTitle;
	private String userID;
	private int seatID;
	private Date ticket_time;
		
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getSeatID() {
		return seatID;
	}
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	public Date getTicket_time() {
		return ticket_time;
	}
	public void setTicket_time(Date ticket_time) {
		this.ticket_time = ticket_time;
	}
	public TicketDTO() {
		
	}
	
	public TicketDTO(int ticketID,String movieTitle, String userID,int seatID, Date ticket_time) {
		this.ticketID = ticketID;
		this.movieTitle = movieTitle;
		this.userID = userID;
		this.seatID = seatID;
		this.ticket_time = ticket_time;
	}
	
}