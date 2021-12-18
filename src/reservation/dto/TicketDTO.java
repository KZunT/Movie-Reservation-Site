package reservation.dto;

import java.sql.Date;

public class TicketDTO {

	private int ticketID;
	private int movieID;
	private String userID;
	private int seatID;
	private String ticket_payment;
	private Date ticket_time;
		
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
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
	public String getTicket_payment() {
		return ticket_payment;
	}
	public void setTicket_payment(String ticket_payment) {
		this.ticket_payment = ticket_payment;
	}
	public Date getTicket_time() {
		return ticket_time;
	}
	public void setTicket_time(Date ticket_time) {
		this.ticket_time = ticket_time;
	}
	public TicketDTO() {
		
	}
	
	public TicketDTO(int ticketID,int movieID, String userID,int seatID,String ticket_payment, Date ticket_time) {
		this.ticketID = ticketID;
		this.movieID = movieID;
		this.userID = userID;
		this.seatID = seatID;
		this.ticket_payment = ticket_payment;
		this.ticket_time = ticket_time;
	}
	
}