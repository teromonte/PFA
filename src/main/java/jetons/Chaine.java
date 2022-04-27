package jetons;

public class Chaine {
    public Chaine() {
    }

    public static int longueur(String var0) {
        return var0.length();
    }

    public static char caractere(String var0, int var1) {
        return var0.charAt(var1);
    }

    public static int comparaison(String var0, String var1) {
        return var0.compareTo(var1);
    }

    public static boolean egalite(String var0, String var1) {
        return var0.equals(var1);
    }

    public static String sousChaine(String var0, int var1, int var2) {
        return var0.substring(var1, var2);
    }

    public static char[] tableaucaractères(String var0) {
        return var0.toCharArray();
    }
}

