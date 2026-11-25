import java.util.Scanner;
public class App {
    // # Variables
    static int cnt = 0; // count of row

    // # Scanner
    static Scanner in = new Scanner(System.in);

    // # Array
    static String[][] table = new String[100][7]; // 0 = id, 1 = firstname, 2 = lastname, 3 = midtermgrade, 4 = finals grade, 5 = semgrade, 6 = remark
    final static String[] headers = {"ID", "First Name", "Last Name", "Midterm Grade", "Final Grade"};

    // TODO YUNG MENU: laman adobo, sinigang, kalderata, menudo, sabaw...

    static void addStudent(Scanner in){

        for (int c = 0; c < headers.length; c++){
            System.out.print("Enter student " + headers[c] + ": ");
            table[cnt][c] = in.nextLine();
        }

        // TODO Kunin Midterm tas final grade tas i calcu yung sem grade.
        // TODO isama narin yung remarks

        cnt++;
        System.out.println("Record added successfully! LUMAYAS KA");
    }

    static void showRecord(){

        System.out.println(String.join(" | ", headers));
    

        for (int r = 0; r < cnt; r++){
            System.out.println(String.join(" | ", table[r]));
        }
    }
    public static void main(String[] args) {

        addStudent(in);
        showRecord();

    }
}
