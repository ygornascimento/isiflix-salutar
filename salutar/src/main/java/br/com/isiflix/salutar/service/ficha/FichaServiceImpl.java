package br.com.isiflix.salutar.service.ficha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isiflix.salutar.dao.FichaPacienteDAO;
import br.com.isiflix.salutar.model.FichaPaciente;

@Component
public class FichaServiceImpl implements IFichaService {
	
	@Autowired
	private FichaPacienteDAO dao;

	@Override
	public FichaPaciente cadastrar(FichaPaciente nova) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FichaPaciente alterar(FichaPaciente ficha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FichaPaciente> buscarPorNome(FichaPaciente nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FichaPaciente recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluir(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
