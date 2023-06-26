package ejercicio2;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();

        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Compra segura");
            System.out.println("4. Listado de libros por especialidad");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer la opción

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String author = scanner.nextLine();
                    System.out.print("Ingrese las ventas del libro: ");
                    int sales = scanner.nextInt();
                    System.out.print("Ingrese la calificación de la crítica del libro: ");
                    int criticRating = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea después de leer la calificación de la crítica
                    System.out.print("Ingrese la especialidad del libro: ");
                    String specialty = scanner.nextLine();
                    System.out.print("Ingrese los comentarios del libro: ");
                    String comments = scanner.nextLine();

                    Book book = new Book(title, author, sales, criticRating, specialty, comments);
                    bookStore.addBook(book);
                    System.out.println("Libro agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el autor del libro a modificar: ");
                    String modifyAuthor = scanner.nextLine();
                    Book existingBook = bookStore.booksByAuthor.get(modifyAuthor);
                    if (existingBook == null) {
                        System.out.println("El libro no existe en la librería.");
                    } else {
                        System.out.print("Ingrese el nuevo título del libro: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Ingrese las nuevas ventas del libro: ");
                        int newSales = scanner.nextInt();
                        System.out.print("Ingrese la nueva calificación de la crítica del libro: ");
                        int newCriticRating = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea después de leer la nueva calificación de la crítica
                        System.out.print("Ingrese los nuevos comentarios del libro: ");
                        String newComments = scanner.nextLine();

                        Book newBook = new Book(newTitle, existingBook.author, newSales, newCriticRating,
                                existingBook.specialty, newComments);
                        bookStore.modifyBook(newBook);
                        System.out.println("Libro modificado con éxito.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el autor para buscar la compra segura: ");
                    String searchAuthor = scanner.nextLine();
                    Book bestBook = bookStore.getBookWithBestRatingByAuthor(searchAuthor);
                    if (bestBook == null) {
                        System.out.println("No se encontró ningún libro del autor especificado.");
                    } else {
                        System.out.println("El libro con mejor crítica del autor " + searchAuthor + " es:");
                        System.out.println("Título: " + bestBook.title);
                        System.out.println("Autor: " + bestBook.author);
                        System.out.println("Ventas: " + bestBook.sales);
                        System.out.println("Calificación de la crítica: " + bestBook.criticRating);
                        System.out.println("Especialidad: " + bestBook.specialty);
                        System.out.println("Comentarios: " + bestBook.comments);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la especialidad para listar los libros: ");
                    String searchSpecialty = scanner.nextLine();
                    List<Book> booksBySpecialty = bookStore.getBooksBySpecialtyOrderedBySales(searchSpecialty);
                    if (booksBySpecialty.isEmpty()) {
                        System.out.println("No se encontraron libros en la especialidad especificada.");
                    } else {
                        System.out.println("Los libros de la especialidad " + searchSpecialty + " ordenados por ventas son:");
                        for (Book b : booksBySpecialty) {
                            System.out.println("Título: " + b.title);
                            System.out.println("Autor: " + b.author);
                            System.out.println("Ventas: " + b.sales);
                            System.out.println("Calificación de la crítica: " + b.criticRating);
                            System.out.println("Especialidad: " + b.specialty);
                            System.out.println("Comentarios: " + b.comments);
                            System.out.println("--------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        }
    }
}
