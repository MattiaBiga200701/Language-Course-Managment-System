package controller;

import exception.DAOException;
import model.dao.ConnectionFactory;
import model.dao.CourseInsertionDAO;
import model.dao.LessonInsertionDAO;
import model.domain.Course;
import model.domain.Lesson;
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
                case 1 -> this.courseInsertion();
                case 2 -> this.lessonInsertion();
                case 4 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void courseInsertion(){

        CourseInsertionDAO dao = new CourseInsertionDAO();
        Course newCourse;
        try{

            newCourse = AmministrazioneView.getCourseInformation();
            newCourse = dao.execute(newCourse);

        }catch(DAOException | IOException e){
            throw new RuntimeException(e);
        }
        AmministrazioneView.showNewCourse(newCourse);
    }


    public void lessonInsertion(){

        LessonInsertionDAO dao = new LessonInsertionDAO();
        Lesson newLesson;
        try {

            newLesson = AmministrazioneView.getLessonInformation();
            newLesson = dao.execute(newLesson);

        }catch(DAOException | IOException e){
            throw new RuntimeException(e);
        }
        AmministrazioneView.showNewLesson(newLesson);
    }
}
