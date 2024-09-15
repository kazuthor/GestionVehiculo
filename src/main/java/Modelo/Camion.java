/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Camion extends Vehiculo implements Mantenimiento {
    private double peso;

    public Camion(String matricula, String marca, String modelo, int anioFabricacion, double peso) {
        super(matricula, marca, modelo, anioFabricacion);
        this.peso = peso;
    }

    @Override
    public double calcularCostoMantenimiento() {
        return peso * (2024 - anioFabricacion) * 0.5; 
    }

    @Override
    public void realizarRevision() {
        System.out.println("Realizando revisión de camión...");
    }

    @Override
    public void cambiarAceite() {
        System.out.println("Cambiando aceite del camión...");
    }
}