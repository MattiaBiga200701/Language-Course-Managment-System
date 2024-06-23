package view;

import exception.TimeFormatException;
import model.domain.Attendance;
import model.domain.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InsegnanteView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    INSEGNANTE  DASHBOARD      *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Report Agenda");
        System.out.println("2) Student attendance");
        System.out.println("3) Student absence list");
        System.out.println("4) Quit");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }

    public static Teacher getReportTeacherInformation() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nome;
        String cognome;
        Teacher reportTeacher = null;
        while(reportTeacher == null) {

            System.out.print("\nEnter your name: ");
            nome = reader.readLine();

            System.out.print("Enter your surname: ");
            cognome = reader.readLine();

            reportTeacher = new Teacher(nome, cognome, null, null);

        }
        System.out.println();
        return reportTeacher;

    }


    public static Attendance getAttendanceInformation() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String studente = null;
        String dataLez = null;
        String oraLez = null;
        String codiceCorso = null;
        Attendance newAttendance = null;
        while(newAttendance == null) {

            System.out.print("\nEnter student id: ");
            studente =reader.readLine();

            System.out.print("Entern lesson's date: ");
             dataLez = reader.readLine();

            System.out.print("Enter lesson time: ");
            oraLez = reader.readLine();

            System.out.print("Enter CourseID: ");
            codiceCorso = reader.readLine();
            try {
                newAttendance = new Attendance(studente, dataLez, oraLez, codiceCorso, null);
            }catch(DateTimeParseException e){
                System.out.println("Date Format error retype with this format [yyy-MM-dd]");
            }catch(TimeFormatException e){
                System.out.println("Time Format error retype with this format [HH:MM:SS]");
            }
        }
        System.out.println();
        return newAttendance;
    }

    public static void showNewAttendance(Attendance newAttendance){

        String studente = newAttendance.getStudente();
        String dataLez = newAttendance.getDataLez();
        String oraLez = newAttendance.getOraLez();
        String codiceCorso = newAttendance.getCodiceCorso();
        String nomeLiv = newAttendance.getNomeLiv();

        System.out.println("Attendance " + studente + " " + dataLez + " " + oraLez + " " + codiceCorso + " " + nomeLiv + " entered correctly\n");
    }
}
