package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		Conta contaBD = em.find(Conta.class, 6);
		contaBD.setTitular("Luan Peixoto Pereira");
		System.out.println(contaBD);
		
		em.getTransaction().commit();
		em.close();
	}
}
