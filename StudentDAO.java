import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public static boolean addStudent(Student s) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name,email,course) VALUES(?,?,?)"
            );

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
