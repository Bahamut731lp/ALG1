package danek;

import java.util.Scanner;

public class HraHadaniCisla {
    static Scanner rd = new Scanner(System.in);

    static int Min = 0;
    static int Max = 100;

    public static void main(String[] args) {

        boolean hraBezi = true;

        while (hraBezi) {
            System.out.println("==========================");
            System.out.printf("%-1s: %s\n", "1", "Počítač hádá");
            System.out.printf("%-1s: %s\n", "2", "Hráč hádá");
            System.out.printf("%-1s: %s\n", "3", "Konec");
            System.out.println("==========================");
            System.out.print("Zadejte číslo volby: ");

            int volba = rd.nextInt();

            switch (volba) {
            case 1:
                hadaPocitac();
                break;

            case 2:
                hadaHrac();
                break;

            case 3:
                hraBezi = false;
                break;
            }
        }

    }

    public static void hadaPocitac() {
        int lokalniMin = Min;
        int lokalniMax = Max;

        int mozneCislo = (lokalniMin + lokalniMax) / 2;
        boolean uhadnuto = false;

        System.out.printf(
                "- Pokud je číslo větší, napiště %s\n -Pokud je číslo menší, napiště %s\n -Pokud vaše myšlené číslo uhádnu, napište %s\n",
                "V", "M", "U");

        while (!uhadnuto) {
            System.out.printf("Je vaše myšlené číslo %s?\n", mozneCislo);
            String odpoved = rd.next();

            switch (odpoved) {
            case "V":
                lokalniMin = mozneCislo; // Číslo už nemůže být větší, než náš původní odhad
                mozneCislo = lokalniMin + ((lokalniMax - lokalniMin) / 2) + ((lokalniMax - lokalniMin) % 2);

                if (mozneCislo >= Max) {
                    mozneCislo = Max;
                    uhadnuto = true;
                }

                break;

            case "M":
                lokalniMax = mozneCislo;
                mozneCislo = lokalniMin + ((lokalniMax - lokalniMin) / 2) - ((lokalniMax - lokalniMin) % 2);

                if (mozneCislo <= Min) {
                    mozneCislo = Min;
                    uhadnuto = true;
                }

                break;
            case "U":
                uhadnuto = true;
                break;
            default:
                break;
            }
        }

        System.out.printf("Vaše myšlené číslo je %s!\n", mozneCislo);
    }

    public static void hadaHrac() {
        int mysleneCislo = vygenerujNahodneCislo(0, 100);
        boolean uhadnuto = false;

        System.out.printf("Myslím si číslo mezi %s a %s... (cheat: %s)\n", Min, Max, mysleneCislo);

        while (!uhadnuto) {
            int pokus = rd.nextInt();

            if (pokus == mysleneCislo) {
                uhadnuto = true;
            } else {
                System.out.printf("Myšlené číslo je %s než %s \n", pokus < mysleneCislo ? "větší" : "menší", pokus);
            }

        }

        System.out.println("Gratuluji, uhádli jste mé myšlené číslo!");
    }

    public static int vygenerujNahodneCislo(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}