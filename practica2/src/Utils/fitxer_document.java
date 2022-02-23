/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ausias
 */
public class fitxer_document {
    public static File crear_document() throws IOException {
        String nom = Utils.LlegirString("Digues el nom de l'arxiu: ");
        File arxiu = new File("./" + nom + ".txt");
        FileWriter writer = new FileWriter(arxiu, true);
        PrintWriter printer = new PrintWriter(writer);

        writer.close();
        return arxiu;
    }

    public static File escriure_document(File arxiu, String frase) throws IOException {

        FileWriter writer = new FileWriter(arxiu, true);
        PrintWriter printer = new PrintWriter(writer);

        printer.println(frase);

        writer.close();
        return arxiu;
    }

    public static File mostrar_document(File arxiu) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(arxiu);
        BufferedReader buffer = new BufferedReader(reader);
        String linea = buffer.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = buffer.readLine();
        }
        reader.close();
        return arxiu;
    }

    public static File mostrarLinea_document(File arxiu, int liniaUser) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(arxiu);
        BufferedReader buffer = new BufferedReader(reader);
        String linea = buffer.readLine();

        for (int i = 1; i < liniaUser; i++) {

            linea = buffer.readLine();
        }
        System.out.println(linea);
        reader.close();
        return arxiu;
    }
}
