public class Student {
    private int id;
    private String name;
    private String password;
    private String email;
    private  String address;
    private String city;
    private String contact_no;
    public int borrowed=0;

    public Student() {
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(int borrowed) {
        this.borrowed = borrowed;
    }

    public Student(String name, String password, String email, String address, String city, String contact_no, int id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact_no = contact_no;
        this.id=id;
    }

    public Student(String name, String password, String email, String address, String city, String contact_no,int id,  int borrowed) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact_no = contact_no;
        this.borrowed = borrowed;
    }

    public Student(int id, String name, String password,String contact_no) {
        this.id = id;
        this.name = name;
        this.password =password;
        this.contact_no = contact_no;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContact_no() {
        return contact_no;
    }
}
