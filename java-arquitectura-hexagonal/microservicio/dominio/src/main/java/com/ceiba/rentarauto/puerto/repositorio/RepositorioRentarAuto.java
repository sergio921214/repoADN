package com.ceiba.rentarauto.puerto.repositorio;

import com.ceiba.rentarauto.modelo.entidad.RentarAuto;

public interface RepositorioRentarAuto {
	

	
    /**
     * Permite guardar la renta de un auto
     * @param RentarAuto
     */
    Long guardarRenta(RentarAuto rentarAuto);
    
    /**
     * Permite validar si existe una renta de auto con una placa
     * @param placa
     * @return si existe o no la renta
     */
    boolean existe(String placa);

}
