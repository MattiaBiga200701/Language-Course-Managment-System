package controller;

import exception.DAOException;
import model.dao.AttendanceInsertionDAO;
import model.dao.ConnectionFactory;
import model.dao.ReportAgendaDAO;
import model.domain.Attendance;
import model.domain.Role;
import model.domain.Teacher;
import view.AmministrazioneView;
import view.InsegnanteView;

import java.io.IOException;
import java.sql.SQLException;

public class InsegnanteController implements Controller {

    public void start(){
        try {
            ConnectionFactory.changeRole(Role.INSEGNANTE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            int choice;
            try {
                choice = InsegnanteView.showMenu();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch(choice) {
                case 1 -> this.reportAgenda();
                case 2 -> this.attendanceInsertion();
                case 4 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void reportAgenda(){

        ReportAgendaDAO dao = new ReportAgendaDAO();
        Teacher reportTeacher;

        try{
            reportTeacher = InsegnanteView.getReportTeacherInformation();
            dao.execute(reportTeacher);
        }catch(DAOException | IOException e ){
            throw new RuntimeException(e);

        }

    }

    public void attendanceInsertion(){
        AttendanceInsertionDAO dao = new AttendanceInsertionDAO();
        Attendance newAttendance;
        try{
            newAttendance = InsegnanteView.getAttendanceInformation();
            newAttendance = dao.execute(newAttendance);
        }catch(DAOException| IOException e){
            throw new RuntimeException(e);
        }

        InsegnanteView.showNewAttendance(newAttendance);
    }
}
