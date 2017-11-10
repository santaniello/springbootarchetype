package br.com.tdv.springbootarchetype.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_TEST_TELEFONE")
@SequenceGenerator(name = "SEQ_TELEFONETEST_GEN", sequenceName = "SEQ_TEST_TELEFONE", initialValue = 1, allocationSize = 1)
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TELEFONETEST_GEN")
	@Column(name = "TEST_TELEFONE_ID")
	private Long id;

	@Column(name = "TEST_TELEFONE_DDD", nullable = false)
	private String ddd;

	@Column(name = "TEST_TELEFONE_NUMERO", nullable = false)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "TEST_PESSOA_ID", foreignKey = @ForeignKey(name = "FK_TEST_TELEFONE_PESSOA"))
	private Pessoa pessoa;

	public Telefone() {
	}

	public Telefone(Long id, String ddd, String numero, Pessoa pessoa) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", ddd=" + ddd + ", numero=" + numero + "]";
	}

}
