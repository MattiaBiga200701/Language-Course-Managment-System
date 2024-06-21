package model.dao;

import exception.DAOException;
import model.domain.Course;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CourseInsertionDAO implements GenericProcedureDAO<Course> {

    public Course execute(Object... params) throws DAOException {

        Course newCourse = (Course) params[0];
        String codiceInterno = newCourse.getCodiceInterno();
        String dataAtt = newCourse.getDataAtt();
        String nomeLiv = newCourse.getNomeLiv();


        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserimento_corso(?, ?, ?)}");
            cs.setString(1, codiceInterno);
            cs.setString(2, dataAtt);
            cs.setString(3, nomeLiv);
            cs.executeQuery();

        }catch(SQLException e){
            throw new DAOException("CourseInsertion error: " +  e.getMessage());
        }

        return new Course(codiceInterno, nomeLiv,  dataAtt);
    }
}
