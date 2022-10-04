package danek;

import java.util.Arrays;

public class DateTimeTools {
    static final int[] DaysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (isLeapYear(year) && month == 2 && day == 29)
            return true;

        if (month > 12)
            return false;
        if (day > DaysInMonth[month - 1])
            return false;

        return true;
    }

    public static boolean isValidTime(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0)
            return false;
        if (hours > 23 || minutes > 59 || seconds > 59)
            return false;

        return true;
    }

    public static int getWeekDay(int day, int month, int year) {
        if (!isValidDate(day, month, year))
            throw new IllegalArgumentException("Zadané datum je neplatné.");

        int k = year % 100;
        int j = year / 100;

        int vysledek = ((day + (((month + 1) * 26) / 10) + k + (k / 4) + (j / 4)) + (5 * j)) % 7;
        return ((vysledek + 5) % 7) + 1;
    }

    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year))
            return 29;
        return DaysInMonth[month - 1];
    }

    public static String formatDate(int day, int month, int year) {
        if (!isValidDate(day, month, year))
            throw new IllegalArgumentException("Zadané datum není platné.");

        return (day + "." + month + "." + year);
    }

    public static int[] parseDate(String date) {
        int[] dateArray = Arrays.stream(date.split(".")).mapToInt(Integer::parseInt).toArray();

        if (!isValidDate(dateArray[0], dateArray[1], dateArray[2]))
            throw new IllegalArgumentException("Zadané datum je neplatné.");

        return dateArray;
    }
}
