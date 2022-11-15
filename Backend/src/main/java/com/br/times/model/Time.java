package com.br.times.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String nome;

    @Size(max = 100)
    private String estadio;

    @Size(max = 100)
    private String cidade;

    /* GETTERS AND SETTERS */
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
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Times{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estadio='" + estadio + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
