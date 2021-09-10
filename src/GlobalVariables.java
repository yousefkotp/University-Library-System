import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GlobalVariables {
    public static Librarian[] librarians = new Librarian[50];
    public static int counter_librarians = 0;
    public static Books[] books = new Books[50];
    public static int counter_books = 0;
    public static Student[] students = new Student[50];
    public static int counter_students = 0;
    public static IssuedBooks[] issuedbooks = new IssuedBooks[50];
    public static int counter_issued = 0;
    public static Admin[] admin = new Admin[50];
    public static int counter_admin = 0;


    public static void printLibrarians(Librarian[] librarians) throws FileNotFoundException {
        PrintWriter librarianFile = new PrintWriter("Librarians.txt");
        for (int i = 0; i < counter_librarians; i++) {
            librarianFile.print(librarians[i].getName() + ",");
            librarianFile.print(librarians[i].getPass() + ",");
            librarianFile.print(librarians[i].getEmail() + ",");
            librarianFile.print(librarians[i].getAddress() + ",");
            librarianFile.print(librarians[i].getCity() + ",");
            librarianFile.print(librarians[i].getContact_no() + ",");
            librarianFile.print(librarians[i].getId());
            librarianFile.println();
        }
        librarianFile.close();
    }

    public static void printBooks(Books[] books) throws FileNotFoundException {
        PrintWriter booksFile = new PrintWriter("Books.txt");
        for (int i = 0; i < counter_books; i++) {
            booksFile.print(books[i].getCall_no() + ",");
            booksFile.print(books[i].getName() + ",");
            booksFile.print(books[i].getAuthor() + ",");
            booksFile.print(books[i].getPublisher() + ",");
            booksFile.print(books[i].getQuantity() + ",");
            booksFile.print(books[i].getIssued() + ",");
            booksFile.print(books[i].getAdded_date());
            booksFile.println();
        }
        booksFile.close();
    }


    public static void printStudents(Student[] student) throws FileNotFoundException {
        PrintWriter studentFile = new PrintWriter("Students.txt");
        for (int i = 0; i < counter_students; i++) {
            studentFile.print(student[i].getName() + ",");
            studentFile.print(student[i].getPassword() + ",");
            studentFile.print(student[i].getEmail() + ",");
            studentFile.print(student[i].getAddress() + ",");
            studentFile.print(student[i].getCity() + ",");
            studentFile.print(student[i].getContact_no() + ",");
            studentFile.print(student[i].getId() + ",");
            studentFile.print(student[i].getBorrowed());
            studentFile.println();
        }
        studentFile.close();
    }

    public static void printIssuesBooks(IssuedBooks[] issuedbooks) throws FileNotFoundException {
        PrintWriter issuedBooksFile = new PrintWriter("IssuedBooks.txt");
        for (int i = 0; i < counter_issued; i++) {
            issuedBooksFile.print(issuedbooks[i].getCall_no() + ",");
            issuedBooksFile.print(issuedbooks[i].getName() + ",");
            issuedBooksFile.print(issuedbooks[i].getAuthor() + ",");
            issuedBooksFile.print(issuedbooks[i].getPublisher() + ",");
            issuedBooksFile.print(issuedbooks[i].getQuantity() + ",");
            issuedBooksFile.print(issuedbooks[i].getIssued() + ",");
            issuedBooksFile.print(issuedbooks[i].getAdded_date()+",");
            issuedBooksFile.print(issuedbooks[i].getIssuedate()+ ",");
            issuedBooksFile.print(issuedbooks[i].getReturndate()+ ",");
            issuedBooksFile.print(issuedbooks[i].student.getId() + ",");
            issuedBooksFile.print(issuedbooks[i].student.getName() + ",");
            issuedBooksFile.print(issuedbooks[i].student.getPassword() + ",");
            issuedBooksFile.print(issuedbooks[i].student.getContact_no());

            issuedBooksFile.println();
        }
        issuedBooksFile.close();
    }

    public static void readBooks(String filename) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filename));
        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] token = line.split(",");
            books[counter_books++] = new Books(token[0], token[1], token[2], token[3], Integer.parseInt(token[4]), Integer.parseInt(token[5]), token[6]);
        }
        inFile.close();
    }
    public static void readAdmin(String filename) throws FileNotFoundException{
        Scanner inFile = new Scanner(new File (filename));
        while(inFile.hasNextLine()){
            String line=inFile.nextLine();
            String [] token = line.split(",");
            admin[counter_admin++] = new Admin(token[0],token[1]);
        }
        inFile.close();
    }
    public static void readLibrarian(String filename) throws FileNotFoundException{
        Scanner inFile = new Scanner(new File(filename));
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            String [] token = line.split(",");
            librarians[counter_librarians++] = new Librarian(token[0],token[1],token[2],token[3],token[4],token[5],Integer.parseInt(token[6]));
        }
        inFile.close();
    }
    public static void readStudent(String filename) throws FileNotFoundException{
        Scanner inFile = new Scanner(new File(filename));
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            String [] token = line.split(",");
            students[counter_students++] = new Student(token[0],token[1],token[2],token[3],token[4],token[5],Integer.parseInt(token[6]),Integer.parseInt(token[7]));
        }
        inFile.close();
    }
    public static void readIssued(String filename) throws FileNotFoundException{
        Scanner inFile = new Scanner(new File(filename));
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            String[] token = line.split(",");

            Student s= new Student(Integer.parseInt(token[9]),token[10],token[11],token[12]);

            issuedbooks[counter_issued]=new IssuedBooks(token[0],token[1],token[2],token[3],Integer.parseInt(token[4]),Integer.parseInt(token[5]),token[6],token[7],token[8]);
            issuedbooks[counter_issued++].setStudent(s);


        }
        inFile.close();
    }



}
