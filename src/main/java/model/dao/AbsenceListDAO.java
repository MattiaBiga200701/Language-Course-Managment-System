package model.dao;

import exception.DAOException;
import model.domain.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbsenceListDAO extends PrinterResultTable implements GenericProcedureDAO<Void> {

    public Void execute(Object... params) throws DAOException {


        String CF = (String) params[0];

        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call lista_assenze(?)}");
            cs.setString(1, CF);
            ResultSet rs = cs.executeQuery();
            printResultsTable(rs, System.out);
        }catch(SQLException e){
            throw new DAOException("Absence list error: " + e.getMessage());
        }

        return null;
    }
}
