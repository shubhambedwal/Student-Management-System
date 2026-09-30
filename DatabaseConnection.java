import java.sql.*;

public class DatabaseConnection {
    db.url=jdbc:mysql://localhost:3306/smartstudent
    db.username=root
    db.password=YOUR_PASSWORD

    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();

try (InputStream input =
         DatabaseConnection.class
             .getClassLoader()
             .getResourceAsStream("db.properties")) {

    properties.load(input);

} catch (IOException e) {
    throw new RuntimeException("Unable to load database configuration", e);
}
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
