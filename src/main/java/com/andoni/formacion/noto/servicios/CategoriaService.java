package com.andoni.formacion.noto.servicios;

import java.util.List;
import java.util.Optional;

import com.andoni.formacion.noto.entidades.Categoria;

public interface CategoriaService {

	List<Categoria> getAllCategorias();
	Optional<Categoria> getCategoriaById(Long id);
	Categoria saveCategoria(Categoria categoria);
	Categoria updateCategoria(Categoria categoria);
	Boolean deleteCategoriaById(Long id);
}
