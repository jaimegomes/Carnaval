package br.com.prova.interfaces;

import java.util.List;

import br.com.prova.model.Entidade;

public interface GenericManagedBean {

	public Entidade getPorId(Integer id) throws Exception;

	public void salvar() throws Exception;

	public void remover() throws Exception;

	public List<Entidade> listar() throws Exception;

}
