package com.solutis.selecao.cloneapi.controller;

import com.solutis.selecao.cloneapi.exception.CloneExceptions;
import com.solutis.selecao.cloneapi.model.Clone;
import com.solutis.selecao.cloneapi.service.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/*@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)*/
@RestController
@RequestMapping("v1/clones")
public class CloneController {

    @Autowired
    private CloneService cloneService;

    @GetMapping("{id}")
    public ResponseEntity<Clone> getCloneById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cloneService.getCloneById(id).orElseThrow(CloneExceptions::new));
    }
    @GetMapping
    public ResponseEntity<Iterable<Clone>> getAllClones() {
        return ResponseEntity.ok(cloneService.getAllClones());
    }

    @PostMapping
    public ResponseEntity<Clone> addClone(@Valid @RequestBody Clone clone) {
        return new ResponseEntity<>(cloneService.addClone(clone), HttpStatus.CREATED);
    }

    @DeleteMapping("id}")
    public ResponseEntity<Void> deleteClone(@PathVariable("id") Long id) {
        cloneService.deleteClone(id);
        return ResponseEntity.ok().build();
    }
}
