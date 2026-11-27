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
    
    // # MENU
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
                    editRecord();
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
    
    
    // # GRADE COMPUTER
    static double computeGrade(int midgrade, int fingrade){ 
        midgrade *= 0.40;
        fingrade *= 0.60;
 
        return midgrade + fingrade;
    }       
    
    
    // # STUDENT ADDER
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
    
  
    // # EPSTEIN FILES (SHOW RECOD)
    static void showRecord(){ 
 
        System.out.println(String.join(" | ", headers));
    
        for (int r = 0; r < cnt; r++){
            System.out.println(String.join(" | ", table[r]));
        }
    }
    
  
  // # RECORD DELETE
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
 
  // # RECORD EDIT
    static void editRecord() {
        if (cnt == 0) {
            System.out.println("No records available to edit.");
            return;
        }
 
        System.out.print("Enter the Student ID to edit: ");
        String targetId = in.nextLine().trim();
 
        int foundIndex = -1;
 
        // Dto sa part na to hinahanap yung student ID na iedit
        for (int r = 0; r < cnt; r++) {
            if (table[r][0] != null && table[r][0].equalsIgnoreCase(targetId)) {
                foundIndex = r;
                break;
            }
        }
 
        // 2. Dto kung hindi mahanap yung student ID maglalabas ito na hindi mahanap dba?? 
        if (foundIndex == -1) {
            System.out.println("Student with ID '" + targetId + "' not found.");
            return;
        }
 
        // 3. Dto naman papakita muna yung record ng student para malaman kung ano ang ieedit nya ;)
        System.out.println("\nEditing Record for: " + table[foundIndex][1] + " " + table[foundIndex][2] + " (ID: " + table[foundIndex][0] + ")");
        System.out.println("Select field to edit:");
        for (int i = 0; i < headers.length; i++) {
            System.out.println((i + 1) + ". " + headers[i] + " (Current: " + table[foundIndex][i] + ")");
        }
        System.out.println((headers.length + 1) + ". Edit All Fields");
        System.out.println("0. Cancel");
        System.out.print("Enter your choice: ");
 
        int editChoice = 0;
        try {
            editChoice = in.nextInt();
            in.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("Invalid input! Edit cancelled.");
            in.nextLine();
            return;
        }
 
        // 4. Dto yung process ng pag edit ng record based sa choice ng user rightt...
        if (editChoice == 0) {
            System.out.println("Edit cancelled.");
            return;
        } else if (editChoice >= 1 && editChoice <= headers.length) {
            int colIndex = editChoice - 1;
            System.out.print("Enter new " + headers[colIndex] + ": ");
            table[foundIndex][colIndex] = in.nextLine();
            System.out.println(headers[colIndex] + " updated successfully!");
        } else if (editChoice == headers.length + 1) {
            for (int c = 0; c < headers.length; c++) {
                System.out.print("Enter new " + headers[c] + " (Current: " + table[foundIndex][c] + "): ");
                table[foundIndex][c] = in.nextLine();
            }
            System.out.println("All fields updated successfully!");
        } else {
            System.out.println("Invalid choice! Edit cancelled.");
        }
    }
 
  
  // ! MAIN !
    public static void main(String[] args) {
 
        while (true){
            menu();
        }
 
    }
}
