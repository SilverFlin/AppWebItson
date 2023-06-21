package edu.itson.webapptest.negocio.impl;

import edu.itson.dominio.Usuario;
import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.BOException;
import edu.itson.webapptest.exceptions.PersistenceException;
import edu.itson.webapptest.negocio.interfaces.IEmailListBO;
import edu.itson.webapptest.persistence.FacadePersistence;
import exceptions.PersistenciaException;
import implementations.facade.FachadaPersistencia;
import interfaces.IPersistencia;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class EmailListBO implements IEmailListBO {

    private FacadePersistence persistence;

    public EmailListBO() {
        this.persistence = new FacadePersistence();
    }

    @Override
    public Email create(final Email email) throws BOException {

        try {
            Email emailCreado = persistence.createEmail(email);
            return emailCreado;
        } catch (PersistenceException ex) {
            throw new BOException("Error Create Email: " + ex.getMessage());
        }

    }

}
