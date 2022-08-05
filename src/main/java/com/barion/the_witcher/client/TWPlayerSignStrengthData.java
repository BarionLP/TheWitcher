package com.barion.the_witcher.client;

public class TWPlayerSignStrengthData {
    public static int signStrength = 0;

    public static void set(int signStrength) {TWPlayerSignStrengthData.signStrength = signStrength;}
    public static int get() {return signStrength;}

    public static boolean canCastSigns() {return signStrength > 0;}
}