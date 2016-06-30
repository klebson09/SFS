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
    
    /**
     * Adicionador de paciente, recebe uma pessoa e um paciente e os add na 
     * ordem certa colocando primeiramente o o obj pessoa no banco e resgatando
     * 
     * @param pessoa
     * @param paciente 
     */
    public void AdicionarPaciente(Pessoa pessoa, Paciente paciente){
        daopessoa.adicionar(pessoa);
        idPessoa = daopessoa.buscarPessoaPorCPF(pessoa.getCpf()).getIdPessoa();
        paciente.setPessoaIdPessoa(idPessoa);
        daopaciente.adicionar(paciente);
    }
    
    public Paciente RecuperarPaciente(){
        return pacienteTmp;
    }
}
