/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

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
        System.out.println("1. Crear Generador de Mana");
        System.out.println("2. Crear Recolector de Elixir");
        System.out.println("3. Crear Recolector de Cobalto");
        System.out.println("4. Crear Guarnicion de Gremios");
        System.out.println("5. Crear Guarnicion de Magos");
        System.out.println("6. Crear Guarnicion Especial");
        System.out.println("7. Crear Taller de Aerodeslizador");
        System.out.println("8. Crear Taller de Espejos de Fuego");
        System.out.println("0. Volver");
        System.out.println("-------------------");
        
         switch(entrada.nextLine()){
                    case "1":
                        return "Generador de Mana";
                    case "2":
                        return "Recolector de Elixir";
                    case "3":
                        return "Recolector de Cobalto";
                    case "4":
                        return "Guarnicion de Gremios";
                    case "5":
                        return "Guarnicion de Magos";
                    case "6":
                        return "Guarnicion Especial";
                    case "7":
                        return "Taller de Aerodeslizador";
                    case "8":
                        return "Taller de Espejos de Fuego";
                    case "0":
                        return "Volver";
                    default:
                        return null;
                }
    }
    
    public String menuTropas(){
        
        System.out.println("--Tropas a Crear--");
        System.out.println("Ingrese una opcion:");
        System.out.println("1. Crear Gremio");
        System.out.println("2. Crear Magos");
        System.out.println("3. Crear Especial");
        System.out.println("4. Volver");
        System.out.println("------------------");
        
        switch (entrada.nextLine()){
            
            case "1":
                return "Gremio";
            case "2":
                return "Magos";
            case "3":
                return "Especial";
            default:
                return "volver";
        
        }
    }
    
    public String menuVehiculos(){
        
        System.out.println("---Vehiculos a Crear---");
        System.out.println("Ingrese una opcion");
        System.out.println("1. Crear Aerodeslizador");
        System.out.println("2. Crear Espejo de Fuego");
        System.out.println("-----------------------");
        
        switch (entrada.nextLine()){
            case "1":
                return "Aerodeslizador";
            case "2":
                return "Espejo de Fuego";
            default:
                return null;
        } 
    }
    
}
