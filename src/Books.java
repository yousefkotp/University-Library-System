public class Books {
    private String call_no;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issued =0;
    private String added_date;

    public Books(String call_no, String name, String author, String publisher, int quantity, int issued, String added_date) {
        this.call_no = call_no;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.added_date = added_date;
    }





    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStudent(Student student) {
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public void setAdded_date(String added_date) {
        this.added_date = added_date;
    }



    public int getIssued() {
        return issued;
    }

    public String getAdded_date() {
        return added_date;
    }

    public Books(String call_no, String name, String author, String publisher, int quantity, Student student, int issued, String added_date) {
        this.call_no = call_no;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.added_date = added_date;
    }

    public Books (String call_no ){
        this.call_no = call_no;
    }

    public Books(String call_no, String name, String author, String publisher, int quantity) {
        this.call_no = call_no;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }






    public String getCall_no() {
        return call_no;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }


}
