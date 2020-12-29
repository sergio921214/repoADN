package com.ceiba.rentarauto.servicio;

//import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.rentarauto.modelo.entidad.RentarAuto;
import com.ceiba.rentarauto.puerto.repositorio.RepositorioRentarAuto;

public class ServicioGuardarRentaAuto {
	
    private static final String EL_AUTO_YA_EXISTE_EN_EL_SISTEMA = "El auto ya existe en el sistema";

    private final RepositorioRentarAuto repositorioRentarAuto;

    public ServicioGuardarRentaAuto(RepositorioRentarAuto repositorioRentarAuto) {
        this.repositorioRentarAuto = repositorioRentarAuto;
    }

    public Long ejecutar(RentarAuto rentarAuto) {
        
        return this.repositorioRentarAuto.guardarRenta(rentarAuto);
    }


}