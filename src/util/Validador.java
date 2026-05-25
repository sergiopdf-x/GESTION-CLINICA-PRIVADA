package util;
public class Validador {
    public static boolean correo(String correo){
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean telefono(String telefono){
        return telefono.matches("\\d+");
    }

    public static boolean vacio(String texto){
        return texto.trim().isEmpty();
    }
}
