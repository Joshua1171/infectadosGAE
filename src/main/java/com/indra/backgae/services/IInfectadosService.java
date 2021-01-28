package com.indra.backgae.services;

import com.indra.backgae.entities.Hospitalizados;

import java.util.List;

public interface IInfectadosService {

    public List<Hospitalizados> findAll();
    public Hospitalizados findById(Long id);
    public void deleteById(Long id);
    public Hospitalizados buscarPorId(Long id);
}
