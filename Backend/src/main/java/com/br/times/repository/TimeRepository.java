package com.br.times.repository;

import com.br.times.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    public List<Time> findAll();
    public Time findByNome(String nome);
    public Time findByEstadio(String estadio);
    public Time findByCidade(String cidade);

}
