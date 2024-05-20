package com.andoni.formacion.noto.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andoni.formacion.noto.entidades.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
