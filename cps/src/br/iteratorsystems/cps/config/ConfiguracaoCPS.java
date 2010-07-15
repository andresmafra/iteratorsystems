package br.iteratorsystems.cps.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.iteratorsystems.cps.entities.PARAMETRIZACAO_CPS;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Classe que carrega as configura��es do cps.
 * @author Andr�
 * 
 */
public class ConfiguracaoCPS implements ServletContextListener{

	/**
	 * Sess�o do hibernate
	 */
	private static final Session SESSION = HibernateConfig.getSession();
	
	/**
	 * Variavel est�tica para o nome do objeto de sess�o.
	 */
	private static final String PARAMETRIZACAO = "parametrizacao";
	
	/**
	 * Obtem a parametriza��o do sistema.
	 * @return Classe de parametriza��o com os dados do banco.
	 */
	private static PARAMETRIZACAO_CPS obterParametrizacaoCps() {
		PARAMETRIZACAO_CPS parametrizacaoCPS = null;
		try {
			Criteria criteria = 
				SESSION.createCriteria(PARAMETRIZACAO_CPS.class);
			parametrizacaoCPS = 
				(PARAMETRIZACAO_CPS) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parametrizacaoCPS;
	}

	/**
	 * Destroi o contexto da aplica��o.
	 * @param event - Evento do servlet
	 */
	public void contextDestroyed(ServletContextEvent event) {
		try{
			event.getServletContext().removeAttribute(PARAMETRIZACAO);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicia o contexto da aplica��o e insere um objeto de configura��o do
	 * sistema no contexto.
	 * @param event - Evento do servlet
	 */
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute(
					PARAMETRIZACAO,obterParametrizacaoCps());
	}
}
