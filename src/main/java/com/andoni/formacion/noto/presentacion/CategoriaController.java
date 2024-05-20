package com.andoni.formacion.noto.presentacion;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Categoria>> getAllCategorias(){
		return new ResponseEntity<>(categoriaService.getAllCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id){
		return categoriaService.getCategoriaById(id)
				.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		System.out.println(categoria.toString());
		return new ResponseEntity<>(categoriaService.updateCategoria(categoria), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Boolean> deleteCategoria(@PathVariable Long id) {
		
		if(categoriaService.deleteCategoriaById(id)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
		
	}
}
