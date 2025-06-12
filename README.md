EJERCICIO 1 - Documentación y Complejidad Algorítmica (25 puntos)
- Dadas las clases Producto y Tienda, realiza la documentación JavaDoc completa y el análisis de complejidad algorítmica únicamente de la clase Tienda. Además, indica que el método listarProductosBasico está deprecado.
```
import java.util.ArrayList;
import java.util.List;

class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
```
```
public class Tienda {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public boolean eliminarProducto(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
    
    public double calcularValorInventario() {
        double valorTotal = 0;
        for (Producto p : productos) {
            valorTotal += p.getPrecio() * p.getStock();
        }
        return valorTotal;
    }
    
    public int contarProductosCaros(double precioMinimo) {
        int contador = 0;
        for (Producto p : productos) {
            if (p.getPrecio() >= precioMinimo) {
                contador++;
            }
        }
        return contador;
    }
    
    public String listarProductosBasico() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.getNombre()).append(" - Precio: ").append(p.getPrecio()).append("€\n");
        }
        return sb.toString();
    }
    
    public String obtenerResumen() {
        return "Total productos: " + productos.size() + 
               ", Valor inventario: " + calcularValorInventario() + "€";
    }
}
```

EJERCICIO 2 - Optimización de Código (30 puntos)
- Dada la clase AnalisisVentas, optimiza todos sus métodos e indica qué cambios específicos has realizado y por qué mejoran el rendimiento.
```
import java.util.ArrayList;
import java.util.List;

public class AnalisisVentas {
    double[] ventas = {120.5, 85.0, 200.3, 95.8, 150.0, 300.2, 85.0, 120.5, 200.3, 110.7, 120.5, 175.9, 85.0, 180.4};
    
    // Verifica si existe alguna venta superior a 100€
    boolean existeVentaAlta() {
        boolean encontrada = false;
        for (double venta : ventas) {
            if (venta > 100.0) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }
    
    // Encuentra la venta de menor importe
    double ventaMinima() {
        double minima = ventas[0];
        for (double venta : ventas) {
            if (venta < minima) {
                minima = venta;
            }
        }
        return minima;
    }
    
    // Cuenta ventas que superan los 150€
    int contarVentasAltas() {
        int contador = 0;
        for (double venta : ventas) {
            if (venta > 150.0) {
                contador++;
            }
        }
        return contador;
    }
    
    // Calcula el promedio de ventas
    double promedioVentas() {
        double suma = 0;
        for (double venta : ventas) {
            suma += venta;
        }
        return suma / ventas.length;
    }
    
    // Calcula desviaciones respecto al promedio
    double[] desviacionesPromedio() {
        double promedio = promedioVentas();
        double[] resultado = new double[ventas.length];
        for (int i = 0; i < ventas.length; i++) {
            resultado[i] = ventas[i] - promedio;
        }
        return resultado;
    }
    
    // Encuentra la venta más repetida
    double ventaMasRepetida() {
        int maxRepeticiones = 0;
        double ventaFrec = ventas[0];
        for (int i = 0; i < ventas.length; i++) {
            int repeticiones = 0;
            for (int j = 0; j < ventas.length; j++) {
                if (ventas[i] == ventas[j]) {
                    repeticiones++;
                }
            }
            if (repeticiones > maxRepeticiones) {
                ventaFrec = ventas[i];
                maxRepeticiones = repeticiones;
            }
        }
        return ventaFrec;
    }
    
    // Análisis con múltiples ineficiencias
    double calculoComplejo() {
        double freq1 = ventaMasRepetida();
        double freq2 = ventaMasRepetida();
        double resultado = 0;
        double promedio = promedioVentas();
        for (int i = 0; i < ventas.length; i++) {
            resultado += ventas[i] + freq1 + freq2 + promedio;
        }
        return resultado / 100;
    }
}
```

EJERCICIO 3 - Testing con JUnit (20 puntos)
- Crea los tests unitarios necesarios para los métodos ventaMinima, ventaMasRepetida y contarVentasAltas de la clase AnalisisVentas (usa la versión original, no la optimizada). Los tests deben cubrir:
  - Casos normales
  - Casos límite
  - Casos excepcionales
- Incluye al menos 3 tests por cada método.

EJERCICIO 4 - Refactorización (25 puntos)
- Refactoriza la siguiente clase Empleado aplicando buenas prácticas de programación:
```
public class Empleado {
    String nombre = "Sin nombre";
    String departamento;
    boolean activo = true;
    double salario = 25000.0;
    int experiencia = 0;
    CategoriaEmpleado categoria = CategoriaEmpleado.Junior;
    
    String[] proyectos;
    double[] bonificaciones;
    
    int antiguedad = 0; // años en la empresa
    
    enum CategoriaEmpleado {
        Becario, Junior, Senior, Lead, Manager
    }
    
    // Determina si el empleado puede recibir aumento
    boolean puedeRecibirAumento() {
        if (experiencia <= 2 || experiencia == 2) {
            if (!activo) {
                return false;
            } else {
                return false;
            }
        } else {
            if (!activo) {
                return false;
            } else {
                return true;
            }
        }
    }
    
    // Calcula el salario con aumento según categoría
    double calcularSalarioConAumentoYBonificacionSegunCategoria() {
        switch (categoria) {
            case Becario:
                if (!puedeRecibirAumento()) return salario;
                return salario + (salario * 0.05);
            case Junior:
                if (!puedeRecibirAumento()) return salario;
                return salario + (salario * 0.10);
            case Senior:
                if (!puedeRecibirAumento()) return salario;
                return salario + (salario * 0.15);
            case Lead:
                if (!puedeRecibirAumento()) return salario;
                return salario + (salario * 0.20);
            case Manager:
                if (!puedeRecibirAumento()) return salario;
                if (antiguedad <= 1) return salario + (salario * 0.25);
                return salario + (salario * 0.30);
            default:
                return salario;
        }
    }
    
    public static void main(String[] args) {
        Empleado e = new Empleado();
        e.categoria = CategoriaEmpleado.Senior;
        e.experiencia = 5;
        e.salario = 35000;
        System.out.println("Salario final: " + 
            e.calcularSalarioConAumentoYBonificacionSegunCategoria());
    }
}
```
