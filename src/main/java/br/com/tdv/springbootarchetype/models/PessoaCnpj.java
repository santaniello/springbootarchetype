package br.com.tdv.springbootarchetype.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "T_TEST_PESSOACNPJ", uniqueConstraints = {
		@UniqueConstraint(name = "UQ_TESTE_PESSOACNPJ", columnNames = { "TEST_PESSOA_ID", "TEST_CNPJ_ID" }) })
@SequenceGenerator(name = "SEQ_PESSOACNPJ_GEN", sequenceName = "SEQ_TEST_PESSOACNPJ", initialValue = 1, allocationSize = 1)
public class PessoaCnpj implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOACNPJ_GEN")
	@Column(name = "TEST_PESSOACNPJ_ID")
	private Long id;

	@OneToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "TEST_PESSOA_ID", foreignKey = @ForeignKey(name = "FK_TEST_PESSOACNPJPESSOA"))
	private Pessoa pessoa;

	@OneToOne(targetEntity = Cnpj.class)
	@JoinColumn(name = "TEST_CNPJ_ID", foreignKey = @ForeignKey(name = "FK_TEST_PESSOACNPJCNPJ"))
	private Cnpj cnpj;

	@Column(name = "TEST_PESSOACNPJ_DTCAD", columnDefinition = "DATE default SYSDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	public PessoaCnpj() {
	}

	public PessoaCnpj(Long id, Pessoa pessoa, Cnpj cnpj, Calendar dataCadastro) {
		this.id = id;
		this.pessoa = pessoa;
		this.cnpj = cnpj;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cnpj getCnpj() {
		return cnpj;
	}

	public void setCnpj(Cnpj cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		PessoaCnpj other = (PessoaCnpj) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

}
