package br.com.isiflix.salutar.service.midia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isiflix.salutar.dao.MidiaDAO;
import br.com.isiflix.salutar.model.Midia;

@Component
public class MidiaServiceImpl implements IMidiaService {
	
	@Autowired
	private MidiaDAO dao;

	@Override
	public Midia cadastrarNova(Midia midia) {
		// TODO Auto-generated method stub
		return dao.save(midia);
	}

	@Override
	public Midia alterarDados(Midia midia) {
		// TODO Auto-generated method stub
		return dao.save(midia);
	}

	@Override
	public boolean excluir(Integer id) {
		// TODO Auto-generated method stub
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Midia recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
