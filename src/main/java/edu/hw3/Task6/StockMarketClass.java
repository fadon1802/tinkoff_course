package edu.hw3.Task6;

import java.util.PriorityQueue;

public class StockMarketClass implements StockMarket {
    private final PriorityQueue<Stock> stocks;

    public StockMarketClass() {
        stocks = new PriorityQueue<>((s1, s2) -> Double.compare(s2.price(), s1.price()));
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
