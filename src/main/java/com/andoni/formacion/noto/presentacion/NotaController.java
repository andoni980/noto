package com.andoni.formacion.noto.presentacion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andoni.formacion.noto.entidades.Nota;
import com.andoni.formacion.noto.servicios.NotaService;

@CrossOrigin
@RestController
@RequestMapping("/notas")
public class NotaController {

	private NotaService notaService;
	
	public NotaController(NotaService notaService) {
		this.notaService = notaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Nota>> getAllNotas(@RequestParam Boolean eliminadas){
		return new ResponseEntity<>(notaService.getAllNotas(eliminadas), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nota> getNotaById(@PathVariable Long id){
		return notaService.getNotaById(id)
				.map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<List<Nota>> getNotasByCategoriaId(@PathVariable Long id){
		return notaService.getNotasByCategoriaId(id)
				.map(notas -> new ResponseEntity<>(notas, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Nota> saveNota(@RequestBody Nota nota) {
		System.out.println(nota.toString());
		if(nota.getFechaCreacion() == null) {
			nota.setFechaCreacion(LocalDateTime.now());
		}
		return new ResponseEntity<>(notaService.saveNota(nota), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Nota> updateNota(@RequestBody Nota nota) {
		return new ResponseEntity<>(notaService.updateNota(nota), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Boolean> deleteNota(@PathVariable Long id) {
		
		if(notaService.deleteNotaById(id)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}
}
