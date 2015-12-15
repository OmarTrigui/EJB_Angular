package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.service.CompteBancaireServiceLocal;

import com.enis.dto.CompteBancaireDTO;

/**
 * Servlet implementation class AjoutCbServlet1
 */
public class SupprimerCbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;

	public SupprimerCbServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String rib = request.getParameter("rib");

		CompteBancaireDTO compte = compteBancaireServiceLocal
				.getAccountByRib(Long.parseLong(rib));

		if (compte == null) {
			System.out.println("Compte introuvable");
		} else {

			CompteBancaireDTO cDTO = new CompteBancaireDTO();

			cDTO.setRib(Long.parseLong(rib));
			cDTO.setSolde(compte.getSolde());
			cDTO.setClient(compte.getClient());

			compteBancaireServiceLocal.supprimerCompteBancaire(cDTO);
		}

	}

}
