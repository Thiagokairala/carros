package carros.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import carros.entities.pessoas.aparencia.Imagem;
import carros.services.image.ImagemService;

@RestController
@RequestMapping("/image")
@Service
@Scope("request")
public class ImagemController {

	private ImagemService imagemService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Imagem> singleFileUpload(@RequestParam("image") MultipartFile file)
			throws IOException {

		if (!file.isEmpty()) {
			try {

				return new ResponseEntity<Imagem>(imagemService.salvarImagem(file), HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Imagem>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<Imagem>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/upload/{idImagem}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Imagem> replaceFile(@RequestParam("image") MultipartFile file,
			@PathVariable Long idImagem) throws IOException {
		System.out.println(idImagem);

		if (!file.isEmpty()) {
			try {
				return new ResponseEntity<Imagem>(imagemService.atualizarImagem(file, idImagem), HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<Imagem>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<Imagem>(HttpStatus.UNAUTHORIZED);
		}

	}

	@RequestMapping(value = "/buscarFoto/{id}/{hash}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> testzphoto(@PathVariable("id") long id) throws IOException {
		return imagemService.getImagem(id);
	}

	@Autowired
	public void setImagemService(ImagemService imagemService) {
		this.imagemService = imagemService;
	}

}
