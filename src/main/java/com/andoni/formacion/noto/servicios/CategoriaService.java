package com.andoni.formacion.noto.servicios;

import java.util.List;

import com.andoni.formacion.noto.entidades.Categoria;

public interface CategoriaService {

	List<Categoria> getAllCategorias();
	Categoria getCategoriaById(Long id);
	Categoria saveCategoria(Categoria categoria);
	Categoria updateCategoria(Categoria categoria);
	void deleteCategoriaById(Long id);
}
