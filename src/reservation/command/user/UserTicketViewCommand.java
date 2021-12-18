package reservation.command.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.dao.TicketDAO;
import reservation.dto.TicketDTO;
import reservation.frontController.ActionForward;
import reservatoin.command.Command;

public class UserTicketViewCommand implements Command {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		boolean isRedirect = false;
		String viewPage = "userTicketView.jsp";
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		TicketDAO ticketDAO = new TicketDAO();
		ArrayList<TicketDTO> list = ticketDAO.getList(pageNumber);
		request.setAttribute("list", list);
		request.setAttribute("pageNumber", pageNumber);
//		request.setAttribute("nextExist", TicketDAO.nextPage(pageNumber));
		return new ActionForward(isRedirect, viewPage);
	}
	
}