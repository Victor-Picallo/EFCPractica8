package Ejercicio2y3;

public class AnalisisVentas {
    double[] ventas = { 120.5, 85.0, 200.3, 95.8, 150.0, 300.2, 85.0, 120.5, 200.3, 110.7, 120.5, 175.9, 85.0, 180.4 };

    // Verifica si existe alguna venta superior a 100€
    // Elimino la variable innecesaria y hago que devuelve true si encuentra la
    // venta o false en caso contrario
    boolean existeVentaAlta() {
        for (double venta : ventas) {
            if (venta > 100.0) {
                return true;
            }
        }
        return false;
    }

    // Encuentra la venta de menor importe
    // Simplemente anadi una throw exception para evitar array nulo o vacio
    double ventaMinima() {
        if (ventas == null || ventas.length == 0) {
            throw new IllegalArgumentException("Array vacio o nulo");
        }
        double minima = ventas[0];
        for (double venta : ventas) {
            if (venta < minima) {
                minima = venta;
            }
        }
        return minima;
    }

    // Cuenta ventas que superan los 150€
    // Simplemente anadi una throe expcetion para evitar array nulo o vacio
    int contarVentasAltas() {
        if (ventas == null || ventas.length == 0) {
            throw new IllegalArgumentException("Array vacio o nulo");
        }
        int contador = 0;
        for (double venta : ventas) {
            if (venta > 150.0) {
                contador++;
            }
        }
        return contador;
    }

    // Calcula el promedio de ventas
    // Simplemente anadi una throw exception para evitar array nulo o vacio
    double promedioVentas() {
        if (ventas == null || ventas.length == 0) {
            throw new IllegalArgumentException("Array vacio o nulo");
        }
        double suma = 0;
        for (double venta : ventas) {
            suma += venta;
        }
        return suma / ventas.length;
    }

    // Calcula desviaciones respecto al promedio
    // Simplemente anadi una throe exception para evitar array nulo o vacio
    double[] desviacionesPromedio() {
        if (ventas == null || ventas.length == 0) {
            throw new IllegalArgumentException("Array vacio o nulo");
        }
        double[] resultado = new double[ventas.length];
        double promedio = promedioVentas();
        for (int i = 0; i < ventas.length; i++) {
            resultado[i] = ventas[i] - promedio;
        }
        return resultado;
    }

    // Encuentra la venta más repetida
    // Simplemente anadi una throe exception para evitar array nulo o vacio
    double ventaMasRepetida() {
        if (ventas == null || ventas.length == 0) {
            throw new IllegalArgumentException("Array vacio o nulo");
        }
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
    // Elimino la variable innecesaria y refactorizo freq1 a freq
    // Cree una variable sumaVentas
    // Sustitui el bucle for por un for each
    // Hice el calculo resultado fuera del bucle
    // Cree otra variable ventaTamano para calcular una sola vez el tamano de las
    // ventas
    double calculoComplejo() {
        if (ventas == null || ventas.length == 0) {
            throw new IllegalArgumentException("Array vacio o nulo");
        }
        double freq = ventaMasRepetida();
        double sumaVentas = 0;
        double promedio = promedioVentas();
        int ventaTamano = ventas.length;
        for (double venta : ventas) {
            sumaVentas += venta;
        }
        double resultado = sumaVentas + (freq + freq + promedio) * ventaTamano;
        return resultado / 100;
    }
}
