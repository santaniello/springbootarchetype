package br.com.tdv.springbootarchetype.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tdv.springbootarchetype.helpers.DateTimeHelper;



@Entity
@Table(name = "T_TEST_PESSOA")
@SequenceGenerator(name = "SEQ_PESSOATEST_GEN", sequenceName = "SEQ_TEST_PESSOA", initialValue = 1, allocationSize = 1)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOATEST_GEN")
	@Column(name = "TEST_PESSOA_ID")
	private Long id;

	@Column(name = "TEST_PESSOA_NOME", columnDefinition = "VARCHAR2(100)", nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "TEST_PESSOA_TIPO", length = 50, nullable = false)
	private PessoaTipo tipo;

	@Column(name = "TEST_PESSOA_DTCADASTRO", columnDefinition = "DATE default SYSDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
	private List<Telefone> telefones;

	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
	private Set<PessoaCnpj> cnpjs;

	public Pessoa() {
	}

	public Pessoa(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Pessoa(Long id, String nome, PessoaTipo tipo, Calendar dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PessoaTipo getTipo() {
		return tipo;
	}

	public void setTipo(PessoaTipo tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<PessoaCnpj> getCnpjs() {
		return cnpjs;
	}

	public void setCnpjs(Set<PessoaCnpj> cnpjs) {
		this.cnpjs = cnpjs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", dataCadastro="
				+ DateTimeHelper.toDateTimeAsString(dataCadastro) + "]";
	}

}
