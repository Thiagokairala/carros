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

import carros.services.image.ImagemService;

@RestController
@RequestMapping("/image")
@Service
@Scope("request")
public class ImagemController {

	private ImagemService imagemService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> singleFileUpload(@RequestParam("image") MultipartFile file)
			throws IOException {

		if (!file.isEmpty()) {
			try {
				imagemService.salvarImagem(file);
				return new ResponseEntity<String>(HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/buscarFoto/{id}/{hash}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> testphoto(@PathVariable("id") long id) throws IOException {
		return imagemService.getImagem(id);
	}

	@Autowired
	public void setImagemService(ImagemService imagemService) {
		this.imagemService = imagemService;
	}

}
