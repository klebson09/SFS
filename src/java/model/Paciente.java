/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class Paciente extends Pessoa implements Serializable {

    private Integer idPaciente;
    private String numSUS;
    private Integer PessoaIdPessoa;

    public Paciente() {
    }

    public Paciente(Integer idPaciente, String numSUS, Integer PessoaIdPessoa) {
        this.idPaciente = idPaciente;
        this.numSUS = numSUS;
        this.PessoaIdPessoa = PessoaIdPessoa;
    }
    
    public Paciente(String numSUS, String nome, String dataNasc, String sexo, 
            String cpf, String rg, String naturalidade, String email, 
            String telefone, String celular, String pwd) {
        super(nome, dataNasc, sexo, cpf, rg, naturalidade, email, 
                telefone, celular, pwd);
        this.numSUS = numSUS;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNumSUS() {
        return numSUS;
    }

    public void setNumSUS(String numSUS) {
        this.numSUS = numSUS;
    }

    public Integer getPessoaIdPessoa() {
        return PessoaIdPessoa;
    }

    public void setPessoaIdPessoa(Integer PessoaIdPessoa) {
        this.PessoaIdPessoa = PessoaIdPessoa;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dao.PessoaDAO[ idPessoa=" + idPaciente + " ]";
    }

}
