package Ejercicio4;

public class Junior extends Empleado {

    public Junior(String nombre, String departamento, boolean activo, double salario, int experiencia,
            String[] proyectos, double[] bonificaciones) {
        super(nombre, departamento, activo, salario, experiencia,
                CategoriaEmpleado.Junior, proyectos, bonificaciones);
    }

    @Override
    double calcularSalarioConAumentoYBonificacionSegunCategoria() {
        if (!puedeRecibirAumento())
            return getSalario();
        return getSalario() + (getSalario() * 0.10);
    }

}
