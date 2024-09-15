/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Coche extends Vehiculo implements Mantenimiento {
    private String turbo;  // Atributo adicional para coches

    public Coche(String matricula, String marca, String modelo, int anioFabricacion, String turbo) {
        super(matricula, marca, modelo, anioFabricacion);
        this.turbo = turbo;
    }

    public String getTurbo() {
        return turbo;
    }

    @Override
    public double calcularCostoMantenimiento() {
        return (2024 - anioFabricacion) * 100 + (turbo.equalsIgnoreCase("si") ? 500 : 0);  // Ejemplo: costo adicional si tiene turbo
    }

    @Override
    public void realizarRevision() {
        System.out.println("Revisión realizada para el coche con matrícula " + matricula);
    }

    @Override
    public void cambiarAceite() {
        System.out.println("Cambio de aceite realizado para el coche con matrícula " + matricula);
    }
}