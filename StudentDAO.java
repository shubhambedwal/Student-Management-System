import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s){
        try(Connection con=DatabaseConnection.getConnection()){
            String sql="insert into students(name,roll_no,department,email,phone,marks) values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,s.getName());
            ps.setString(2,s.getRollNo());
            ps.setString(3,s.getDepartment());
            ps.setString(4,s.getEmail());
            ps.setString(5,s.getPhone());
            ps.setDouble(6,s.getMarks());

            ps.executeUpdate();
            System.out.println("Student Added");
        }catch(Exception e){e.printStackTrace();}
    }

    public void viewStudents(){
        try(Connection con=DatabaseConnection.getConnection()){
            ResultSet rs=con.createStatement().executeQuery("select * from students");
            while(rs.next()){
                System.out.println(rs.getString("roll_no")+" | "+rs.getString("name")+" | "+rs.getDouble("marks"));
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void deleteStudent(String rollNo){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement("delete from students where roll_no=?");
            ps.setString(1,rollNo);
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    public void searchStudent(String rollNo){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement("select * from students where roll_no=?");
            ps.setString(1,rollNo);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch(Exception e){e.printStackTrace();}
    }
}