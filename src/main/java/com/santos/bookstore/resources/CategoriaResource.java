package com.santos.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santos.bookstore.domain.Categoria;
import com.santos.bookstore.dtos.CategoriaDTO;
import com.santos.bookstore.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		
		Categoria obj = categoriaService.encontraCategoriaPorId(id); 
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findall(){
		List<Categoria> list = categoriaService.encontraTodasCategorias();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
		obj = categoriaService.criaCategoria(obj);
		URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO>update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto){
		Categoria newObj = categoriaService.atualizaCategoria(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
 	
	
}
