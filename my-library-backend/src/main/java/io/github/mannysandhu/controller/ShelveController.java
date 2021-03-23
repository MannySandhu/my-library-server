package io.github.mannysandhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mannysandhu.exception.ResourceNotFoundException;
import io.github.mannysandhu.model.Shelve;
import io.github.mannysandhu.repository.ShelveRepository;

@RestController
@RequestMapping("/api/v1/")
public class ShelveController {
	
	@Autowired
	private ShelveRepository shelveRepository;
	
	// get all shelves
	@GetMapping("/shelves")
	public List<Shelve> getAllShelves(){
		return shelveRepository.findAll();
	}
	
	// create a shelve
	@PostMapping("/shelves")
	public Shelve createShelve(@RequestBody Shelve shelve) {
		return shelveRepository.save(shelve);
	}
	
	// get a shelve by id
	@GetMapping("/shelves/{id}")
	public ResponseEntity<Shelve> getShelveById(@PathVariable long id) {
		Shelve shelve = shelveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shelve not found with id: " + id));
		return ResponseEntity.ok(shelve);
	}
	

}
