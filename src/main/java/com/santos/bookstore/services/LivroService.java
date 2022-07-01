package com.santos.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.bookstore.domain.Livro;
import com.santos.bookstore.exceptions.ObjectNotFoundException;
import com.santos.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro encontraLivroPorId(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não econtrado! Id " + id + ", Tipo " + Livro.class.getName()));
	
		
	}

	public List<Livro> encontraTodosOsLivros(Integer id_cat) {
		categoriaService.encontraCategoriaPorId(id_cat);
		return livroRepository.encontraLivrosPorcategoria(id_cat);
		
	}

	public Livro atuaizaLivro(Integer id, Livro obj) {
		Livro newObj = encontraLivroPorId(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTexto(obj.getTexto());
	}

	
	
	
	
	
	
}
