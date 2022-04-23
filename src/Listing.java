public class Listing
{
    private String name;
    private int id;
    private double gpa;

    public Listing(String n, int i, double g) {
        name = n;
        id = i;
        gpa = g;
    }

    public String toString() {
        return ("Name is  " + name + "\nID is  " + id + "\nGPA is " + gpa + "\n");
    }

    public Listing deepCopy() {
        Listing clone = new Listing(name, id, gpa);
        return clone;
    }

    public int compareTo(String targetKey) {
        return(name.compareTo(targetKey));
    }


    public String getKey() {
        return name;
    }
}
