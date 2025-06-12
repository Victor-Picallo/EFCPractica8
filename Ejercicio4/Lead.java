package Ejercicio4;

public class Lead extends Empleado {

    public Lead(String nombre, String departamento, boolean activo, double salario, int experiencia,
            String[] proyectos, double[] bonificaciones) {
        super(nombre, departamento, activo, salario, experiencia,
                CategoriaEmpleado.Lead, proyectos, bonificaciones);
    }

    @Override
    double calcularSalarioConAumentoYBonificacionSegunCategoria() {
        if (!puedeRecibirAumento())
            return getSalario();
        return getSalario() + (getSalario() * 0.20);

    }
}
