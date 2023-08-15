package companymanagementsystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Connections {

    private final String username = "root";
    private final String password = "123456";

    private final String dbname = "company_management";

    private final String host = "localhost";

    private final int port = 3306;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    public Connections() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbname;
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed" + e);
        }
    }

    public boolean preparedAddData(String username, String password) { // Dönen boolean göre. 

        try {
            String query = "INSERT INTO ADMIN (username, password) VALUES (?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int resultSet = preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
    
    

    public boolean preparedLoginCheckpoint(String username, String password) {

        try {
            String query = "SELECT id,username,password FROM ADMIN WHERE username=? AND password=? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultS = preparedStatement.executeQuery();
            if (resultS.next()) {
                return true;
            }

        } catch (SQLException exception) {
            return false;
        }
        return false;
       }
    
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String[] getColumnNames(String tableName) throws SQLException {
    String query = "SHOW COLUMNS FROM " + tableName;

    statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query);
    List<String> columnNames = new ArrayList<>();
    while (resultSet.next()) {
        columnNames.add(resultSet.getString("Field"));
    }
    return columnNames.toArray(new String[columnNames.size()]);
}
    
    
    
    public List<Object[]> fetchRowObjects(String tableName) throws SQLException{
    String query = "SELECT * FROM " + tableName;
    statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query);
    String[] columnNames = getColumnNames(tableName);
    
    List<Object[]> rowsList = new ArrayList<>(); 
    while (resultSet.next()) {
        Object[] rows = new Object[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            rows[i] = resultSet.getObject(columnNames[i]);
        }
        rowsList.add(rows); 
    }

    return rowsList;
}
    
    public void insertData(String tableName, String[] columnNames, String[] values) {
    String columns = String.join(", ", columnNames);
    String placeholders = String.join(", ", Collections.nCopies(columnNames.length, "?"));
    String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";
    
    try {
        PreparedStatement preparedStatementt = connection.prepareStatement(query);
        for (int i = 0; i < values.length; i++) {
            preparedStatementt.setString(i + 1, values[i]);
        }
        
        preparedStatement.executeUpdate();
        // Ekleme iþlemi baþarýyla tamamlandý.
    } catch (SQLException e) {
        e.printStackTrace();
        // Ekleme iþlemi sýrasýnda bir hata oluþtu.
    }
}

  
  public void updateData(String tableName, String[] columnNames, String[] newValues, String primaryKeyColumnName, String primaryKeyValue) {
    
    try {
        // Veritabaný baðlantýsýný al
        
        
        // SQL sorgusu
        StringBuilder updateQuery = new StringBuilder("UPDATE " + tableName + " SET ");
        for (int i = 0; i < columnNames.length; i++) {
            updateQuery.append(columnNames[i]).append(" = ?");
            if (i < columnNames.length - 1) {
                updateQuery.append(", ");
            }
        }
        updateQuery.append(" WHERE ").append(primaryKeyColumnName).append(" = ?");
        
        // PreparedStatement oluþtur
        preparedStatement = connection.prepareStatement(updateQuery.toString());
        
        // Yeni deðerleri PreparedStatement'e ekle
        for (int i = 0; i < newValues.length; i++) {
            preparedStatement.setString(i + 1, newValues[i]);
        }
        
        // Primary key deðerini PreparedStatement'e ekle
        preparedStatement.setString(newValues.length + 1, primaryKeyValue);
        
        // Sorguyu çalýþtýr
        preparedStatement.executeUpdate();
        
        // Baþarýlý mesajý veya güncellendiyse mesajý göster
        System.out.println("Data updated successfully!");
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Hata mesajý göster
        System.err.println("Error updating data: " + ex.getMessage());
    } 
}

  public void deleteRow(String tableName, String primaryKeyColumnName, String primaryKeyValue) {
    String deleteQuery = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?";
    
    try {
        PreparedStatement preparedStatementFour = connection.prepareStatement(deleteQuery);
        preparedStatementFour.setString(1, primaryKeyValue);
        preparedStatementFour.executeUpdate();
        
        System.out.println("Row deleted successfully!");
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.err.println("Error deleting row: " + ex.getMessage());
    }
}




    

    
    
    
    
    
    
    
    
 
        
    

}
