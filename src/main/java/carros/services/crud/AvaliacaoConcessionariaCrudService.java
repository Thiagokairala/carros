package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.AvaliacaoConcessionariaDao;
import carros.dao.pessoa.ConcessionariaDao;
import carros.entities.negocio.AvaliacaoConcessionaria;
import carros.entities.usuarios.Concessionaria;

@Service
public class AvaliacaoConcessionariaCrudService {
	private AvaliacaoConcessionariaDao avaliacaoConcessionariaDao;
	private ConcessionariaDao concessionariaDao;

	public AvaliacaoConcessionaria avaliarConcessionaria(AvaliacaoConcessionaria avaliacaoConcessionaria) {

		avaliacaoConcessionaria.setNotaGeral((avaliacaoConcessionaria.getNotaDocumentacao()
				+ avaliacaoConcessionaria.getNotaInformacao() + avaliacaoConcessionaria.getNotaVelocidade()) / 3.0);

		avaliacaoConcessionaria
				.setConcessionaria(concessionariaDao.buscarConcessionaria(avaliacaoConcessionaria.getConcessionaria()));

		avaliacaoConcessionaria.setConcessionaria(calcularNovaAvaliacao(avaliacaoConcessionaria.getConcessionaria(),
				avaliacaoConcessionaria.getNotaGeral()));

		return avaliacaoConcessionariaDao.avaliarConcessionaria(avaliacaoConcessionaria);
	}

	private Concessionaria calcularNovaAvaliacao(Concessionaria concessionaria, double notaGeral) {
		concessionaria.setNumeroAvaliacoes(concessionaria.getNumeroAvaliacoes() + 1);
		notaGeral += concessionaria.getNotaGeral();
		concessionaria.setNotaGeral(notaGeral);
		return concessionaria;
	}

	@Autowired
	public void setAvaliacaoConcessionariaDao(AvaliacaoConcessionariaDao avaliacaoConcessionariaDao) {
		this.avaliacaoConcessionariaDao = avaliacaoConcessionariaDao;
	}

	@Autowired
	public void setConcessionariaDao(ConcessionariaDao concessionariaDao) {
		this.concessionariaDao = concessionariaDao;
	}

}
