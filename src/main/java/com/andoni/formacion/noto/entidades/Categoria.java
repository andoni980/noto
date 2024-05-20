package com.andoni.formacion.noto.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El nombre es obligatorio")
	@Size(min = 2, max = 150)
	@Column(name = "nombre")
	private String nombre;
	
	@Size(min = 2, max = 500)
	@Column(name = "descripcion")
	private String descripcion;
	

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private Set<Nota> notas;

}
