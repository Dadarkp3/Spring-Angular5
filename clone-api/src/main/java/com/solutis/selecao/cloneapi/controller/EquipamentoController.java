package com.solutis.selecao.cloneapi.controller;

/*import com.solutis.selecao.cloneapi.model.Clone;*/
import com.solutis.selecao.cloneapi.model.Equipamento;
import com.solutis.selecao.cloneapi.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)*/
@RestController
@RequestMapping("v1/equipamentos")
public class EquipamentoController {
    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("equipamento/{id}")
    public ResponseEntity<Equipamento> getCloneById(@PathVariable("id") Long id) {
        Equipamento equipamento = equipamentoService.getEquipamentoById(id);
        return new ResponseEntity<>(equipamento, HttpStatus.OK);
    }
    @GetMapping("todos")
    public ResponseEntity<List<Equipamento>> getAllClones() {
        List<Equipamento> list = equipamentoService.getAllEquipamento();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
