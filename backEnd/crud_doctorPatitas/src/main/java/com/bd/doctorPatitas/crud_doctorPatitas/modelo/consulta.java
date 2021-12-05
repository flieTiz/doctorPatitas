/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.doctorPatitas.crud_doctorPatitas.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ivan
 */

@Document(collection="consulta")
public class consulta {
    
    @Id
    private String numeroConsulta;
    private String antecedentes;
    private String historiaM;
    private String vacunas;

    public String getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(String numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getHistoriaM() {
        return historiaM;
    }

    public void setHistoriaM(String historiaM) {
        this.historiaM = historiaM;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }
    
    
}
