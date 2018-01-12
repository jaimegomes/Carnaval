package br.com.prova.interfaces;

import java.util.List;

import br.com.prova.entities.Entidade;

public interface GenericManagedBean {

	public Entidade getPorId(Integer id) throws Exception;

	public Boolean inserir(Entidade entidade) throws Exception;

	public Boolean editar(Entidade entidade) throws Exception;

	public Boolean remover(Entidade entidade) throws Exception;

	public Boolean removerPorId(Integer id) throws Exception;

	public List<Entidade> listar() throws Exception;

}
