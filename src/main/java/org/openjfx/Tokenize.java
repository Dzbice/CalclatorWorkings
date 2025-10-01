package org.openjfx;

import java.util.ArrayList;

public class Tokenize {

    static String tokenize(String token){
        ArrayList<Token> tokens = new ArrayList<>();
        for(int i =0; i<= token.length() - 1; i++){
            if(TOKENTYPES.SPACE.is(String.valueOf(token.charAt(i)))){continue;}
            //System.out.println(tokens);
            if (i != 0 && TOKENTYPES.LITERAL.is(String.valueOf(token.charAt(i-1))) && TOKENTYPES.LITERAL.is(String.valueOf(token.charAt(i)))) {
                //System.out.println(i);
                continue;
            }
            if (TOKENTYPES.LITERAL.is(String.valueOf(token.charAt(i)))){
                Token x = new Token("Literal", String.valueOf(token.charAt(i)));
                int j = i+1;
                while(j <= token.length()-1 && TOKENTYPES.LITERAL.is(String.valueOf(token.charAt(j)))){
                   // System.out.println(x.getValue());
                    x.setValue(x.getValue() + (token.charAt(j)));
                    j++;
                    if(j>=token.length()){
                        break;
                    }
                }
                tokens.add(x);
            }

            if(TOKENTYPES.OPERATOR.is(String.valueOf(token.charAt(i)))){
                //System.out.println("Operator");
                tokens.add(new Token("Operator",String.valueOf(token.charAt(i))));
            }
            if(TOKENTYPES.LBRACKET.is(String.valueOf(token.charAt(i)))){
                //System.out.println("Operator");
                tokens.add(new Token("LBRACKET",String.valueOf(token.charAt(i))));
            }
            if(TOKENTYPES.RBRACKET.is(String.valueOf(token.charAt(i)))){
                //System.out.println("Operator");
                tokens.add(new Token("RBRACKET",String.valueOf(token.charAt(i))));
            }


        }



        StringBuffer output = new StringBuffer();
        for(Token n : tokens){
          //  System.out.println(n);
            output.append(n).append(" ");
        }
        System.out.println(output);


        return output.toString();
    }


}
