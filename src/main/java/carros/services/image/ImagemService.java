package carros.services.image;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import carros.dao.pessoa.aparencia.ImagemDao;
import carros.entities.negocio.Oferta;
import carros.entities.pessoas.aparencia.Imagem;

@Service
public class ImagemService {
	private ImagemDao imagemDao;

	public Imagem salvarImagem(MultipartFile file) throws IOException {
		String fileName = "image/" + (new GregorianCalendar()).getTimeInMillis() + "."
				+ file.getOriginalFilename().split("\\.")[1];
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
		stream.write(bytes);
		stream.close();

		return salvarRegistroDeImagem(fileName);
	}

	public Imagem atualizarImagem(MultipartFile file, Long idImagem) throws IOException {
		String fileName = "image/" + (new GregorianCalendar()).getTimeInMillis() + "."
				+ file.getOriginalFilename().split("\\.")[1];
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
		stream.write(bytes);
		stream.close();

		return salvarUpdateDeImagem(fileName, idImagem);
	}

	public ResponseEntity<byte[]> getImagem(long id) throws IOException {
		Imagem imagem = imagemDao.buscarImagem(id);
		InputStream in = new FileInputStream("./" + imagem.getCaminhoImagem());

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
	}

	public List<Imagem> getImagemOferta(Oferta oferta) {
		return imagemDao.buscarImagensOferta(oferta.getVeiculo().getAvaliacaoVeiculo().getId());

	}

	private Imagem salvarUpdateDeImagem(String fileName, Long idImagem) {
		Imagem imagem = new Imagem();
		imagem.setCaminhoImagem(fileName);
		imagem.setId(idImagem);
		imagem.setHashImagem(Long.toString(new GregorianCalendar().getTimeInMillis()));
		return imagemDao.update(imagem);
	}

	private Imagem salvarRegistroDeImagem(String fileName) {
		Imagem imagem = new Imagem();
		imagem.setCaminhoImagem(fileName);
		imagem.setHashImagem(Long.toString(new GregorianCalendar().getTimeInMillis()));
		return imagemDao.inserir(imagem);
	}

	@Autowired
	public void setImagemDao(ImagemDao imagemDao) {
		this.imagemDao = imagemDao;
	}

}
