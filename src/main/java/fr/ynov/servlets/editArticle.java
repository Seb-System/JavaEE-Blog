package fr.ynov.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ynov.daoexample.dao.DAOArticle;
import fr.ynov.daoexample.dao.DAOFactory;
import fr.ynov.daoexample.model.Article;

/**
 * Servlet implementation class addArticle
 */
public class editArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Article art = daoArticle.getArticle(id);
		
		if(art != null) {
			request.setAttribute("author",  art.getAuteur());
			request.setAttribute("title",  art.getTitle());
			request.setAttribute("desc",  art.getDescription());
			request.setAttribute("text",  art.getText());
		}


		this.getServletContext().getRequestDispatcher("/WEB-INF/editArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();

		String id = request.getParameter("id");

		System.out.println(id);

		Date now = new Date(System.currentTimeMillis());

		if (request.getParameter("author") != "" && request.getParameter("title") != ""
				&& request.getParameter("about") != "" && request.getParameter("content") != "") {
			daoArticle.updateArticle(
					new Article(Integer.valueOf(id), request.getParameter("author"), request.getParameter("title"),
							request.getParameter("about"), request.getParameter("content"), now));
			request.setAttribute("status", "Votre Article à bien été modifier");
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/editArticle.jsp").forward(request, response);

	}

}
