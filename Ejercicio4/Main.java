package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        
        String[] proyectos = { "Proyecto A", "Proyecto B" };
        double[] bonificaciones = { 500.0, 300.0 };

        Empleado becario = new Becario(
                "Ana", "Desarrollo", true, 12000.0, 1,
                proyectos, bonificaciones);

        Empleado junior = new Junior(
                "Carlos", "QA", true, 18000.0, 3,
                proyectos, bonificaciones);

        Empleado senior = new Senior(
                "Lucía", "Backend", true, 25000.0, 6,
                proyectos, bonificaciones);

        Empleado lead = new Lead(
                "Pedro", "Frontend", true, 30000.0, 8,
                proyectos, bonificaciones);

        Empleado manager = new Manager(
                "Luis", "IT", 3, true, 40000.0, 5,
                proyectos, bonificaciones);

        System.out.println("Salario final del Becario: " +
                becario.calcularSalarioConAumentoYBonificacionSegunCategoria());

        System.out.println("Salario final del Junior: " +
                junior.calcularSalarioConAumentoYBonificacionSegunCategoria());

        System.out.println("Salario final del Senior: " +
                senior.calcularSalarioConAumentoYBonificacionSegunCategoria());

        System.out.println("Salario final del Lead: " +
                lead.calcularSalarioConAumentoYBonificacionSegunCategoria());

        System.out.println("Salario final del Manager: " +
                manager.calcularSalarioConAumentoYBonificacionSegunCategoria());
    }
}
