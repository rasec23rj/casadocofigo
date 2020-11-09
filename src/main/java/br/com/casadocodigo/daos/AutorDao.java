package br.com.casadocodigo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Autor;

public class AutorDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Autor autor) {
		
		manager.persist(autor);
	}
	
	public List<Autor> lista(){
		
		return manager.createQuery(
				"select a from Autor a", Autor.class
				).getResultList();
	}
	
}
