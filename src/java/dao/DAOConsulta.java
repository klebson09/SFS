package dao;

import model.Consulta;
import com.mysql.jdbc.Statement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOConsulta implements Serializable {

    public void adicionar(Consulta consulta) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into consulta "
                + "(Paciente_idPaciente, Paciente_numSUS, MEdico_idMEdico, "
                + "MEdico_CRM, descricaoConsulta, dataConsulta, tipoConsulta, observacao, idEndereco)"
                + " values (?,?,?,?,?,?,?,?,?)";

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            // seta os valores
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, consulta.getPacienteIdPaciente());
            stmt.setString(2, consulta.getPacienteNumSUS());
            stmt.setInt(3, consulta.getMedicoIdMedico());
            stmt.setString(4, consulta.getMedicoCRM());
            stmt.setString(5, consulta.getDescricaoConsulta());
            stmt.setString(6, consulta.getDataConsulta());
            stmt.setString(7, consulta.getTipoConsulta());
            stmt.setString(8, consulta.getObservacao());
            stmt.setInt(9, consulta.getIdEndereco());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete() {
    }

    public void list() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Consulta consulta = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String query = "SELECT Paciente_idPaciente, Paciente_numSUS, MEdico_idMEdico, MEdico_CRM, tipo_consulta, observacao, arquivo_consulta=";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "root");
            //conectando stmt = con.createStatement(); //criando um statement
            rs = stmt.executeQuery(query); //executando a query

            // o result set contém os resultados da operação
            if (rs.next()) {

                consulta = new Consulta();

//Recuperando os dados do result set.
                consulta.setIdConsulta(Integer.MIN_VALUE);
                consulta.setPacienteIdPaciente(rs.getInt("Paciente_idPaciente"));
                consulta.setPacienteNumSUS(rs.getString("Paciente_numSUS"));
                consulta.setMedicoIdMedico(rs.getInt("MEdico_idMEdico"));
                consulta.setMedicoCRM(rs.getString("MEdico_CRM"));
                consulta.setTipoConsulta(rs.getString("tipo_consulta"));
                consulta.setObservacao(rs.getString("observacao"));
                consulta.setArquivoConsulta(rs.getBytes("arquivo_consulta"));
                System.out.println(consulta);
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

    public Consulta buscarConsultaPorDesc(String descricao) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";
        Consulta consulta = new Consulta();
        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT * FROM consulta WHERE descricaoConsulta = ?");
            stmt.setString(1, descricao);
            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            while (rs.next()) {
                consulta.setIdConsulta(rs.getInt("idConsulta"));
                consulta.setPacienteIdPaciente(rs.getInt("Paciente_idPaciente"));
                consulta.setPacienteNumSUS(rs.getString("Paciente_numSUS"));
                consulta.setMedicoIdMedico(rs.getInt("MEdico_idMEdico"));
                consulta.setMedicoCRM(rs.getString("MEdico_CRM"));
                consulta.setDescricaoConsulta(rs.getString("descricaoConsulta"));
                consulta.setDataConsulta(rs.getString("dataConsulta"));
                consulta.setTipoConsulta(rs.getString("tipoConsulta"));
                consulta.setObservacao(rs.getString("observacao"));
                consulta.setIdEndereco(rs.getInt("idEndereco"));
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

        return consulta;
    }

    public ArrayList<Consulta> listarConsultas() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost/bd_sistema_ficha_saude";

        try {

            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver
            con = DriverManager.getConnection(url, "root", "");
            //conectando stmt = con.createStatement(); //criando um statement
            stmt = con.prepareStatement("SELECT * FROM consulta");

            rs = stmt.executeQuery(); //executando a query

            // o result set contém os resultados da operação
            while (rs.next()) {
                Consulta consulta = new Consulta();

                consulta.setIdConsulta(rs.getInt("idConsulta"));
                consulta.setPacienteIdPaciente(rs.getInt("Paciente_idPaciente"));
                consulta.setPacienteNumSUS(rs.getString("Paciente_numSUS"));
                consulta.setMedicoIdMedico(rs.getInt("MEdico_idMEdico"));
                consulta.setMedicoCRM(rs.getString("MEdico_CRM"));
                consulta.setDescricaoConsulta(rs.getString("descricaoConsulta"));
                consulta.setDataConsulta(rs.getString("dataConsulta"));
                consulta.setTipoConsulta(rs.getString("tipoConsulta"));
                consulta.setObservacao(rs.getString("observacao"));
                consulta.setIdEndereco(rs.getInt("idEndereco"));
                consultas.add(consulta);
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

        return consultas;
    }

}
