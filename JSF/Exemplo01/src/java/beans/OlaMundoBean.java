package beans;

import java.io.Serializable;

@javax.faces.bean.ManagedBean
@javax.faces.bean.RequestScoped
public class OlaMundoBean implements Serializable {

    private String nome;

    public String bemVindoNovaPagina() {
        return "welcome";
    }

    public void bemVindo() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
