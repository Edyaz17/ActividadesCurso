package com.methaporce.vista;

import com.methaporce.modelo.GestorPelicula;
import com.methaporce.modelo.Pelicula;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Gestor de Películas");

         // Agregamos unas cuantas peliculas al objeto Pelicula como lista
        List<Pelicula> peli = new ArrayList<Pelicula>();
        
        peli.add(new Pelicula(1, "Iron Man", false));
        peli.add(new Pelicula(2, "Batman", true));
        peli.add(new Pelicula(3, "Superman", true));
        

        GestorPelicula gestor = new GestorPelicula((List<Pelicula>) peli);
        
        //Va a leer las entradas
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opcion; // Para que el usuario seleccione una opción del menu y aquí se guarde
           
        while (!salir) {
            System.out.println("\nMenú: \n"
                + "1. Agregar película                   "
                + "2. Eliminar película\n"
                + "3. Mostrar lista de películas         "
                + "4. Mostrar películas disponibles\n"
                + "5. Mostrar películas no disponibles   "
                + "6. Marcar película como disponible\n"
                + "7. Salir\n");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            try {
                switch (opcion) {

                    case 1:
                        System.out.print("Escriba el Id de la película: ");
                        int id = entrada.nextInt();
                        entrada.nextLine();
                        System.out.print("Escriba el nombre de la película: ");
                        String nombre = entrada.nextLine();
                        System.out.print("¿Está disponible? true/false: ");
                        boolean disponible = entrada.nextBoolean();

                        Pelicula pelicula = new Pelicula(id, nombre, disponible);
                        gestor.agregarPelicula(pelicula);
                        System.out.println(peli.toString());
                        System.out.println("\n");
                        break;

                    case 2:
                        System.out.print("\nIngrese Id de la película a eliminar: ");
                        id = entrada.nextInt();
                        entrada.nextLine();
                        gestor.eliminarPelicula(id);
                        System.out.println(peli.toString());
                        break;

                    case 3:
                        System.out.println("\nEstas son todas las películas:");
                        System.out.println(gestor.obtenerPeliculas().toString());
                        break;

                    case 4:
                        System.out.println("\nPelículas disponibles:");
                        System.out.println(gestor.obtenerPeliculasDisponibles());
                        break;

                    case 5:
                        System.out.println("Películas no disponibles:");
                        System.out.println(gestor.obtenerPeliculasNoDisponibles());
                        break;

                    case 6:
                        System.out.print("Ingrese el Id de la película que desea cambiar a disponible: ");
                        id = entrada.nextInt();
                        entrada.nextLine();
                        gestor.marcarPeliculaComoDisponible(id);
                        System.out.println(peli.toString());
                        break;

                    case 7:
                        entrada.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Error de entrada, ingrese solo numeros del 1 al 7");
                        break;
                    }
                }catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                entrada.nextInt();
            }
            
        }
    }
}