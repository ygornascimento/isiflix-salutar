package br.com.isiflix.salutar.service.ficha;

import java.util.List;

import br.com.isiflix.salutar.model.FichaPaciente;

public interface IFichaService {
	public FichaPaciente cadastrar(FichaPaciente nova);
	public FichaPaciente alterar(FichaPaciente ficha);
	public List<FichaPaciente> buscarPorNome(String nome);
	public FichaPaciente recuperarPeloId(Integer id);
	public boolean excluir(Integer id);
}
