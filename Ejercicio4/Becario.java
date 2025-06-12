package Ejercicio4;

public class Becario extends Empleado {

    public Becario(String nombre, String departamento, boolean activo, double salario, int experiencia,
            String[] proyectos, double[] bonificaciones) {
        super(nombre, departamento, activo, salario, experiencia,
                CategoriaEmpleado.Becario, proyectos, bonificaciones);
    }

    @Override
    boolean puedeRecibirAumento() {
        return false;
    }

    @Override
    double calcularSalarioConAumentoYBonificacionSegunCategoria() {
        if (!puedeRecibirAumento())
            return getSalario();
        return getSalario() + (getSalario() * 0.05);

    }
}
