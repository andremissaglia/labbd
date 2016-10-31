package labbd;

import java.sql.SQLException;

public class Labbd {

    public static void main(String[] args) {
        try {
            OracleConnection.connect();
            Ex1 ex1 = new Ex1();
            ex1.oracle2Mongo("LE04BAIRRO");
            OracleConnection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
