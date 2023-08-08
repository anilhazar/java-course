package jdbcmysqldatabasequery;


import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.sun.jdi.connect.spi.Connection;

public class Connections {

    private String username = "root";
    private String password = "";

    private String dbname = "demo";

    private String host = "localhost";

    private int port = 2151531;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    public void manuelCommit() {
        connection.setAutoCommit(false); // commit and rollback methods are manueal now
        statement = connection.createStatement();
        String query1 = "DELETE FROM table WHERE id = 2";
        String query2 = "UPDATE table SET isim='Ali' WHERE id=1";

        statement.executeUpdate(query2);
        int flag = statement.executeUpdate(query1);
        if (flag == 0) {
            connection.rollback();
            System.out.println("Query Failed. Rolling back the remaining queries...");

        } else {
            connection.commit();
        }

    }

    public void fetchData() {
        String query = "SELECT * FROM table";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

        } catch (Exception e) {
        }

    }

    public void preaparedFetchData(int data) {

        String query = "SELECT * FROM table WHERE age > ? AND name like ? ";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, data);
            preparedStatement.setString(2, "A%");
            ResultSet = resultSet = preparedStatement.executeQuery();
        }

    }

    public void addData() {
    private String name = "Agit";
    private String surname = "Demir";
    private int age = 25;

    
        try{
    statement = connection.createStatement();

        String query = "INSERT INTO table ("name", "surname", "age") VALUES (" '" + name + "'  " + surname + "  '" + age + "'  ")"
        ;
        
    statement.executeUpdate(query); // ekleme yaptýðýmýzdan tabloyu güncellemiþ oluyoruz aslýnda.
    }
    catch(Exception ex){
   }
}

   public void updateData(){

    try{
    statement = connection.createStatement();
    
    String query = "UPDATE table SET name= 'anil' WHERE id=1";

    statement.executeUpdate(query);
   }
   catch(Exception ex){
   }
  }
    
    public void deleteData(){
   
    try{
    statement = connection.createStatement();

    String query = "DELETE FROM table WHERE surname='demir' ";
    
    int amountOfDataDeleted = statement.executeUpdate(query);
   }
    catch(Exception ex){
   }
}

    
    public Connections(){
    
    // URL : "jdbc:mysql:localhost:99999/databasename;
    
    String url = "jdbc:mysql:" + host + ":" + port + "/" + dbname;
    
    connection = DriverManager.getConnection(url, username,password);
}

    public static void main(String[] args) {
        Connections connections = new Connections();
        
        connections.fetchData();
        connections.addData();
        connections.fetchData();
        connections.updateData();
        connections.fetchData();
        connections.deleteData();
        connections.fetchData();
        connections.preparedFetchData(24);
        connections.fetchData();
        connections.manuelCommit();        
        connections.fetchData();

        
    }
}
