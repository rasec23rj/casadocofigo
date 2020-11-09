package br.com.casadocodigo.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.AutorDao;
import br.com.casadocodigo.models.Autor;

@Named
@RequestScoped
public class AdminAutorBean {
	
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorDao dao;
	
	@Transactional
	public void salvar() {
		dao.salvar(autor);
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
