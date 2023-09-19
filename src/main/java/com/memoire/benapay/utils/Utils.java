package com.memoire.benapay.utils;

public class Utils {
    public static String generateCode(){
        int num = (int) (Math.random() * 100000);
        return "TRX"+num;
    }
}
