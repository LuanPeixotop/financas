package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemocao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, 8);
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}
}
