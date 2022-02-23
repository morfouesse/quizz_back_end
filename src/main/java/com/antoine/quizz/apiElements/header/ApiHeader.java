package com.antoine.quizz.apiElements.header;

import java.util.ArrayList;

public class ApiHeader {

    public static final String HEADER_NAME_VERSION = "X-API-VERSION";
    public static final int VERSION1 = 1;
    public static final int VERSION2 = 2;

    public static final int STABLE_VERSION = VERSION1;

    public ArrayList<Integer> listVersion = new ArrayList<>();

    public ApiHeader() {
        listVersion.add(VERSION1);
        listVersion.add(VERSION2);
        listVersion.add(STABLE_VERSION);
    }
}
