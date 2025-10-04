package org.openjfx.DzMath;

public class Constants {
    public static double PI = pi();
    /*public static double pI() {
        int l = 20;
        double[] series = new double[l];
        double coeff = (2 * normalFunction.sqrt(2)) / normalFunction.power(99, 2);
        for (int k = 0; k <= series.length - 1; k++) {
            double fProduct = normalFunction.factorial(4 * k) / (normalFunction.power(normalFunction.factorial(k), 4));
            // System.out.println(fProduct);
            double sProduct = ((double)(26390 * k + 1103) / (normalFunction.power(396, 4 * k)));
            // System.out.println(sProduct);
            series[k] = fProduct * sProduct;
            // System.out.println(series[k]);
        }
        return 1 / (coeff * SupportingFunctions.summation(series));
    }*/
    //pi Found via the chudnovsky algorithm
    public static double pi(){
        int l = 5;
        double[] series = new double[l];
        double coeff = 12;
        for(int k =0;k<=series.length-1;k++){
            double numerator = (normalFunction.power(-1,k)) * normalFunction.factorial(6*k) * (545140134 * k + 13591409);
            double denominator = normalFunction.factorial(3*k) * normalFunction.power(normalFunction.factorial(k),3);
            double denominatorAgain = normalFunction.power(640320,3*k) * (normalFunction.power(normalFunction.sqrt(640320),3));
            series[k] = numerator/(denominatorAgain * denominator);
        }

        return 1/(coeff * SupportingFunctions.summation(series));
    }


}
