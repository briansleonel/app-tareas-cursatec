package gonzalez.brian.AppTareas.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gonzalez.brian.AppTareas.entity.Tarea;
import gonzalez.brian.AppTareas.repository.TareaRepository;
import jakarta.transaction.Transactional;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	// Constructor
	public TareaService() {
	}

	// Methods

	/**
	 * Esta función permite crear una nueva tarea, a partir de datos provistos y
	 * guardarlo en la BD
	 *
	 * @param titulo      titulo de la tarea
	 * @param descripcion descripcion de la tarea
	 * @param fechaLimite fecha límite de la tarea
	 */
	@Transactional
	public void crearTarea(String titulo, String descripcion, LocalDate fechaLimite) throws Exception {
		// Validando título
		if (titulo.isEmpty()) {
			throw new Exception("Debe ingresar un título");
		} else if (titulo.length() <= 5) {
			throw new Exception("El título debe tener más de 5 caracteres");
		}

		// Validando la descripción
		if (titulo.isEmpty()) {
			throw new Exception("Debe ingresar una descripción");
		}

		Tarea tarea = new Tarea(titulo, descripcion, LocalDate.now(), fechaLimite, true);
		tareaRepository.save(tarea);
	}

	/**
	 * Permite buscar todas las tareas almacenadas en la BD
	 * 
	 * @return
	 */
	public List<Tarea> buscarTareas() {
		return tareaRepository.findAll();
	}

	/**
	 * Permite buscara una determinada tarea por su ID en la BD
	 *
	 * @param titulo titulo de la tarea a buscar
	 * @return
	 */
	public Tarea buscarTareaPorID(Integer id) {
		Tarea tareaEncontrada = tareaRepository.getReferenceById(id);

		return tareaEncontrada;
	}

	public String formatearFecha(LocalDate fecha) {
		String formato = "dd/MM/yyyy";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(formato);

		return dateFormatter.format(fecha);
	}
}
