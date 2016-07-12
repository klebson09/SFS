package servlet;

import dao.*;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author klebson
 */
public class ControladorDAO {

    private final DAOPessoa daopessoa;
    private final DAOPaciente daopaciente;
    private final DAOEndereco daoendereco;
    private Integer idPessoa = null;
    private Integer idEndereco = null;
    private Paciente pacienteTmp = null;
    private Endereco enderecoTmp = null;

    public ControladorDAO() {
        this.daopessoa = new DAOPessoa();
        this.daopaciente = new DAOPaciente();
        this.daoendereco = new DAOEndereco();
    }

    protected void construtorDeObjetos(ArrayList<Object> objetos,
            String classe) {

        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getClass() == Paciente.class) {
                pacienteTmp = (Paciente) objetos.get(i);
//            } else if (objetos.get(i).getClass() == Medico.class) {
//                Medico medico = (Medico) objetos.get(i);
            } else if (objetos.get(i).getClass() == Endereco.class) {
                enderecoTmp = (Endereco) objetos.get(i);
            }
        }
        switch (classe) {
            case "Paciente":
                AdicionarPaciente(pacienteTmp, enderecoTmp);
                break;
            
            case "Medico":
        }
    }

    /**
     * Adicionador de paciente, recebe um paciente e o add com os att certos
     * primeiro os de pessoa depois os de paciente
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
        idPessoa = daopessoa.buscarPessoaPorCPF(paciente.getCpf()).
                getIdPessoa();

        paciente.setPessoaIdPessoa(idPessoa);
        daopaciente.adicionar(paciente);
    }
    
//    protected void AdicionarMedico(Medico medico, Endereco endereco) {
//        daoendereco.adicionar(endereco);
//        idEndereco = daoendereco.buscarEndereco(endereco.getLogradouro()).
//                getIdEndereco();
//
//        medico.setIdEndereco(idEndereco);
//        daopessoa.adicionar(medico);
//        idPessoa = daopessoa.buscarPessoaPorCPF(medico.getCpf()).
//                getIdPessoa();
//
//        medico.setPessoaIdPessoa(idPessoa);
//        daopaciente.adicionar(medico);
//    }
}
