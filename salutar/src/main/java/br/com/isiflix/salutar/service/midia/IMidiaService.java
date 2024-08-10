package br.com.isiflix.salutar.service.midia;

import br.com.isiflix.salutar.model.Midia;

public interface IMidiaService {
	Midia cadastrarNova(Midia midia);
	Midia alterarDados(Midia midia);
	boolean excluir(Integer id);
	Midia recuperarPeloId(Integer id);

}
