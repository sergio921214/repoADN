package com.ceiba.auto.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class AutoTest {
    @Test
    public void validarPlacaLongitudIgual6() {
        // arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPlaca("ADBC124");
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }
    
    @Test 
    public void validarDigitosPlacaIgual3() {
    	AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPlaca("ABCDEF");
    	BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionLongitudValor.class, "La placa debe tener 3 digitos");
    }
    
    @Test
    public void validarPlacaIsNull() {
    	AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPlaca(null);
    	BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la placa del Auto");
    }
    
    @Test
    public void validarCombustibleIsNull() {
    	AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conTipoCombustible(null);
    	BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de combustible");
    }
    
    @Test
    public void validarPrecioPorDiaIsNull() {
    	AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPrecioPordia(null);
    	BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el precio por dia");
    }
    
    @Test
    public void validarMultiplicadorFinSemanaIsNull() {
    	AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conMultiplicadorFinSemana(null);
    	BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el multiplicador fin semana");
    }
}
