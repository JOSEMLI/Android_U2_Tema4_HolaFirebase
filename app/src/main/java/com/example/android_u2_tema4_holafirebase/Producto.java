package com.example.android_u2_tema4_holafirebase;

public class Producto {

  private String id;
  private String nombre;
  private Double precio;


  public Producto() {
  }

  public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }


  public Producto(String id, String nombre, double precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}
