package fr.ynov.daoexample.dao;
import java.util.List;

import fr.ynov.daoexample.model.Article;

public interface DAOArticle {
	
	public Article getArticle(int id);
	public List<Article> getAllArticles();
	public void addArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(int id);
	public List<Article> getLastArticles();

}
