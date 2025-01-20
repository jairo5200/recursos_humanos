package pt.rh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.rh.modelo.Empleado;
import pt.rh.servicio.EmpleadoServicio;

import java.util.List;

@RestController
//http://localhost:8080/rh-app/
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/empleado/")
    public List<Empleado> listarEmpleados(){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        return empleados;
    }

    @GetMapping("/empleado/{idEmpleado}")
    public Empleado buscarEmpleadoPorId(@PathVariable Integer idEmpleado){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        return empleado;
    }

    @PostMapping("/empleado")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        Empleado elEmpleado = empleadoServicio.guardarEmpleado(empleado);
        return elEmpleado;
    }

    @PutMapping("/empleado/{idEmpleado}")
    public Empleado actualizarEmpleado(@PathVariable Integer idEmpleado, @RequestBody Empleado empleado){
        Empleado elEmpleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        elEmpleado.setNombre(empleado.getNombre());
        elEmpleado.setDepartamento(empleado.getDepartamento());
        elEmpleado.setSueldo(empleado.getSueldo());
        empleadoServicio.guardarEmpleado(elEmpleado);
        return elEmpleado;
    }

    @DeleteMapping("empleado/{id}")
    public void eliminarEmpleado(@PathVariable Integer idEmpleado){
        Empleado elEmpleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado),
        empleadoServicio.eliminarEmpleado(elEmpleado);
    }
}
