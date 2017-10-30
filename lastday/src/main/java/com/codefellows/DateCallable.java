package com.codefellows;

import java.util.Date;
import java.util.concurrent.Callable;

public class DateCallable implements Callable {
    @Override
    public Date call() throws Exception {
        throw new Exception("could not retrieve date");

        //Date today = new Date();
        //return today;
    }
}
