package gonzalez.brian.AppTareas.entity;

import java.time.LocalDate;

public class Tarea {
	// Atributos
	private String titulo;
	private String descripcion;
	private LocalDate fechaCreacion;
	private LocalDate fechaLimite;
	private boolean activa;

	// Constructors
	public Tarea() {
		super();
	}

	public Tarea(String titulo, String descripcion, LocalDate fechaCreacion, LocalDate fechaLimite, boolean activa) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaLimite = fechaLimite;
		this.activa = activa;
	}

	// Getters and setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
