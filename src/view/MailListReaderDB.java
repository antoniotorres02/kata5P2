package view;

import java.util.List;
import model.Mail;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailListReaderDB {

    String database;

    public MailListReaderDB(String database) {
        this.database = database;
    }

    public List<Mail> read() {
        String sql = "SELECT Mail FROM direcc_email";
        List<Mail> mailList = new ArrayList<>();
        try ( Connection conn = this.connect();  
                Statement stmt = conn.createStatement();  
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                mailList.add(new Mail(rs.getString(1)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mailList;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.database);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
