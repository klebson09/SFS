/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exame;

/**
 *
 * @author Pedro Jatoba
 */
public class DAOExame {
    
    
    public void adicionar(Exame exame){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
        String sql = "insert into exame "
                + "(consulta_idConsulta, tipo_exame, especialidade, observacao, data_exame)"
                + " values (?,?,?,?,?)";
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //registrando o driver

            con = DriverManager.getConnection(url, "root", "");
            // seta os valores
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, exame.getConsultaIdConsulta());
            stmt.setString(2, exame.getTipoExame());
            stmt.setString(3, exame.getEspecialidade());
            stmt.setString(4, exame.getObservacao());
            stmt.setString(5, exame.getDataExame());
            
            // executa
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Exame buscarExamePorConsulta(int idConsulta){
        Connection con;
        PreparedStatement SQL;
        Exame exame = new Exame();
        try {
            String url = "jdbc:mysql://localhost:3306/bd_sistema_ficha_saude";
            con = DriverManager.getConnection(url, "root", "");
            SQL = con.prepareStatement("Select * from exame where consulta_idPessoa = ?");
            SQL.setInt(1, idConsulta);
            ResultSet rs = SQL.executeQuery();
            
            if (rs.next()) {
                exame.setIdExame(rs.getInt("idExame"));
                exame.setConsultaIdConsulta(rs.getInt("consulta_idPessoa"));
                exame.setTipoExame(rs.getString("tipo_exame"));
                exame.setEspecialidade(rs.getString("especialidade"));
                exame.setObservacao(rs.getString("observacao"));
                exame.setDataExame(rs.getString("data_exame"));
            } else {
                System.out.println("Cliente não encontrado");
            }
            rs.close();
            SQL.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e);
        }
        return exame;
    }
}
