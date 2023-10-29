package edu.hw3.Task6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StockMarketClassTest {

    @Test
    void mostValuableStock1() {
        Stock stock1 = new Stock(1000, "firstStock");
        Stock stock2 = new Stock(2000, "secondStock");

        var market = new StockMarketClass();
        market.add(stock1);
        market.add(stock2);

        assertEquals("secondStock", market.mostValuableStock().name());
    }

    @Test
    void mostValuableStock2() {
        Stock stock1 = new Stock(1000, "firstStock");
        Stock stock2 = new Stock(2000, "secondStock");

        var market = new StockMarketClass();
        market.add(stock2);
        market.add(stock1);

        assertEquals("secondStock", market.mostValuableStock().name());
    }
}
