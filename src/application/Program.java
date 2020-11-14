package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE DepartmentId = ?");
            st.setDouble(1, 200.00);
            st.setInt(2, 2);

            int affectedRows = st.executeUpdate();

            System.out.println("Done! Affected rows: " + affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
