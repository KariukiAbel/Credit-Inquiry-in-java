package com.nabesh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {
    private MenuOptions accountType;
    private Scanner input;

    private final static MenuOptions[] choices = {MenuOptions.ZERO_BALANCE, MenuOptions.CREDIT_BALANCE,
            MenuOptions.DEBIT_BALANCE, MenuOptions.EXIT};

    private void readRecords() {
        AccountRecord record = new AccountRecord();
        try {
            input = new Scanner(new File("clients.txt"));

            while (input.hasNext()) {
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());

                if (shouldDisplay(record.getBalance())) {
                    System.out.printf("%-10d%-12s%-12s%10.2f\n",
                            record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
                }
            }
        } catch (NoSuchElementException elmentException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File cannot be found.");
            System.exit(1);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private boolean shouldDisplay(double balance) {
        if ((accountType == MenuOptions.CREDIT_BALANCE) && balance < 0)
            return true;
        else if ((accountType == MenuOptions.DEBIT_BALANCE) && balance > 0)
            return true;
        else if ((accountType == MenuOptions.ZERO_BALANCE) && balance == 0)
            return true;
        return false;
    }

    private MenuOptions getRequests(){
        Scanner text = new Scanner(System.in);
        int request = 1;
        try{
            do{
                System.out.println("\n? ");
                request = text.nextInt();
            }while((request < 1) || (request > 4));
        }catch (NoSuchElementException noSuchElementException){
            System.err.println("Invalid input");
            System.exit(1);
        }
        return choices [request - 1 ];
    }

    public void processRequests(){
        accountType = getRequests();
        while (accountType != MenuOptions.EXIT){
            switch (accountType){
                case ZERO_BALANCE:
                    System.out.println("\nAccounts with zero balances.");
                    break;
                case DEBIT_BALANCE:
                    System.out.println("\nAccounts with debit balances.");
                    break;
                case CREDIT_BALANCE:
                    System.out.println("\nAccounts with credit balances.");
                    break;
            }
            readRecords();
            accountType = getRequests();
        }
    }
}