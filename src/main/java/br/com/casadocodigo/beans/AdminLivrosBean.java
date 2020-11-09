package br.com.casadocodigo.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao dao;
	
	@Transactional
	public void salvar() {
		
		dao.salvar(livro);
		System.out.println("Livro salvo com Sucesso: " + livro);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
