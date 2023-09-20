package API_Spring.Cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Config{

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Germinare", "postgres", "1234");
            return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            return false;

        }
    }
    public void desconectar(){
        try{
        if(conn !=null && !conn.isClosed()){
            // Desconectando do BD
            conn.close();
        }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
