package fr.ynov.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ynov.daoexample.dao.DAOArticle;
import fr.ynov.daoexample.dao.DAOFactory;
import fr.ynov.daoexample.model.Article;

/**
 * Servlet implementation class listArticles
 */
public class listArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listArticles() {
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
		List<Article> articles = daoArticle.getAllArticles();

		request.setAttribute("articles", articles);

		this.getServletContext().getRequestDispatcher("/WEB-INF/listArticles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("button");
		String id = request.getParameter("id");

		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		List<Article> articles = daoArticle.getAllArticles();

		request.setAttribute("articles", articles);

		if ("Voir".equals(button)) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/listArticles.jsp").forward(request, response);
		} else if ("Supprimer".equals(button)) {
			daoArticle.deleteArticle(Integer.valueOf(id));
			request.setAttribute("status", "Votre Article à bien été supprimé");
			this.getServletContext().getRequestDispatcher("/WEB-INF/listArticles.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/listArticles.jsp").forward(request, response);
		}

	}

}
