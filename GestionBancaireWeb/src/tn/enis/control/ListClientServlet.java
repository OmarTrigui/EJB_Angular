package tn.enis.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.helper.GsonHelper;
import tn.enis.service.ClientBanqueServiceLocal;

/**
 * Servlet implementation class AjoutCbServlet1
 */
public class ListClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	ClientBanqueServiceLocal clientBanqueServiceLocal;

	public ListClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pr = response.getWriter();

		pr.write(GsonHelper.getPrettyFormat(clientBanqueServiceLocal
				.getAllClientBanque()));

	}

}
