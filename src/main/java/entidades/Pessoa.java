package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private Date dataNascimento;
	@Column
	private String email;
	@Column
	private List<Telefone> telefone;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
}
