package com.halas.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class MyDate {

    private MyDate() {
    }

    public static String getCurrentDateTime() {
        Date instant = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("_yyyy-MM-dd_HH.mm.ss.SSS");
        return sdf.format(instant);
    }
}
