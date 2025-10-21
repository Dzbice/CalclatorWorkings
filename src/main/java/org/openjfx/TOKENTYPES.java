package org.openjfx;

public enum TOKENTYPES {
    LITERAL("0123456789"),
    OPERATOR("+/-*^!"),
    PI("pi"),
    E("e"),
    LBRACKET("("),
    RBRACKET(")"),
    SPACE(" "),
    NEGATIVE("m");


    public final String tokenType;
    TOKENTYPES(String tokenType){
        this.tokenType = tokenType;
    }
    Boolean is(String a){
        return this.tokenType.contains(a);
    }


}

