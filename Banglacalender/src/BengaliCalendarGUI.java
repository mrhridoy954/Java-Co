import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class BengaliCalendarGUI extends JFrame {
    private static final String[] MONTH_NAMES = {
            "",
            "\u09AC\u09C8\u09B6\u09BE\u0996",
            "\u099C\u09CD\u09AF\u09C8\u09B7\u09CD\u09A0",
            "\u0986\u09B7\u09BE\u09A2\u09BC",
            "\u09B6\u09CD\u09B0\u09BE\u09AC\u09A3",
            "\u09AD\u09BE\u09A6\u09CD\u09B0",
            "\u0986\u09B6\u09CD\u09AC\u09BF\u09A8",
            "\u0995\u09BE\u09B0\u09CD\u09A4\u09BF\u0995",
            "\u0985\u0997\u09CD\u09B0\u09B9\u09BE\u09AF\u0993\u09A3",
            "\u09AA\u09CC\u09B7",
            "\u09AE\u09BE\u0998",
            "\u09AB\u09BE\u09B2\u09CD\u0997\u09C1\u09A8",
            "\u099A\u09C8\u09A4\u09CD\u09B0"
    };
    private static final String[] BENGALI_NUMBERS = {
            "\u09E6","\u09E7","\u09E8","\u09E9","\u09EA","\u09EB","\u09EC","\u09ED","\u09EE","\u09EF"
    };

    public BengaliCalendarGUI(int day, int month, int year) {
        super();
        setTitle(MONTH_NAMES[month]);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(6, 7, 12, 12);
        panel.setLayout(gridLayout);

        JLabel[] daysOfWeek = new JLabel[7];
        String[] daysOfWeekNames = {
                "\u09B0\u09AC\u09BF",
                "\u09B8\u09CB\u09AE",
                "\u09AE\u0999\u09CD\u0997\u09B2",
                "\u09AC\u09C1\u09A7",
                "\u09AC\u09C3\u09B9\u09B8\u09CD\u09AA\u09A4\u09BF",
                "\u09B6\u09C1\u0995\u09CD\u09B0",
                "\u09B6\u09A8\u09BF",
        };

        for (int i = 0; i < 7; i++) {
            daysOfWeek[i] = new JLabel("<html><font face='Nirmala UI' size='5' color='black'>" + daysOfWeekNames[i]);
            panel.add(daysOfWeek[i]);
        }

        JLabel[] dates = new JLabel[day];
        for (int i = 1; i <= day; i++) {
            dates[i - 1] = new JLabel("<html><font face='Nirmala UI' size='4' color='black'>" +
                    convertNumberToBengali(i));
            panel.add(dates[i - 1]);
        }

        add(panel);
    }

    public static String convertNumberToBengali(int number) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int digit = number % 10;
            result.insert(0, BENGALI_NUMBERS[digit]);
            number /= 10;
        }
        return result.toString();
    }

    public static boolean isLeapYear(int year) {
        year += 593;
        return (year & 3) == 0 && ((year % 25) != 0 || (year & 15) == 0);
    }

    public static int yearStartDay(int year) {
        int day = 0;
        for (int i = 0; i < year; i++) {
            if (day < 7) {
                if (isLeapYear(i)) {
                    day += 2;
                } else {
                    day++;
                }
            }
            if (day == 7) {
                day = 0;
            }
        }
        return day;
    }

    public static int generateMonthNumber(String name, String studentID) {
        int sum = 0;

        // Calculate sum of ASCII values of letters in the name
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            sum += (int) c;
        }

        // Calculate sum of digits in the student ID
        for (int i = 0; i < studentID.length(); i++) {
            char c = studentID.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                sum += digit;
            }
        }

        // Take the remainder when divided by 12 to get the month number
        int monthNumber = sum % 12;

        // Add 1 to the month number to match the range 1-12
        monthNumber += 1;

        return monthNumber;
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        String studentID = JOptionPane.showInputDialog("Enter your student ID:");

        int month = generateMonthNumber(name, studentID);

        int year = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                year = Integer.parseInt(JOptionPane.showInputDialog("Enter a Year:"));
                if (year <= 0) {
                    throw new Exception();
                }
                validInput = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid year entered. Please enter a positive number.");
            }
        }

        int startDay = yearStartDay(year);
        int daysInMonth = getDaysInMonth(month, isLeapYear(year));
        BengaliCalendarGUI calendar = new BengaliCalendarGUI(daysInMonth, month, startDay);
    }

    public static int getDaysInMonth(int month, boolean isLeapYear) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                return isLeapYear ? 30 : 29;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }
}
