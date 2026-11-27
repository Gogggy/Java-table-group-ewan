import java.util.Scanner;
import java.util.Arrays;
public class App {
    // # Variables
    static int cnt = 0; // count of row

    // # Scanner
    static Scanner in = new Scanner(System.in);

    // # Array
    static String[][] table = new String[100][7]; // 0 = id, 1 = lastname, 2 = firstname, 3 = midtermgrade, 4 = finals grade, 5 = semgrade, 6 = remark
    final static String[] headers = {"ID", "Last Name", "First Name", "Midterm Grade", "Final Grade", "Semestral Grade", "Remark"};

    static void menu(){
        int choice = 0;
    
            System.out.println("1. Add Student");
            System.out.println("2. Show Record");
            System.out.println("3. Edit Record");
            System.out.println("4. Search Record");
            System.out.println("5. Delete Record");
            System.out.println("6. Exit");
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
                    break; // was no break
                case 5:
                    DeleteRecord();
                    break;    
                case 6:
                    System.out.println("Exit");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
        
    static double computeGrade(int midgrade, int fingrade){
        midgrade *= 0.40;
        fingrade *= 0.60;

        return midgrade + fingrade;
    }       

    static void addStudent(Scanner in){

        for (int c = 0; c < headers.length - 2; c++){
            System.out.print("Enter student " + headers[c] + ": ");
    
            table[cnt][c] = in.nextLine();
        }

        table[cnt][5] = computeGrade(Integer.parseInt(table[cnt][3]), Integer.parseInt(table[cnt][4])) + "";

        // TODO isama narin yung remarks

        System.out.println(String.join(" | ", headers));
        System.out.println(String.join(" | ", table[cnt]));
        cnt++;

        System.out.println("Record added successfully! LUMAYAS KA");

    }

    static void showRecord(){

        System.out.println(String.join(" | ", headers));
    
        for (int r = 0; r < cnt; r++){
            System.out.println(String.join(" | ", table[r]));
        }
    }
    static void DeleteRecord() {
        if (cnt == 0) {
        System.out.println("No records available to delete.");
        return;
        }
        System.out.print("Enter the Student ID to delete: ");
        String targetId = in.nextLine().trim();
        int foundIndex = -1;

        // So dito hinahanap yung student id na idelete.
        for (int r = 0; r < cnt; r++) {
        if (table[r][0] != null && table[r][0].equalsIgnoreCase(targetId)) {
        foundIndex = r;
        break;
            }
        }

        // 2. dto naman kung wala yung student id na hinahanap.
        if (foundIndex == -1) {
            System.out.println("Student with ID '" + targetId + "' not found.");
            return;
        }

        // 3. Dito naman idelete yung record at i-shift yung mga susunod na records up.
        for (int r = foundIndex; r < cnt - 1; r++) {
            table[r] = table[r + 1];
        }
        table[cnt - 1] = new String[7]; 
        cnt--;
        System.out.println("\nRecord deleted successfully!\n");
    }
    public static void main(String[] args) {

        while (true){
            menu();
        }

    }
}
