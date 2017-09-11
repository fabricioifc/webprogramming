/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.validators;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validador para impedir que a data de nascimento seja superior a data atual
 *
 * @author fabricio
 */
@FacesValidator("dataNascimentoValidator")
public class DataNascimentoValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        Date dataAtual = new Date();
        Date dataNascimento = (Date) value;
        if (dataAtual.before(dataNascimento)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "A data informada não pode ser superior a data atual", ""));
        }
    }

}
