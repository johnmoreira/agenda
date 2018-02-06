package dao;

import java.util.List;
import entidades.Pessoa;
import utils.genericDAO;

public class PessoaDAO extends genericDAO {

	public void salvar(Pessoa pessoa) {
		super.salvar(pessoa);
    }

	public Pessoa consultar(int cod, Pessoa pessoa) {
		return (Pessoa) super.consultar(cod, pessoa);
	}
	
	public void atualizar(int cod, Pessoa pessoa) {
		super.atualizar(cod, pessoa);
	}
	
	public void deletar(int cod, Pessoa pessoa) {
		super.deletar(cod, pessoa);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listar(Pessoa pessoa){
		return super.Listar(pessoa);
	}
}