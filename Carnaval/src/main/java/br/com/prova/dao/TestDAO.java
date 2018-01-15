package br.com.prova.dao;

import br.com.prova.model.Nota;

public class TestDAO {

	public static void main(String[] args) throws Exception {

		Nota nota = null;

		// INSERÇÂO OK
		// EscolaSamba escolaSamba = (EscolaSamba)
		// EscolaSambaDAO.getInstance().getPorId(4);
		// Jurado jurado = (Jurado) JuradoDAO.getInstance().getPorId(3);
		// Quesito quesito = (Quesito) QuesitoDAO.getInstance().getPorId(1);
		// nota = new Nota(2, escolaSamba, jurado, quesito);
		// Boolean inseriu = NotaDAO.getInstance().inserir(nota);
		// System.out.println("Sucesso ao inserir: " + inseriu);

		// BUSCA POR ID OK
		// nota = (Nota) NotaDAO.getInstance().getPorId(1);
		// System.out.println("Nome: " + nota.getNome());

		// EDIÇÂO OK
		// nota.setNome("kakaroto");
		// nota.setPeso(3);
		// Boolean editou = NotaDAO.getInstance().editar(nota);
		// System.out.println("Sucesso ao editar: " + editou);

		// LISTAGEM OK
		// List<Entidade> listNotas = NotaDAO.getInstance().listar();
		//
		// for (Entidade e : listNotas) {
		// nota = (Nota) e;
		// System.out.println("Id: " + nota.getId());
		// System.out.println("Nome: " + nota.getNome());
		// System.out.println("Peso: " + nota.getPeso());
		// }

		// REMOCÃO OK
		// Boolean removeu = NotaDAO.getInstance().remover(nota);
		// Boolean removeuPorId = NotaDAO.getInstance().removerPorId(2);
		// System.out.println("Sucesso ao remover: " + removeu);
		// System.out.println("Sucesso ao remover por id: " + removeuPorId);

		NotaDAO dao = NotaDAO.getInstance();
		// nota = (Nota) dao.getPorId(7);
		nota = (Nota) dao.getApuracao(1);

	}

}
