package com.br.times.service;

import com.br.times.model.Time;
import com.br.times.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    TimeRepository timeRepository;

    @Override
    public List<Time> findAll() {
        return timeRepository.findAll(Sort.by("id"));
    }

    @Override
    public Optional<Time> findById(Long id) {
        return timeRepository.findById(id);
    }

    @Override
    public Time update(Long id, Time time){
        Optional<Time> updatedTime = timeRepository.findById(id);
        if (!updatedTime.isEmpty()){
            updatedTime.get().setNome(time.getNome());
            updatedTime.get().setCidade(time.getCidade());
            updatedTime.get().setEstadio(time.getEstadio());
            return timeRepository.save(updatedTime.get());
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            timeRepository.deleteById(id);
            return timeRepository.findById(id).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Time findByNome(String nome) {
        return timeRepository.findByNome(nome);
    }

    @Override
    public Time findByEstadio(String estadio) {
        return timeRepository.findByEstadio(estadio);
    }

    @Override
    public Time findByCidade(String cidade) {
        return timeRepository.findByCidade(cidade);
    }

    @Override
    public Time create(Time newTime) {
        try {
            return timeRepository.save(newTime);
        }
        catch (Exception e){
            throw e;
        }
    }

}
