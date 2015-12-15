package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.service.ClientBanqueServiceLocal;

import com.enis.dto.ClientBanqueDTO;

/**
 * Servlet implementation class AjoutCbServlet1
 */
public class SupprimerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	ClientBanqueServiceLocal clientBanqueServiceLocal;

	public SupprimerClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cin = request.getParameter("cin");

		ClientBanqueDTO client = clientBanqueServiceLocal.getClientByCin(cin);

		if (client == null) {
			System.out.println("Client introuvable");
		} else {

			ClientBanqueDTO cDTO = new ClientBanqueDTO(client.getCin(),
					client.getNomClient(), client.getPrenomClient(),
					client.getAdresse());

			clientBanqueServiceLocal.supprimerClientBanque(cDTO);
		}
	}
}