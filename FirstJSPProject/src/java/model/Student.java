
package model;

public class Student {
    private int stu_id;
    private String name;
    private String email;
    private String address;
    private String cell_no;

    public Student() {
    }

    public Student(int stu_id, String name, String email, String address, String cell_no) {
        this.stu_id = stu_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.cell_no = cell_no;
    }

    public Student(String name, String email, String address, String cell_no) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.cell_no = cell_no;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell_no() {
        return cell_no;
    }

    public void setCell_no(String cell_no) {
        this.cell_no = cell_no;
    }

    

    
    
    
}
