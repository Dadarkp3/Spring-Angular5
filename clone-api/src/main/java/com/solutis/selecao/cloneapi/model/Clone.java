package com.solutis.selecao.cloneapi.model;

import javax.annotation.RegEx;
import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Clone implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "O parametro nome não pode ser nulo.")
    @Pattern(regexp="[A-Z]{3}[0-9]{4}", message="Nome inválido!")
    private String nome;

    @NotNull(message = "O parametro idade não pode ser nulo.")
    @Max(value = 20, message = "Não pode criar clone com idade maior que 20")
    @Min(value = 10, message = "Não pode criar clone com idade menor que 10")
    private Integer idade;

    @Column(updatable = false)
    private Date dataCriacao;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Equipamento> equipamentos = new ArrayList<>();

    public Clone() {
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clone clone = (Clone) o;
        return Objects.equals(id, clone.id) &&
                Objects.equals(nome, clone.nome) &&
                Objects.equals(idade, clone.idade) &&
                Objects.equals(dataCriacao, clone.dataCriacao) &&
                Objects.equals(equipamentos, clone.equipamentos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, idade, dataCriacao, equipamentos);
    }

    @Override
    public String toString() {
        return "Clone{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataCriacao=" + dataCriacao +
                ", equipamentos=" + equipamentos +
                '}';
    }

    @PrePersist
    public void prePersist(){
        setDataCriacao(new Date());
    }
}
