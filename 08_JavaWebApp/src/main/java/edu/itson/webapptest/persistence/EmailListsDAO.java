package edu.itson.webapptest.persistence;

import com.mysql.cj.xdevapi.PreparableStatement;
import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.PersistenceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class EmailListsDAO {

    public EmailListsDAO() {
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/webapp",
                "root",
                "325a7fd7a79a"
        );

    }

    public Email create(final Email email) throws PersistenceException {

        String query = "INSERT INTO emails(username, email) VALUES( ? , ? )";

        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email.getUsername());
            statement.setString(2, email.getCorreo());
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Error al crear email: " + ex.getMessage());
        }

        return email;
    }

    public List<Email> findAll() throws PersistenceException {
        List<Email> emails = new LinkedList<>();

        String query = "SELECT id, email, username FROM emails;";
        try (Connection connection = this.getConnection(); PreparedStatement comando = connection.prepareCall(query);) {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                emails.add(new Email(
                        resultado.getInt("id"),
                        resultado.getString("email"),
                        resultado.getString("username"))
                );
            }
            return emails;
        } catch (SQLException ex) {
            throw new PersistenceException(
                    "Error al consultar emails: " + ex.getMessage()
            );
        }
    }

    public Email findById(Integer id) throws PersistenceException {
        Email email = null;

        String query = "SELECT id, email, username FROM emails WHERE id = ?;";
        try (Connection connection = this.getConnection(); PreparedStatement comando = connection.prepareCall(query)) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                email = new Email(
                        resultado.getInt("id"),
                        resultado.getString("email"),
                        resultado.getString("username")
                );
            }
            return email;

        } catch (SQLException ex) {
            throw new PersistenceException("Error al consultar email por id: " + ex.getMessage());
        }
    }

}
