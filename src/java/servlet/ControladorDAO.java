package servlet;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;
import model.Endereco;
import model.Exame;
import model.Medico;
import model.Paciente;

/**
 * @author klebson
 */
public class ControladorDAO {

    private final DAOPessoa daopessoa;
    private final DAOPaciente daopaciente;
    private final DAOMedico daomedico;
    private final DAOEndereco daoendereco;
    private final DAOConsulta daoconsulta;
    private Integer idPessoa = null;
    private Integer idEndereco = null;
    private Paciente pacienteTmp = null;
    private Endereco enderecoTmp = null;
    private Medico medicoTmp = null;
    private Consulta consultaTmp = null;
    private List<Exame> exameTmp = null;

    public ControladorDAO() {
        this.daopessoa = new DAOPessoa();
        this.daopaciente = new DAOPaciente();
        this.daoendereco = new DAOEndereco();
        this.daomedico = new DAOMedico();
        this.daoconsulta = new DAOConsulta();
    }
    
    /**
     * Fachada para adicionar objetos
     * @param objetos lista de Objetos simples com os objetos para serem 
     * adicionados
     * @param classe String contendo o tipo de classe que sera adicionada
     * (Paciente, Medico, Consulta e Exame)
     */
    protected void addObjeto(ArrayList<Object> objetos,
            String classe) {

        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getClass() == Paciente.class) {
                pacienteTmp = (Paciente) objetos.get(i);
            } else if (objetos.get(i).getClass() == Medico.class) {
                medicoTmp = (Medico) objetos.get(i);
            } else if (objetos.get(i).getClass() == Endereco.class) {
                enderecoTmp = (Endereco) objetos.get(i);
            } else if (objetos.get(i).getClass() == Consulta.class) {
                consultaTmp = (Consulta) objetos.get(i);
            } else if (objetos.get(i).getClass() == Exame.class) {
                exameTmp.add((Exame)objetos.get(i));
            }
        }
        switch (classe) {
            case "Paciente":
                AdicionarPaciente(pacienteTmp, enderecoTmp);
                break;

            case "Medico":
                AdicionarMedico(medicoTmp, enderecoTmp);
                break;
            case "Consulta":
                AdicionarConsulta(consultaTmp, enderecoTmp, pacienteTmp, medicoTmp);
                break;
            case "Exame":
                break;
        }
    }

    /**
     * Adicionador de paciente, recebe um paciente e um endereco e o add com os
     * att certos primeiro os de pessoa depois os de paciente
     *
     * @param paciente
     * @param endereco
     */
    protected void AdicionarPaciente(Paciente paciente, Endereco endereco) {
        daoendereco.adicionar(endereco);
        idEndereco = daoendereco.buscarEndereco(endereco.getLogradouro()).
                getIdEndereco();

        paciente.setIdEndereco(idEndereco);
        daopessoa.adicionar(paciente);
        idPessoa = daopessoa.buscarPessoaPorCPF(paciente.getCPF()).
                getIdPessoa();

        paciente.setPessoaIdPessoa(idPessoa);
        daopaciente.adicionar(paciente);
    }

    /**
     * Adicionador de medico, recebe um medico e um endereco e o add com os att
     * certos primeiro os de pessoa depois os de medico
     *
     * @param medico
     * @param endereco
     */
    protected void AdicionarMedico(Medico medico, Endereco endereco) {
        daoendereco.adicionar(endereco);
        idEndereco = daoendereco.buscarEndereco(endereco.getLogradouro()).
                getIdEndereco();

        medico.setIdEndereco(idEndereco);
        daopessoa.adicionar(medico);
        idPessoa = daopessoa.buscarPessoaPorCPF(medico.getCPF()).
                getIdPessoa();

        medico.setPessoaIdPessoa(idPessoa);
        daomedico.adicionar(medico);
    }

    protected void AdicionarConsulta(Consulta consulta, Endereco endereco, 
            Paciente paciente, Medico medico) {
        Paciente pacienteCompleto;
        Medico medicoCompleto;
        
        daoendereco.adicionar(endereco);
        idEndereco = daoendereco.buscarEndereco(endereco.getLogradouro()).
                getIdEndereco();
        
        pacienteCompleto = daopaciente.buscarPaciente(paciente.getEmail(), paciente.getPwd());
        medicoCompleto = daomedico.buscarMedico(medico.getNome());
        
        consulta.setPacienteIdPaciente(pacienteCompleto.getIdPaciente());
        consulta.setPacienteNumSUS(pacienteCompleto.getNumSUS());
        consulta.setMedicoIdMedico(medicoCompleto.getIdMedico());
        consulta.setMedicoCRM(medicoCompleto.getNumCRM());
        consulta.setIdEndereco(idEndereco);
        
        daoconsulta.adicionar(consulta);
    }
    protected void AdicionarExame(Exame exame) {

    }
    
    protected Medico buscarMedico(String nomeMedico){
        Medico medicoBusca;
         medicoBusca = daomedico.buscarMedico(nomeMedico);
        return medicoBusca;
    }
    
    protected Medico buscarMedico(String email, String pwd){
        Medico medicoBusca;
         medicoBusca = daomedico.buscarMedicoPorUsuario(email, pwd);
        return medicoBusca;
    }
    
    protected Paciente buscarPaciente(String email, String pwd){
        Paciente pacienteBusca;
         pacienteBusca = daopaciente.buscarPaciente(email, pwd);
        return pacienteBusca;
    }
}
