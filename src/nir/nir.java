package nir;

public class nir {

    private final int min;
    private final int max;
    private final int num;

    private nir(int min,int max,int num) {
        this.min = min;
        this.max = max;
        this.num = num;
    }
    
    public static nir parse(int min, int max, int num) {
        if (max < min) {
            return new nir(min,min,min);
        }
        if (num > max) {
            return new nir(min,max,max);
        }
        if (num < min) {
            return new nir(min,max,min);
        }
        return new nir(min,max,num);
    }
    
    public static nir of(int min, int max, int num) {
        return new nir(min,max,num);
    }
    
    public static nir of(int num) {
        return new nir(num,num,num);
    }
    
    public int getMin() {
        return this.min;
    }
    
    public int getMax() {
        return this.max;
    }
    
    public int getValue() {
        return this.num;
    }
}
