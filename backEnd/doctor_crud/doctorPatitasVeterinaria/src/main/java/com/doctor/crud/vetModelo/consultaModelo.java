/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.vetModelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author flietiz
 */
@Document(collection="datos_consulta")

public class consultaModelo {
    
    @Id
    private String id;
    private String id_consulta;
    private String antecedentes;
    private String sintomatologia;
    private String historialMedicamentos;
    private String vacunas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }

    public void setSintomatologia(String sintomatologia) {
        this.sintomatologia = sintomatologia;
    }

    public String getHistorialMedicamentos() {
        return historialMedicamentos;
    }

    public void setHistorialMedicamentos(String historialMedicamentos) {
        this.historialMedicamentos = historialMedicamentos;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }
    
}
