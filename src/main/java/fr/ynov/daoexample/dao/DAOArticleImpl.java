package fr.ynov.daoexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.ynov.daoexample.model.Article;

public class DAOArticleImpl implements DAOArticle {

	private Connection connection;

	public DAOArticleImpl(Connection con) {
		connection = con;
	}

	public Article getArticle(int id) {

		Article article = new Article(id, null, null, null, null, null);

		try {
			String query = "SELECT * FROM articles WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() == false) {
				return null;
			} else {
				do {
					article.setId(rs.getInt("id"));
					article.setAuteur(rs.getString("auteur"));
					article.setTitle(rs.getString("titre"));
					article.setDescription(rs.getString("description"));
					article.setText(rs.getString("texte"));
					article.setDate(rs.getDate("date"));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	public List<Article> getLastArticles() {
		List<Article> article = new ArrayList<Article>();

		try {
			String query = "SELECT * FROM articles ORDER BY id DESC LIMIT 2;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				do {
					Article e = new Article(0, null, null, null, null, null);

					e.setId(rs.getInt("id"));
					e.setAuteur(rs.getString("auteur"));
					e.setTitle(rs.getString("titre"));
					e.setDescription(rs.getString("description"));
					e.setText(rs.getString("texte"));
					e.setDate(rs.getDate("date"));

					article.add(e);

				} while (rs.next());
			} else {
				System.err.println("Aucuns articles dans la base de donnée !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return article;
	}

	public List<Article> getAllArticles() {
		List<Article> article = new ArrayList<Article>();

		try {
			String query = "SELECT * FROM articles;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				do {
					Article e = new Article(0, null, null, null, null, null);

					e.setId(rs.getInt("id"));
					e.setAuteur(rs.getString("auteur"));
					e.setTitle(rs.getString("titre"));
					e.setDescription(rs.getString("description"));
					e.setText(rs.getString("texte"));
					e.setDate(rs.getDate("date"));

					article.add(e);

				} while (rs.next());
			} else {
				System.err.println("Aucuns articles dans la base de donnée !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return article;
	}

	public void addArticle(Article article) {
		try {
//		System.out.println("Auteur : " + article.getAuteur());
//		System.out.println("Titre : " + article.getTitle());
//		System.out.println("Description : " + article.getDescription());
//		System.out.println("Texte : " + article.getText());
//		System.out.println("Date : " + article.getDate());
			String query = "INSERT INTO articles(id,auteur,titre,description,texte,date) VALUES(null,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, article.getAuteur());
			ps.setString(2, article.getTitle());
			ps.setString(3, article.getDescription());
			ps.setString(4, article.getText());
			ps.setDate(5, article.getDate());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateArticle(Article article) {
		PreparedStatement ps;

		try {
			String query = "UPDATE articles SET auteur = ?, titre = ?, description = ?, texte = ?, date = ? WHERE id = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, article.getAuteur());
			ps.setString(2, article.getTitle());
			ps.setString(3, article.getDescription());
			ps.setString(4, article.getText());
			ps.setDate(5, article.getDate());
			ps.setInt(6, article.getId());

			int statut = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteArticle(int id) {

//		System.out.println("L'article n° " + id + " à bien été supprimer");
		PreparedStatement preparedStatement;

		try {
			String query = "DELETE FROM articles WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			int statut = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error >> " + e.getMessage());
		}
	}

}
