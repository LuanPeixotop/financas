package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJpqlManyToMany {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(3);
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		List<Movimentacao> resultado = query.getResultList();
		
		resultado.forEach(res -> {
			System.out.println(res.getDescricao());
			System.out.println(res.getValor());
		});
		
		em.getTransaction().commit();
		em.close();
	}
}
