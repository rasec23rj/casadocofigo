package br.com.casadocodigo.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.AutorDao;
import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	
	private Livro livro = new Livro();
	
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private AutorDao autoDao;
	private List<Integer> autoresId = new ArrayList<>();
	
	@Transactional
	public void salvar() {
		for (Integer autorid : autoresId) {
			livro.getAutores().add(new Autor(autorid));
		}
		dao.salvar(livro);
		this.livro = new Livro();
		this.autoresId = new ArrayList<>();
	}

	public List<Autor> getAutores(){
		return autoDao.lista();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}
	
}
