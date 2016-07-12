package servlet.facade;

import dao.DAOPessoa;
import dao.DAOMedico;
import dao.DAOEndereco;
import model.Medico;
import model.Pessoa;

/**
 *
 * @author klebson
 */
public class FacadeMedico {

    private DAOPessoa daopessoa;
    private DAOMedico daomedico;
    private DAOEndereco daoendereco;
    Integer idPessoa = null;

    public FacadeMedico() {
        this.daopessoa = daopessoa;
        this.daomedico = daomedico;
        this.daoendereco = daoendereco;
    }
    
    public void AdicionarMedico(Pessoa pessoa, Medico medico){
        daopessoa.adicionar(pessoa);
        idPessoa = daopessoa.buscarPessoaPorCPF(pessoa.getCpf()).getIdPessoa();
        medico.setPessoaIdPessoa(idPessoa);
        daomedico.adicionar(medico);
        
        
    }
}
