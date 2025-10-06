package org.openjfx;

import java.util.ArrayList;

public class Tokenize {

    static ArrayList<Token> tokenize(String token){
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
                if(i !=0 && (TOKENTYPES.LITERAL.is(String.valueOf(token.charAt(i-1))) || TOKENTYPES.RBRACKET.is(String.valueOf(token.charAt(i-1))) )){
                    tokens.add(new Token("Operator","*"));
                }
                tokens.add(new Token("LBRACKET",String.valueOf(token.charAt(i))));
            }
            if(TOKENTYPES.RBRACKET.is(String.valueOf(token.charAt(i)))){
                //System.out.println("Operator");
                if(i != token.length() -1 && (TOKENTYPES.LITERAL.is(String.valueOf(token.charAt(i+1))))){
                    tokens.add(new Token("RBRACKET",String.valueOf(token.charAt(i))));
                    tokens.add(new Token("Operator","*"));
                } else{

                    tokens.add(new Token("RBRACKET",String.valueOf(token.charAt(i))));
                }

            }
            if(String.valueOf(token.charAt(i)).equalsIgnoreCase("p")){
                if(i == token.length()-1){

                } else{
                    if(String.valueOf(token.charAt(i+1)).equalsIgnoreCase("i")){
                        tokens.add(new Token("PI","pi"));
                    }
                }
            }

            if(String.valueOf(token.charAt(i)).equalsIgnoreCase("e")){
                tokens.add(new Token("e","e"));
            }


        }




        ArrayList<Token> updatedTokens = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            Token current = tokens.get(i);


            if (current.getType().equals("PI") || current.getType().equals("e")) {
                if (i > 0) {
                    Token prev = tokens.get(i - 1);
                    if (prev.getType().equals("Literal") || prev.getType().equals("RBRACKET")) {
                        updatedTokens.add(new Token("Operator", "*"));
                    }
                }
            }

            updatedTokens.add(current);


            if (current.getType().equals("PI") || current.getType().equals("e")) {
                if (i + 1 < tokens.size()) {
                    Token next = tokens.get(i + 1);
                    if (next.getType().equals("Literal") || next.getType().equals("LBRACKET")) {
                        updatedTokens.add(new Token("Operator", "*"));
                    }
                }
            }
        }


        return updatedTokens;
    }


}
