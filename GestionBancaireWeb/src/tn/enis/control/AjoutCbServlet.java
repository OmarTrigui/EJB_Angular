package tn.enis.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.service.CompteBancaireServiceLocal;

import com.enis.dto.ClientBanqueDTO;
import com.enis.dto.CompteBancaireDTO;

/**
 * Servlet implementation class AjoutCbServlet1
 */
public class AjoutCbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;

	public AjoutCbServlet() {
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
		String soldeStr = "";
		float solde = 0f;

		try {
			cin = request.getParameter("cin");
			soldeStr = request.getParameter("solde");
			solde = Float.parseFloat(soldeStr);

			ClientBanqueDTO client = compteBancaireServiceLocal
					.getClientByCin(cin);

			if (client == null) {
				pr.write("The associated client is not found");
			} else {
				CompteBancaireDTO cDTO = new CompteBancaireDTO();
				cDTO.setClient(client);
				cDTO.setSolde(solde);
				compteBancaireServiceLocal.ajoutCompteBancaire(cDTO);
				pr.write("Account is successfully registered");
			}

		} catch (Exception e) {
			pr.write("Invalid input");
		}

	}

}
