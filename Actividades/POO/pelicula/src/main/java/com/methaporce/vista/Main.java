package com.methaporce.vista;

import com.methaporce.modelo.GestorPelicula;
import com.methaporce.modelo.Pelicula;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        //Se crea lista del objeto pelicula
        List<Pelicula> peli = new ArrayList<>();
        //Agregamos unas cuantas peliculas:
        peli.add(new Pelicula(1,"Proyecto Manhatan",true));
        peli.add(new Pelicula(2,"Rapido y furioso",false));
        peli.add(new Pelicula(3,"Constantine",false));
        peli.add(new Pelicula(4,"One Piece Live Action",true));
        
       GestorPelicula gestor = new GestorPelicula(peli);
        //Creamos el menu
        System.out.println("Gestor de Películas\n "
                + "Menu:\n "
                + "1.Agregar\n "
                + "2.Eliminar\n "
                + "3.Mostrar Lista\n "
                + "4.Mostrar Peliculas disponibles\n "
                + "5.Mostrar peliculas no disponibles\n "
                + "6.Marcar peliculas disponibles \n "
                + "7.Salir\n "
                + "Introduce el número de la opción deseada: ");
        //Creamos variable entera para seleccionar menu
        int opcion;
        //Lector de entrada 
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        //Mientras sea diferente a Salir realizará el proceso
        while(!salir){
            opcion = input.nextInt();
            //Aplicamos Switch para las opciones
            try {
                switch(opcion){
                    case 1:
                        System.out.println("Escriba el Id de la pelicula: ");
                        int id = input.nextInt();
                        input.nextLine();
                        System.out.println("Escriba el nombre de la pelicula: ");
                        String nombre = input.nextLine();
                        System.out.println("Se encuentra disponible la pelicula: true/false ");
                        boolean disponible = input.nextBoolean();
                        //input.nextLine();
                        Pelicula pelicula= new Pelicula(id, nombre, disponible);
                        gestor.agregarPelicula(pelicula);
                        System.out.println("Se agrego a la lista: " + pelicula.toString());
                        break;
                
                    case 2:
                        System.out.println("Escriba el Id de la pelicula a eliminar: ");
                        int idDel = input.nextInt();
                        gestor.eliminarPelicula(idDel);
                        break;
                   
                    case 3:
                        System.out.println("Lista de peliculas: ");
                        
                        gestor.obtenerPeliculas();
                        System.out.println(peli.toString());

                        break;
                    
                    case 4:
                        System.out.println("Películas disponibles: ");
                        gestor.obtenerPeliculasDisponibles();
                        System.out.println(gestor.obtenerPeliculasDisponibles());
                        break;
                
                    case 5:
                        System.out.println("Peliculas no disponibles: ");
                        gestor.obtenerPeliculasNoDisponibles();
                        System.out.println(gestor.obtenerPeliculasNoDisponibles());
                        break;
                    
                    case 6:
                        System.out.println("Marcar pelicula como disponible:\n "
                                + "Ingrese el ID de la película: \n");
                        int idDisp = input.nextInt();
                        
                        gestor.marcarPeliculaComoDisponible(idDisp); 
                        break;    
        
                    case 7:
                        System.out.println("Salir del programa ");
                        input.close();
                        System.exit(0);
                        break;  
            
                    default:
                        System.out.println("opción invalida");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un número");
                input.next();
            }System.out.println("Gestor de Películas\n "
                + "Menu:\n "
                + "1.Agregar  "
                + "2.Eliminar "
                + "3.Mostrar Lista "
                + "4.Mostrar Peliculas disponibles "
                + "5.Mostrar peliculas no disponibles "
                + "6.Marcar peliculas disponibles  "
                + "7.Salir\n "
                + "Introduce el número de la opción deseada: ");
            System.out.println("Seleccione nuevamente una opción: ");
                        
        }
        
    }
}

