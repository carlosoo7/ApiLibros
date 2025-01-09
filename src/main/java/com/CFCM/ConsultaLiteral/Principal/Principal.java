package com.CFCM.ConsultaLiteral.Principal;

import com.CFCM.ConsultaLiteral.Modelo.DatosLibro;
import com.CFCM.ConsultaLiteral.Modelo.Idioma;
import com.CFCM.ConsultaLiteral.Modelo.Libro;
import com.CFCM.ConsultaLiteral.Repository.LibrosRepository;
import com.CFCM.ConsultaLiteral.Service.ConsumoApi;
import com.CFCM.ConsultaLiteral.Service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private int opcion;
    private ConsumoApi consumoApi = new ConsumoApi();
    private String urlBase = "https://gutendex.com/books?search=%20";
    private LibrosRepository repository;

    public Principal(LibrosRepository repository) {
        this.repository = repository;
    }

    public void muestraMenu() {
        do {
            System.out.println("""
                    Bienvenido a Consulta literaria a continuacion seleccione una opcion
                    1 - Búsqueda de libro por título.
                    2 - Lista de todos los libros.
                    3 - Lista de autores.
                    4 - Exhibir cantidad de libros en un determinado idioma.
                    5 - Listar autores vivos en determinado año.
                    0 - Salir
                    """);
            try {
                opcion = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion invalida o no ingresada");
            }


            switch (opcion) {
                case 1:
                    BúsquedaDeLibroPorTítulo();
                    break;
                case 2:
                    ListaDeLibros();
                    break;
                case 3:
                    ListaDeAutores();
                    break;
                case 4:
                    FiltroLibrosIdioma();
                    break;
                case 5:
                    FiltroAutoresVivos();
                    break;
                case 0:
                    System.out.println("Saliendo del Programa");
                    break;

            }
        } while (opcion != 0);
    }


    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese El titulo del libro que desea buscar");
        var titulo = teclado.next();
        var json = consumoApi.obtenerDatos(urlBase + titulo.replace(" ", "+"));
        DatosLibro datosLibro = new ConvierteDatos().obtenerDatos(json, DatosLibro.class);
        System.out.println(datosLibro);
        return datosLibro;
    }

    private void BúsquedaDeLibroPorTítulo() {
        var datosLibro = getDatosLibro();
        Optional<Libro> libro = Optional.of(new Libro(datosLibro));
        if (libro.get().getTitulo() == null) {
            System.out.println("Serie no encontrada");
            return;
        } else {
            repository.save(libro.get());
        }
    }

    private void ListaDeLibros() {
        var libros = repository.findAll();
        libros.forEach(System.out::println);
    }

    private void ListaDeAutores() {
        List<Libro> Autores = repository.findAll();
        Autores.forEach(e -> e.getAutores().forEach(System.out::println));
    }

    private void FiltroLibrosIdioma() {
        System.out.println("Ingrese el idioma que desea buscar");
        Idioma consulta = Idioma.fromEspanol(teclado.next());
        List<Libro> libros = repository.findByIdiomasContaining(consulta);
        libros.forEach(System.out::println);
    }

    private void FiltroAutoresVivos() {
        System.out.println("Escriba el año en el que el autor estuvo vivo");
        int year = teclado.nextInt();
        List<Libro> Autores = repository.findbyaño(year);
        Autores.forEach(e -> e.getAutores().forEach(System.out::println));
    }
}
