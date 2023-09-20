package API_Spring.Cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario_padrao{
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    Config config= new Config();
    
    public boolean inserir(String e_mail, String nome, String senha, int cep, int cpf){
        try{
        config.conectar();//Abrindo uma conexão com o banco
        pstmt= conn.prepareStatement("INSERT INTO USUARIO_PADRAO( e_mail, nome, senha, cep, cpf) VALUES(?,?,?,?,?)");

        //Setando o valor dos parametros
        pstmt.setString(1, e_mail);
        pstmt.setString(2, nome);
        pstmt.setString(3, senha);
        pstmt.setInt(4,cep);
        pstmt.setInt(5,cpf);
        pstmt.execute(); // Executando o comando sql do preparedStatement
        config.desconectar(); //Fechando conexão do banco
        return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }
    public boolean remover(String email){
            try{
                config.conectar();//Abrindo uma conexão com o banco
                String remover= "DELETE FROM USUARIO_PADRAO WHERE E_MAIL=?";
                pstmt= conn.prepareStatement(remover);
    
                //Setando o valor dos parametros
                pstmt.setString(1,email);
                pstmt.execute(); // Executando o comando sql do preparedStatement
                config.desconectar(); //Fechando conexão do banco
                return true;
            }catch(SQLException sqle){
                sqle.printStackTrace();
                return false;
            }
        }
        public boolean alterarNome(String nome,  int cpf){
            try{
            config.conectar();//Abrindo uma conexão com o banco
            pstmt= conn.prepareStatement("UPDATE USUARIO_PADRAO SET NOME= ? WHERE CPF=? ");
    
            //Setando o valor dos parametros
            pstmt.setString(1, nome);
            pstmt.setInt(2,cpf);
            pstmt.execute(); // Executando o comando sql do preparedStatement
            config.desconectar(); //Fechando conexão do banco
                return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    
        }
        public boolean alterarSenha(String senha, int cpf){
            try{
            config.conectar();//Abrindo uma conexão com o banco
            pstmt= conn.prepareStatement("UPDATE USUARIO_PADRAO SET SENHA= ? WHERE CPF=? ");
    
            //Setando o valor dos parametros
            pstmt.setString(1, senha);
            pstmt.setInt(2, cpf);
            pstmt.execute(); // Executando o comando sql do preparedStatement
            config.desconectar(); //Fechando conexão do banco
                return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    
        }
        public boolean alterarEmail(String e_mail, int cpf){
            try{
            config.conectar();//Abrindo uma conexão com o banco
            pstmt= conn.prepareStatement("UPDATE USUARIO_PADRAO SET e_mail= ? WHERE CPF=?");
    
            //Setando o valor dos parametros
            pstmt.setString(1, e_mail);
            pstmt.setInt(2,cpf);
            pstmt.execute(); // Executando o comando sql do preparedStatement
            config.desconectar(); //Fechando conexão do banco
                return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    
        }
        public boolean alterarCep(int cep, int cpf){
            try{
            config.conectar();//Abrindo uma conexão com o banco
            pstmt= conn.prepareStatement("UPDATE USUARIO_PADRAO SET CEP= ? WHERE CPF=?");
    
            //Setando o valor dos parametros
            pstmt.setInt(1,cep);
            pstmt.setInt(2,cpf);
            pstmt.execute(); // Executando o comando sql do preparedStatement
            config.desconectar(); //Fechando conexão do banco
                return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    
        }
        
        public ResultSet buscar(){
            try{
                config.conectar();//Abrindo uma conexão com o banco
                pstmt= conn.prepareStatement("SELECT * FROM USUARIO_PADRAO ORDER BY COD");
                //Executando o comando SQL do objeto prparedStatement
                // e armazenando o ResultSet
                rs= pstmt.executeQuery();
                return rs;// Retornando o Result Set
            }catch(SQLException sqle){
                sqle.printStackTrace();
                return null;
            }finally{
                config.desconectar(); //Fechando conexão do banco
            }
        }
        public ResultSet buscarUmUsuario(int cpf){
            try{
                config.conectar();//Abrindo uma conexão com o banco
                pstmt= conn.prepareStatement("SELECT * FROM USUARIO_PADRAO WHERE CPF=?");
                //Executando o comando SQL do objeto prparedStatement
                pstmt.setInt(1,cpf);
                // e armazenando o ResultSet
                rs= pstmt.executeQuery();
                return rs;// Retornando o Result Set
            }catch(SQLException sqle){
                sqle.printStackTrace();
                return null;
            }finally{
                config.desconectar(); //Fechando conexão do banco
            }
        }
}