package com.andoni.formacion.noto.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andoni.formacion.noto.datos.CategoriaRepository;
import com.andoni.formacion.noto.entidades.Categoria;

@Service
public class CategoriaServiceImp implements CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImp(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria getCategoriaById(Long id) {
		return categoriaRepository.findById(id).get();
	}

	@Override
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void deleteCategoriaById(Long id) {
		categoriaRepository.deleteById(id);
	}

}
