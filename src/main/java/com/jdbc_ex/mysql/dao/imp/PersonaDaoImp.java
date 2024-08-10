package com.jdbc_ex.mysql.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc_ex.mysql.dao.PersonaDao;
import com.jdbc_ex.mysql.entities.Persona;

public class PersonaDaoImp implements PersonaDao {

    @Override
    public ResultSet getPersonas(Connection conn) throws SQLException {
        String select = "SELECT * FROM persona";

        PreparedStatement ps = conn.prepareStatement(select);

        return ps.executeQuery();
    }

    @Override
    public ResultSet getPersonaById(Connection conn, Integer id) throws SQLException {
        String select = "SELECT * FROM persona WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(select);
        ps.setInt(1, id);

        return ps.executeQuery();
    }

    @Override
    public void createPersona(Connection conn, Persona persona) throws SQLException {
        String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(insert);

        ps.setLong(1, persona.getId());
        ps.setString(2, persona.getNombre());
        ps.setInt(3, persona.getEdad());
        ps.executeUpdate();

        ps.close();

        conn.commit();
    }

    @Override
    public void createTable(Connection conn) throws SQLException {
        String table = "CREATE TABLE persona(id INT, nombre VARCHAR(18), edad INT, PRIMARY KEY(id))";
        conn.prepareStatement(table).execute();

        conn.commit();
    }

}
