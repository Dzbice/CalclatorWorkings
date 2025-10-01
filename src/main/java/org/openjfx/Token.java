package org.openjfx;

public class Token {
    private String type;
    private String value;
    public Token(String type, String value){
        this.type = type;
        this.value = value;
    }

    public String getType(){
        return this.type;
    }

    public String getValue(){
        return this.value;
    }

    public void setType(String type){
        this.type = type;
    }
    public void setValue(String value){
        this.value = value;
    }
    @Override
    public String toString(){
        return this.type + ": "  + this.value;
    }
}
