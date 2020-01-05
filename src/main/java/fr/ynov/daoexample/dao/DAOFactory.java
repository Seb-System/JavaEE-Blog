package fr.ynov.daoexample.dao;

public class DAOFactory {
	private MySQLManager manager;
	private DAOArticle daoArticle;
	public DAOFactory() {
		manager = MySQLManager.getInstance();
		daoArticle = new DAOArticleImpl(manager.getConnection());
	}
	
	public DAOArticle getDaoArticle() {
		return daoArticle;
	}
} 