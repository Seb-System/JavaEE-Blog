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
public class addArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();

		Date now = new Date(System.currentTimeMillis());
		

		if (request.getParameter("author") != "" && request.getParameter("title") != ""
				&& request.getParameter("about") != "" && request.getParameter("content") != "") {
			daoArticle.addArticle(new Article(0, request.getParameter("author"), request.getParameter("title"),
					request.getParameter("about"), request.getParameter("content"), now));
			request.setAttribute("status", "Votre Article à bien été ajouté");
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(request, response);

	}

}
