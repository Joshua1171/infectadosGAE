package com.indra.backgae.services;

import com.indra.backgae.dao.IInfectadosDao;
import com.indra.backgae.entities.Hospitalizados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfectadosServiceImpl implements IInfectadosService{

    @Autowired
    private IInfectadosDao iInfectadosDao;
    @Override
    public List<Hospitalizados> findAll() {
        return (List<Hospitalizados>) iInfectadosDao.findAll();
    }

    @Override
    public Hospitalizados findById(Long id) {
        return iInfectadosDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        iInfectadosDao.deleteById(id);
    }

    @Override
    public Hospitalizados buscarPorId(Long id) {
        return iInfectadosDao.findById(id).orElse(null);
    }
}
