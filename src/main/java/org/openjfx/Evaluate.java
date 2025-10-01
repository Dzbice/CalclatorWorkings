package org.openjfx;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Evaluate {
    static double evaluate(String postfix){
        double output;
        Stack<String> stack = new Stack<>();
        System.out.println(postfix);
        ArrayList<String> lookThru = new ArrayList<>(List.of(postfix.split("\\s+")));
        System.out.println(lookThru);
        for(int i = 0; i<=lookThru.size()-1;i++){
            if(TOKENTYPES.LITERAL.is(String.valueOf(lookThru.get(i).charAt(lookThru.get(i).length()-1)))){
                stack.push(lookThru.get(i));
            } else{
                double b = Double.parseDouble(stack.pop());
                double a = Double.parseDouble(stack.pop());
                switch (lookThru.get(i)){
                    case "+":
                        stack.push(String.valueOf(b+a));
                        break;
                    case "-":

                        stack.push(String.valueOf(a-b));
                        break;
                    case "*":

                        stack.push(String.valueOf(a*b));
                        break;
                    case "/":

                        stack.push(String.valueOf(a/b));
                        break;
                    case "^":
                        stack.push(String.valueOf(power(a,b)));
                        break;
                }
            }
        }
        output = Double.parseDouble(stack.pop());

        return output;
    }

    static double power(double a, double b){
        double output = a;
        if(b ==0 || a==1){
            return 1;
        }
        for(int i = 1; i<b; i++ ){
            output*=a;
        }
        return output;
    }
}

