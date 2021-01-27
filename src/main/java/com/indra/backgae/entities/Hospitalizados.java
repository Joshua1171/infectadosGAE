package com.indra.backgae.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "infectados")
@Data
public class Hospitalizados implements Serializable {
    private static final long serialVersionUID = -1548311496094961284L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    //private int año;
    //private int año;
    //private int mes;
    private int hospitalizados_totales;
    private int hospitalizados_totales_cdmx;
    private int camas_intubados_totales;
    private int camas_intubados_cdmx;
    private int camas_intubados_edomex;
    private int camas_generales_totales;
    private int camas_generales_cdmx;
    private int camas_generales_edomex;
}
