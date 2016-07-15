package dao;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Medico;
import model.Pessoa;

/**
 *
 * @author klebson
 */
public class DAOMedico {

    public void adicionar(Medico medico) {
//public void adicionar(Paciente paciente, Pessoa pessoa, Endereco endereco) {

        //daoPessoa.adicionar(pessoa);
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into medico "
                + "(CRM, Pessoa_idPessoa)"
                + " values (?, ?)";

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            // seta os valores
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, medico.getNumCRM());
            stmt.setInt(2, medico.getPessoaIdPessoa());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

        //daoEndereco.adicionar(endereco);
    }

    public Integer pegaIdPessoa(String cpf) throws SQLException, IOException {
        Integer idPessoa = null;
        Connection con = null;
        PreparedStatement SQL;
        Medico medico = null;

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
        Medico medico = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String query = "SELECTCRM, Pessoa_idPessoa="; // obs no select
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            rs = stmt.executeQuery(query); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                medico = new Medico();

//Recuperando os dados do result set.
                //medico.Medico(Integer.MIN_VALUE);
                medico.setNumCRM(rs.getNString("crm"));//OBS
                System.out.println(medico);
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

    public Medico buscarMedico(String nome) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico = new Medico();
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";

        DAOPessoa daoPessoa = new DAOPessoa();
        medico.parser(daoPessoa.buscarPessoaPorNome(nome));
        int idpessoa = medico.getIdPessoa();
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idMEdico, CRM "
                    + "FROM medico "
                    + "WHERE Pessoa_idPessoa=" + "'" + idpessoa + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {
                medico.setIdMedico(rs.getInt("idMEdico"));
                medico.setNumCRM(rs.getString("CRM"));
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

        return medico;
    }

    public Medico buscarMedicoPorUsuario(String email, String senha) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";

        DAOPessoa daoPessoa = new DAOPessoa();
        medico = (Medico) daoPessoa.buscarPessoa(email, senha);

        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT idMEdico, CMR"
                    + "FROM medico "
                    + "WHERE Pessoa_idPessoa=" + "'" + medico.getIdPessoa() + "'");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {
                medico.setIdMedico(rs.getInt("idMEdico"));
                medico.setNumCRM(rs.getString("CMR"));
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

        return medico;
    }

    //lista de medicos kl
    public List<Medico> getListar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico;
        DAOPessoa daoPessoa = new DAOPessoa();
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        List<Medico> medicos = new ArrayList<>();
        List<Pessoa> pessoas;

        pessoas = daoPessoa.listarPessoa();

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT *"
                    + "FROM medico ");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            while (rs.next()) {
                medico = new Medico();
                medico.setIdMedico(rs.getInt("idMEdico"));
                medico.setNumCRM(rs.getString("CRM"));
                medico.setPessoaIdPessoa(rs.getInt("pessoa_IdPessoa"));
                medicos.add(medico);
            }
            for (int i = 0; i < medicos.size(); i++) {
                for (int j = 0; j < pessoas.size(); j++) {
                    if (medicos.get(i).getPessoaIdPessoa().equals(pessoas.get(j).getIdPessoa())) {
                        medicos.get(i).setNome(pessoas.get(j).getNome());
                    }
                }
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

        return medicos;
    }
}
