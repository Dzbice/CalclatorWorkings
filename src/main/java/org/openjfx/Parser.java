package org.openjfx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Parser {
    public static HashMap<String,Integer> precedence = new HashMap<>(){{
        put("+",1);
        put("-",1);
        put("*",2);
        put("/",2);
        put("^",3);
    }};

//128+21-3(4+5)*2-1/2
    static String shuntingYard(ArrayList<Token> tokens){
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<= tokens.size()-1;i++){
            Token tokenRead = tokens.get(i);
            if(tokenRead.getType().equals("Literal") || tokenRead.getType().equals("PI")){
                output.append(tokenRead.getValue()).append(" ");
            }
            else if(tokenRead.getType().equals("Operator")){
                if(!stack.isEmpty()){
                    if(TOKENTYPES.OPERATOR.is(stack.peek()) && precedence.get(stack.peek()) >= precedence.get(tokenRead.getValue())){
                         output.append(stack.pop()).append(" ");
                    }
                }
                stack.push(tokenRead.getValue());
            }
            else if(tokenRead.getType().equals("LBRACKET")){
                stack.push(tokenRead.getValue());
            }
            else if(tokenRead.getType().equals("RBRACKET")) {
                while (!stack.peek().equals("(")) {
                    if (!stack.isEmpty()) {
                        output.append(stack.pop()).append(" ");
                    }
                }
                if(stack.peek().equals("(")){
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            output.append(stack.pop()).append(" ");
        }

        return output.toString();
    }





}
