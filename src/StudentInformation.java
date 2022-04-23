import java.util.Scanner;

public class StudentInformation {

    public static void main(String[] args) {

        BinaryTree t = new BinaryTree();
        boolean exitProg = false;


        Listing student1 = new Listing("Garry Smith", 12345, 2.8);
        Listing student2 = new Listing("Eva Human", 43546, 4.0);
        Listing student3 = new Listing("Mary Fisher", 452353, 3.5);
        Listing student4 = new Listing("Nancy Roberts", 243876, 4.0);
        Listing student5 = new Listing("Henry Adams", 542365, 2.8);
        t.insert(student1);
        t.insert(student2);
        t.insert(student3);
        t.insert(student4);
        t.insert(student5);

        while (!exitProg) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter: 1 to insert a new student's information");
            System.out.println("2 to fetch and output a student's information");
            System.out.println("3 to delete a student's information");
            System.out.println("4 to update a student's information");
            System.out.println("5 to output all student's information in descending order, and");
            System.out.println("6 to exit the program.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the student's full name: ");
                    String fullName = scanner.next();


                    System.out.println("Enter the student's id: ");
                    int id = scanner.nextInt();

                    System.out.println("Enter the student's gpa: ");
                    double gpa = scanner.nextDouble();
                    t.insert(new Listing(fullName, id, gpa));
                    break;

                case 2:
                    System.out.println("Enter the student's full name: ");
                    fullName = scanner.nextLine();
                    System.out.println(t.fetch(fullName));
                    break;

                case 3:
                    System.out.println("Enter the student's full name: ");
                    fullName = scanner.nextLine();
                    t.delete(fullName);

                    System.out.println(fullName + "has been removed.");
                    break;
                case 4:
                    System.out.println("Enter the student's full name: ");
                    fullName = scanner.nextLine();

                    System.out.println("Enter the student's new information at the following prompts:");
                    System.out.println("Update the student's name: ");
                    String newName = scanner.nextLine();

                    System.out.println("Update the student's id: ");
                    id = scanner.nextInt();

                    System.out.println("Update the student's gpa: ");
                    gpa = scanner.nextDouble();

                    t.update(fullName, new Listing(newName, id, gpa));

                    System.out.println(newName + " has been updated.");
                    break;
                case 5:
                    t.RNLTraversal(t.root);
                    break;
                case 6:
                    System.out.println("Exiting Program");
                    exitProg = true;
                    break;
                default:
                    System.out.println("Choose a number");
                    break;
            }

        }
    }
}



