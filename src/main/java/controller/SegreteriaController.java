package controller;

import exception.DAOException;
import model.dao.ConnectionFactory;
import model.dao.StudentInsertionDAO;
import model.domain.Role;
import model.domain.Student;
import view.AmministrazioneView;
import view.SegreteriaView;

import java.io.IOException;
import java.sql.SQLException;

public class SegreteriaController {

    public void start(){

        try {
            ConnectionFactory.changeRole(Role.SEGRETERIA);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            int choice;
            try {
                choice = SegreteriaView.showMenu();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch(choice) {
                case 1 -> this.studentInsertion();
                case 2 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void studentInsertion(){
        StudentInsertionDAO dao = new StudentInsertionDAO();
        Student newStudent;
        try{
            newStudent = SegreteriaView.getStudentInformation();
            newStudent = dao.execute(newStudent);
        }catch(DAOException | IOException e){
            throw new RuntimeException(e);
        }

        SegreteriaView.showNewStudente(newStudent);
    }
}
