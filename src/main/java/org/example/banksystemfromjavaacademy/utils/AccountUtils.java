package org.example.banksystemfromjavaacademy.utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This account already exists";

    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account have been successfully created";

    public static String generateAccountNumber() {
        /**
         * year(like 2026) + randomNineDigits
         */
        Year currentYear = Year.now();
        int min = 100_000_000;
        int max = 999_999_999;

        //generate a random number between min and max
        int randomNumber = (int) Math.floor(Math.random() * (max-min+1) + min);

        //convert the currentYear and randomNumber to a Strings, then concatenate them together
        String randomNumberString = String.valueOf(randomNumber);
        String currentYearString = String.valueOf(currentYear);

        return currentYearString +
                randomNumberString;
    }

}
