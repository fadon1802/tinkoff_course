package edu.hw2;

import edu.hw2.Task1.Expr.*;
import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task4.Calling;
import static java.lang.System.out;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        out.println(res + " = " + res.evaluate());

        Rectangle r = new Square();
        r.setWidth(4);
        r.setHeight(5);
        r.setHeight(6);
        out.println(r.area());
        Rectangle r1 = new Square();
        r1.setHeight(20);
        out.println(r1.area());

        var sq = new Square();
        sq.setHeight(5);
        sq.setWidth(6);
        out.println(sq.area());
        sq.setSize(15);
        out.println(sq.area());

        var pce = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        try {
            pce.updatePackages();
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        out.println(Calling.callingInfo());
    }
}
