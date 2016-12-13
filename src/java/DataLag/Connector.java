package DataLag;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connector {
    
    private Connection connection;
    private static Connector instance;
    private static PreparedStatement stmt;
    private final String HOST     = "46.101.126.94";
    private final int    PORT     = 3306;
    private final String DATABASE = "polygon";
    private final String USERNAME = "root"; 
    private final String PASSWORD = "bookworm#10laesehest";
  
    
    public Connector() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
    public static Connector getInstance() throws SQLException, ClassNotFoundException{
        if(instance == null) instance = new Connector();
        
       return instance;
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public ResultSet doQuery(String query) throws SQLException{
        System.out.println("*********"+query);
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        return res;
    }
    
    public void doUpdate(String query) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
    }
    
    public static PreparedStatement prepare(String SQLString) throws ClassNotFoundException {
        try {
            stmt = (PreparedStatement) getInstance().getConnection().prepareStatement(SQLString, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Fejl i DB.Prepare()");
        }
        return stmt;
    }

}