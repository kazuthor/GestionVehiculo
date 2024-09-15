/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.Vista;
import Modelo.Vehiculo;
import Modelo.Coche;
import Modelo.Camion;
import Modelo.Motocicleta;
import Modelo.Mantenimiento;

import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Controlador {
    private Vista vista;
    private ArrayList<Vehiculo> vehiculos;  // Lista de vehículos registrados

    public Controlador(Vista vista) {
        this.vista = vista;
        vehiculos = new ArrayList<>();
    }

    // Panel Registro
    public void registrarVehiculo() {
        String matricula = vista.getMatricula();
        String marca = vista.getMarca();
        String modelo = vista.getModelo();
        int anio = vista.getAñoFabricacion();
        String tipo = vista.getTipoVehiculo();
        String turbo = vista.getTurbo();

        Vehiculo vehiculo = null;

        switch (tipo) {
            case "Coche":
                vehiculo = new Coche(matricula, marca, modelo, anio, turbo);
                break;
            case "Camion":
                double peso = vista.getPeso();
                vehiculo = new Camion(matricula, marca, modelo, anio, peso);
                break;
            case "Motocicleta":
                int cilindrada = vista.getCilindrada();
                vehiculo = new Motocicleta(matricula, marca, modelo, anio, cilindrada);
                break;
            default:
                JOptionPane.showMessageDialog(vista, "Tipo de vehículo no válido");
                return;
        }

        vehiculos.add(vehiculo);
        JOptionPane.showMessageDialog(vista, "Vehículo registrado exitosamente.");
    }

    public void mostrarVehiculos() {
        StringBuilder resultado = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            resultado.append(vehiculo.getMatricula())
                     .append(" - ").append(vehiculo.getMarca())
                     .append(" ").append(vehiculo.getModelo())
                     .append(" (Año: ").append(vehiculo.getAnioFabricacion()).append(")\n");
        }
        vista.mostrarResultado(resultado.toString(), vista.txtAregistrar);
    }

    // Panel Motocicletas
    public void consultarMotocicleta() {
        StringBuilder resultado = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Motocicleta) {
                resultado.append(vehiculo.getMatricula())
                         .append(": Costo de mantenimiento: ")
                         .append(vehiculo.calcularCostoMantenimiento())
                         .append("\n");
            }
        }
        vista.mostrarResultado(resultado.toString(), vista.txtResulMoto);
    }

    public void realizarMantenimientoMotocicleta() {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Motocicleta) {
                ((Mantenimiento) vehiculo).realizarRevision();
                ((Mantenimiento) vehiculo).cambiarAceite();
            }
        }
        JOptionPane.showMessageDialog(vista, "Mantenimiento realizado a todas las motocicletas.");
    }

    // Panel Camiones
    public void consultarCamion() {
        StringBuilder resultado = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Camion) {
                resultado.append(vehiculo.getMatricula())
                         .append(": Costo de mantenimiento: ")
                         .append(vehiculo.calcularCostoMantenimiento())
                         .append("\n");
            }
        }
        vista.mostrarResultado(resultado.toString(), vista.txtResulCamion);
    }

    public void realizarMantenimientoCamion() {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Camion) {
                ((Mantenimiento) vehiculo).realizarRevision();
                ((Mantenimiento) vehiculo).cambiarAceite();
            }
        }
        JOptionPane.showMessageDialog(vista, "Mantenimiento realizado a todos los camiones.");
    }

    // Panel Coches
    public void consultarCoche() {
        StringBuilder resultado = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Coche) {
                resultado.append(vehiculo.getMatricula())
                         .append(": Costo de mantenimiento: ")
                         .append(vehiculo.calcularCostoMantenimiento())
                         .append("\n");
            }
        }
        vista.mostrarResultado(resultado.toString(), vista.txtResulCoche);
    }

    public void realizarMantenimientoCoche() {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Coche) {
                ((Mantenimiento) vehiculo).realizarRevision();
                ((Mantenimiento) vehiculo).cambiarAceite();
            }
        }
        JOptionPane.showMessageDialog(vista, "Mantenimiento realizado a todos los coches.");
    }

    // Método para obtener el resultado más reciente (si es necesario)
    public String obtenerResultado() {
        // Supongamos que quieres obtener un resultado basado en la última operación
        // Esto es solo un ejemplo; ajusta según tu lógica de negocio
        return "Resultado de la operación más reciente";
    }
}