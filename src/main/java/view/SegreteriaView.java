package view;

import exception.PhoneNumberFormatException;
import exception.TimeFormatException;
import model.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SegreteriaView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    SEGRETERIA DASHBOARD       *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Student Insertion");
        System.out.println("2) Quit");




        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }

    public static Student getStudentInformation() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String CF;
        String nome;
        String cognome;
        String dataNascita;
        String indirizzoRes;
        String numTelefono;
        String dataIscrizione;
        String codiceCorso;
        Student newStudent = null;

        while(newStudent == null) {

            System.out.print("\nEnter student's CF: ");
            CF = reader.readLine();

            System.out.print("Enter student's name: ");
            nome = reader.readLine();

            System.out.print("Enter student's surname: ");
            cognome = reader.readLine();

            System.out.print("Enter student's date of birth: ");
            dataNascita = reader.readLine();

            System.out.print("Enter student's residence address: ");
            indirizzoRes = reader.readLine();

            System.out.print("Enter student's phone number: ");
            numTelefono = reader.readLine();

            System.out.print("Enter registration's date for the course: ");
            dataIscrizione = reader.readLine();

            System.out.print("Enter CourseID: ");
            codiceCorso = reader.readLine();

            try{
                newStudent = new Student(CF, nome, cognome, dataNascita, indirizzoRes, numTelefono, dataIscrizione, codiceCorso, null );
            }catch(DateTimeParseException e){
                System.out.println("Date Format error retype with this format [yyy-MM-dd]");
            }catch(PhoneNumberFormatException e ){
                System.out.println("Phone Number Format error retype");
            }
        }

        System.out.println();
        return newStudent;
    }

    public static void showNewStudente(Student newStudent){

        String CF = newStudent.getCF();
        String nome = newStudent.getNome();
        String cognome = newStudent.getCognome();

        String dataIscrizione = newStudent.getDataIscrizione();
        String codiceCorso = newStudent.getCodiceCorso();
        String nomeLiv = newStudent.getNomeLivello();

        System.out.println("Student " + CF + " " + nome + " " + cognome + " "  + dataIscrizione + " " + codiceCorso + " " + nomeLiv + " entered correctly.\n" );
    }
}
