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

public class Index extends HttpServlet {

	private static final long serialVersionUID = -211917049804938656L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOArticle daoArticle = factory.getDaoArticle();
		List<Article> articles = daoArticle.getLastArticles();

		if(daoArticle.getAllArticles().size() == 0) {
			req.setAttribute("title-1", "Empty");
			req.setAttribute("title-2", "Empty");

			req.setAttribute("text-1", "Empty");
			req.setAttribute("text-2", "Empty");
		} else if (daoArticle.getAllArticles().size() == 1) {
			req.setAttribute("title-1", articles.get(0).getTitle());
			req.setAttribute("title-2", "Empty");

			req.setAttribute("text-1", articles.get(0).getDescription());
			req.setAttribute("text-2", "Empty");
		} else {
			req.setAttribute("title-1", articles.get(0).getTitle());
			req.setAttribute("title-2", articles.get(1).getTitle());

			req.setAttribute("text-1", articles.get(0).getDescription());
			req.setAttribute("text-2", articles.get(1).getDescription());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		req.setAttribute("name", name);

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

}