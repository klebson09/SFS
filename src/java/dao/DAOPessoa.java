package dao;

import model.Pessoa;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Paciente;

public class DAOPessoa {

    public void adicionar(Pessoa pessoa) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into pessoa "
                + "(nome, data_nasc, CPF, RG, email, pwd, idEndereco)"
                + " values (?,?,?,?,?,?,?)";

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            System.out.println(con.getAutoCommit());
            try ( // seta os valores
                    PreparedStatement stmt = con.prepareStatement(sql)) {
                        stmt.setString(1, pessoa.getNome());
                        stmt.setString(2, pessoa.getDataNasc());
                        stmt.setString(3, pessoa.getCPF());
                        stmt.setString(4, pessoa.getRG());
                        stmt.setString(5, pessoa.getEmail());
                        stmt.setString(6, pessoa.getPwd());
                        stmt.setInt(7, pessoa.getIdEndereco());
                        stmt.execute();
                        stmt.close();
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete() {
    }

    public void list(Endereco endereco) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String query = "SELECT idPessoa, nome, data_nasc, CPF, RG, email, pwd FROM 'pessoa' WHERE idPessoa=";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            rs = stmt.executeQuery(query); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                pessoa = new Paciente();

//Recuperando os dados do result set.
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNasc(rs.getString("data_nasc"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setPwd(rs.getString("pwd"));

                DAOEndereco daoEndereco = new DAOEndereco();
                daoEndereco.adicionar(endereco);
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

    public Pessoa buscarPessoaPorCPF(String cpfPessoa) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa usuario = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idPessoa, nome, data_nasc, CPF, RG, email, pwd FROM pessoa WHERE CPF=" + "'" + cpfPessoa + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                usuario = new Paciente();
                //Recuperando os dados do result set.
                usuario.setIdPessoa(rs.getInt("idPessoa"));
                usuario.setNome(rs.getString("nome"));
                usuario.setDataNasc(rs.getString("data_nasc"));
                usuario.setCPF(rs.getString("CPF"));
                usuario.setRG(rs.getString("RG"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPwd(rs.getString("pwd"));
                System.out.println(usuario);

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

        return usuario;
    }

    public Pessoa buscarPessoa(String email, String senha) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa paciente = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idPessoa, nome, data_nasc, CPF, RG, email, pwd "
                    + "FROM pessoa "
                    + "WHERE email=" + "'" + email + "'"
                    + "AND pwd=" +"'" + senha + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                paciente = new Paciente();

                //Recuperando os dados do result set.
                paciente.setIdPessoa(rs.getInt("idPessoa"));
                paciente.setNome(rs.getString("nome"));
                paciente.setDataNasc(rs.getString("data_nasc"));
                paciente.setCPF(rs.getString("CPF"));
                paciente.setRG(rs.getString("RG"));
                paciente.setEmail(rs.getString("email"));
                paciente.setPwd(rs.getString("pwd"));
                System.out.println(paciente);

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

        return paciente;
    }

}
