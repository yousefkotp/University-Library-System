public class Librarian {
    private String name;
    private String pass;
    private String email;
    private String address;
    private String city;
    private String contact_no;
    private int id;





    public Librarian(String name, String pass, String email, String address, String city, String contact_no, int id) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact_no = contact_no;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
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

    public String getContact_no() {
        return contact_no;
    }
}
