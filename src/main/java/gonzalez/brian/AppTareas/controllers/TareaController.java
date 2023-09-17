package gonzalez.brian.AppTareas.controllers;

import java.time.LocalDate;

import gonzalez.brian.AppTareas.entity.Tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import gonzalez.brian.AppTareas.services.TareaService;

@Controller
@RequestMapping(path = "/")
public class TareaController {

	@Autowired
    TareaService tareasService;

    /**
     * Permite mostrar todas las tareas creadas al usuario,
     * así como el formulario para agregar una nueva tarea
     *
     * @param model
     * @return nombre de template
     */
    @GetMapping(path = "/")
    public String tareas(Model model) {
        model.addAttribute("tareas", tareasService.buscarTareas());

        return "crearTareas";
    }

    /**
     * Permite agregar una nueva tarea a la lista de tareas y luego redireccionar a la página principal
     *
     * @param titulo      titulo de la tarea
     * @param descripcion descripcion de la tarea
     * @param mesLimite   mes limite de la tarea
     * @param diaLimite   día limite de la tarea
     * @return
     */
    @PostMapping(path = "/create")
    public String crearTarea(@RequestParam String titulo, @RequestParam String descripcion,
                             @RequestParam int mesLimite, @RequestParam int diaLimite, Model model) {

        try {
            tareasService.crearTarea(titulo, descripcion, LocalDate.of(2023, mesLimite, diaLimite));
            model.addAttribute("exito", "Se ha creado la tarea");
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("tareas", tareasService.buscarTareas());
            return "crearTareas";
        }
    }

    @GetMapping("/mostrar/{id}")
    public String mostrar(@PathVariable Integer id, Model model) {
        Tarea tarea = tareasService.buscarTareaPorID(id);
        String fechaFormateada = tareasService.formatearFecha(tarea.getFechaLimite());


        model.addAttribute("fecha", fechaFormateada);
        model.addAttribute("tarea", tarea);

        return "mostrarTarea";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificarTarea(@PathVariable Integer id, Model model) {
    	Tarea tarea = tareasService.buscarTareaPorID(id);
    	model.addAttribute("tarea", tarea);
    	
        return "modificarTarea";
    }
    
    @PostMapping("/completar/{id}")
    public String completarTarea(@PathVariable Integer id, Model model) {

        return "";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Integer id, Model model) {

        return "";
    }
}
