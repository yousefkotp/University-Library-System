import java.io.FileNotFoundException;


public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        //default login username for admin section is "admin"
        //default login password for admin section is "admin"

        //default login username for librarian section is "yousef"
        //default login password for librarian sections is "123"

        GlobalVariables.readBooks("Books.txt");
        GlobalVariables.readAdmin("Admin.txt");
        GlobalVariables.readLibrarian("Librarians.txt");
        GlobalVariables.readStudent("Students.txt");
        GlobalVariables.readIssued("IssuedBooks.txt");


        new LibraryManagement();
    }
}
