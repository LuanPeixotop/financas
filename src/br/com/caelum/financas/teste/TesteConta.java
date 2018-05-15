package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Luan");
		conta.setAgencia("123");
		conta.setBanco("Inter");
		conta.setNumero("546");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();

		conta.setTitular("Luan Peixoto");
		em2.merge(conta);

		em2.getTransaction().commit();
		em2.close();
	}
}
