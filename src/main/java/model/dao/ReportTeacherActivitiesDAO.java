package model.dao;

import exception.DAOException;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;

public class ReportTeacherActivitiesDAO extends PrinterResultTable implements GenericProcedureDAO<Void> {

    public Void execute(Object... params) throws DAOException {

        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call report_attività_insegnanti()}");
            ResultSet rs = cs.executeQuery();
            printResultsTable(rs, System.out);
        }catch(SQLException e){
            throw new DAOException("Report error: " + e.getMessage());
        }
        return null;
    }

}

