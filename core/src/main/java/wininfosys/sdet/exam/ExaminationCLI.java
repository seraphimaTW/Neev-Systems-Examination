package wininfosys.sdet.exam;

import wininfosys.sdet.exam.client.CountryNotFoundException;
import wininfosys.sdet.exam.helper.RestCountriesHelper;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExaminationCLI {

    public static void main(String[] args) {
        new ExaminationCLI().startInterface();
    }

    ExaminationCLI() {
        System.out.println("Welcome to the ExaminationCLI!");
    }

    void startInterface() {
        RestCountriesHelper restCountriesHelper = new RestCountriesHelper();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Please make you selection: NAME or CODE. If you would like to exit, enter QUIT");
                String input = scanner.next();
                String capitalName = "";
                try {
                    switch(input) {
                        case "NAME":
                            System.out.println("Please enter country name");
                            String countryName = scanner.next();
                            try {
                                capitalName = restCountriesHelper.getCapitalByCountryName(countryName);
                            } catch (NoSuchElementException | CountryNotFoundException e) {
                                System.out.println("We were not able to found any data for your input, please try again");
                                break;
                            }
                            System.out.println("The Capital City name is " + capitalName);
                            break;
                        case "CODE":
                            System.out.println("Please enter 2-letter or 3-letter country code");
                            String countryCode = scanner.next();
                            try {
                                capitalName = restCountriesHelper.getCapitalByCountryCode(countryCode);
                            } catch (NoSuchElementException | CountryNotFoundException e) {
                                System.out.println("We were not able to found any data for your input, please try again");
                                break;
                            }
                            System.out.println("The Capital City name is " + capitalName);
                            break;
                        case "QUIT":
                            System.exit(0);
                        default:
                            System.out.println("This option is currently not available");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong, we apologize for the inconvenience");
                }
                System.out.println("Type YES to continue");
            } while (scanner.next().equalsIgnoreCase("YES"));
        } catch (Exception e) {
            System.out.println("Something went wrong, we apologize for the inconvenience");
        }
    }

}
