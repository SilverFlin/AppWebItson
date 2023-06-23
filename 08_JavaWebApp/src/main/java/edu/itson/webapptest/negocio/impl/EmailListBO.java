package edu.itson.webapptest.negocio.impl;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.BOException;
import edu.itson.webapptest.exceptions.PersistenceException;
import edu.itson.webapptest.negocio.interfaces.IEmailListBO;
import edu.itson.webapptest.persistence.FacadePersistence;
import java.util.List;

/**
 *
 */
public class EmailListBO implements IEmailListBO {

    private final FacadePersistence persistence;

    public EmailListBO() {
        this.persistence = new FacadePersistence();
    }

    @Override
    public Email create(final Email email) throws BOException {

        try {
            return persistence.createEmail(email);
        } catch (PersistenceException ex) {
            throw new BOException("Error @ Create Email: " + ex.getMessage());
        }

    }

    @Override
    public List<Email> findAll() throws BOException {
        try {
            return persistence.findAllEmails();
        } catch (PersistenceException ex) {
            throw new BOException("Error @ find all Emails: " + ex.getMessage());
        }

    }

    @Override
    public Email findById(final Integer id) throws BOException {
        try {
            return persistence.findEmailById(id);
        } catch (PersistenceException ex) {
            throw new BOException("Error @ find email by id: " + ex.getMessage());
        }
    }

}
