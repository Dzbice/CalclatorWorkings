package org.openjfx.DzMath;

public class Constants {
    public static double PI = pi();
    public static double e = e();
    //pi Found via the chudnovsky algorithm
    public static double pi(){
        int l = 5;
        double[] series = new double[l];
        double coeff = 12;
        for(int k =0;k<=series.length-1;k++){
            double numerator = (normalFunction.power(-1,k)) * normalFunction.factorial((long)6*k) * (545140134 * k + 13591409);
            double denominator = normalFunction.factorial((long)3*k) * normalFunction.power(normalFunction.factorial(k),3);
            double denominatorAgain = normalFunction.power(640320,3*k) * (normalFunction.power(normalFunction.sqrt(640320),3));
            series[k] = numerator/(denominatorAgain * denominator);
        }

        return 1/(coeff * SupportingFunctions.summation(series));
    }

    public static double e(){
        int l = 20;
        double[] series = new double[l];
        for(int n = 0;n<=l-1;n++){
            double numerator = normalFunction.power(1,n);
            double denominator = normalFunction.factorial(n);
            series[n] = numerator/denominator;
        }
        return SupportingFunctions.summation(series);
    }


}
