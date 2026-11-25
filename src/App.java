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
    static void menu(){
        int choice = 0;
    
            System.out.println("1. Add Student");
            System.out.println("2. Show Record");
            System.out.println("3. Edit Record");
            System.out.println("4. Search Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            try {
                 choice = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                in.nextLine();
                return;
            } 
             
    
            switch (choice){
                case 1:
                    addStudent(in);
                    break;
                case 2:
                    showRecord();
                    break;
                case 3:
                    System.out.println("Edit Record"); //TODO EDIT RECORD METHOD MARK IKAW NA RITO FUCK YOU
                    break;
                case 4:
                    System.out.println("Search Record"); //TODO SEARCH RECORD METHOD JAMES 
                    // 
                case 5:
                    System.out.println("Exit");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } 
       

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

        while (true){
            menu();
        }

    }
}
