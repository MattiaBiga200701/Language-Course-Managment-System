package model.dao;

import exception.DAOException;
import model.domain.Teacher;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TeacherInsertionDAO implements GenericProcedureDAO<Teacher>  {

    public Teacher execute(Object... params) throws DAOException {
        Teacher newTeacher = (Teacher) params[0];
        String nome = newTeacher.getNome();
        String cognome = newTeacher.getCognome();
        String nazione = newTeacher.getNazione();
        String indirizzoRes = newTeacher.getIndirizzoRes();

        try{

            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserimento_insegnante(?, ?, ?, ?)}");
            cs.setString(1, nome);
            cs.setString(2, cognome);
            cs.setString(3, nazione);
            cs.setString(4, indirizzoRes);
            cs.executeQuery();

        }catch(SQLException e ){
            throw new DAOException("Teacher insertion error: " + e.getMessage());
        }

        return new Teacher(nome, cognome, nazione, indirizzoRes);
    }
}
