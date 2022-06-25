package com.santos.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.bookstore.domain.Categoria;
import com.santos.bookstore.domain.Livro;
import com.santos.bookstore.repositories.CategoriaRepository;
import com.santos.bookstore.repositories.LivroRepository;

@Service
public class DBServices {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instaciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de T.I");
		Categoria cat2 = new Categoria(null, "Ficcção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Rafael S Santos", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G Wells", "Loren ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the worlds", "H.G Wells", "Loren ipsum", cat2);
		Livro l5 = new Livro(null, "I Robbot", "Isaac Asimov", "Loren ipsum", cat2);
		Livro l6 = new Livro(null, "Uma história de Pelé", "Galvão Bueno", "Loren ipsum", cat3);
		

		cat2.getLivro().addAll(Arrays.asList(l3,l4,l5));
		cat3.getLivro().addAll(Arrays.asList(l6));
		

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
		
	}

}
