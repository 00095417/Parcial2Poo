/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creacionista;

import java.util.Scanner;

/**
 *
 * @author Carlos Ruiz
 */
public class Menu {
    
    private static Menu menu;
    private Scanner entrada = new Scanner(System.in);
    
    private Menu(){}
    
    public static Menu getInstance(){
        if (menu == null){
            menu = new Menu();
        }
        return menu;
    }
    
    public void menuPrincipal(){

        System.out.println("----- Menu -----");
        System.out.println("Ingrese una opcion:");
        System.out.println("1. Crear edificio");
        System.out.println("2. Crear tropas");
        System.out.println("3. Crear vehiculos");
        System.out.println("4. Atacar");
        System.out.println("5. Defender");
        System.out.println("6. Recolectar");
        System.out.println("7. Terminar turno");
        System.out.println("-------------------");
    }
    
    public String menuEdificios(){
    
        System.out.println("--Edificios a crear--");
        System.out.println("Ingrese una opcion:");
        System.out.println("1. Crear Generador de Granito");
        System.out.println("2. Crear Recolector de Ether");
        System.out.println("3. Crear Recolector de Carbono");
        System.out.println("4. Crear Guarnicion de Incursion");
        System.out.println("5. Crear Guarnicion de Reclutas");
        System.out.println("6. Crear Guarnicion Especial");
        System.out.println("7. Crear Taller de Demoledor");
        System.out.println("8. Crear Taller de Helicopteros");
        System.out.println("0. Volver");
        System.out.println("-------------------");
        
         switch(entrada.nextLine()){
                    case "1":
                        return "Generador de Granito";
                    case "2":
                        return "Recolector de Ether";
                    case "3":
                        return "Recolector de Carbono";
                    case "4":
                        return "Guarnicion de Incursion";
                    case "5":
                        return "Guarnicion de Reclutas";
                    case "6":
                        return "Guarnicion Especial";
                    case "7":
                        return "Taller de Demoledor";
                    case "8":
                        return "Taller de Helicopteros";
                    case "0":
                        return "Volver";
                    default:
                        return null;
                }
    }
    
    public String menuTropas(){
        
        System.out.println("--Tropas a Crear--");
        System.out.println("Ingrese una opcion:");
        System.out.println("1. Crear Incursion");
        System.out.println("2. Crear Recluta");
        System.out.println("3. Crear Especial");
        System.out.println("4. Volver");
        System.out.println("------------------");
        
        switch (entrada.nextLine()){
            
            case "1":
                return "Incursion";
            case "2":
                return "Recluta";
            case "3":
                return "Especial";
            default:
                return "volver";
        
        }
    }
    
    public String menuVehiculos(){
        
        System.out.println("---Vehiculos a Crear---");
        System.out.println("Ingrese una opcion");
        System.out.println("1. Crear Demoledor");
        System.out.println("2. Crear Helicoptero");
        System.out.println("-----------------------");
        
        switch (entrada.nextLine()){
            case "1":
                return "Demoledor";
            case "2":
                return "Helicoptero";
            default:
                return null;
        } 
    }
    
}
