package br.com.tdv.springbootarchetype.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="TDVADM.T_USU_USUARIO")
@Transactional
public class Usuario  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USU_USUARIO_CODIGO",columnDefinition="CHAR(10)")
	private String codigo;
	
	@Column(name="USU_USUARIO_NOME")
	private String nome;

	public Usuario() {}	
	
	public Usuario(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo; 
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}