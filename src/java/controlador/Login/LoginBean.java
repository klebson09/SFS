package controlador.Login;

import dao.DAOPessoa;
import java.sql.SQLException;
import model.Pessoa;

public class LoginBean {
    private DAOPessoa daoPessoa = null;
    private Pessoa pessoaTmp = null;
    private String email, password;

    public LoginBean() {
        this.daoPessoa = new DAOPessoa();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(String email, String senha) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        
        pessoaTmp = daoPessoa.buscarPessoa(email, senha);
        if (pessoaTmp.getEmail().equals(email) || pessoaTmp.getPwd().equals(senha)) {
            retorno = true;
        }
        
        return retorno;
    }
}
