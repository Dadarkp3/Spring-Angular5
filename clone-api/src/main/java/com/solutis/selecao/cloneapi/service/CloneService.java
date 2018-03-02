package com.solutis.selecao.cloneapi.service;

import com.solutis.selecao.cloneapi.exception.CloneExceptions;
import com.solutis.selecao.cloneapi.model.Clone;
import com.solutis.selecao.cloneapi.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CloneService {

    @Autowired
    private CloneRepository cloneRepository;


    public Iterable<Clone> getAllClones() {
        return cloneRepository.findAll();
    }

    public Optional<Clone> getCloneById(Long id) {
        if(id == null){
            throw new CloneExceptions("Oops, não podemos pesquisar sem id.");
        }
        return cloneRepository.findById(id);
    }

    public Clone addClone(Clone clone) {
        Clone cloneDb = findByNome(clone.getNome());

        if(clone.getId() == null && cloneDb != null){
            throw new CloneExceptions("Oops, não podemos criar um clone com nome repetido.");
        }
        if(cloneDb != null && !cloneDb.getId().equals(clone.getId()) && clone.getNome().equals(cloneDb.getNome())){
            throw new CloneExceptions("Oops, não podemos criar um clone com nome repetido.");
        }
        cloneRepository.save(clone);
        return cloneRepository.findById(clone.getId()).get();
    }

    public Clone findByNome(String nome) {
        return cloneRepository.findByNome(nome);
    }


    public void deleteClone(Long id) {
        if(id == null){
            throw new CloneExceptions("Id nula, não podemos deletar assim.");
        }
        cloneRepository.deleteById(id);
    }
}
