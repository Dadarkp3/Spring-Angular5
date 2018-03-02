package com.solutis.selecao.cloneapi.service;

/*import com.solutis.selecao.cloneapi.model.Clone;*/
import com.solutis.selecao.cloneapi.model.Equipamento;
import com.solutis.selecao.cloneapi.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> getAllEquipamento() {
        List<Equipamento> list = new ArrayList<>();
        equipamentoRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Equipamento getEquipamentoById(Long id) {
        Equipamento obj = equipamentoRepository.findById(id).get();
        return obj;
    }

    public void addEquipamento(Equipamento equipamento) {
        equipamentoRepository.save(equipamento);
    }


}
