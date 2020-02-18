package com.example.android_u2_tema4_holafirebase;

public class Usuario {
    private String id;
    private String usuario;
    private String contraseña;


    public Usuario() {
    }

    public Usuario(String id, String usuario, String contraseña) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }


    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
