public class Student {
    private String name, rollNo, department, email, phone;
    private double marks;

    public Student(String name, String rollNo, String department,
               String email, String phone, double marks) {

    if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("Name cannot be empty");
    }

    if (rollNo == null || rollNo.isBlank()) {
        throw new IllegalArgumentException("Roll number cannot be empty");
    }

    if (email == null || !email.contains("@")) {
        throw new IllegalArgumentException("Invalid email");
    }

    if (marks < 0 || marks > 100) {
        throw new IllegalArgumentException("Marks must be between 0 and 100");
    }

    this.name = name;
    this.rollNo = rollNo;
    this.department = department;
    this.email = email;
    this.phone = phone;
    this.marks = marks;
}

    public String getName(){ return name; }
    public String getRollNo(){ return rollNo; }
    public String getDepartment(){ return department; }
    public String getEmail(){ return email; }
    public String getPhone(){ return phone; }
    public double getMarks(){ return marks; }
}
