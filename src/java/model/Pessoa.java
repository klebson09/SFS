/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author klebson
 * 
 */
public class Pessoa implements Serializable {
    protected Integer idPessoa;
    protected String nome;
    protected String dataNasc;
    protected String sexo;
    protected String CPF;
    protected String RG;
    protected String naturalidade;
    protected String estadoCivil;
    protected String email;
    protected String telefone;
    protected String celular;
    protected String pwd;
    protected Integer idEndereco;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public Pessoa(String nome, String dataNasc, String sexo, 
            String cpf, String rg, String naturalidade, String estadoCivil,
            String email, String telefone, String celular, String pwd){
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.CPF = cpf;
        this.RG = rg;
        this.naturalidade = naturalidade;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.pwd = pwd;
    }
    
    public Pessoa(Integer idPessoa, String nome, String dataNasc, String sexo, 
            String cpf, String rg, String naturalidade, String estadoCivil, 
            String email, String telefone, String celular, String pwd, 
            Integer inEndereco){
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.CPF = cpf;
        this.RG = rg;
        this.naturalidade = naturalidade;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.pwd = pwd;
        this.idEndereco = inEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
    public void parser(Pessoa pessoa){
        this.CPF = pessoa.CPF;
        this.RG = pessoa.RG;
        this.celular = pessoa.celular;
        this.email = pessoa.email;
        this.dataNasc = pessoa.dataNasc;
        this.estadoCivil = pessoa.estadoCivil;
        this.idEndereco = pessoa.idEndereco;
        this.idPessoa =  pessoa.idPessoa;
        this.naturalidade = pessoa.naturalidade;
        this.nome = pessoa.nome;
        this.pwd = pessoa.pwd;
        this.sexo = pessoa.sexo;
        this.telefone = pessoa.telefone;
    }
}
