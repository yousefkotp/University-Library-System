public class IssuedBooks extends Books{
    private String returndate;
    private String issuedate;
    public Student student;

    public String getReturndate() {
        return returndate;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public void setStudent(Student student) {
        this.student = student;
    }

    public IssuedBooks(String call_no, Student student, String returndate) {
        super(call_no);
        this.student=student;
        this.returndate = returndate;
    }

    public IssuedBooks(String call_no, String name, String author, String publisher, int quantity, int issued, String added_date,String issuedate,String returndate) {
        super(call_no, name, author, publisher, quantity, issued, added_date);
        this.issuedate= issuedate;
        this.returndate=returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getIssuedate() {
        return issuedate;
    }
}
