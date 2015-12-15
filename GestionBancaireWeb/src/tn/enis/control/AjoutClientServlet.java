package tn.enis.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.exception.InvalidNameException;
import tn.enis.model.ClientBanqueEntity;
import tn.enis.service.ClientBanqueServiceLocal;
import antlr.PrintWriterWithSMAP;

import com.enis.dto.ClientBanqueDTO;

/**
 * Servlet implementation class AjoutCbServlet1
 */
public class AjoutClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	ClientBanqueServiceLocal clientBanqueServiceLocal;

	public AjoutClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pr = response.getWriter();
		
		String cin = "";
		String nom = "";
		String prenom = "";
		String adresse = "";

		try {
			cin = request.getParameter("cin");
			nom = request.getParameter("firstName");
			prenom = request.getParameter("lastName");
			adresse = request.getParameter("address");

		} catch (NullPointerException e) {
			pr.write("Invalid input");
		}

		ClientBanqueDTO client = clientBanqueServiceLocal
				.getClientByCin(cin);

		if (client != null) {
			pr.write("The Provided CIN already exists");

		} else {

			ClientBanqueDTO cDTO = new ClientBanqueDTO(cin, nom, prenom,
					adresse);
			try {
				clientBanqueServiceLocal.ajoutClientBanque(cDTO);
				pr.write("Client has been successfully registered");
			} catch (Exception e) {
				pr.write("Unknown Error");
			}
		}

	}
}
