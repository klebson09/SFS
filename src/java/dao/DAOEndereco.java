package dao;

import model.Endereco;
import model.Pessoa;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klebsonsantana
 */
public class DAOEndereco {
    
    public void adicionar(Endereco endereco) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into endereco "
                + "(logradouro, numero, complemento, bairro, cidade, estado, cep)"
                + " values (?,?,?,?,?,?,?)";
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            // seta os valores
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, endereco.getLogradouro());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setString(7, endereco.getCep());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void list() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Endereco endereco = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String query = "SELECT 'idEndereco', 'logradouro', 'numero', 'complemento', 'cidade', 'estado' ,'cep' FROM 'endereco' WHERE idEndereco=";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "root");
            //conectando stmt = con.createStatement(); //criando um statement
            rs = stmt.executeQuery(query); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {
                
                endereco = new Endereco();

                //Recuperando os dados do result set.
                endereco.setIdEndereco(Integer.MIN_VALUE);
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));
                System.out.println(endereco);
            }
        } catch (ClassNotFoundException ex) {
            //Problemas no carregamento do driver
            ex.printStackTrace();
        } catch (SQLException ex) { //principal exceção JDBC
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                
            }
            
        }
    }
    
    public int pegaUltimaPessoa() {
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String query = "SELECT * from pessoa where idPessoa = (select max(idPessoa) from pessoa)";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "root");
            //conectando stmt = con.createStatement(); //criando um statement
            rs = stmt.executeQuery(query); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                // pessoa = new Pessoa();
//Recuperando os dados do result set.
//                endereco.setIdEndereco(Integer.MIN_VALUE);
//                endereco.setLogradouro(rs.getString("logradouro"));
//                endereco.setNumero(rs.getInt("numero"));
//                endereco.setComplemento(rs.getString("complemento"));
//                endereco.setCidade(rs.getString("cidade"));
//                endereco.setEstado(rs.getString("estado"));
//                endereco.setCep(rs.getString("cep"));
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                System.out.println(pessoa.toString());
                return rs.getInt("idPessoa");
            }
        } catch (ClassNotFoundException ex) {
            //Problemas no carregamento do driver
            ex.printStackTrace();
        } catch (SQLException ex) { //principal exceção JDBC
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                
            }
            
        }
        
        return 0;
    }
    
    public Endereco buscarEndereco(String logradouro) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Endereco endereco = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idEndereco, logradouro, numero, complemento, cidade, estado, cep "
                    + "FROM endereco "
                    + "WHERE logradouro=" + "'" + logradouro + "'");
            
            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {
                
                endereco = new Endereco();

                //Recuperando os dados do result set.
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado("estado");
                endereco.setCep("cep");
                
            }
        } catch (ClassNotFoundException ex) {
            //Problemas no carregamento do driver
            ex.printStackTrace();
        } catch (SQLException ex) { //principal exceção JDBC
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                
            }
            
        }
        
        return endereco;
    }
}

