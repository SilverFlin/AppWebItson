package edu.itson.webapptest.negocio.impl;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.negocio.interfaces.IEmailListBO;

/**
 *
 */
public class EmailListBO implements IEmailListBO {

    public EmailListBO() {
    }

    @Override
    public Email createEmail(final Email email) {

        Integer id = (int) Math.floor(Math.random() * 100 + 1);

        Email emailGuardado = new Email(email.getCorreo(), email.getUsername());
        emailGuardado.setId(id);

        return emailGuardado;
    }

}
