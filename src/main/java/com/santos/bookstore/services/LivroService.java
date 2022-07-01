package com.santos.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.bookstore.domain.Livro;
import com.santos.bookstore.exceptions.ObjectNotFoundException;
import com.santos.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	
	@Autowired
	LivroRepository livroRepository;
	
	public Livro encontra LivroPorId(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não econtrado! Id " + id + ", Tipo " + Livro.class.getName()));
	
		
	}
	
}
