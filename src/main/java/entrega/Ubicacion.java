package main.java.entrega;

public class Ubicacion {
	
	private String coordenadas;
	private String calle;
	private String avenida;
	private String edifico;
	private String local;
	
	public Ubicacion() {
	}

	public Ubicacion(String coordenadas, String calle, String avenida,
			String edifico, String local) {
		super();
		this.coordenadas = coordenadas;
		this.calle = calle;
		this.avenida = avenida;
		this.edifico = edifico;
		this.local = local;
	}


	public String getCoordenadas() {
		return coordenadas;
	}


	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getAvenida() {
		return avenida;
	}


	public void setAvenida(String avenida) {
		this.avenida = avenida;
	}


	public String getEdifico() {
		return edifico;
	}


	public void setEdifico(String edifico) {
		this.edifico = edifico;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}
	
	
	

}
