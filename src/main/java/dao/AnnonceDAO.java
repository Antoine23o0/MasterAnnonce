package dao;

import db.ConnectionDB;
import modele.entite.AnnonceEntite;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO extends DAO<AnnonceEntite> {

    public AnnonceDAO(Connection connection) {
        super(connection);
    }
    public AnnonceDAO () throws ClassNotFoundException {
        super(ConnectionDB.getInstance());
    }

    @Override
    public boolean insert(AnnonceEntite annonce) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, annonce.getTitle());
            stmt.setString(2, annonce.getDescription());
            stmt.setString(3, annonce.getAdresse());
            stmt.setString(4, annonce.getMail());

            stmt.setDate(5, Date.valueOf(LocalDate.now()));
            
            int rowsInserted = stmt.executeUpdate();
            System.out.println("Insertion réussie ! " + rowsInserted + " ligne(s) ajoutée(s).");
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERREUR lors de l'insertion !");
        }
        return false;
    }

    @Override
    public boolean update(AnnonceEntite annonce) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE annonce SET title=?, description=?, adress=?, mail=?, date=? WHERE id=?");
            stmt.setString(1, annonce.getTitle());
            stmt.setString(2, annonce.getDescription());
            stmt.setString(3, annonce.getAdresse());
            stmt.setString(4, annonce.getMail());

            stmt.setDate(5, Date.valueOf(annonce.getDate()));

            stmt.setInt(6, annonce.getId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Mise à jour réussie ! " + rowsUpdated + " ligne(s) mise(s) à jour.");
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERREUR lors de la mise à jour !");
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM annonce WHERE id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public List<AnnonceEntite> getAll() {
        List<AnnonceEntite> annonces = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM annonce");
            while (rs.next()) {
                annonces.add(new AnnonceEntite(rs.getInt("id"), rs.getString("title"),
                        rs.getString("description"), rs.getDate("date").toString(),
                        rs.getString("mail"), rs.getString("adresse")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return annonces;
    }

    @Override
    public AnnonceEntite getById(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annonce WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new AnnonceEntite(rs.getInt("id"), rs.getString("title"),
                        rs.getString("description"), rs.getString("adress"),
                        rs.getString("mail"), rs.getString("date"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
