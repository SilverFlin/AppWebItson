package edu.itson.webapptest.persistence;

import com.mysql.cj.xdevapi.PreparableStatement;
import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.PersistenceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class EmailListsDAO {

    public EmailListsDAO() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/itson_Test",
                "root",
                "325a7fd7a79a"
        );

    }

    public Email crear(final Email email) throws PersistenceException {

        String query = "INSERT INTO emails(username, email) VALUES( ? , ? )";

        try {
            Connection connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(0, email.getUsername());
            statement.setString(1, email.getCorreo());
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Error al crear email: " + ex.getMessage());
        }

        return email;
    }
}
