package com.jdbc_ex.mysql.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc_ex.mysql.entities.Persona;

public interface PersonaDao {
    public ResultSet getPersonas(Connection conn) throws SQLException;
    public ResultSet getPersonaById(Connection conn, Long id) throws SQLException;
    public void createPersona(Connection conn, Persona persona) throws SQLException;
    public void createTable(Connection conn) throws SQLException;
}
