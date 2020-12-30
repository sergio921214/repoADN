package com.ceiba.auto.servicio;

import com.ceiba.auto.puerto.repositorio.RepositorioAuto;

public class ServicioCambiarRentadoAuto {

    private final RepositorioAuto repositorioAuto;

    public ServicioCambiarRentadoAuto(RepositorioAuto repositorioAuto) {
        this.repositorioAuto = repositorioAuto;
    }

    public void ejecutar(String placa) {
        
        this.repositorioAuto.rentar(placa);    
    }


}
