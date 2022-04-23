import java.util.Scanner;

public class StudentInformation {

    public static void main(String[] args) {

        BinaryTree t = new BinaryTree();


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


        t.Menu();



    }
}
