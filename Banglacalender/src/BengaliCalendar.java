import javax.swing.*;
import java.awt.*;

public class BengaliCalendar extends JFrame {
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

    public BengaliCalendar(int day, int month, int year) {
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

        JLabel[] dates = new JLabel[31];
        int startDay = monthStartDay(month, year);
        int daysInMonth = getDaysInMonth(month, year);
        for (int i = 1; i <= daysInMonth; i++) {
            dates[i - 1] = new JLabel("<html><font face='Nirmala UI' size='4' color='black'>" +
                    convertNumberToBengali(i));
            panel.add(dates[i - 1]);
        }

        if (month < 11 || month == 12) {
            panel.add(new JLabel());
        } else if (month == 11 && isLeapYear(year + 1)) {
            panel.add(new JLabel());
        }
        if (month < 7) {
            panel.add(new JLabel());
        }
        add(panel);
    }

    public static String convertNumberToBengali(int number) {
        String[] bengaliNumbers = {
                "\u09E6", "\u09E7", "\u09E8", "\u09E9", "\u09EA", "\u09EB", "\u09EC", "\u09ED", "\u09EE", "\u09EF"
        };

        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int digit = number % 10;
            result.insert(0, bengaliNumbers[digit]);
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
            if (day > 6) {
                if (day == 7) {
                    day = 0;
                } else if (isLeapYear(i)) {
                    day = 1;
                }
            }
        }
        return day;
    }

    public static int monthStartDayCalc(int day, int month, int incr) {
        for (int i = 0; i < month; i++) {
            if (day < 7) {
                day += incr;
            }
            if (day > 6) {
                if (day > 7) {
                    day = day - 7;
                } else {
                    day = 0;
                }
            }
        }
        return day;
    }

    public static int monthStartDay(int month, int year) {
        int day = yearStartDay(year);
        if (month > 1 && month < 7) {
            month--;
            day = monthStartDayCalc(day, month, 3);
        }
        if (month > 6) {
            int LastMonth = month - 7;
            day = monthStartDayCalc(monthStartDayCalc(day, 6, 3), LastMonth, 2);
            if (month == 12 && !isLeapYear(year + 1)) {
                day--;
            }
        }
        return day;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year + 1)) {
            return 30;
        }
        int[] daysInMonth = {0, 31, 30, 30, 31, 31, 30, 30, 31, 31, 30, 30, 31};
        return daysInMonth[month];
    }

    public static void main(String[] args) {
        int year = 0;
        int month = 0;
        boolean validInput = false;

        // Take input for year
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

        // Take input for name
        String name = JOptionPane.showInputDialog("Enter your name:");
        int nameValue = calculateNameValue(name);

        // Take input for student ID
        String studentID = JOptionPane.showInputDialog("Enter your student ID:");
        int studentIDValue = calculateStudentIDValue(studentID);

        // Calculate the month based on name and student ID values
        month = (nameValue + studentIDValue) % 12;

        BengaliCalendar calendar = new BengaliCalendar(getDaysInMonth(month, year), month, year);
    }

    public static int calculateNameValue(String name) {
        int value = 0;
        for (char c : name.toCharArray()) {
            value += (int) c;
        }
        return value;
    }

    public static int calculateStudentIDValue(String studentID) {
        int value = 0;
        for (char c : studentID.toCharArray()) {
            if (Character.isDigit(c)) {
                value += Character.getNumericValue(c);
            }
        }
        return value;
    }
}

