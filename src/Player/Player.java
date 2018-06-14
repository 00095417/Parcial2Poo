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
                setRazaE("Heroico");
                break;
        }
    }
    
    public void jugar(){
        
        switch(getRazaE()){
            case "Alquimista":
                raza.getFactory("1").getAlquimista();
                break;
            case "Creacionista":
                System.out.println(getRazaE() + " menu");
                break;
            case "Heroico":
                System.out.println(getRazaE() + " menu");
                break;
        }
    }
    
    public int getVidaEdificioPrincipal(){
        
        switch(getRazaE()){
            case "Alquimista":
                return raza.getFactory("1").getVidaEdificioPrincipal();
            case "Creacionista":
                return 0;
            case "Heroico":
                return 0;
        }
        return 0;
    }
    
    public void setFasejuego(){
        
        switch(getRazaE()){
            case "Alquimista":
                raza.getFactory("1").setFase(this.fase);
                break;
            case "Creacionista":
                break;
            case "Heroico":
                break;
        } 
    }
}
