package ar.com.tecnosoftware.somos.proyecto.controller;

import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addProyecto(@Valid @RequestBody Proyecto proyecto) {
        proyectoService.add(proyecto);
    }

    @GetMapping (value = "/listar")
    public List<Proyecto> findAllProyecto(){
        return proyectoService.buscarTodos();
    }

    @PutMapping (value = "/baja/proyecto/{id}")
    public void bajaProyecto(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectosEmpleados) {
        proyectoEmpleadoService.darBajaProyectosEmpleados(proyectosEmpleados);
        proyectoService.darBaja(id);
    }

    @PutMapping (value = "/baja/tecnologiaConProyecto/{id}")
    public void bajaTecnologiaDeProyecto(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaTecnologiaDeProyectos(proyectos, id);
    }

}