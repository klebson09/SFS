/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
/**
 *
 * @author Pedro Jatoba
 */
public class Exame implements Serializable {
    
    private Integer idExame;
    private int consultaIdConsulta;
    private String tipoExame;
    private String especialidade;
    private String observacao;
    private String dataExame;

    public Exame() {
    }

    public Exame(Integer idExame) {
        this.idExame = idExame;
    }
    
    public Exame(int consultaidConsulta, String tipoExame, String especialidade,
            String dataExame) {
        this.consultaIdConsulta = consultaidConsulta;
        this.tipoExame = tipoExame;
        this.especialidade = especialidade;
        this.dataExame = dataExame;
    }
    
    public Exame(Integer idExame, int consultaidConsulta, String tipoExame, 
            String especialidade, String dataExame) {
        this.idExame = idExame;
        this.consultaIdConsulta = consultaidConsulta;
        this.tipoExame = tipoExame;
        this.especialidade = especialidade;
        this.dataExame = dataExame;
    }

    public Integer getIdExame() {
        return idExame;
    }

    public void setIdExame(Integer idExame) {
        this.idExame = idExame;
    }

    public int getConsultaIdConsulta() {
        return consultaIdConsulta;
    }

    public void setConsultaIdConsulta(int consultaIdConsulta) {
        this.consultaIdConsulta = consultaIdConsulta;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExame != null ? idExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.idExame == null && other.idExame != null) || (this.idExame != null && !this.idExame.equals(other.idExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Exame[ idExame=" + idExame + " ]";
    }
    
}
