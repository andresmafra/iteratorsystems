package br.iteratorsystems.cps.exceptions;

public class CpsGeneralExceptions extends Throwable {

	//n�mero 'especial' para as excess�es! :*)
	private static final long serialVersionUID = 666L;
	
	public CpsGeneralExceptions(String message,Throwable cause){
		super(message,cause);
	}
	public CpsGeneralExceptions(String message){
		super(message);
	}
	public CpsGeneralExceptions(Throwable cause){
		super(cause);
	}
	
}
