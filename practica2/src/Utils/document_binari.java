/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.*;

/**
 *
 * @author ausias
 */
public class document_binari {

    public static File crear_document() throws FileNotFoundException, IOException {
        String nom = Utils.LlegirString("Digues el nom de l'arxiu: ");
        File arxiu = new File("./" + nom + ".bin");
        FileOutputStream fos = new FileOutputStream(arxiu);

        return arxiu;
    }
    public static File escriure_text(File arxiu, String frase) throws FileNotFoundException, IOException{
        OutputStream os = new FileOutputStream(arxiu);
        os.write(frase.getBytes(), 0, frase.length());
        
        os.flush();
        os.close();
        
        return arxiu;
    }
    public static File escriure_nums(File arxiu, int numero) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(arxiu);
        DataOutputStream dos = new DataOutputStream(fos);
        
        dos.writeInt(numero);
        
        return arxiu;
    }
    public static File lectura_fitxer(File arxiu) throws IOException{
        FileInputStream fis = new FileInputStream(arxiu);
        DataInputStream dis = new DataInputStream(fis);
        
        System.out.println(dis.read());
        
        fis.close();
        return arxiu;
    }
    
}
