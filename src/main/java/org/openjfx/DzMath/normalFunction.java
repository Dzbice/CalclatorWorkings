package org.openjfx.DzMath;

public class normalFunction {

    public static double power(double  a, double  b){
        double output = a;
        if(b ==0 || a==1){
            return 1;
        }

        for(int i = 1; i< (int)absoluteValue(b); i++ ){
            output*=a;
        }
        if (b < 0){
            return 1.0/output;
        }
        return output;
    }

    public static long factorial(long a){
        long output = 1;
        if(a == 0){
            return 1;
        }

        for(long i = a; i>0;i--){
            output*=i;
        }
        return output;
    }

    public static double absoluteValue(double n) {
        if (n < 0) {
            return n * -1;
        } else {
            return n;
        }
    }

    public static double sqrt(double n) {
        int[] perfectSquares = new int[100];
        int[] perfect = new int[100];
        for (int i = 1; i < 101; i++) {
            perfectSquares[i - 1] = (int) power(i, 2);
            perfect[i - 1] = i;
        }
        double guess = perfect[SupportingFunctions.binarySearch(perfectSquares, n)];
        // System.out.println(guess);
        double gnext = 0;
        for (int i = 1; i <= 100; i++) {
            gnext = (guess + n / guess) / 2;
            guess = gnext;
        }
        return gnext;
    }




}
