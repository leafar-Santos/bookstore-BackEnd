package com.santos.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.bookstore.domain.Categoria;
import com.santos.bookstore.exceptions.ObjectNotFoundException;
import com.santos.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria encontraCategoriaPorId(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não econtrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
