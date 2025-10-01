package org.openjfx;

public enum TOKENTYPES {
    LITERAL("0123456789"),
    OPERATOR("+/-*^!"),
    LBRACKET("("),
    RBRACKET(")"),
    SPACE(" ");


    public final String tokenType;
    TOKENTYPES(String tokenType){
        this.tokenType = tokenType;
    }
    Boolean is(String a){
        return this.tokenType.contains(a);
    }


}

