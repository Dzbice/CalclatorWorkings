package org.openjfx.DzMath;

public class normalFunction {

    public static double power(double  a, double  b){
        double output = a;
        if(b ==0 || a==1){
            return 1;
        }
        for(int i = 1; i<b; i++ ){
            output*=a;
        }
        if (b < 0){
            return 1.0/output;
        }
        return output;
    }
}
