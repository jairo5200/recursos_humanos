package pt.rh.servicio;

import pt.rh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    public Empleado guardarEmpleado(Empleado elEmpleado);

    public void eliminarEmpleado(Empleado elEmpleado);
}
