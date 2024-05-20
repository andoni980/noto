package com.andoni.formacion.noto.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andoni.formacion.noto.entidades.Categoria;
import com.andoni.formacion.noto.servicios.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping
	public List<Categoria> getAllCategorias(){
		return categoriaService.getAllCategorias();
	}
	
	@GetMapping("{id}")
	public Categoria getCategoriaById(@PathVariable Long id){
		return categoriaService.getCategoriaById(id);
	}
	
	@PostMapping("/save")
	public Categoria saveCategoria(@RequestBody Categoria categoria) {
		return categoriaService.saveCategoria(categoria);
	}
	
	@PutMapping("/update")
	public Categoria updateCategoria(@RequestBody Categoria categoria) {
		return categoriaService.saveCategoria(categoria);
	}
	
	@DeleteMapping("/delete{id}")
	public void deleteCategoria(@PathVariable Long id) {
		categoriaService.deleteCategoriaById(id);
	}
}
