package Modelo;

public class Deuda {
	private String dni;
	private String entidadFinanciera;
	private double monto;
	private String fecha;
	
	public Deuda(String dni, String entidadFinanciera, double monto, String fecha) {
		this.dni = dni;
		this.entidadFinanciera = entidadFinanciera;
		this.monto = monto;
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEntidadFinanciera() {
		return entidadFinanciera;
	}
	public void setEntidadFinanciera(String entidadFinanciera) {
		this.entidadFinanciera = entidadFinanciera;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
