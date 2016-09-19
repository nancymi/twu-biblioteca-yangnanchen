package com.twu.biblioteca;

import com.twu.biblioteca.manager.BibliotecaManager;
import com.twu.biblioteca.manager.BookManager;
import com.twu.biblioteca.manager.CustomerManager;
import com.twu.biblioteca.manager.LibrarianManager;
import source.Environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {

    public static final int COMMAND_LIST_BOOK = 0;
    public static final int COMMAND_QUIT = 1;

    public static final String[] commands = new String[] {
            "List Books",
            "Quit"
    };

    public BibliotecaManager bibliotecaManager;
    public LibrarianManager librarianManager;
    public CustomerManager customerManager;

    public BibliotecaApp(BibliotecaManager bibliotecaManager,
                         LibrarianManager librarianManager,
                         CustomerManager customerManager) {
        this.bibliotecaManager = bibliotecaManager;
        this.librarianManager = librarianManager;
        this.customerManager = customerManager;
    }

    public BibliotecaManager getBibliotecaManager() {
        return this.bibliotecaManager;
    }

    public LibrarianManager getLibrarianManager() {
        return this.librarianManager;
    }

    public CustomerManager getCustomerManager() {
        return this.customerManager;
    }

    public static void main(String[] args) {

        BibliotecaManager bibliotecaManager = BibliotecaManager.getInstance(
                BookManager.getInstance(Environment.getBooksByEnvironment()));
        LibrarianManager librarianManager = LibrarianManager.getInstance(bibliotecaManager);
        CustomerManager customerManager = CustomerManager.getInstance(bibliotecaManager, librarianManager);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(bibliotecaManager, librarianManager, customerManager);

        System.out.println(bibliotecaApp.welcome());
        System.out.println(bibliotecaApp.generateCommandLine());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int command = Integer.valueOf(scanner.nextLine());
            switch (command) {
                case COMMAND_LIST_BOOK:
                    if (bibliotecaManager.showBooks().isEmpty()) {
                        System.out.println(bibliotecaManager.showBooksEmpty());
                    } else {
                        System.out.println(bibliotecaManager.showBooks());
                    }
                    break;
                case COMMAND_QUIT:
                    return;
                default:
                    System.out.println("Select a valid option!");
            }

        }
    }

    public String welcome() {
        String welcomeMsg = "welcome!";

        return welcomeMsg;
    }

    public String generateCommandLine() {
        StringBuilder sb = new StringBuilder();
        sb.append("What you want to do?\n");
        for (int i = 0; i < commands.length; i ++) {
            sb.append(i + " : " + commands[i] + "\n");
        }
        return sb.toString();
    }
}
