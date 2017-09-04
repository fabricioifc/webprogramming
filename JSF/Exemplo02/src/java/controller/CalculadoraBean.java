package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalculadoraBean {

    private Integer n1;
    private Integer n2;
    private Integer resultado;

    public String somar() {
        resultado = n1 + n2;
        return "resultadoSoma.xhtml";
    }
    
    public String subtrair() {
        resultado = n1 - n2;
        return "resultadoSubtracao.xhtml";
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

}
