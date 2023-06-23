package edu.itson.webapptest.negocio.interfaces;

import edu.itson.webapptest.dominio.Email;
import edu.itson.webapptest.exceptions.BOException;
import java.util.List;

/**
 * BO s.f. Business Object.
 */
public interface IEmailListBO {

    Email create(Email email) throws BOException;

    List<Email> findAll() throws BOException;

    Email findById(Integer id) throws BOException;

}
