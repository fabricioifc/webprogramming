package br.com.ifc.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtils {

    public static void adicionarMensagem(String mensagem, FacesMessage.Severity tipo) {
        //Adiciona a mensagem ao contexto (h:messages globalOnly)
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, mensagem, null));
        //Mantem a mensagem caso seja feiro redirecionamento com o parâmetro faces-redirect=true
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static void adicionarMensagemDeErro(String message) {
        adicionarMensagem(message, FacesMessage.SEVERITY_ERROR);
    }

    public static void adicionarMensagemDeSucesso(String message) {
        adicionarMensagem(message, FacesMessage.SEVERITY_INFO);
    }
}
