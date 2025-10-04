package org.openjfx.DzMath;

public class Constants {

    public static double pi() {
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
    }
}
