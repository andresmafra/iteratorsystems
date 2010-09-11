package br.iteratorsystems.cps.interfaces;

import java.io.Serializable;
import java.util.List;

import br.iteratorsystems.cps.exceptions.CpsComparacaoException;
import br.iteratorsystems.cps.to.ResultadoComparacaoTO;

/**
 * Interface responsavel pelos metodos padroes de compara��o
 * @author Andr�
 *
 */
public interface MotorComparacao extends Serializable{

	
	List<ResultadoComparacaoTO> comparar() throws CpsComparacaoException;
}
