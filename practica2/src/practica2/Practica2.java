/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/*
Fes un programa que permeti gestionar el fitxer de clients amb les següents
operacions:
a) Alta d’un client (registrar un client que no existia abans al fitxer)
b) Consulta d’un client per posició
c) Consulta d’un client per codi
d) Modificar un client
e) Esborrar un client
f) Llistat de tots els clients
 */
import Utils.Utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class dades {

}

public class Practica2 {

    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        File nomarx = Utils.crear_document();
        List<String> noms = new ArrayList<>();
        List<String> codi = new ArrayList<>();
        List<String> cognoms = new ArrayList<>();
        List<String> dataNaix = new ArrayList<>();
        List<String> adreca = new ArrayList<>();
        List<String> eMail = new ArrayList<>();
        do{
            menu(nomarx, noms, codi, cognoms, dataNaix, adreca, eMail);
        }while(!salir(codi));

    }
    static boolean salir(List<String> codi){
        if(codi.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    static void menu(File nomarx, List noms, List codi, List cognoms, List dataNaix, List adreca, List eMail) throws IOException {
        imprimirMenu();
        int opcio = Utils.LlegirIntLimitat("Selecciona una opcio: ", 1, 7);
        switch (opcio) {
            case 1:
                AltaClient(nomarx, noms, codi, cognoms, dataNaix, adreca, eMail);
                break;
            case 2:
                ConsultaClientPos(nomarx);
                break;
            case 3:
                ConsultaClientCodi(nomarx, codi);
                break;
            case 4:
                ModificarClient(nomarx, codi);
                break;
            case 5:
                EsborrarClient(nomarx, codi);
            case 6:
                LlistaClient(nomarx);
            
        }
    }

    static void imprimirMenu() {
        System.out.println("\n\n1 per a Alta d’un client \n"
                + "2 Consulta d’un client per posició\n"
                + "3 Consulta d’un client per codi\n"
                + "4 Modificar un client\n"
                + "5 Esborrar un client\n"
                + "6 Llistat de tots els clients");
    }

    static void AltaClient(File nomarx, List noms, List codi, List cognoms, List dataNaix, List adreca, List eMail) throws IOException {

        String codigo = Utils.LlegirString("Digues el codi del nou usuari: ");
        codi.add(codigo);
        codigo = Utils.printfCasero(6, codigo);
        

        String nombre = Utils.LlegirString("Digues el nom del nou usuari: ");
        noms.add(nombre);
        nombre = Utils.printfCasero(20, nombre);
        

        String apellido = Utils.LlegirString("Digues el cognom del nou usuari: ");
        cognoms.add(apellido);
        apellido = Utils.printfCasero(30, apellido);
        

        String fecha = Utils.LlegirString("Digues la data de naixement del nou usuari(DDMMYYYY): ");
        dataNaix.add(fecha);
        fecha = Utils.printfCasero(8, fecha);
        

        String direccion = Utils.LlegirString("Digues la direcció del nou usuari: ");
        adreca.add(direccion);
        direccion = Utils.printfCasero(40, direccion);
        

        String correo = Utils.LlegirString("Digues el correu del nou usuari: ");
        eMail.add(correo);
        correo = Utils.printfCasero(30, correo);
        

        String newUser = codigo + nombre + apellido + fecha + direccion + correo;
        Utils.escriure_document(nomarx, newUser);
    }

    private static void ConsultaClientPos(File nomarx) throws IOException {
        int liniaUser = Utils.LlegirIntLimitat("Digues la linea que vols que llegeixi: ", 0, 999999999);
        Utils.mostrarLinea_document(nomarx, liniaUser);

    }

    private static void ConsultaClientCodi(File nomarx, List codi) throws IOException {
        String consulta = Utils.LlegirString("Digues el codi que vols consultar: ");
        int linea = -1;
        for (int i = 0; i < codi.size(); i++) {
            if (codi.get(i).equals(consulta)) {
                linea = i + 1;
            }
        }
        Utils.mostrarLinea_document(nomarx, linea);
    }

    private static void ModificarClient(File nomarx, List codi) {

    }

    private static void EsborrarClient(File nomarx, List codi) {
        int user = Utils.LlegirInt("Digues el codi de l'usuari que vols borrar: ");
        int linea = -1;
        for (int i = 0; i < codi.size(); i++) {
            if (user == i) {
                linea = i + 1;
            } else {
                System.out.println("No s'ha trobat el codi que demanes.");
            }
        }

        File inputFile = new File("C:\\Data\\archivo.txt");
        File outputFile = new File("C:\\Data\\archivo_nuevo.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.trim().equals(user)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LlistaClient(File nomarx) throws IOException {
        Utils.mostrar_document(nomarx);
    }

}
