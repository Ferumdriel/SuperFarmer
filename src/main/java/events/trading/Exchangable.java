package events.trading;

import events.trading.exchangeRules.ExchangeRules;

/**
 * Created by 20305 on 05.09.2017.
 */
public class Exchangable<T> implements Trading{

    private ExchangeRules<T> exchangeRules;

    public Exchangable(){
        exchangeRules = new ExchangeRules<>();
    }

    @Override
    public boolean isTradePossible() {
        return false;
    }
}
