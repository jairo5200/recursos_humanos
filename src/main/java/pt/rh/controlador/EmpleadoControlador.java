package pt.rh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.rh.excepcion.RecursoNoEncontradoExcepcion;
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

    @GetMapping("/empleados/")
    public List<Empleado> listarEmpleados(){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        return empleados;
    }

    @GetMapping("/empleados/{idEmpleado}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer idEmpleado){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            throw new RecursoNoEncontradoExcepcion("no se encontro el id: "+ idEmpleado);
        }
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/empleados/")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        Empleado elEmpleado = empleadoServicio.guardarEmpleado(empleado);
        return elEmpleado;
    }

    @PutMapping("/empleados/{idEmpleado}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer idEmpleado, @RequestBody Empleado empleado){
        Empleado elEmpleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        if (elEmpleado == null){
            throw  new RecursoNoEncontradoExcepcion("el id recibido no existe: "+idEmpleado);
        }
        elEmpleado.setNombre(empleado.getNombre());
        elEmpleado.setDepartamento(empleado.getDepartamento());
        elEmpleado.setSueldo(empleado.getSueldo());
        empleadoServicio.guardarEmpleado(elEmpleado);
        return ResponseEntity.ok(elEmpleado);
    }

    @DeleteMapping("empleados/{id}")
    public void eliminarEmpleado(@PathVariable Integer idEmpleado){
        Empleado elEmpleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        empleadoServicio.eliminarEmpleado(elEmpleado);
    }
}
