package br.iteratorsystems.cps.exceptions;

public class CpsExceptions extends Throwable {

	//n�mero 'especial' para as excess�es! :*)
	private static final long serialVersionUID = 666L;
	
	public CpsExceptions(String message,Throwable cause){
		super(message,cause);
	}
	public CpsExceptions(String message){
		super(message);
	}
	public CpsExceptions(Throwable cause){
		super(cause);
	}
	
}
