/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Motocicleta extends Vehiculo implements Mantenimiento {
    private int cilindrada;

    public Motocicleta(String matricula, String marca, String modelo, int anioFabricacion, int cilindrada) {
        super(matricula, marca, modelo, anioFabricacion);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoMantenimiento() {
        return cilindrada * (2024 - anioFabricacion) * 0.2; 
    }

    @Override
    public void realizarRevision() {
        System.out.println("Realizando revisión de motocicleta...");
    }

    @Override
    public void cambiarAceite() {
        System.out.println("Cambiando aceite de la motocicleta...");
    }
}
