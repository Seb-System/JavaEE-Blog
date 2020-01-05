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
public class viewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewArticle() {
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
			request.setAttribute("date",  art.getDate());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/viewArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
			request.setAttribute("date",  art.getDate());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/viewArticle.jsp").forward(request, response);
	}

}
