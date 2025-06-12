package Ejercicio4;

public abstract class Empleado {
    protected String nombre = "Sin nombre";
    protected String departamento;
    protected boolean activo = true;
    protected double salario = 25000.0;
    protected int experiencia = 0;
    protected CategoriaEmpleado categoria = CategoriaEmpleado.Junior;
    protected String[] proyectos;
    protected double[] bonificaciones;

    enum CategoriaEmpleado {
        Becario, Junior, Senior, Lead, Manager
    }

    public Empleado(String nombre, String departamento, boolean activo, double salario, int experiencia,
            Empleado.CategoriaEmpleado categoria, String[] proyectos, double[] bonificaciones) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.activo = activo;
        this.salario = salario;
        this.experiencia = experiencia;
        this.categoria = categoria;
        this.proyectos = proyectos;
        this.bonificaciones = bonificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getSalario() {
        return salario;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public String[] getProyectos() {
        return proyectos;
    }

    public double[] getBonificaciones() {
        return bonificaciones;
    }

    // Determina si el empleado puede recibir aumento
    boolean puedeRecibirAumento() {
        return isActivo() && getExperiencia() >= 2;
    }

    // Calcula el salario con aumento según categoría
    abstract double calcularSalarioConAumentoYBonificacionSegunCategoria();
}
