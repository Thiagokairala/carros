package carros.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import carros.dao.negocio.MarcaVeiculoDao;
import carros.dao.negocio.ModeloVeiculoDao;
import carros.entities.atualizarBanco.MarcasAtt;
import carros.entities.atualizarBanco.ModeloVeiculoAtt;
import carros.entities.negocio.MarcaVeiculo;
import carros.entities.negocio.ModeloVeiculo;
import carros.entities.negocio.TipoVeiculo;

@RestController
@Service
@Scope("request")
@RequestMapping("/atualizar")
public class AtualizarMarcasEModelos {
	private MarcaVeiculoDao marcaVeiculoDao;
	private ModeloVeiculoDao modeloVeiculoDao;

	@RequestMapping(value = "/marcas", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> atualizarMarcas() throws Exception {
		System.out.println("atualizando marcas");
		List<MarcasAtt> marcas = sendGetMarca();
		List<MarcaVeiculo> marcasLista = parserListMarcas(marcas);
		inserirListaDeMarcas(marcasLista);

		double i = 0;
		int size = marcasLista.size();
		for (MarcaVeiculo marca : marcasLista) {
			System.out.println(100 * (i / size) + "%");
			i++;
			List<ModeloVeiculoAtt> modelosVeiculoAtt = sendGetModelo(marca);
			List<ModeloVeiculo> modelosVeiculo = parseModelosVeiculo(modelosVeiculoAtt, marca);
			inserirModelosVeiculo(modelosVeiculo);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private void inserirModelosVeiculo(List<ModeloVeiculo> modelosVeiculo) {
		try {
			for (ModeloVeiculo modeloVeiculo : modelosVeiculo) {

				modeloVeiculoDao.registrar(modeloVeiculo);
			}
		} catch (Exception e) {
			// nothing to do.
		}

	}

	private List<ModeloVeiculo> parseModelosVeiculo(List<ModeloVeiculoAtt> modelosVeiculoAtt, MarcaVeiculo marca) {
		List<ModeloVeiculo> modelosVeiculo = new ArrayList<ModeloVeiculo>();

		for (ModeloVeiculoAtt veiculo : modelosVeiculoAtt) {
			ModeloVeiculo modelo = new ModeloVeiculo();
			modelo.setId(veiculo.getId());
			modelo.setMarcaVeiculo(marca);
			modelo.setNome(veiculo.getFipe_name());
			TipoVeiculo tipoVeiculo = new TipoVeiculo();
			tipoVeiculo.setId(new Long(1));
			modelo.setTipoVeiculo(tipoVeiculo);

			modelosVeiculo.add(modelo);
		}

		return modelosVeiculo;
	}

	private List<ModeloVeiculoAtt> sendGetModelo(MarcaVeiculo marca) throws Exception {
		String url = "http://fipeapi.appspot.com/api/1/carros/veiculos/" + marca.getId() + ".json";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();

		// print result
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		ObjectMapper objectMapper = new ObjectMapper();
		List<ModeloVeiculoAtt> modeloAtt = mapper.readValue(response.toString(),
				objectMapper.getTypeFactory().constructCollectionType(List.class, ModeloVeiculoAtt.class));

		return modeloAtt;
	}

	private void inserirListaDeMarcas(List<MarcaVeiculo> marcasLista) {
		for (MarcaVeiculo marca : marcasLista) {
			try {
				marcaVeiculoDao.inserirMarca(marca);
			} catch (Exception e) {
				// nothing to do.
			}
		}
	}

	private List<MarcaVeiculo> parserListMarcas(List<MarcasAtt> marcas) {
		List<MarcaVeiculo> marcasVeiculo = new ArrayList<MarcaVeiculo>();
		for (MarcasAtt marcaAtt : marcas) {
			MarcaVeiculo marcaVeiculo = new MarcaVeiculo();
			marcaVeiculo.setId(marcaAtt.getId());
			marcaVeiculo.setNome(marcaAtt.getFipe_name());
			marcasVeiculo.add(marcaVeiculo);
		}
		return marcasVeiculo;
	}

	// HTTP GET request
	private List<MarcasAtt> sendGetMarca() throws Exception {
		String url = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();

		// print result
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		ObjectMapper objectMapper = new ObjectMapper();
		List<MarcasAtt> marcaAtt = mapper.readValue(response.toString(),
				objectMapper.getTypeFactory().constructCollectionType(List.class, MarcasAtt.class));
		return marcaAtt;

	}

	@Autowired
	public void setMarcaVeiculoDao(MarcaVeiculoDao marcaVeiculoDao) {
		this.marcaVeiculoDao = marcaVeiculoDao;
	}

	@Autowired
	public void setModeloVeiculoDao(ModeloVeiculoDao modeloVeiculoDao) {
		this.modeloVeiculoDao = modeloVeiculoDao;
	}

}
