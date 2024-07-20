package br.com.isiflix.salutar.service.ficha;

import java.util.List;
import java.util.UUID;

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
		nova.setUuid(UUID.randomUUID().toString());
		nova.setAtivo(1);
		return dao.save(nova);
	}

	@Override
	public FichaPaciente alterar(FichaPaciente ficha) {
		// TODO Auto-generated method stub
		return dao.save(ficha);
	}

	@Override
	public List<FichaPaciente> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNomePacienteContaining(nome);
	}

	@Override
	public FichaPaciente recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public boolean excluir(Integer id) {
		// TODO Auto-generated method stub
		FichaPaciente ficha = recuperarPeloId(id);
		if (ficha != null) {
			ficha.setAtivo(0);
			dao.save(ficha);
			return true;
		}
		return false;
	}

}
