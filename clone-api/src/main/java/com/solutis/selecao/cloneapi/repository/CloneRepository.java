package com.solutis.selecao.cloneapi.repository;

import com.solutis.selecao.cloneapi.model.Clone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CloneRepository extends CrudRepository<Clone, Long> {

    Clone findByNome(String nome);

    @Query(value = "SELECT c from Clone c left join c.equipamentos where c.id = :id")
    Optional<Clone> findById(@Param("id") Long id);
}
