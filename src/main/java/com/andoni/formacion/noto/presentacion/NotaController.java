package com.andoni.formacion.noto.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andoni.formacion.noto.entidades.Nota;
import com.andoni.formacion.noto.servicios.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {

	private NotaService notaService;
	
	public NotaController(NotaService notaService) {
		this.notaService = notaService;
	}
	
	@GetMapping
	public List<Nota> getAllNotas(){
		return notaService.getAllNotas();
	}
	
	@GetMapping("/{id}")
	public Nota getNotaById(@PathVariable Long id){
		return notaService.getNotaById(id);
	}
	
	@PostMapping("/save")
	public Nota saveNota(@RequestBody Nota nota) {
		return notaService.saveNota(nota);
	}
	
	@PutMapping("/update")
	public Nota updateNota(@RequestBody Nota nota) {
		return notaService.saveNota(nota);
	}
	
	@DeleteMapping("{id}/delete")
	public void deleteNota(@PathVariable Long id) {
		notaService.deleteNotaById(id);
	}
}
