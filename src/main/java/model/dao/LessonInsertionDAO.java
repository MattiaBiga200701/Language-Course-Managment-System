package model.dao;

import exception.DAOException;
import model.domain.Lesson;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class LessonInsertionDAO implements GenericProcedureDAO<Lesson> {

    public Lesson execute(Object... params) throws DAOException {

        Lesson newLesson = (Lesson) params[0];
        String dataLez = newLesson.getDataLez();
        String ora = newLesson.getOra();
        String codiceInterno = newLesson.getCodiceCorso();
        String nomeIns = newLesson.getNomeIns();
        String cognomeIns = newLesson.getCognomeIns();
        String nomeLiv;

        try{

            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserimento_lezione(?, ?, ?, ?, ?, ?)}");
            cs.setString(1, dataLez);
            cs.setString(2, ora);
            cs.setString(3, codiceInterno);
            cs.setString(4, nomeIns);
            cs.setString(5, cognomeIns);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.executeQuery();
            nomeLiv = cs.getString(6);


        }catch(SQLException e){
            throw new DAOException("Lesson insertion error: " + e.getMessage());
        }

        return new Lesson(dataLez, ora, codiceInterno, nomeLiv, nomeIns, cognomeIns);

    }
}
