package animals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 20305 on 12.08.2017.
 */
public class ExchangeRules<T>{
    private Map<T, int[]> viableExchanges;

    public ExchangeRules(Map<T, int[]> viableExchangeObjects){
        viableExchanges = viableExchangeObjects;
    }

    public int getExchangeCost(T t){
        return viableExchanges.get(t)[0];
    }

    public int getExchangeGain(T t){
        return viableExchanges.get(t)[1];
    }

    public void addRule(T t, int exchangeCost, int exchangeGain){
        viableExchanges.put(t, new int[] {exchangeCost, exchangeGain});
    }

    public Map<T, int[]> getViableExchanges() {
        return viableExchanges;
    }
}
