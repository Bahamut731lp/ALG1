package danek;

public class DateTimeToolsTest {

    public static void main(String[] args) {

        suite("Test přestupného roku");
        test("Rok 2000 je přestupný", DateTimeTools.isLeapYear(2000), true);
        test("Rok 2021 není přestupný", DateTimeTools.isLeapYear(2001), false);
        test("Rok 0 je přestupný", DateTimeTools.isLeapYear(0), true);
        test("Rok -1970 není přestupný", DateTimeTools.isLeapYear(-1970), false);

        suite("Test platného data");
        test("Datum 2.5.2002 je platné", DateTimeTools.isValidDate(1, 1, 2005), true);
        test("Datum 1.13.2021 není platné", DateTimeTools.isValidDate(1, 13, 2021), false);
        test("Datum 1.1.1 je platné", DateTimeTools.isValidDate(1, 1, 1), true);
        test("Datum 32.1.1980 není platné", DateTimeTools.isValidDate(32, 1, 1980), false);
        test("Datum 29.2.2020 je platné", DateTimeTools.isValidDate(29, 2, 2020), true);
        test("Datum 29.2.2021 není platné", DateTimeTools.isValidDate(29, 2, 2021), false);

        suite("Test platného času");
        test("Čas 8:05:10 je platný", DateTimeTools.isValidTime(8, 05, 10), true);
        test("Čas 24:00:00 není platný", DateTimeTools.isValidTime(24, 0, 0), false);
        test("Čas 23:59:59 je platný", DateTimeTools.isValidTime(8, 05, 10), true);
        test("Čas -12:00:00 není platný", DateTimeTools.isValidTime(-12, 0, 0), false);
        test("Čas 00:00:00 je platný", DateTimeTools.isValidTime(0, 0, 0), true);

        suite("Test dní v měsíci");
        test("Leden v roce 2020 má 31 dní", DateTimeTools.getNumberOfDays(1, 2020), 31);
        test("Únor v roce 2020 má 29 dní", DateTimeTools.getNumberOfDays(2, 2020), 29);
        test("Únor v roce 2021 má 28 dní", DateTimeTools.getNumberOfDays(2, 2021), 28);
        test("Květen v roce 1970 má 31 dní", DateTimeTools.getNumberOfDays(5, 1970), 31);
        test("Listopad v roce 100 má 30 dní", DateTimeTools.getNumberOfDays(11, 100), 30);

        suite("Test nalezení dne podle data");
        test("18.11.2021 je středa", DateTimeTools.getWeekDay(18, 11, 2021), 3);
        test("18.11.2021 je čtvrtek", DateTimeTools.getWeekDay(18, 11, 2021), 4);
        test("18.11.2021 je pátek", DateTimeTools.getWeekDay(18, 11, 2021), 5);
    }

    public static void suite(String name) {
        String dividers = "=========================";

        System.out.println();
        System.out.println(dividers);
        System.out.println(name);
        System.out.println(dividers);
    }

    public static <T> void test(String caption, T expression, T expectedResult) {
        boolean assertion = expression == expectedResult;
        System.out.printf("- %-30s: %s\n", caption, assertion ? "✅" : "❎");
    }

}
