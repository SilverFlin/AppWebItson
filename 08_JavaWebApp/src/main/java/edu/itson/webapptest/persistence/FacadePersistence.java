package edu.itson.webapptest.persistence;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.PersistenceException;
import java.util.List;

/**
 *
 */
public class FacadePersistence {

    private final EmailListsDAO emailListDAO;

    public FacadePersistence() {
        this.emailListDAO = new EmailListsDAO();
    }

    public Email createEmail(final Email email) throws PersistenceException {
        return this.emailListDAO.create(email);
    }

    public List<Email> findAllEmails() throws PersistenceException {
        return this.emailListDAO.findAll();
    }

    public Email findEmailById(final Integer id) throws PersistenceException {
        return this.emailListDAO.findById(id);
    }
}
