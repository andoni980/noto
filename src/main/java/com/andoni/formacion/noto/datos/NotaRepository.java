package com.andoni.formacion.noto.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andoni.formacion.noto.entidades.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
