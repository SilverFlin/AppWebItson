package edu.itson.webapptest.persistence;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.PersistenceException;

/**
 *
 * @author Toled
 */
public class FacadePersistence {

    private final EmailListsDAO emailListDAO;

    public FacadePersistence() {
        this.emailListDAO = new EmailListsDAO();
    }

    public Email createEmail(final Email email) throws PersistenceException {
        return this.emailListDAO.crear(email);
    }

}
