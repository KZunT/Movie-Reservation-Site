package reservation.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reservation.dao.TicketDAO;
import reservation.dto.TicketDTO;
import reservation.frontController.ActionForward;
import reservation.util.ModalUtil;
import reservatoin.command.Command;

public class UserTicketInfoViewCommand implements Command {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		boolean isRedirect = false;
		String viewPage = "userTicketInfoView.jsp";
		HttpSession session = request.getSession();
		int ticketID = 0;
		if (request.getParameter("ticketID") != null) {
			ticketID = Integer.parseInt(request.getParameter("ticketID"));
		}
		if(ticketID == 0) {
			session.setAttribute("modal", new ModalUtil("���� �޽���", "��ȿ���� ���� Ƽ���Դϴ�.", ModalUtil.ERROR));
			viewPage = "mainView.reservation";
			isRedirect = true;
		}
		TicketDTO ticket = new TicketDAO().getTicket(ticketID);
//		if (ticket.getBbsAvailable() == 0) {
//			session.setAttribute("modal", new ModalUtil("���� �޽���", "���� Ƽ�� �Դϴ�.", ModalUtil.ERROR));
//			viewPage = "mainView.reservation";
//			isRedirect = true;
//		}
		request.setAttribute("ticket", ticket);
		return new ActionForward(isRedirect, viewPage);
	}
	
}