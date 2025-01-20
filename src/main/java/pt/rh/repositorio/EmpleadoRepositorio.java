package pt.rh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.rh.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
