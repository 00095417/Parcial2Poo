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
    
    private String eleccion, razaE;
    private int fase;
    
    Scanner entrada = new Scanner(System.in);
    FactoryProducerRazas raza = new FactoryProducerRazas();

    public void setFase(int fase) {
        this.fase = fase;
    }

    public int getFase() {
        return fase;
    }

    public String getRazaE() {
        return razaE;
    }

    public void setRazaE(String razaE) {
        this.razaE = razaE;
    }
    
    public void eleccionRaza(){
        
        System.out.println("Elija una raza:\n1. Alquimista\n2. Creacionista\n3. Heroica");
        
        this.eleccion = entrada.nextLine();
        
        switch(this.eleccion){
            case "1":
                setRazaE("Alquimista");
                break;
            case "2":
                setRazaE("Creacionista");
                break;
            case "3":
                setRazaE("heroico");
                break;
        }
    }
    
    public void jugar(){
        System.out.println("Jugando...");
    }
}
