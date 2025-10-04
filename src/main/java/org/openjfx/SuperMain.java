package org.openjfx;

import org.openjfx.DzMath.Constants;

public class SuperMain {
    public static void main(String[] args) {
        /*int x =1;
        while(true){
            double y = Math.PI * normalFunction.power(x,2);
            System.out.println("r = "+ x + "\nA = " + y);
            if(y %1 == 0){
                System.out.println("r = "+ x + "\nA = " + y);
                break;
            }
            x++;

        }*/
        System.out.println("\nMy pi: " + Constants.pi() + "\nJava Pi: " + Math.PI + "\n Di" +
                "fference: " + (Constants.pi()- Math.PI));
        Main.main(args);
    }
}