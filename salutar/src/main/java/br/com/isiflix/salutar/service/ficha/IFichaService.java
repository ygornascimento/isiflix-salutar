package br.com.isiflix.salutar.service.ficha;

import java.util.List;

import br.com.isiflix.salutar.model.FichaPaciente;

public interface IFichaService {
	FichaPaciente cadastrar(FichaPaciente nova);
	FichaPaciente alterar(FichaPaciente ficha);
	List<FichaPaciente> buscarPorNome(String nome);
	FichaPaciente recuperarPeloId(Integer id);
	boolean excluir(Integer id);
}
