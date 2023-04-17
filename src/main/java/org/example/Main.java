package org.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.example.Pk_Process.Lancement;

@ApplicationPath("/api")
public class Main extends Application{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Lancement lancement = new Lancement();
        lancement.Lance();
    }
}
