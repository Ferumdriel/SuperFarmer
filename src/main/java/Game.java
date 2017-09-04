import events.Event;
import events.dices.DiceRoller;
import farm.Farm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 20305 on 26.08.2017.
 */
public class Game {
    Farm farm;
    List<Event> events = new LinkedList<>();

    public Game(){
        farm = new Farm();
        events.add(new DiceRoller(farm));
    }

    public void launch(){
        sendGreetingNotification();
        sendRulesNotification();
        Scanner sc = new Scanner(System.in);
        do{
            for(Event event: events){
                event.performEvent();
            }
            farm.printCurrentFarmStatus();
            System.out.println("Do you want to continue? (y/n)");
        }
        while(!sc.nextLine().equals("n"));
    }

    private void sendGreetingNotification(){
        System.out.println("Witaj w tej cudownej grze kolego." +
                " Celem gry jest zdobycie conajmniej 1 królika, 1 owcy, 1 świni, 1 krowy oraz 1 konia." +
                " Przeszkodzić Ci w tym mogą grasujące w okolicy wilki i lisy." +
                " Przeciwko lisowi obronić Cię może mały pies, przeciwko wilkowi duży pies." +
                " By rzucić kostkami wćisnij 1");
    }

    private void sendRulesNotification(){
//        System.out.println("Aktualny stan Twojej hodowli: króliki: "+ liczbakrolikow+ ", owce: "+ liczbaowiec+", świnie: "+liczbaswin+", krowy: "+liczbakrow+", konie: "+liczbakoni);
    }

    public Farm getFarm() {
        return farm;
    }
}
