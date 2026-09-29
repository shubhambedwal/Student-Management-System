import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Scanner for input

        System.out.print("Username: ");
        String u = sc.nextLine();  //u for user name

        System.out.print("Password: ");
        String p = sc.nextLine();   //p for password

        if(!u.equals("admin") || !p.equals("admin123")) {
            System.out.println("Invalid Login!");
            return;
        }

        StudentDAO dao = new StudentDAO();  //connection to studentDAO

        while(true) {
            System.out.println("\n1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Delete Student");
            System.out.println("4.Search By Roll No");
            System.out.println("5.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    double marks;

                    while (true) {
                    System.out.print("Marks (0-100): ");

            try {
                    marks = Double.parseDouble(sc.nextLine());

                    if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }

                break;

                } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                }
        }

                    dao.addStudent(new Student(name, roll, dept, email, phone, marks));
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Roll No: ");
                    String deleteRoll = sc.nextLine();
                    dao.deleteStudent(deleteRoll);
                    break;

                case 4:
                    System.out.print("Roll No: ");
                    String searchRoll = sc.nextLine();
                    dao.searchStudent(searchRoll);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
