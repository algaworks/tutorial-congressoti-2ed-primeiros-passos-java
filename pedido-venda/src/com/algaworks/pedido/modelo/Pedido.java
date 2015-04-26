package com.algaworks.pedido.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.pedido.desconto.CalculadoraDesconto;
import com.algaworks.pedido.desconto.CalculadoraDescontoAtacado;
import com.algaworks.pedido.desconto.CalculadoraDescontoVarejo;

public class Pedido {

	private Long numero;
	private LocalDate dataCriacao;
	private String observacao;
	private double valorFrete;
	private double valorTotal;
	private TipoPedido tipo;
	
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	public Pedido(Long numero, double valorFrete, TipoPedido tipo) {
		this.numero = numero;
		this.dataCriacao = LocalDate.now();
		this.valorFrete = valorFrete;
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", dataCriacao=" + dataCriacao
				+ ", observacao=" + observacao + ", valorFrete=" + valorFrete
				+ ", valorTotal=" + valorTotal + ", tipo=" + tipo
				+ ", cliente=" + cliente + ", itens=" + itens + "]";
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void adicionarItem(ItemPedido item) {
		itens.add(item);
		recalcularValorTotal();
	}
	
	public Integer totalItens() {
		return itens.size();
	}
	
	private void recalcularValorTotal() {
		valorTotal = itens.stream()
							.mapToDouble(i -> i.getValorUnitario() * i.getQuantidade())
							.sum();
	}
	
	public double calcularDesconto() {
		CalculadoraDesconto calculadoraDesconto = tipo.calculadora();
		return calculadoraDesconto.calcular(valorTotal);
	}
	
}










