package com.treino.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.treino.demo.entities.Category;

@Component
public class CategoryRepository {
	
	private Map<Long, Category> map = new HashMap<>();
	
	public void save(Category obj) {
		//inserindo uma categoria na coleção "Map"
		map.put(obj.getId(), obj);
	}
	
	public Category findById(Long id) {
		return map.get(id);
	}
	
	public List<Category> findAll() {
		// acessando os valores da lista e instanciando a lista
		return new ArrayList<Category>(map.values());
	}
}
