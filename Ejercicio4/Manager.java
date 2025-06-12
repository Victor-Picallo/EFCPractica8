package Ejercicio4;

public class Manager extends Empleado {

    private int antiguedad = 2;

    public Manager(String nombre, String departamento, int antiguedad, boolean activo, double salario, int experiencia,
            String[] proyectos, double[] bonificaciones) {
        super(nombre, departamento, activo, salario, experiencia,
                CategoriaEmpleado.Manager, proyectos, bonificaciones);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    @Override
    double calcularSalarioConAumentoYBonificacionSegunCategoria() {
        if (!puedeRecibirAumento())
            return getSalario();
        if (getAntiguedad() <= 1)
            return getSalario() + (getSalario() * 0.25);
        return getSalario() + (getSalario() * 0.30);

    }

}
