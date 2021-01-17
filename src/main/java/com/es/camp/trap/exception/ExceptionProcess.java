package com.es.camp.trap.exception;

@SuppressWarnings("all")
public class ExceptionProcess {

    private static class User {};

    public void throwException() {
        User user = null;

        if (user == null) {
            throw new NullPointerException();
        }
    }

    public void cannotCatchNPEException() {
        try {
            throwException();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public void canCatchException() {
        try {
            throwException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExceptionProcess process = new ExceptionProcess();
        process.cannotCatchNPEException();
        process.canCatchException();
    }

}
