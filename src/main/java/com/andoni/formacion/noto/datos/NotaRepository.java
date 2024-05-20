package com.andoni.formacion.noto.datos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andoni.formacion.noto.entidades.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	Optional<List<Nota>>findByCategoriaId(Long id);
}
