package controller;

import model.dao.ConnectionFactory;
import model.domain.Course;
import model.domain.Role;
import view.AmministrazioneView;

import java.io.IOException;
import java.sql.SQLException;

public class AmministrazioneController implements Controller {

    public void start(){
        try {
            ConnectionFactory.changeRole(Role.AMMINISTRAZIONE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            int choice;
            try {
                choice = AmministrazioneView.showMenu();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch(choice) {
                case 1 -> courseInsertion();
                case 4 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void courseInsertion(){

        Course newCourse = AmministrazioneView.getCourseInformation();
    }
}