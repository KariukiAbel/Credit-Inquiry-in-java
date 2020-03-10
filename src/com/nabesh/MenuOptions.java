package com.nabesh;

public enum MenuOptions {
    ZERO_BALANCE( 1 ),
    CREDIT_BALANCE( 2 ),
    DEBIT_BALANCE( 3 ),
    EXIT( 4 );

    public final int value;

    public int getValue() {
        return value;
    }

    public MenuOptions(int valueOption){
        value = valueOption;
    }
}
