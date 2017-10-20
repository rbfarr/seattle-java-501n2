package com.codefellows;

public interface IComplexWebService extends IWebService {
    void doSomethingComplicated();
    int MAX_NUM_SERVICES = 25;

    static int getNumberOfWebServices() {
        return 0;
    }
}
