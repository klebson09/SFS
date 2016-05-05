package model;

import java.io.Serializable;
import java.util.Collection;

public class Endereco implements Serializable {

    private Integer idEndereco;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private Collection<Pessoa> pessoaDAOCollection;

    public Endereco() {
    }

    public Endereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Endereco(Integer idEndereco, String logradouro, int numero, String complemento, String cidade, String estado, String cep, String idPessoa) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idPessoa = idPessoa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String idPessoa;

    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Collection<Pessoa> getPessoaDAOCollection() {
        return pessoaDAOCollection;
    }

    public void setPessoaDAOCollection(Collection<Pessoa> pessoaDAOCollection) {
        this.pessoaDAOCollection = pessoaDAOCollection;
    }

    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.dao.EnderecoDAO[ idEndereco=" + idEndereco + " ]";
    }

    public void setIdPessoa(int idPessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
