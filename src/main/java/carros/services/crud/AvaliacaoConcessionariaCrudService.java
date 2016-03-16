package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.AvaliacaoConcessionariaDao;
import carros.entities.negocio.AvaliacaoConcessionaria;

@Service
public class AvaliacaoConcessionariaCrudService {
	private AvaliacaoConcessionariaDao avaliacaoConcessionariaDao;

	public AvaliacaoConcessionaria avaliarConcessionaria(
			AvaliacaoConcessionaria avaliacaoConcessionaria) {

		avaliacaoConcessionaria
				.setNotaGeral((avaliacaoConcessionaria.getNotaDocumentacao()
						+ avaliacaoConcessionaria.getNotaInformacao() + avaliacaoConcessionaria
						.getNotaVelocidade()) / 3.0);
		System.out.println(avaliacaoConcessionaria.getNotaGeral());

		return avaliacaoConcessionariaDao
				.avaliarConcessionaria(avaliacaoConcessionaria);
	}

	@Autowired
	public void setAvaliacaoConcessionariaDao(
			AvaliacaoConcessionariaDao avaliacaoConcessionariaDao) {
		this.avaliacaoConcessionariaDao = avaliacaoConcessionariaDao;
	}

}
