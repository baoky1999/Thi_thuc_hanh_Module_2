package Thi_thuc_hanh_Module_2.services;

import Thi_thuc_hanh_Module_2.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class CommonCheck {

    private static final Scanner sc = new Scanner(System.in);

    public static int checkParseInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Sai định dạng, nhập lại:");
            }
        }
        return value;
    }

    private static final String REGEX_NAME = "^.{4,50}$";

    public static String checkRegexPoint() {
        String value = sc.nextLine();
        while (!value.matches(REGEX_NAME)) {
            System.err.print("Sai định dạng, nhập lại: ");
            value = sc.nextLine();
        }
        return value;
    }


    private static final String REGEX_PHONE =     "^(090|091)\\d{7}$"
            ;

    public static String checkRegexPhone() {
        String value = sc.nextLine();
        while (!value.matches(REGEX_PHONE)) {
            System.err.print("Sai định dạng, nhập lại: ");
            value = sc.nextLine();
        }
        return value;
    }

    public static boolean isDay(String day) {
        if (!(isCheckFormatDay(day,"dd/MM/yyyy" ))) {
            System.out.println("Ngày nhập viện chưa đúng định dạng!");
            return false;
        }
        return true;
    }

    public static  boolean isCheckFormatDay(String ngay, String dinhDang) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dinhDang);
            LocalDate.parse(ngay, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


}
