package gonzalez.brian.AppTareas.services;

import java.time.LocalDate;
import java.util.ArrayList;

import gonzalez.brian.AppTareas.entity.Tarea;

public class TareaService {

    private ArrayList<Tarea> tareas;

    // Constructor
    public TareaService() {
        this.tareas = new ArrayList<Tarea>();
    }


    // Methods

    /**
     * Esta función permite crear una nueva tarea, a partir de datos provistos,
     * y agregarla a la lista de tareas
     *
     * @param titulo      titulo de la tarea
     * @param descripcion descripcion de la tarea
     * @param fechaLimite fecha límite de la tarea
     */
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
        tareas.add(tarea);
    }

    // Getters and setters

    /**
     * Mostrar todas las tareas
     *
     * @return listado de tares
     */
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
}
