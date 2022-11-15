package com.br.times.service;

import com.br.times.model.Time;

import java.util.List;
import java.util.Optional;

public interface TimeService {

    public List<Time> findAll();
    public Optional<Time> findById(Long id);
    public Time findByNome(String nome);
    public Time findByEstadio(String estadio);
    public Time findByCidade(String cidade);
    public Time create(Time newTime);

    public Time update(Long id, Time time);
    public boolean delete(Long id);
}
