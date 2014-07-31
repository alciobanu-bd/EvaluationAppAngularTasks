package ro.alinagarea.clinica.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DoctorServiceImpl implements DoctorService {
    public void insertSomeDoctors(){
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection("jdbc:h2:mem:clinica", "root", "");
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO specializations(id, description) VALUES(1,'Cardiologie');";

            stmt.executeUpdate(sql);

            String sql2 =
                    "INSERT INTO doctors(first_name, last_name, specialty_id) VALUES('Alina','Garea',1);";
            stmt.executeUpdate(sql2);

            System.out.println("Inserted records into the table...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
