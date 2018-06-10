/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlosruiz.s.world;

import Player.Player;
/**
 *
 * @author Carlos Ruiz
 */
public class CarlosRuizSWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numFase = 0;
        Player player1 = new Player();
        Player player2 = new Player();
        
        player1.eleccionRaza();
        player2.eleccionRaza();
        
        player1.setFase(0);
        player2.setFase(0);
        
        while(player1.getFase()<=2&&player2.getFase()<=2){
            
            System.out.println("Player1: ");
            player1.jugar();
            System.out.println("Player2: ");
            player2.jugar();
            
            player1.setFase(numFase+=1);
            player2.setFase(numFase);
            
            System.out.println("------Fin fase " + numFase + "------");
        }
    }   
}
