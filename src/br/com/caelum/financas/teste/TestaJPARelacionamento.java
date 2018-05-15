package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaJPARelacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("0000");
		conta.setBanco("Inter");
		conta.setNumero("998564-0");
		conta.setTitular("Jão");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Compra de um celular");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("706.23"));
	
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
