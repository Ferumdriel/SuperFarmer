import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random dice = new Random();
    static int liczbakrolikow = 0;
    static int liczbaowiec = 0;
    static int liczbaswin = 0;
    static int liczbakrow = 0;
    static int liczbakoni = 0;
    static int liczbamalychpsow = 0;
    static int liczbaduzychpsow = 0;
    static int wynikzoltej = 0;
    static int wynikczerwonej = 0;
    static int liczbarzutow = 0;
    static String zolta;
    static String czerwona;
    static int nagrodakrolik = 0;
    static int nagrodaowca = 0;
    static int nagrodaswinia = 0;
    static int nagrodakrowa = 0;
    static int nagrodakon = 0;

    public static void main(String[] args){

        System.out.println("Witaj w tej cudownej grze kolego. Celem gry jest zdobycie conajmniej 1 królika, 1 owcy, 1 świni, 1 krowy oraz 1 konia.");
        System.out.println("Przeszkodzić Ci w tym mogą grasujące w okolicy wilki i lisy.");
        System.out.println("Przeciwko lisowi obronić Cię może mały pies, przeciwko wilkowi duży pies.");
        System.out.println("Aktualny stan Twojej hodowli: króliki: "+ liczbakrolikow+ ", owce: "+ liczbaowiec+", świnie: "+liczbaswin+", krowy: "+liczbakrow+", konie: "+liczbakoni);
        System.out.println("By rzucić kostkami wćisnij 1");

        while(liczbakrolikow<1 || liczbaowiec<1 || liczbaswin<1 || liczbakrow<1 || liczbakoni<1) {

            Scanner input = new Scanner(System.in);
            String temp = input.nextLine();


            if (temp.equals("1")) {
                rzutKostka();
                nagrodaZaRzut();
                atakLisa();
                atakWilka();
            }
            else if (temp.equals("2")) {
                if (liczbakrolikow >= 6)
                    zamianaKrolikowNaOwce();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("3")) {
                if (liczbaowiec >= 1)
                    zamianaOwcyNaKroliki();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("4")) {
                if (liczbaowiec >= 2)
                    zamianaOwiecNaSwinie();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("5")) {
                if (liczbaswin >= 1)
                    zamianaSwiniNaOwce();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("6")) {
                if (liczbaswin >= 3)
                    zamianaSwinNaKrowy();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("7")) {
                if (liczbakrow >= 1)
                    zamianaKrowyNaSwinie();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("8")) {
                if (liczbakrow >= 2)
                    zamianaKrowNaKonia();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("9")) {
                if (liczbakoni >= 1)
                    zamianaKoniaNaKrowy();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("10")) {
                if (liczbaowiec >= 1)
                    zamianaOwcyNaMalegoPsa();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }
            else if (temp.equals("11")) {
                if (liczbakrow >= 1)
                    zamianaKrowyNaDuzegoPsa();
                else
                    System.out.println("Hola, hola, nie oszukuj, kolego.");
            }

            System.out.println("Aktualny stan Twojej hodowli: króliki: " + liczbakrolikow + ", owce: " + liczbaowiec + ", świnie: " + liczbaswin + ", krowy: " + liczbakrow + ", konie: " + liczbakoni+" (dodatkowo: małe psy: "+liczbamalychpsow+", duże psy: "+liczbaduzychpsow+")");
            System.out.println("Wciśnij 1 by rzucić kostkami");
            System.out.println("Wciśnij 2 by wymienić 6 królików na 1 owcę");
            System.out.println("Wciśnij 3 by wymienić 1 owcę na 6 królików");
            System.out.println("Wciśnij 4 by wymienić 2 owce na 1 świnię");
            System.out.println("Wciśnij 5 by wymienić 1 świnię na 2 owce");
            System.out.println("Wciśnij 6 by wymienić 3 świnie na 1 krowę");
            System.out.println("Wciśnij 7 by wymienić 1 krowę na 3 świnie");
            System.out.println("Wciśnij 8 by wymienić 2 krowy na 1 konia");
            System.out.println("Wciśnij 9 by wymienić 1 konia na 2 krowy");
            System.out.println("Wciśnij 10 by wymienić 1 owcę na 1 małego psa");
            System.out.println("Wciśnij 11 by wymienić 1 krowę na 1 dużego psa");

        }

        System.out.println("Gratulacje, udało Ci się wypełnić zadanie. Potrzebowałeś do tego "+liczbarzutow+" rzutów kostkami.");
    }

    public static void rzutKostka(){
        wynikzoltej = 1+dice.nextInt(12);

        if(wynikzoltej<=6)
            zolta = "królik";
        else if(wynikzoltej>6&&wynikzoltej<=9)
            zolta = "owca";
        else if(wynikzoltej==10)
            zolta = "świnia";
        else if(wynikzoltej==11)
            zolta = "krowa";
        else if(wynikzoltej==12)
            zolta = "wilk";
        System.out.println("Kostka żółta: "+ zolta);

        wynikczerwonej = 1+dice.nextInt(12);

        if(wynikczerwonej<=6)
            czerwona = "królik";
        else if(wynikczerwonej==7||wynikczerwonej==8)
            czerwona = "owca";
        else if(wynikczerwonej==9||wynikczerwonej==10)
            czerwona = "świnia";
        else if(wynikczerwonej==11)
            czerwona = "koń";
        else if(wynikczerwonej==12)
            czerwona = "lis";
        System.out.println("Kostka czerwona: "+czerwona);
        liczbarzutow++;
    }

    public static void nagrodaZaRzut(){
        int roboczykrolik = 0;
        int roboczaowca = 0;
        int roboczaswinia = 0;
        int roboczakrowa = 0;
        int roboczykon = 0;

        if(czerwona.equals("królik")){
            roboczykrolik +=1;
        }
        else if(czerwona.equals("owca")){
            roboczaowca +=1;
        }
        else if(czerwona.equals("świnia")){
            roboczaswinia +=1;
        }
        else if(czerwona.equals("koń")){
            roboczykon +=1;
        }

        if(zolta.equals("królik")){
            roboczykrolik +=1;
        }
        else if(zolta.equals("owca")){
            roboczaowca +=1;
        }
        else if(zolta.equals("świnia")){
            roboczaswinia +=1;
        }
        else if(zolta.equals("krowa")){
            roboczakrowa +=1;
        }

        if(roboczykrolik>0)
            nagrodakrolik = (roboczykrolik + liczbakrolikow)/2;
        else
            nagrodakrolik = 0;
        if(roboczaowca>0)
            nagrodaowca = (roboczaowca + liczbaowiec)/2;
        else
            nagrodaowca = 0;
        if(roboczaswinia>0)
            nagrodaswinia = (roboczaswinia + liczbaswin)/2;
        else
            nagrodaswinia = 0;
        if(roboczakrowa>0)
            nagrodakrowa = (roboczakrowa + liczbakrow)/2;
        else
            nagrodakrowa = 0;
        if(roboczykon>0)
            nagrodakon = (roboczykon + liczbakoni)/2;
        else
            nagrodakon = 0;

        liczbakrolikow += nagrodakrolik;
        liczbaowiec += nagrodaowca;
        liczbaswin += nagrodaswinia;
        liczbakrow += nagrodakrowa;
        liczbakoni += nagrodakon;
    }

    public static void atakLisa(){
        if(czerwona.equals("lis")){
            if(liczbamalychpsow<1){
                System.out.println("Sprytny lis zakradł się do zagrody i zjadł Twoje króliki w ilości: "+liczbakrolikow+", innymi słowy - wszystkie");
                liczbakrolikow = 0;
            }
            else {
                liczbamalychpsow -= 1;
                System.out.println("Dzięki bohaterskiej postawie małego psa, udało się obronić Twoje króliki, co jednak przypłacił życiem");
            }
        }
    }

    public static void atakWilka(){
        if(zolta.equals("wilk")){
            if(liczbaduzychpsow<1){
                System.out.println("Zły wilk zakradł się do zagrody i zjadł wszystkie Twoje zwierzęta, tzn króliki: " + liczbakrolikow + ", owce: " + liczbaowiec + ", świnie: " + liczbaswin + ", krowy: " + liczbakrow + ", konie: " + liczbakoni);
                liczbakrolikow = 0;
                liczbaowiec = 0;
                liczbaswin = 0;
                liczbakrow = 0;
            }
            else {
                liczbaduzychpsow -= 1;
                System.out.println("Dzięki bohaterskiej postawie dużego psa, udało się obronić Twoje zwierzęta, co jednak przypłacił życiem");
            }
        }
    }

    public static void zamianaKrolikowNaOwce(){
        liczbakrolikow -=6;
        liczbaowiec +=1;
        System.out.println("Wymieniłeś 6 królików na 1 owcę");
    }
    public static void zamianaOwcyNaKroliki(){
        liczbakrolikow +=6;
        liczbaowiec -=1;
        System.out.println("Wymieniłeś 1 owcę na 6 królików");
    }
    public static void zamianaOwiecNaSwinie(){
        liczbaswin +=1;
        liczbaowiec -=2;
        System.out.println("Wymieniłeś 2 owce na 1 świnię");
    }
    public static void zamianaSwiniNaOwce(){
        liczbaswin -=1;
        liczbaowiec +=2;
        System.out.println("Wymieniłeś 1 świnię na 2 owce");
    }
    public static void zamianaOwcyNaMalegoPsa(){
        liczbamalychpsow +=1;
        liczbaowiec -=1;
        System.out.println("Wymieniłeś 1 owcę na 1 małego psa");
    }
    public static void zamianaSwinNaKrowy(){
        liczbakrow +=1;
        liczbaswin -=3;
        System.out.println("Wymieniłeś 3 świnie na 1 krowę");
    }
    public static void zamianaKrowyNaSwinie(){
        liczbakrow -=1;
        liczbaswin +=3;
        System.out.println("Wymieniłeś 1 krowę na 6 świń");
    }
    public static void zamianaKrowyNaDuzegoPsa(){
        liczbakrow -=1;
        liczbaduzychpsow +=1;
        System.out.println("Wymieniłeś 1 krowę na 1 dużego psa");
    }
    public static void zamianaKrowNaKonia(){
        liczbakrow -=2;
        liczbakoni +=1;
        System.out.println("Wymieniłeś 2 krowy na 1 konia");
    }
    public static void zamianaKoniaNaKrowy(){
        liczbakrow +=2;
        liczbakoni -=1;
        System.out.println("Wymieniłeś 1 konia na 2 krowy");
    }
}
