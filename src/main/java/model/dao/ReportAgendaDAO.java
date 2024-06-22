package model.dao;

import exception.DAOException;
import model.domain.Teacher;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportAgendaDAO extends PrinterResultTable implements GenericProcedureDAO<Void> {

    public Void execute(Object... params) throws DAOException {

        Teacher reportTeacher = (Teacher) params[0];
        String name = reportTeacher.getNome();
        String surname = reportTeacher.getCognome();

        try{

            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call report_agenda(?, ?)}");
            cs.setString(1, name);
            cs.setString(2, surname);
            ResultSet rs = cs.executeQuery();
            printResultsTable(rs, System.out);

        }catch(SQLException e ){
            throw new DAOException("Report error: " + e.getMessage());
        }

        return null;
    }

}
