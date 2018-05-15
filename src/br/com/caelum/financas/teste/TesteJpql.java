package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJpql {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(6);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta " +
					  "and m.tipo = :pTipo " +
					  "order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		List<Movimentacao> resultado = query.getResultList();
		
		resultado.forEach(res -> {
			System.out.println(res.getDescricao());
			System.out.println(res.getValor());
		});
		
		em.getTransaction().commit();
		em.close();
	}
}
