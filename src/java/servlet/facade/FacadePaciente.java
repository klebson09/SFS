/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.facade;

import dao.DAOPessoa;
import dao.DAOPaciente;
import dao.DAOEndereco;
import model.Paciente;
import model.Pessoa;

/**
 *
 * @author klebson
 */
public class FacadePaciente {
    private DAOPessoa daopessoa;
    private DAOPaciente daopaciente;
    private DAOEndereco daoendereco;
    Integer idPessoa = null;
    private Paciente pacienteTmp = null;
    
    public FacadePaciente() {
        this.daopessoa =  new DAOPessoa();
        this.daopaciente =  new DAOPaciente();
        this.daoendereco = new DAOEndereco();
    }
    
    
    
    
    public Paciente RecuperarPaciente(){
        return pacienteTmp;
    }
}
