package com.treino.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino.demo.entities.Category;
import com.treino.demo.repositories.CategoryRepository;

/*Define que a classe CategoryResource vai ser
 * um recurso rest*/
@RestController
/*Defini o caminho pelo qual esse recurso vai
 * responder */
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/*quando for feita uma requisição na rota /categories
	 * o método abaixo vai ser chamado*/
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		// ok retorna um 200
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	} 
}
