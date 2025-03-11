
import java.util.Scanner;

public class Main {
    public static int findFirstDayOfYear(int year) {
        int dayOfWeek = (((year - 1) * 365) + ((year - 1) / 4) - ((year - 1) / 100) + ((year) / 400) + 1) % 7;
        return dayOfWeek;
    }

    public static boolean isLeap(int year) {
        boolean leap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;
        return leap;
    }



    public static int monthDays(int month, int year) {
        int numberOfDays = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            numberOfDays = 31;
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11 ) {
            numberOfDays = 30;
        }
        else if (month == 2) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0)
                        numberOfDays = 29;
                    else
                        numberOfDays = 28;
                }
                else
                    numberOfDays = 29;
            }
            else {
                numberOfDays = 28;
            }
        }
        return numberOfDays;
    }

    public static int findElapsedDays(int month, int year) {
        int passedDays = 0;
        for (int i=1; i<month; i++) {
            passedDays += monthDays(i, year);
        }
        return passedDays;
    }

    public static int[][] assignWeekDays(int month, int year) {
        int passedDays = findElapsedDays(month, year);
        int[][] daysArray = new int[passedDays][2];
        int firstDayOfYear = findFirstDayOfYear(year);
        daysArray[0][1] = firstDayOfYear;
        for (int i=1; i<=passedDays; i++) {
            daysArray[i-1][0] = i;
            if (daysArray[i-1][1]+1 >6) {
                if (i<passedDays) {
                    daysArray[i][1] = 0;
                }
            }
            else {
                if (i<passedDays) {
                    daysArray[i][1] = daysArray[i-1][1]+1;
                }
            }
        }
        return daysArray;
    }

    public static int findLastWeekDayOfLastMonth(int month, int year) {
        int lastWeekDay = 0;

        for (int i=0; i<findElapsedDays(month, year); i++) {
            lastWeekDay = assignWeekDays(month,year)[i][1];
        }
        return lastWeekDay;
    }

    public static int [][] currentMonth(int month, int year){
        int[][] daysArray = new int[monthDays(month, year)][2];

        if (findLastWeekDayOfLastMonth(month, year)+1 >6) {
            daysArray[0][1] = 0;
        }
        else {
            daysArray[0][1] = findLastWeekDayOfLastMonth(month, year)+1;
        }

        for (int i=1; i<=monthDays(month, year); i++) {
            daysArray[i-1][0] = i;
            if (daysArray[i-1][1]+1 >6) {
                if (i<monthDays(month, year)) {
                    daysArray[i][1] = 0;
                }
            }
            else {
                if (i<monthDays(month, year)) {
                    daysArray[i][1] = daysArray[i-1][1]+1;
                }
            }
        }

        return daysArray;
    }

    public static String nameOfDay(int day) {
        String dayName = "";
        if (day==0) {
            dayName = "S";
        }
        else if (day==1) {
            dayName = "M";
        }
        else if (day==2) {
            dayName = "T";
        }
        else if (day==3) {
            dayName = "W";
        }
        else if (day==4) {
            dayName = "Th";
        }
        else if (day==5) {
            dayName = "F";
        }
        else if (day==6) {
            dayName = "Sa";
        }
        return dayName;
    }


    public static String nameOfDayFull(int day) {
        String dayName = "";
        if (day==0) {
            dayName = "Sunday";
        }
        else if (day==1) {
            dayName = "Monday";
        }
        else if (day==2) {
            dayName = "Tuesday";
        }
        else if (day==3) {
            dayName = "Wednesday";
        }
        else if (day==4) {
            dayName = "Thursday";
        }
        else if (day==5) {
            dayName = "Friday";
        }
        else if (day==6) {
            dayName = "Saturday";
        }
        return dayName;
    }

    public static String nameOfMonth(int month) {
        String monthName = "";
        if (month==1) {
            monthName = "January";
        }
        else if (month==2) {
            monthName = "February";
        }
        else if (month==3) {
            monthName = "March";
        }
        else if (month == 4) {
            monthName = "April";
        }
        else if (month==5) {
            monthName = "May";
        }
        else if (month==6) {
            monthName = "June";
        }
        else if (month==7) {
            monthName = "July";
        }
        else if (month==8) {
            monthName = "August";
        }
        else if (month==9) {
            monthName = "September";
        }
        else if (month==10) {
            monthName = "October";
        }
        else if (month==11) {
            monthName = "November";
        }
        else if (month==12) {
            monthName = "December";
        }
        return monthName;
    }

    public static int[] findDateFromElapsedDays(int elapsedDays, int year) {
        int[]monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int []dateArr = new int[3];
        int count = 0;
        if (isLeap(year)) {
            monthDays[1] = 29;
        }
        for (int i=0; i<monthDays.length; i++) {
            if (elapsedDays<=monthDays[i] && elapsedDays>0) {
                break;
            }
            else {
                elapsedDays-=monthDays[i];
                count++;
            }
        }
        dateArr[0] = elapsedDays;
        dateArr[1] = count+1;
        dateArr[2] = year;
        return dateArr;
    }

    public static void main(String[] args) {
        for (int i=0; i<31; i++) {
            System.out.println(currentMonth(4,2023)[i][1]);
        }
    }
}