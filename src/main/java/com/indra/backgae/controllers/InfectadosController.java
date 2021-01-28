package com.indra.backgae.controllers;

import com.indra.backgae.entities.Hospitalizados;
import com.indra.backgae.services.IInfectadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InfectadosController {
    @Autowired
    private IInfectadosService iInfectadosService;

    @GetMapping("/infectados")
    public List<Hospitalizados> verTodos(){
        return iInfectadosService.findAll();
    }

    @GetMapping("/infectados/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
    Hospitalizados hospitalizados;
    Map<String,Object> response=new HashMap<>();
        try{
        hospitalizados=iInfectadosService.buscarPorId(id);
    }catch (DataAccessException e){
        response.put("mensaje","Error al hacer la consulta en la base de datos");
        response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
        if (hospitalizados==null){
        response.put("mensaje","error:");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
    }
        return new ResponseEntity<Hospitalizados>(hospitalizados,HttpStatus.OK);
}

    @DeleteMapping("/infectados/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            iInfectadosService.deleteById(id);
        }catch (DataAccessException e){
            response.put("mensaje","Error al hacer la consulta en la base de datos");
            response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        response.put("mensaje","Country successfully removed!");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
    }
}
