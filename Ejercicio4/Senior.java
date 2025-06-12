package Ejercicio4;

public class Senior extends Empleado {

    public Senior(String nombre, String departamento, boolean activo, double salario, int experiencia,
            String[] proyectos, double[] bonificaciones) {
        super(nombre, departamento, activo, salario, experiencia,
                CategoriaEmpleado.Senior, proyectos, bonificaciones);
    }

    @Override
    double calcularSalarioConAumentoYBonificacionSegunCategoria() {
        if (!puedeRecibirAumento())
            return getSalario();
        return getSalario() + (getSalario() * 0.15);

    }
}
