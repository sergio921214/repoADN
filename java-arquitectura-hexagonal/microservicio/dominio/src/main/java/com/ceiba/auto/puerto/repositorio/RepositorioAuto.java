package com.ceiba.auto.puerto.repositorio;

import com.ceiba.auto.modelo.entidad.Auto;

public interface RepositorioAuto {
    /**
     * Permite crear un auto
     * @param auto
     * @return el id generado
     */
    Long crear(Auto auto);

    /**
     * Permite rentar un auto
     * @param auto
     */
    void rentar(String placa);

    /**
     * Permite validar si existe un auto con una placa
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);
    
    /**
     * Permite validar si existe un auto con una placa excluyendo un id
     * @param placa
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String placa);




}