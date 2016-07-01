package servlet;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Medico;
import model.Paciente;
import model.Pessoa;
import servlet.facade.FacadeMedico;
import servlet.facade.FacadePaciente;

/**
 *
 * @author klebson
 */
public class ControladorDAO {

    ArrayList<Object> objetos = new ArrayList();

    public ControladorDAO() {

    }

    protected void construtorDeObjetos(Pessoa pessoa, Paciente paciente, Medico medico, String classe) {
//        Endereco endereco;ArrayList<Object> objetos

//        for (int i = 0; i < objetos.size(); i++) {
//            if (objetos.get(i).getClass() == Pessoa.class) {
//
//                pessoa = (Pessoa) objetos.get(i);
//            } else if (objetos.get(i).getClass() == Paciente.class) {
//                paciente = (Paciente) objetos.get(i);
//            }else if(objetos.get(i).getClass()== Medico.class){
//                Medico medico = new Medico();
//                medico = (Medico) objetos.get(i);
//                
//            } else if (objetos.get(i).getClass() == Endereco.class) {
//                endereco = (Endereco) objetos.get(i);
//            }
//
//        }
        switch (classe) {
            case "Paciente":
                FacadePaciente facadePaciente = new FacadePaciente();
                facadePaciente.AdicionarPaciente(pessoa, paciente);
            case "Medico":
                FacadeMedico facadeMedico = new FacadeMedico();
                facadeMedico.AdicionarMedico(pessoa, medico);
        }

    }

    void construtorDeObjetos(Pessoa pessoa, Medico medico, String medico0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
