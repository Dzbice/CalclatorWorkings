package org.openjfx;

import org.openjfx.DzMath.Constants;
import org.openjfx.DzMath.normalFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Evaluate {
    static double evaluate(String postfix){
        if(postfix.isBlank()){
            return 0;
        }
        double output;
        Stack<String> stack = new Stack<>();
        //System.out.println(postfix);
        ArrayList<String> lookThru = new ArrayList<>(List.of(postfix.split("\\s+")));
        //System.out.println(lookThru);
        for(int i = 0; i<=lookThru.size()-1;i++){
            if(TOKENTYPES.LITERAL.is(String.valueOf(lookThru.get(i).charAt(lookThru.get(i).length()-1)))){
                stack.push(lookThru.get(i));
            } else if(TOKENTYPES.PI.is(lookThru.get(i))){
                stack.push(String.valueOf(Constants.PI));
            } else if(TOKENTYPES.E.is(lookThru.get(i))){
                stack.push(String.valueOf(Constants.e));
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
                        stack.push(String.valueOf(normalFunction.power(a,b)));
                        break;
                }
            }
        }
        output = Double.parseDouble(stack.pop());

        return output;
    }
}

