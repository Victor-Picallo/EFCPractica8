package Ejercicio1;

import java.util.ArrayList;
/**
 * Copyright (c) 2025, Victor, todos los derechos reservados.
 */


/**
 * Clase sobre una tienda
 * @author Victor
 * @version 1.0
 */
public class Tienda {
    /**
     * Un ArrayList de productos
     */
    private ArrayList<Producto> productos = new ArrayList<>();
    
    /**
     * Metodo para agregar un producto a la lista
     * @param producto que queremos agregar a la lista
     * O(1)
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    /**
     * Metodo para eliminar productos segun su codigo
     * @param codigo del producto que queremos eliminar
     * @return true o false segun se haya podido eliminar o no
     * O(n)
     */
    public boolean eliminarProducto(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para buscar un producto en la lista mediante el codigo
     * @param codigo del prodcuto que queremos encontrar
     * @return el producto o null si no hay ningun producto asociado a ese codigo
     * O(n)
     */
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Metodo para calcular el Valor del inventario
     * @return el valor total del inventario
     * O(n)
     */
    public double calcularValorInventario() {
        double valorTotal = 0;
        for (Producto p : productos) {
            valorTotal += p.getPrecio() * p.getStock();
        }
        return valorTotal;
    }
    
    /**
     * Metodo para contar productos caros 
     * @param precioMinimo precio minimo para considerarse caro
     * @return el numero de productos caros que hay
     * O(n)
     */
    public int contarProductosCaros(double precioMinimo) {
        int contador = 0;
        for (Producto p : productos) {
            if (p.getPrecio() >= precioMinimo) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Meotodo para listar los productos 
     * @return lista con los productos
     * O(n)
     * @deprecated Este metodo esta obsoleto
     */
    public String listarProductosBasico() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.getNombre()).append(" - Precio: ").append(p.getPrecio()).append("€\n");
        }
        return sb.toString();
    }
    
    /**
     * Metodo para obtener el resumen del inventario
     * @return el resumen del inventario
     * O(n)
     */
    public String obtenerResumen() {
        return "Total productos: " + productos.size() + 
               ", Valor inventario: " + calcularValorInventario() + "€";
    }
}
