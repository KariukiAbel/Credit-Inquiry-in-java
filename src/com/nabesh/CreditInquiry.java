package com.nabesh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditInquiry {
    private MenuOptions accountType;
    private Scanner input;

    private final static MenuOptions [] choices = {MenuOptions.ZERO_BALANCE, MenuOptions.CREDIT_BALANCE,
            MenuOptions.DEBIT_BALANCE, MenuOptions.EXIT};

    private void readRecords(){
        AccountRecord record = new AccountRecord();
        try {
            input = new Scanner(new File("clients.txt"));

            while (input.hasNext()){
                record.setAccount(input.nextInt());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
