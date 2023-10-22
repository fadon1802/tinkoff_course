package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(int number) implements Expr {
        @Override
        public double evaluate(){
            return (float)number;
        }
    }
    record Negate(Expr e) implements Expr {
        @Override
        public double evaluate(){
            return -e.evaluate();
        }
    }
    record Exponent(Expr e, float pow) implements Expr {
        @Override
        public double evaluate(){
            return Math.pow(e.evaluate(), pow);
        }
    }
    record Addition(Expr e1, Expr e2) implements Expr {
        @Override
        public double evaluate(){
            return e1.evaluate() + e2.evaluate();
        }
    }
    record Multiplication(Expr e1, Expr e2) implements Expr {
        @Override
        public double evaluate(){
            return e1.evaluate() * e2.evaluate();
        }
    }

}
