package gonzalez.brian.AppTareas.services;

import java.time.LocalDate;
import java.util.ArrayList;

import gonzalez.brian.AppTareas.entity.Tarea;

public class TareaService {
	
	private ArrayList<Tarea> tareas ;
	
	// Constructor
	public TareaService() {
		this.tareas = new ArrayList<Tarea>();
	}


	// Methods

	/**
	 * Esta función permite crear una nueva tarea, a partir de datos provistos,
	 * y agregarla a la lista de tareas
	 * @param titulo titulo de la tarea
	 * @param descripcion descripcion de la tarea
	 * @param fechaLimite fecha límite de la tarea
	 */
	public void crearTarea(String titulo, String descripcion, LocalDate fechaLimite) {
		Tarea tarea = new Tarea(titulo, descripcion, LocalDate.now(), fechaLimite, true);
		tareas.add(tarea);
	}

	// Getters and setters

	/**
	 * Mostrar todas las tareas
	 * @return listado de tares
	 */
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
}
