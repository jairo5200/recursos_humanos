package pt.rh.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.rh.modelo.Empleado;
import pt.rh.repositorio.EmpleadoRepositorio;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado elEmpleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
        return elEmpleado;
    }

    @Override
    public Empleado guardarEmpleado(Empleado elEmpleado) {
        return  empleadoRepositorio.save(elEmpleado);
    }

    @Override
    public void eliminarEmpleado(Empleado elEmpleado) {
        empleadoRepositorio.delete(elEmpleado);
    }
}
