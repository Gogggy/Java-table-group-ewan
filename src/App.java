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
                    extracted();
                    break;
                case 5:
                    System.out.println("Exit");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }


        public static void extracted() {
    if (cnt == 0) {
        System.out.println("No records available.");
        return;
    }

    System.out.println(" Search Record ");
    System.out.println("1. Search by Student ID");
    System.out.println("2. Search by Name (First Name or Last Name)");
    System.out.print("Enter your option: ");

    int option;
        try {
            option = Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        switch (option) {
            case 1 -> {
                System.out.print("Enter Student ID: ");
                String id = in.nextLine().trim();
                boolean foundID = false;
                for (int i = 0; i < cnt; i++) {
                    if (id.equalsIgnoreCase(table[i][0])) {
                        displayStudent(i);
                        foundID = true;
                        break;
                    }
                }
                if (!foundID) System.out.println("Student ID not found.");
            }

            case 2 -> {
                System.out.print("Enter First Name or Last Name: ");
                String name = in.nextLine().trim().toLowerCase();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    break;
                }
                boolean foundName = false;
                for (int i = 0; i < cnt; i++) {
                    String first = table[i][1] == null ? "" : table[i][1].toLowerCase();
                    String last  = table[i][2] == null ? "" : table[i][2].toLowerCase();
                    if (first.contains(name) || last.contains(name)) {
                        displayStudent(i);
                        foundName = true;
                    }
                }
                if (!foundName) System.out.println("Student not found.");
            }

            default -> System.out.println("Invalid choice! Please enter 1 or 2.");
        }
    }

    public static void displayStudent(int i) {
        System.out.println(" Student Record ");
        System.out.println("ID: " + table[i][0]);
        System.out.println("First Name: " + table[i][1]);
        System.out.println("Last Name: " + table[i][2]);
        System.out.println("Midterm Grade: " + table[i][3]);
        System.out.println("Final Grade: " + table[i][4]);
        System.out.println("Semester Grade: " + table[i][5]);
        System.out.println("Remark: " + table[i][6]);
    }
}
            
    


  
         


    