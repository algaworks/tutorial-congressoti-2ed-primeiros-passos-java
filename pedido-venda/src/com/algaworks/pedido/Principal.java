package com.algaworks.pedido;

import com.algaworks.pedido.modelo.Cliente;
import com.algaworks.pedido.modelo.ItemPedido;
import com.algaworks.pedido.modelo.Pedido;
import com.algaworks.pedido.modelo.TipoPedido;

public class Principal {

	public static void main(String[] args) {
		Pedido pedido = new Pedido(1L, 50.0, TipoPedido.VAREJO);
		
		Cliente cliente = new Cliente("João", "joao@email.com", "1234-1234");
		pedido.setCliente(cliente);
		
		ItemPedido geladeira = new ItemPedido(1, 1500.0, "Geladeira FrostFree");
		pedido.adicionarItem(geladeira);
		
		ItemPedido fogao = new ItemPedido(1, 800.0, "Fogão 6 bocas");
		pedido.adicionarItem(fogao);
		
		System.out.println(pedido);
		System.out.println("Total de itens no pedido: " + pedido.totalItens());
		System.out.println("Desconto para pedido: " + pedido.calcularDesconto());
	}
	
}
