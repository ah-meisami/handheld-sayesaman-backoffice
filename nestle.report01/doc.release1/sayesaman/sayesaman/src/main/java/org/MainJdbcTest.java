package org;

import org.apache.log4j.Logger;
import org.sunich.model.Person;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/13/13
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainJdbcTest {
    private Connection con = null;
    private CallableStatement cstmt = null;
    //    private PreparedStatement pstmt = null;
    private Statement stmt = null;

    private ResultSet rs = null;
    private static Logger log = Logger.getLogger(MainJdbcTest.class);

    public MainJdbcTest() {
        String databaseUrl = "jdbc:jtds:sqlserver://Oracle01/Sale;";
        String databaseUsername = "sa";
        String databasePassword = "111111";
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        }
    }

    public List gettblPersonnel(String personnelRef, String supervisorRef, String dCRef, String personnelTypeRef) {
        List ll = new LinkedList();
        try {
            cstmt = con.prepareCall("{ call gettblPersonnel(?,?,?,?) }");
            cstmt.setString(1, personnelRef);
            cstmt.setString(2, supervisorRef);
            cstmt.setString(3, dCRef);
            cstmt.setString(4, personnelTypeRef);

            log.info("exec gettblPersonnel " + personnelRef + "," + supervisorRef + "," + dCRef + "," + personnelTypeRef);
            rs = cstmt.executeQuery();

            while (rs.next()) {
                Person person = new Person();
                person.setId(Long.valueOf(rs.getString("ID")));
                person.setName(rs.getString("PersonnelName"));
                ll.add(person);

                System.out.println(person.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ll;
    }


    public static void main(String[] args) {
        MainJdbcTest handler = new MainJdbcTest();
        handler.gettblPersonnel("0", "0", "1", "0");
    }
    
}
