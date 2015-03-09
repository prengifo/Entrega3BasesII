package main.java.entrega.models;

import main.java.entrega.states.Estado;
import main.java.entrega.states.EstadoCreada;

import javax.persistence.*;

@Entity
@Table(name="TarjetaDeCredito")
public class TarjetaDeCredito {
	
	@Id
	@Column(name="numeroTarjeta")
	private String numeroTarjeta;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fechaDeVencimiento")
	private String fechaDeVencimiento;
	
	@Column(name="codigoSeguridad")
	private int codigoSeguridad;

    @Column(name = "vencida")
    private boolean vencida;

    // Se marca asi para que Hibernate no lo tome en cuenta para la base
    @Transient
    private Estado estado; //Estado de la tarjeta de credito
	
	@ManyToOne
	@JoinTable(
			name="Usuario_TarjetaCredito", 
			joinColumns = @JoinColumn(name="username"),
			inverseJoinColumns = @JoinColumn(name="numeroTarjeta")
	)
	private Usuario usuario;
	
	public TarjetaDeCredito() {}

    public TarjetaDeCredito(String numeroTarjeta, String nombre, String fechaDeVencimiento, int codigoSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombre = nombre;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.vencida = false;
        this.estado = new EstadoCreada();
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

    public boolean isVencida() {
        return vencida;
    }

    public void setVencida(boolean vencida) {
        this.vencida = vencida;
    }

    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado(){
        return estado;
    }

    public void doAction() {
        estado.doAction(this);
    }
	
	

}
