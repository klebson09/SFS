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
public class Consulta implements Serializable {

    private Integer idConsulta;
    private int pacienteIdPaciente;
    private String pacienteNumSUS;
    private int medicoIdMedico;
    private String medicoCRM;
    private String descricaoConsulta;
    private String tipoConsulta;
    private String observacao;
    private String dataConsulta;
    private byte[] arquivoConsulta;
    private Integer idEndereco;
    
    public Consulta() {
    }

    public Consulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Consulta(Integer idConsulta, int pacienteidPaciente, String pacientenumSUS, 
            int medicoIdMedico, String medicoCRM, String tipoConsulta, 
            String obs, int idEndereco) {
        this.idConsulta = idConsulta;
        this.pacienteIdPaciente = pacienteidPaciente;
        this.pacienteNumSUS = pacientenumSUS;
        this.medicoIdMedico = medicoIdMedico;
        this.medicoCRM = medicoCRM;
        this.tipoConsulta = tipoConsulta;
        this.idEndereco =  idEndereco;
        this.observacao = obs;
    }
    
    public Consulta(int pacienteidPaciente, String pacientenumSUS, 
            int medicoIdMedico, String medicoCRM, String descricaoConsulta,
            String dataConsulta,String tipoConsulta, String obs, int idEndereco) {
        this.pacienteIdPaciente = pacienteidPaciente;
        this.pacienteNumSUS = pacientenumSUS;
        this.medicoIdMedico = medicoIdMedico;
        this.medicoCRM = medicoCRM;
        this.descricaoConsulta = descricaoConsulta;
        this.dataConsulta = dataConsulta;
        this.tipoConsulta = tipoConsulta;
        this.observacao = obs;
        this.idEndereco = idEndereco;
    }
    
    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getPacienteIdPaciente() {
        return pacienteIdPaciente;
    }

    public void setPacienteIdPaciente(int pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }

    public String getPacienteNumSUS() {
        return pacienteNumSUS;
    }

    public void setPacienteNumSUS(String pacienteNumSUS) {
        this.pacienteNumSUS = pacienteNumSUS;
    }

    public int getMedicoIdMedico() {
        return medicoIdMedico;
    }

    public void setMedicoIdMedico(int mEdicoidMEdico) {
        this.medicoIdMedico = mEdicoidMEdico;
    }

    public String getMedicoCRM() {
        return medicoCRM;
    }

    public void setMedicoCRM(String mEdicoCRM) {
        this.medicoCRM = mEdicoCRM;
    }

    public String getDescricaoConsulta() {
        return descricaoConsulta;
    }

    public void setDescricaoConsulta(String descricaoConsulta) {
        this.descricaoConsulta = descricaoConsulta;
    }
    
    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public byte[] getArquivoConsulta() {
        return arquivoConsulta;
    }

    public void setArquivoConsulta(byte[] arquivoConsulta) {
        this.arquivoConsulta = arquivoConsulta;
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
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consulta[ idConsulta=" + idConsulta + " ]";
    }
    
}
