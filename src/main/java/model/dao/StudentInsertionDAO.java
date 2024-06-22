package model.dao;

import exception.DAOException;
import model.domain.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class StudentInsertionDAO implements GenericProcedureDAO<Student> {

    public Student execute(Object... params) throws DAOException{

        Student newStudent = (Student) params[0];
        String CF = newStudent.getCF();
        String nome = newStudent.getNome();
        String cognome = newStudent.getCognome();
        String dataNascita = newStudent.getDataNascita();
        String indirizzoRes = newStudent.getIndirizzoRes();
        String numTelefono = newStudent.getNumTelefono();
        String dataIscrizione = newStudent.getDataIscrizione();
        String codiceCorso = newStudent.getCodiceCorso();
        String nomeLiv;

        try{

            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserimento_studente(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, CF);
            cs.setString(2, nome);
            cs.setString(3, cognome);
            cs.setString(4, dataNascita);
            cs.setString(5, indirizzoRes);
            cs.setString(6, numTelefono);
            cs.setString(7, dataIscrizione);
            cs.setString(8, codiceCorso);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.executeQuery();
            nomeLiv = cs.getString(9);

        }catch(SQLException e){
            throw new DAOException("Lesson Insertion error: " + e.getMessage());
        }

        return new Student(CF, nome, cognome, dataNascita, indirizzoRes, numTelefono, dataIscrizione, codiceCorso, nomeLiv);
    }
}
