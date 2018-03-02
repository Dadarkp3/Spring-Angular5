package com.solutis.selecao.cloneapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Equipamento implements Serializable {

    @Id @GeneratedValue
    private long id;
    private String descricao;


    public Equipamento(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return id == that.id &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, descricao);
    }
}
