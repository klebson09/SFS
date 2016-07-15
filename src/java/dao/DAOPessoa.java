package dao;

import model.Pessoa;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Medico;
import model.Paciente;

/**
 *
 * @author klebson
 */
public class DAOPessoa {

    public void adicionar(Pessoa pessoa) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into pessoa "
                + "(nome, data_nasc, sexo, CPF, RG, naturalidade, estadoCivil, "
                + "telefone, celular, email, pwd, idEndereco)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            System.out.println(con.getAutoCommit());
            try ( // seta os valores
                    PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, pessoa.getDataNasc());
                stmt.setString(3, pessoa.getSexo());
                stmt.setString(4, pessoa.getCPF());
                stmt.setString(5, pessoa.getRG());
                stmt.setString(6, pessoa.getNaturalidade());
                stmt.setString(7, pessoa.getEstadoCivil());
                stmt.setString(8, pessoa.getTelefone());
                stmt.setString(9, pessoa.getCelular());
                stmt.setString(10, pessoa.getEmail());
                stmt.setString(11, pessoa.getPwd());
                stmt.setInt(12, pessoa.getIdEndereco());
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
            stmt = con.prepareStatement("SELECT idPessoa, nome, data_nasc, sexo,"
                    + " CPF, RG, naturalidade, estadoCivil, telefone, celular, "
                    + "email, pwd, idEndereco "
                    + "FROM pessoa "
                    + "WHERE CPF    =" + "'" + cpfPessoa + "'");

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
        Pessoa pessoa = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idPessoa, nome, data_nasc, sexo,"
                    + " CPF, RG, naturalidade, estadoCivil, telefone, celular, "
                    + "email, pwd, idEndereco "
                    + "FROM pessoa "
                    + "WHERE email=" + "'" + email + "'"
                    + "AND pwd=" + "'" + senha + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                pessoa = new Pessoa();

                //Recuperando os dados do result set.
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo("sexo");
                pessoa.setNaturalidade("naturalidade");
                pessoa.setEstadoCivil("estadoCivil");
                pessoa.setTelefone("telefone");
                pessoa.setCelular("celular");
                pessoa.setDataNasc(rs.getString("data_nasc"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setPwd(rs.getString("pwd"));
                pessoa.setIdEndereco(rs.getInt("idEndereco"));

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

        return pessoa;
    }

    public Pessoa buscarPessoaPorNome(String nome) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idPessoa, nome, data_nasc, CPF, RG, email, pwd "
                    + "FROM pessoa "
                    + "WHERE nome=" + "'" + nome + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                pessoa = new Medico();

                //Recuperando os dados do result set.
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNasc(rs.getString("data_nasc"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setPwd(rs.getString("pwd"));
                System.out.println(pessoa);

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

        return pessoa;
    }

    public List<Pessoa> listarPessoa() {
        List<Pessoa> pessoas = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        Pessoa pessoa = new Pessoa();

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT *"
                    + "FROM pessoa ");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            while (rs.next()) {
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setDataNasc(rs.getString("data_nasc"));
                pessoa.setCPF(rs.getString("CPF"));
                pessoa.setRG(rs.getString("RG"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setPwd(rs.getString("pwd"));
                pessoas.add(pessoa);
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

        return pessoas;
    }
}
