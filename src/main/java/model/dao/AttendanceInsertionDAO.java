package model.dao;

import exception.DAOException;
import model.domain.Attendance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class AttendanceInsertionDAO implements GenericProcedureDAO<Attendance> {

    public Attendance execute(Object... params) throws DAOException{

        Attendance newAttendance = (Attendance) params[0];
        String studente = newAttendance.getStudente();
        String dataLez = newAttendance.getDataLez();
        String oraLez = newAttendance.getOraLez();
        String codiceCorso;
        String nomeLiv;

        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserimento_frequenza(?, ?, ?, ?, ?)}");
            cs.setString(1,studente);
            cs.setString(2,dataLez);
            cs.setString(3, oraLez);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.executeQuery();
            codiceCorso = cs.getString(4);
            nomeLiv = cs.getString(5);
        }catch(SQLException e){
            throw new DAOException("Attendance insertion error: " + e.getMessage());
        }

        return new Attendance(studente, dataLez, oraLez, codiceCorso, nomeLiv);
    }
}
