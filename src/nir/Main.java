package nir;

public class Main {

    //esempio funzioni attuali
    public static String fun(int index) {
        String[] l = new String[100];
        for (int i = 0; i < 100; i++) {
            l[i] = String.valueOf(i);
        }
        return l[index];
    }

    //esempi di funzioni attuali con controlli ed eccezioni
    public static String fun2(int index) throws Exception {
        String[] l = new String[100];
        if (index < 0 || index >= 100) {
            throw new Exception("invalid index");
        }
        for (int i = 0; i < 100; i++) {
            l[i] = String.valueOf(i);
        }
        return l[index];
    }

    //esempio di funzioni con nir
    public static String fun(nir nir) {
        String[] l = new String[100];
        for (int i = 0; i < 100; i++) {
            l[i] = String.valueOf(i);
        }
        return l[nir.getValue()];
    }

    public static void main(String[] args) {
        //utilizzo funzioni attuali
        int b = 200;
        //System.out.println(fun(b));
        try {
            System.out.println(fun2(b));
        } catch (Exception e) {
            System.out.println(e);
        }

        //utilizzo funzioni con nir
        nir a = nir.parse(0, 99, 110);
        System.out.println(fun(a));
    }
}
