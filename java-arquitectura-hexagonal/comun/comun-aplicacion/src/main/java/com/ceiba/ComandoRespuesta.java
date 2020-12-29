package com.ceiba;

@SuppressWarnings("hiding")
public class ComandoRespuesta<T, Integer, String > {

    private T valor;
    private Integer errorCode;
    private String errorMsg;

    public ComandoRespuesta(T valor, Integer errorCode, String errorMsg) {
        this.valor = valor;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public T getValor() {
        return valor;
    }

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
    
}
