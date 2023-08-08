package basicloginsystem;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;

public class EmployeeProcess {

    private Connection connection = null;

    private Statement statement = null;

    private PreparedStatement preparedStatement = null;

    public boolean loginInfos(String username, String password) {
        statement = connection.createStatement();
        String query = "SELECT * FROM table WHERE id=1";
        ResultSet resultSet = executeQuery(query);
        String dataUsername = resultSet.getString("usrname");
        String dataPassword = resultSet.getString("password");
        if (dataUsername.equals(username) && dataPassword.equals(password)) {
            return true;
      } 
        else 
            return false;
        

    }

    public EmployeeProcess() {
        String url = "jdbc:mysql:" + Database.host + ":" + Database.port + "/" + Database.dbname;

        connection = DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        EmployeeProcess process = new EmployeeProcess();
    }

}
