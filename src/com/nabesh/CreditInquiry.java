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
}