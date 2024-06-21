package view;

import exception.TimeFormatException;
import model.domain.Course;
import model.domain.Lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AmministrazioneView {
    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    ADMINISTRATION DASHBOARD   *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Course Insertion");
        System.out.println("2) Lessons Insertion");
        System.out.println("3) Teacher Activities Report");
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

    public static Course getCourseInformation() throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String codiceInterno;
        String nomeLiv;
        String dataAtt;
        Course newCourse = null;

        while (newCourse == null){
            System.out.print("\nEnter CourseID: ");
            codiceInterno = reader.readLine();

            System.out.print("Enter Activation Date: ");
            dataAtt = reader.readLine();

            System.out.print("Enter Course Level: ");
            nomeLiv = reader.readLine();

            try{
               newCourse = new Course(codiceInterno, nomeLiv, dataAtt );
            }catch(DateTimeParseException e){
                System.out.println("Date Format yyy-MM-dd");
            }
        }
        System.out.println();
        return newCourse;
    }

    public static void showNewCourse(Course newCourse){

        String codiceInterno = newCourse.getCodiceInterno();
        String nomeLiv = newCourse.getNomeLiv();
        String dataAtt = newCourse.getDataAtt();

        System.out.println("Course " + codiceInterno + " " + nomeLiv + " " + dataAtt + " entered correctly.\n" );

    }

    public static Lesson getLessonInformation() throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataLez;
        String ora;
        String codiceInterno;
        String nomeIns;
        String cognomeIns;
        Lesson newLesson = null;

        while(newLesson == null){

            System.out.print("\nEnter lesson date: ");
            dataLez = reader.readLine();

            System.out.print("Enter lesson time: ");
            ora = reader.readLine();

            System.out.print("Enter CourseID: ");
            codiceInterno = reader.readLine();


            System.out.print("Enter Teacher's name: ");
            nomeIns = reader.readLine();

            System.out.print("Enter Teacher's surname: ");
            cognomeIns = reader.readLine();

            try{
                newLesson = new Lesson(dataLez, ora, codiceInterno, null, nomeIns, cognomeIns);
            }catch(DateTimeParseException e){
                System.out.println("Date Format error retype with this format [yyy-MM-dd]");
            }catch(TimeFormatException e){
                System.out.println("Time Format error retype with this format [HH:MM:SS]");
            }

        }
        System.out.println();
        return newLesson;
    }

    public static void showNewLesson(Lesson newLesson){

        String dataLez = newLesson.getDataLez();
        String ora = newLesson.getOra();
        String codiceInterno = newLesson.getCodiceCorso();
        String nomeLiv = newLesson.getNomeLiv();
        String nomeIns = newLesson.getNomeIns();
        String cognomeIns = newLesson.getCognomeIns();

        System.out.println("Lesson " + dataLez + " " + ora + " " + codiceInterno + " " + nomeLiv + " " + nomeIns + " " + cognomeIns + " entered correctly.\n");
    }
}
