package com.ceasa.dev.web;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ceasa.dev.dominio.Grupo;
import com.ceasa.dev.service.GrupoService;


@Controller
@RequestMapping(value = "/ceasadev")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;

	@GetMapping(value = "/grupos/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		Grupo obj = grupoService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping("/grupos")
	public ResponseEntity<List<Grupo>> findAll() {

		List<Grupo> listGrupos = grupoService.findAll();
		// List<GrupoDAO> listDTO = listGrupos.stream().map(obj -> new
		// GrupoDAO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listGrupos);

	}

	@PostMapping("/grupos")
	public ResponseEntity<Void> insert(@RequestBody Grupo obj) {

		obj = grupoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@PutMapping("/grupos/{id}")
	public ResponseEntity<Void> update(@RequestBody Grupo obj, @PathVariable Integer id) {

		obj.setId(id);
		obj = grupoService.update(obj);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/grupos/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		grupoService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/grupos/nome/{nome}")
	ResponseEntity<?> findByName(@PathVariable String nome) {

		Grupo obj = grupoService.findByNome(nome);
		return ResponseEntity.ok().body(obj);

	}

}
