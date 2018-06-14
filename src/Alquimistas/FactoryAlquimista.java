/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

import Creacionista.Creacionista;
import Factory.AbstracFactoryRazas;
import Heroica.Heroica;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryAlquimista implements AbstracFactoryRazas {
    
    private final Menu menuAlquimista = Menu.getInstance();
    private Edificio edificioPrincipal;
    private Edificio edificioRecurso = new Edificio();
    private Edificio edificioTropas = new Edificio();
    private Edificio edificioVehiculo = new Edificio();
    private ArrayList<Edificio> listaEdificioRecurso = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioGuarnicion = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioTalleres = new ArrayList<>();
    private boolean continuar = true;
    Scanner entrada = new Scanner(System.in);
    
    @Override
    public void getAlquimista() {
        if (edificioPrincipal == null)
        {
            setEdificioPrincipal();
        }
        menus();
        
    }

    @Override
    public Heroica getHeroica(String type) {
        return null;
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return null;
    }
    
    //Creando el Centro de Mando
    public void setEdificioPrincipal(){
        edificioPrincipal = new Edificio();
        edificioPrincipal.EdificioP("Abadia","Mana","Elixir","Cobalto", 
                                    500, 2000, 1000, 1000, 100, 100, 100, 10000, 5000, 5000, 1);
    }
    //Creando los edificios que te generan recursos
    public void setEdificioRecurso(String recurso){
        
        switch(recurso)
        {
            
            case "mana":
                edificioRecurso.EdificioR("Generador de Mana", "Mana", 1000, 0, 0, 50, 50, 500, 3, 100);
                break;
                
            case "elixir":
                edificioRecurso.EdificioR("Recolector de Elixir", "Elixir", 1000, 0, 50, 0, 50, 500, 3, 100);
                break;
                
            case "cobalto":
                edificioRecurso.EdificioR("Recolector de Cobalto", "Cobalto", 1000, 0, 50, 50, 0, 500, 3, 100);
                break;                      
        }
    }
    //Creando las Guarniciones que crearan las tropas
    public void setEdificioTropa(String guarnicio){
        
        TropasAlquimistas tropa = new TropasAlquimistas();
        
        switch(guarnicio)
        {
            case "gremio":
                tropa.TropasAlquimistas("Gremio", 100, 35, 25, 10, 10, 5,0);
                edificioTropas.EdificioT("Guarnicion de Gremios", tropa, 150, 75, 75, 75, 2);
                break;
            case "magos":
                tropa.TropasAlquimistas("Magos", 10, 7, 6, 5, 5, 0,0);
                edificioTropas.EdificioT("Guarnicion de Magos", tropa, 100, 50, 50, 50, 5);
                break;
            case "especial":
                tropa.TropasAlquimistas("Chaman", 100, 50, 50, 0, 50, 50,0);
                edificioTropas.EdificioT("Guarnicion Especial", tropa, 100, 75, 75, 75, 1);
                break;
        }
    }
    //Creando los Talleres que crearan los vehiculos
    public void setEdificioVehiculo(String taller){
    
        VehiculosAlquimistas vehiculo = new VehiculosAlquimistas();
        
        switch (taller)
        {
            case "aerodeslizador":
                vehiculo.VehiculosAlquimistas("Aerodeslizador", 100, 30, 0, 25, 25,0);
                edificioVehiculo.EdificioV("Taller de Aerodeslizadores", vehiculo, 100, 100, 100, 100, 1);
                break;
            case "espejo de fuego":
                vehiculo.VehiculosAlquimistas("Espejo de Fuego", 100, 30, 0, 25, 25,0);
                edificioVehiculo.EdificioV("Taller de Espejos de Fuego", vehiculo, 100, 100, 100, 100, 1);
                break;
        }
    }
    //Mostrando los elementos que posee la raza alquimista
    public void mostrarRaza(){
    
        System.out.println("------Raza Alquimista------");
        System.out.println("---------Recursos----------");
        System.out.println(edificioPrincipal.getMana() + ": " + edificioPrincipal.getCantidadMana());
        System.out.println(edificioPrincipal.getElixir() + ": " + edificioPrincipal.getCantidadElixir());
        System.out.println(edificioPrincipal.getCobalto() + ": " + edificioPrincipal.getCantidadCobalto());
        System.out.println("---------Edificios---------");
        if (listaEdificioRecurso.isEmpty())
        {
            System.out.println("No hay edificios que generen recursos");
        }
        else{
            for (Edificio edificioR: listaEdificioRecurso)
            {
                if("Generador de Mana".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadMana());
                }
                if("Recolector de Elixir".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadElixir());
                }
                if("Recolector de Cobalto".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadCobalto());
                }   
            }
        }
        if (listaEdificioGuarnicion.isEmpty())
        {
            System.out.println("No hay guarniciones");
        }
        else{
            int pos = 0;
            for (Edificio g:listaEdificioGuarnicion)
            {
                System.out.println((pos +=1) +". "+g.getNombre()); 
            }
        }
        if (listaEdificioTalleres.isEmpty())
        {
            System.out.println("No hay talleres");
        }
        else{
            int pos = 0;
            for (Edificio edificioT: listaEdificioTalleres)
            {
                System.out.println((pos += 1) +". "+edificioT.getNombre());
            }
        }
        System.out.println("---------Tropas------------");
        if (listaEdificioGuarnicion.isEmpty())
        {
            System.out.println("No hay guarniciones");
        }
        else{
            for (Edificio g:listaEdificioGuarnicion)
            {
                System.out.println(g.getTropa().getNombreTropa() +" "+ g.getTropa().getCantidad()); 
            }
        }
        if (listaEdificioTalleres.isEmpty())
        {
            System.out.println("No hay talleres");
        }
        else{
            for (Edificio t:listaEdificioTalleres)
            {
                System.out.println(t.getVehiculo().getNombreVehiculo()+" "+t.getVehiculo().getCantidad());
            }
        }
    
    }
    //Mostrando las acciones que el jugador puede realizar atravez de una secuencia de menús
    public void menus(){
        
        while(continuar)
        {
            mostrarRaza();
            menuAlquimista.menuPrincipal();
            
             switch(entrada.nextLine())
            {
                //Menú que te muestra los edificios que se pueden crear y las condiciones para poder hacerlo
                case "1":
                    switch (menuAlquimista.menuEdificios())
                    {
                        case "Generador de Mana":
                            setEdificioRecurso("mana");
                            if (edificioPrincipal.getCantidadElixir()>edificioRecurso.getCosto2()&&
                                edificioPrincipal.getCantidadCobalto()>edificioRecurso.getCosto3())
                            {    
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()-edificioRecurso.getCosto2());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()-edificioRecurso.getCosto3());
                                listaEdificioRecurso.add(edificioRecurso);
                                edificioRecurso = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Recolector de Elixir":
                            setEdificioRecurso("elixir");
                            if (edificioPrincipal.getCantidadMana()>edificioRecurso.getCosto1()&&
                                edificioPrincipal.getCantidadCobalto()>edificioRecurso.getCosto3())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()-edificioRecurso.getCosto1());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()-edificioRecurso.getCosto3());
                                listaEdificioRecurso.add(edificioRecurso);
                                edificioRecurso = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Recolector de Cobalto":
                            setEdificioRecurso("cobalto");
                            if (edificioPrincipal.getCantidadMana()>edificioRecurso.getCosto1()&&
                                edificioPrincipal.getCantidadElixir()>edificioRecurso.getCosto2())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()-edificioRecurso.getCosto1());
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()-edificioRecurso.getCosto2());
                                listaEdificioRecurso.add(edificioRecurso);
                                edificioRecurso = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Guarnicion de Gremios":
                            setEdificioTropa("gremio");
                            if (edificioPrincipal.getCantidadMana()>edificioTropas.getCosto1()&&
                                edificioPrincipal.getCantidadElixir()>edificioTropas.getCosto2()&&
                                edificioPrincipal.getCantidadCobalto()>edificioTropas.getCosto3())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioTropas.getCosto1());
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioTropas.getCosto2());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioTropas.getCosto3());
                                listaEdificioGuarnicion.add(edificioTropas);
                                edificioTropas = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Guarnicion de Magos":
                             setEdificioTropa("magos");
                            if (edificioPrincipal.getCantidadMana()>edificioTropas.getCosto1()&&
                                edificioPrincipal.getCantidadElixir()>edificioTropas.getCosto2()&&
                                edificioPrincipal.getCantidadCobalto()>edificioTropas.getCosto3())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioTropas.getCosto1());
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioTropas.getCosto2());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioTropas.getCosto3());
                                listaEdificioGuarnicion.add(edificioTropas);
                                edificioTropas = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Guarnicion Especial":
                            System.out.println("menu tropas 2");
                             setEdificioTropa("especial");
                             System.out.println("menu tropas 3");
                            if (edificioPrincipal.getCantidadMana()>edificioTropas.getCosto1()&&
                                edificioPrincipal.getCantidadElixir()>edificioTropas.getCosto2()&&
                                edificioPrincipal.getCantidadCobalto()>edificioTropas.getCosto3())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioTropas.getCosto1());
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioTropas.getCosto2());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioTropas.getCosto3());
                                listaEdificioGuarnicion.add(edificioTropas);
                                edificioTropas = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Taller de Aerodeslizador":
                             setEdificioVehiculo("aerodeslizador");
                            if (edificioPrincipal.getCantidadMana()>edificioVehiculo.getCosto1()&&
                                edificioPrincipal.getCantidadElixir()>edificioVehiculo.getCosto2()&&
                                edificioPrincipal.getCantidadCobalto()>edificioVehiculo.getCosto3())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioVehiculo.getCosto1());
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioVehiculo.getCosto2());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioVehiculo.getCosto3());
                                listaEdificioTalleres.add(edificioVehiculo);
                                edificioVehiculo = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;
                        case "Taller de Espejos de Fuego":
                            setEdificioVehiculo("espejo de fuego");
                            if (edificioPrincipal.getCantidadMana()>edificioVehiculo.getCosto1()&&
                                edificioPrincipal.getCantidadElixir()>edificioVehiculo.getCosto2()&&
                                edificioPrincipal.getCantidadCobalto()>edificioVehiculo.getCosto3())
                            {
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioVehiculo.getCosto1());
                                edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioVehiculo.getCosto2());
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioVehiculo.getCosto3());
                                listaEdificioTalleres.add(edificioVehiculo);
                                edificioVehiculo = new Edificio();
                            }
                            else{
                                System.out.println("Recurso Insuficiente");
                            }
                            break;      
                    }
                    break;
                //Menú que te muestra las tropas a crear y las condiciones para hacerlo
                case "2":
                    switch(menuAlquimista.menuTropas())
                    {
                        case "Gremio":
                            if (listaEdificioGuarnicion.isEmpty())
                            {
                                System.out.println("No dispone de Guarniciones");
                                break;
                            }
                            else{
                                System.out.println("Elija que guarnicion usar:");
                                int index = entrada.nextInt();

                                if ("Guarnicion de Gremios".equals(listaEdificioGuarnicion.get(index-1).getNombre())&&index>0)
                                {
                                    TropasAlquimistas tropaAux = listaEdificioGuarnicion.get(index-1).getTropa();
                                    System.out.println("Cantidad a adiestrar (max 5):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadMana()>(tropaAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadElixir()>(tropaAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCobalto()>(tropaAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=5)
                                    {
                                        edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- tropaAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- tropaAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- tropaAux.getCostoR3()*cantidad);

                                        listaEdificioGuarnicion.get(index-1).getTropa().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else{
                                    System.out.println("Error de Guarnicion");
                                }
                                break;
                            }
                        case "Magos":
                            if (listaEdificioGuarnicion.isEmpty())
                            {
                                System.out.println("No dispone de Guarniciones");
                                break;
                            }
                            else{
                                System.out.println("Elija que guarnicion usar:");
                                int index = entrada.nextInt();

                                if ("Guarnicion de Magos".equals(listaEdificioGuarnicion.get(index-1).getNombre())&&index>0)
                                {
                                    TropasAlquimistas tropaAux = listaEdificioGuarnicion.get(index-1).getTropa();
                                    System.out.println("Cantidad a adiestrar (max 10):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadMana()>(tropaAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadElixir()>(tropaAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCobalto()>(tropaAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=10)
                                    {
                                        edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- tropaAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- tropaAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- tropaAux.getCostoR3()*cantidad);

                                        listaEdificioGuarnicion.get(index-1).getTropa().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else{
                                    System.out.println("Error de guarnicion");
                                }
                                break;
                            }
                        case "Especial":
                            if (listaEdificioGuarnicion.isEmpty())
                            {
                                System.out.println("No dispones de la Guarnicion");
                                break;
                            }
                            else{
                                System.out.println("Elija que guarnicion usar:");
                                int index = entrada.nextInt();

                                if ("Guarnicion Especial".equals(listaEdificioGuarnicion.get(index-1).getNombre())&&index>0)
                                {
                                    TropasAlquimistas tropaAux = listaEdificioGuarnicion.get(index-1).getTropa();
                                    System.out.println("Cantidad a adiestrar (max 1):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadMana()>(tropaAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadElixir()>(tropaAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCobalto()>(tropaAux.getCostoR3()*cantidad)&& cantidad==1)
                                    {
                                        edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- tropaAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- tropaAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- tropaAux.getCostoR3()*cantidad);

                                        listaEdificioGuarnicion.get(index-1).getTropa().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else{
                                    System.out.println("No dispone de la Guarnicion Especial");
                                }
                                break;
                            }
                        case "volver":
                            break;
                    }
                    break;
                case "3":
                    switch(menuAlquimista.menuVehiculos()){
                        case "Aerodeslizador":
                            if (listaEdificioTalleres.isEmpty())
                            {
                            System.out.println("No dispone de Talleres");
                            break;
                            }
                            else{
                                System.out.println("Elija que taller usar:");
                                int index = entrada.nextInt();

                                if ("Taller de Aerodeslizadores".equals(listaEdificioTalleres.get(index-1).getNombre())&&index>0)
                                {
                                    VehiculosAlquimistas vehiculoAux = listaEdificioTalleres.get(index-1).getVehiculo();
                                    System.out.println("Cantidad a adiestrar (max 5):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadMana()>(vehiculoAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadElixir()>(vehiculoAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCobalto()>(vehiculoAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=5)
                                    {
                                        edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- vehiculoAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- vehiculoAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- vehiculoAux.getCostoR3()*cantidad);

                                        listaEdificioTalleres.get(index-1).getVehiculo().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("Opcion invalida");                            
                                    }
                                }
                                else 
                                {
                                    System.out.println("Error de Taller");
                                }
                                break;
                            }
                        case "Espejo de Fuego":
                            if (listaEdificioTalleres.isEmpty())
                            {
                            System.out.println("No dispone de un Taller");
                            break;
                            }
                            else{
                                System.out.println("Elija que taller usar:");
                                int index = entrada.nextInt();

                                if ("Taller de Espejos de Fuego".equals(listaEdificioTalleres.get(index-1).getNombre())&&index>0)
                                {
                                    VehiculosAlquimistas vehiculoAux = listaEdificioTalleres.get(index-1).getVehiculo();
                                    System.out.println("Cantidad a adiestrar (max 5):");
                                    int cantidad = entrada.nextInt();
                                    if (edificioPrincipal.getCantidadMana()>(vehiculoAux.getCostoR1()*cantidad)&&
                                        edificioPrincipal.getCantidadElixir()>(vehiculoAux.getCostoR2()*cantidad)&&
                                        edificioPrincipal.getCantidadCobalto()>(vehiculoAux.getCostoR3()*cantidad)&& cantidad>=0 && cantidad<=5)
                                    {
                                        edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- vehiculoAux.getCostoR1()*cantidad);
                                        edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- vehiculoAux.getCostoR2()*cantidad);
                                        edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- vehiculoAux.getCostoR3()*cantidad);

                                        listaEdificioTalleres.get(index-1).getVehiculo().setCantidad(cantidad);
                                    }
                                    else
                                    {
                                        System.out.println("No hay suficientes recursos o cantidad invalida");                            
                                    }
                                }
                                else
                                {
                                    System.out.println("Error de Taller");
                                }
                                break;
                            }
                    }
                case "6":
                    if (listaEdificioRecurso.isEmpty()){
                        System.out.println("No dispone de Edificios que te generen o produscan algun recurso");
                    }
                    else
                    {
                        for (Edificio recolectar:listaEdificioRecurso){
                            if ("Generador de Mana".equals(recolectar.getNombre())){
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()+recolectar.getCantidadMana());
                            }
                            if ("Recolector de Elixir".equals(recolectar.getNombre())){
                                edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadElixir()+recolectar.getCantidadElixir());
                            }
                            if ("Recolector de Cobalto".equals(recolectar.getNombre())){
                                edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()+recolectar.getCantidadCobalto());
                            }
                        }
                    }
                    break;
                case "7":
                    continuar = false;
                    break;
            }
        }
    }
}
