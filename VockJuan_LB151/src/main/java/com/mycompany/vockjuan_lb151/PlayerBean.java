/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.vockjuan_lb151;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanv
 */
@Named(value = "player")
@SessionScoped
public class PlayerBean implements Serializable {

    /**
     * Creates a new instance of player
     */
    private List<String> phrases;
    private List<String> riddleWords;
    private List<String> categories;

    public PlayerBean() {
        phrases = new ArrayList<>();
        riddleWords = new ArrayList<>();
        categories = new ArrayList<>();
    }

    private String username;
    private String password;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String nextPage() {
        if (name == null || name.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name darf nicht leer sein", null));
            return null;
        }
        return "game.xhtml";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (username == null || username.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Benutzername darf nicht leer sein", null));
            return null;
        }
        if (password == null || password.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwort darf nicht leer sein", null));
            return null;
        }
        if ("Juanadmin".equals(username) && "123".equals(password)) {
            return "newjsf.xhtml";
        } else {
            return "nameUser.xhtml";
        }
        
    }

    private Connection getConnection() throws ClassNotFoundException {

        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lbGluck");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connect != null)
                try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    public String test() {

        try {
            // Get a connection to the database
            Connection connection = getConnection();

            // Prepare the INSERT statement with a parameterized query
            String insertQuery = "INSERT INTO user (name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the value of the name parameter to "juan"
            preparedStatement.setString(1, "juan");

            // Execute the INSERT statement
            preparedStatement.executeUpdate();

            // Close the database connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Return the navigation outcome for the next page
        return "newjsf.xhtml";
    }

}
