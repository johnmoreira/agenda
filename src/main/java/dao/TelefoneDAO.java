package dao;

import java.util.List;
import entidades.Telefone;
import utils.genericDAO;

public class TelefoneDAO extends genericDAO {

	public void salvar(Telefone telefone) {
		super.salvar(telefone);
    }

	public Telefone consultar(int cod, Telefone telefone) {
		return (Telefone) super.consultar(cod, telefone);
	}
	
	public void atualizar(int cod, Telefone telefone) {
		super.atualizar(cod, telefone);
	}
	
	public void deletar(int cod, Telefone telefone) {
		super.deletar(cod, telefone);
	}
	
	@SuppressWarnings("unchecked")
	public List<Telefone> listar(Telefone telefone){
		return super.Listar(telefone);
	}
}