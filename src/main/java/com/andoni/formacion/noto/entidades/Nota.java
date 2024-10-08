package com.andoni.formacion.noto.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
@Table(name = "notas")
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El título es obligatorio")
	@Size(min = 2, max = 150)
	@Column(name = "titulo")
	private String titulo;
	
	@NotNull(message = "El texto de la nota es obligatorio")
	@Size(min = 2, max = 10000)
	@Column(name = "texto")
	private String texto;
	
	@NotNull(message = "La fecha de creacion de la nota es obligatorio")
	@PastOrPresent
	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;
	
	@NotNull(message = "La fecha de última modificación de la nota es obligatorio")
	@PastOrPresent
	@Column(name = "fecha_modificacion")
	private LocalDateTime fechaModificacion;
	
	@NotNull()
	@Column(name = "is_eliminada")
	@Builder.Default
	private Boolean isEliminada = false;
	
	@PastOrPresent
	@Column(name = "fecha_eliminacion")
	private LocalDateTime fechaEliminacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

}
