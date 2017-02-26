package fr.adaming.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("validatorQuantite")
public class QuantiteValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent comp, Object val) throws ValidatorException {
		int saisie =(Integer) val;
		
		if(!(saisie>0)){
			try {
				throw new Exception("Veuillez entrer un nombre positif!");
			} catch (Exception e) {
				//l'objet de type faces message sert de bus pour transporter les massages d'erreur vers la page
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

}
