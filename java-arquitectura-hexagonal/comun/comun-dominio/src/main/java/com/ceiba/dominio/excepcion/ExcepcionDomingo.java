package com.ceiba.dominio.excepcion;

public class ExcepcionDomingo extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDomingo(String mensaje) {
        super(mensaje);
    }
}
