package darghex.parces.helpers;

/*
 * Helper para la conversion de cadenas
 */
public abstract class ConvertidorCadena {

    /**
     * Metodo que recibe una variable tipo texto y la convierte toda a minuscula
     * @param texto
     * @return Cadena
     */
    public static String a_minuscula(String texto )
    {
        texto = texto.toLowerCase();
        return texto;
    }

    /**
     * Metodo que recibe una variable tipo texto y la conviertetodo a mayuscula
     * @param texto
     * @return Cadena
     */
    public static String a_mayuscula(String texto )
    {
        texto = texto.toUpperCase();
        return texto;
    }

    /**
     * Metodo que recibe una variable tipo texto y convierte la primera a mayuscula
     * @param texto
     * @return Cadena
     */
    public static String primera_a_mayuscula(String texto )
    {
        texto = a_minuscula(texto);
        char[] caracteres = texto.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        for (int i = 0;  i < caracteres.length -2 ; i++){
            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
                caracteres[i +1] = Character.toUpperCase(caracteres[i+1]);
        }

        return new String(caracteres);//Rearma el texto convirtiendo el arreglo en String nuevamente
    }
}