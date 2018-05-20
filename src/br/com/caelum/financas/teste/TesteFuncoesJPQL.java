package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(6);
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		List<Double> mediasPorDiaETipo = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		for (Double media : mediasPorDiaETipo) {
			System.out.println(media);
		}
		
		em.close();
	}
}
