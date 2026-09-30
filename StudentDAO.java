import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s){
        try(Connection con=DatabaseConnection.getConnection()){
            String sql="insert into students(name,roll_no,department,email,phone,marks) values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);  //database connection for data management

            ps.setString(1,s.getName());
            ps.setString(2,s.getRollNo());
            ps.setString(3,s.getDepartment());
            ps.setString(4,s.getEmail());
            ps.setString(5,s.getPhone());
            ps.setDouble(6,s.getMarks());

            ps.executeUpdate();
            System.out.println("Student Added");
        }catch (SQLException e) {
    System.err.println("Database error: " + e.getMessage());
}
    }

    public void viewStudents(){
      public void viewStudents() {

    String sql = "SELECT roll_no, name, marks FROM students";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            System.out.println(
                rs.getString("roll_no") + " | " +
                rs.getString("name") + " | " +
                rs.getDouble("marks")
            );
        }

    } catch (SQLException e) {
        System.err.println("Unable to load students.");
        e.printStackTrace();
    }
}
}
    }

    public void deleteStudent(String rollNo){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement("delete from students where roll_no=?");
           public void deleteStudent(String rollNo) {

    String sql = "DELETE FROM students WHERE roll_no = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {


        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }

    } catch (SQLException e) {
        System.err.println("Delete failed.");
        e.printStackTrace();
    }
}
        }catch (SQLException e) {
    System.err.println("Database error: " + e.getMessage());
}
    }

    public void searchStudent(String rollNo){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement("select * from students where roll_no=?");
            ps.setString(1,rollNo);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (SQLException e) {
    System.err.println("Database error: " + e.getMessage());
}
    }
}
