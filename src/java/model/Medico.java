package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author klebson
 */
public class Medico extends Pessoa implements Serializable{
    private Integer idMedico;
    private String numCRM;
    private Integer PessoaIdPessoa;
    
    public Medico(Integer idMedico, String numCRM, Integer PessoaIdPessoa) {
        this.idMedico = idMedico;
        this.numCRM = numCRM;
        this.PessoaIdPessoa = PessoaIdPessoa;
    }
//COM ESSE CONSTRUTOR PODEMOS ACESSAR OS ATRIBUTOS DA CLASSE PAI?
//    public Medico(Integer idMedico, String numCRM, Integer PessoaIdPessoa, 
//            Integer idPessoa, String nome, String dataNasc, String cpf, 
//            String rg, String email, String pwd, Integer idEndereco) {
//        super(idPessoa, nome, dataNasc, cpf, rg, email, pwd, idEndereco);
//        this.idMedico = idMedico;
//        this.numCRM = numCRM;
//        this.PessoaIdPessoa = PessoaIdPessoa;
//    }

    public Medico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNumCRM() {
        return numCRM;
    }

    public void setNumCRM(String numCRM) {
        this.numCRM = numCRM;
    }

    public Integer getPessoaIdPessoa() {
        return PessoaIdPessoa;
    }

    public void setPessoaIdPessoa(Integer PessoaIdPessoa) {
        this.PessoaIdPessoa = PessoaIdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.numCRM, other.numCRM)) {
            return false;
        }
        if (!Objects.equals(this.idMedico, other.idMedico)) {
            return false;
        }
        if (!Objects.equals(this.PessoaIdPessoa, other.PessoaIdPessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMedico=" + idMedico + ", numCRM=" + numCRM + ", PessoaIdPessoa=" + PessoaIdPessoa + '}';
    }


    
    
}
