/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Factory.FactoryProducerRazas;
import java.util.Scanner;

/**
 *
 * @author Carlos Ruiz
 */
public class Player {
    
    private String eleccion;
    private int fase;
    
    Scanner entrada = new Scanner(System.in);
    FactoryProducerRazas raza = new FactoryProducerRazas();

    public void setFase(int fase) {
        this.fase = fase;
    }

    public int getFase() {
        return fase;
    }
    
    public void eleccionRaza(){
        
        this.eleccion = entrada.nextLine();
        
        switch(this.eleccion){
            case "1":
                System.out.println(raza.getFactory(this.eleccion).getAlquimista("").alquimista("alquimista"));
                break;
            case "2":
                System.out.println(raza.getFactory(this.eleccion).getCreacionista("").creacionista("creacionista"));
                break;
            case "3":
                System.out.println(raza.getFactory(this.eleccion).getHeroica("").heroica("heroico"));
                break;
        }
    }
    
    public void jugar(){
        System.out.println("Jugando...");
    }
}
