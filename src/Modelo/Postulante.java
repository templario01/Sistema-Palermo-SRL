package Modelo;

public class Postulante {
	private String codigo;
	private String nombre;
	private String DNI;
	private String tipoPostulante;
	private String infocorp;
	private int nroRechazos;
	private String grupo;
	private String observaciones;

	public Postulante(String cod,String nom,String dni,String tipo,String info,int recha, String grupo, String observaciones) {
		this.codigo=cod;
		this.nombre=nom;
		this.DNI=dni;
		this.tipoPostulante=tipo;
		this.infocorp=info;
		this.nroRechazos=recha;
		this.grupo = grupo;
		this.observaciones=observaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getTipoPostulante() {
		return tipoPostulante;
	}

	public void setTipoPostulante(String tipoPostulante) {
		this.tipoPostulante = tipoPostulante;
	}

	public String getInfocorp() {
		return infocorp;
	}

	public void setInfocorp(String infocorp) {
		this.infocorp = infocorp;
}
	
	public int getNroRechazos() {
		return nroRechazos;
	}

	public void setNroRechazos(int nroRechazos) {
		this.nroRechazos = nroRechazos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}