package isi.aepad.controller;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@SessionScoped
@Named("buscarController")
public class BuscarProductoBean implements Serializable{
	private Client client = ClientBuilder.newClient();
	private WebTarget baseApi ;
	private Integer precioMinimo;
	private Integer precioMaximo;
	private String resultado;
	private List<ProductoDTO> productos;
	private List<ProductoDTO> compra;

	private Integer idSeleccionado;

	
	
	@PostConstruct
	public void init() {
		baseApi = client.target("http://localhost:8080/tp-logica/api/");
		this.precioMinimo=1;
		this.precioMaximo=15;
		this.resultado="no se busco nada";
		this.productos = new ArrayList<ProductoDTO>();
		this.compra = new ArrayList<ProductoDTO>();
	}
	
	public String buscar() {
		try {
			String tmp = baseApi.path("producto")
					 .queryParam("precioMaximo", "10")
			        .request(MediaType.APPLICATION_JSON)
			        .get(String.class);
			System.out.println(tmp);
			try(JsonReader reader = Json.createReader(new StringReader(tmp))){
				JsonArray jsonArr = reader.readArray();
				for(int i = 0;i<jsonArr.size();i++) {
					JsonObject obj = jsonArr.getJsonObject(i);
					this.productos.add(new ProductoDTO(obj.getInt("id"),obj.getString("descripcion"),obj.getJsonNumber("precio").doubleValue()));
				}
				
				this.resultado = this.productos.size()+" --> "+this.productos.get(0).toString();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "listaProductos";
	}

	public String comprar() {
		try {
			ProductoDTO aux = new ProductoDTO();
			aux.setId(this.idSeleccionado);
			Integer indice = this.productos.indexOf(aux); 
			ProductoDTO productoComprar = this.productos.get(indice);			
			this.productos.remove(indice);
			this.compra.add(productoComprar);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "miCompra";
	}
	
	public Integer getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(Integer precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public Integer getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(Integer precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}

	public List<ProductoDTO> getCompra() {
		return compra;
	}

	public Integer getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Integer idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public void setCompra(List<ProductoDTO> compra) {
		this.compra = compra;
	}


	
}
