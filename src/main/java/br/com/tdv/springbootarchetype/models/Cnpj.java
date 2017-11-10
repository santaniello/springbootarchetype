package br.com.tdv.springbootarchetype.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "T_TEST_CNPJ")
@SequenceGenerator(name = "SEQ_CNPJTEST_GEN", sequenceName = "SEQ_TEST_CNPJ", initialValue = 1, allocationSize = 1)
@XmlRootElement(name = "cnpj")
@XmlType(propOrder = {"id", "numero"})
public class Cnpj implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CNPJTEST_GEN")
	@Column(name = "TEST_CNPJ_ID")
	private Long id;

	@Column(name = "TEST_CNPJ_NUMERO", nullable = false)
	private String numero;

	public Cnpj() {
	}

	public Cnpj(Long id, String numero) {
		this.id = id;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	@XmlElement
	public void setNumero(String numero) {
		this.numero = numero;
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
		Cnpj other = (Cnpj) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CNPJ [id=" + id + ", numero=" + numero + "]";
	}

}
