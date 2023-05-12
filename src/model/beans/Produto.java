package model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import view.ApresentacaoDeTela;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Integer qtd;
	private Integer qtdMin;
	private Integer qtdMax;
	private Date dataCad;
	private Categoria categoria;

	public Produto() {

	}

	public Produto(Integer id, String nome, Integer qtd, Integer qtdMin, Integer qtdMax, Date dataCad,
			Categoria categoria) {

		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.qtdMin = qtdMin;
		this.qtdMax = qtdMax;
		this.dataCad = dataCad;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getQtdMin() {
		return qtdMin;
	}

	public void setQtdMin(Integer qtdMin) {
		this.qtdMin = qtdMin;
	}

	public Integer getQtdMax() {
		return qtdMax;
	}

	public void setQtdMax(Integer qtdMax) {
		this.qtdMax = qtdMax;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Produto:\nId: " + id + "\nNome: " + nome + "\nQtd: " + qtd + "\nQtd Min: " + qtdMin + "\nQtd Max: "
				+ qtdMax + "\nData Cadastro: " + dataCad + "\nCategoria: " + categoria + "\n\n";
	}

	public boolean validarUpdate(Produto obj, String resp, Integer newQtd) {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		if (resp.equalsIgnoreCase("retirar")) {
			if (newQtd < 0 ) {
				at.mostrarMsg("não há estoque suficiente para fazer essa alteração");
				return false;
			} else if (newQtd <= obj.qtdMin) {
				at.mostrarMsg("QUANTIDADE MINIMA ATINGIDA");
				return true;
			}
		} else {
			if (newQtd > obj.qtdMax) {
				at.mostrarMsg("QUANTIDADE MAXIMA ATINGIDA");
				return true;
			}

		}
		return true;
	}
}
