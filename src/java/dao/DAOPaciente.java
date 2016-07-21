package dao;

import model.Paciente;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Pessoa;

/**
 *
 * @author klebson  
 */
public class DAOPaciente {

    //DAOPessoa daoPessoa = new DAOPessoa();
    // DAOPaciente daopaciente = new DAOPaciente();
    //DAOEndereco daoEndereco = new DAOEndereco();
    public void adicionar(Paciente paciente) {
//public void adicionar(Paciente paciente, Pessoa pessoa, Endereco endereco) {

        //daoPessoa.adicionar(pessoa);
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into paciente "
                + "(numSUS, Pessoa_idPessoa)"
                + " values (?, ?)";

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            // seta os valores
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, paciente.getNumSUS());
            stmt.setInt(2, paciente.getPessoaIdPessoa());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        //daoEndereco.adicionar(endereco);
    }

    public Integer pegaIdPessoa(String cpf) throws SQLException, IOException {
        Integer idPessoa = null;
        Connection con = null;
        PreparedStatement SQL;
        Paciente paciente = null;

        try {
            String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
            con = DriverManager.getConnection(url, "root", "");
            SQL = con.prepareStatement("Select idPessoa from pessoa where CPF = ?");
            SQL.setString(1, cpf);
            ResultSet rs = SQL.executeQuery();
            if (rs.next()) {
                idPessoa = Integer.MIN_VALUE;
            } else {
                System.out.println("Cliente não encontrado");
            }
            rs.close();
            SQL.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e);
        }
        return idPessoa;
    }

    public void delete() {
    }

    public void list() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String query = "SELECT Paciente_numSUS, idPaciente=";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            rs = stmt.executeQuery(query); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                paciente = new Paciente();

//Recuperando os dados do result set.
                //paciente.setIdPaciente(Integer.MIN_VALUE);
                paciente.setNumSUS(rs.getNString("numSUS"));
                System.out.println(paciente);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            //Problemas no carregamento do driver
            ex.printStackTrace();
        } //principal exceção JDBC
        finally {
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

    public Paciente buscarPaciente(String email, String senha) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = new Paciente();
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";

        DAOPessoa daoPessoa = new DAOPessoa();
        paciente.parser(daoPessoa.buscarPessoa(email, senha));
        int idpessoa = paciente.getIdPessoa();
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idPaciente, numSUS "
                    + "FROM paciente "
                    + "WHERE Pessoa_idPessoa=" + "'" + idpessoa + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNumSUS(rs.getString("numSUS"));
                //Recuperando os dados do result set.

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
