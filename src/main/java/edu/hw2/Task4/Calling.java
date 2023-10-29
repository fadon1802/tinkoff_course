package edu.hw2.Task4;

public class Calling {
    private Calling() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        var thisCall = elements[0];
        var className = thisCall.getClassName();
        var methodName = thisCall.getMethodName();
        return new CallingInfo(className, methodName);
    }
}
