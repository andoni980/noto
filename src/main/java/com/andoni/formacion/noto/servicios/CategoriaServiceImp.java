package com.andoni.formacion.noto.servicios;

import java.util.List;
import java.util.Optional;

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
	public Optional<Categoria> getCategoriaById(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public Categoria saveCategoria(Categoria categoria) {
		
		if(categoria.getId() != null) {
			return null;
		}
		
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		
		if(categoria.getId() == null) {
			return null;
		}
		
		return categoriaRepository.save(categoria);
	}

	@Override
	public Boolean deleteCategoriaById(Long id) {
		
		return getCategoriaById(id)
				.map(categoria -> {
					categoriaRepository.deleteById(id);
					return true;
				}).orElse(false);
	}

}
