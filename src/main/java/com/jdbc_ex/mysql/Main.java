package com.jdbc_ex.mysql;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jdbc_ex.mysql.dao.imp.PersonaDaoImp;
import com.jdbc_ex.mysql.entities.Persona;

public class Main {

    public static void main(String[] args) {
        // el valor del string deberia venir de algun lado, aca se esta hardcodeando
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();

            // si el driver falla deberiamos salir del programa
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/testdb";

        try {
            Connection conn = DriverManager.getConnection(uri, "root", "rootpassword");
            conn.setAutoCommit(false);
            
            PersonaDaoImp personaDaoImp = new PersonaDaoImp();

            personaDaoImp.createTable(conn);

            personaDaoImp.createPersona(conn, new Persona("Juan", 22));
            personaDaoImp.createPersona(conn, new Persona("Carla", 27));

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
