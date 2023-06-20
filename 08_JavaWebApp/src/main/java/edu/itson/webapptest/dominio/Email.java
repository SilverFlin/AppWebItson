package edu.itson.webapptest.dominio;

import java.util.Objects;

/**
 *
 */
public class Email {

    private Integer id;
    private String correo;
    private String username;

    public Email() {
    }

    public Email(final String correo, final String username) {
        this.correo = correo;
        this.username = username;
    }

    public Email(final Integer id, final String correo, final String username) {
        this.id = id;
        this.correo = correo;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(final String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Email{" + "id=" + id + ", correo=" + correo + ", username=" + username + '}';
    }

}
