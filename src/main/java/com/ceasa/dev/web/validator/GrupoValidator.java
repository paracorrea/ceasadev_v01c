package com.ceasa.dev.web.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ceasa.dev.dominio.Grupo;
import com.ceasa.dev.service.GrupoService;


public class GrupoValidator implements Validator {

	
	GrupoService grupoService;
	
	
	@Autowired
	public GrupoValidator(GrupoService grupoService) {
		this.grupoService=grupoService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Grupo.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Grupo d = (Grupo) object;
		
		String nome = d.getNome();
		List<Grupo> grupos = grupoService.findByNome(nome);
		
		if (nome !=null) {
			if (grupos.size() > 0) {
				errors.rejectValue("nome", "GrupoJaExiste.grupo.nome");
			}
		}
		
	}

}
