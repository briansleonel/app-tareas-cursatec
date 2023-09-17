package gonzalez.brian.AppTareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gonzalez.brian.AppTareas.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer>{

}
