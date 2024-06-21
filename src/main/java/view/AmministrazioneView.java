package view;

import model.domain.Course;

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
}
