/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

/**
 *
 * @author Carlos Ruiz
 */
public class Menu {
    
    private static Menu menu;
    
    private Menu(){}
    
    public static Menu getInstance(){
        if (menu == null){
            menu = new Menu();
        }
        return menu;
    }
    
    public void mostrar(){

        System.out.println("----- Menu -----");
        System.out.println("1. Crear edificio");
        System.out.println("2. Atacar");
        System.out.println("3. Defender");
    }
    
}
