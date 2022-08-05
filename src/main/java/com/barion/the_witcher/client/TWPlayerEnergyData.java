package com.barion.the_witcher.client;

public class TWPlayerEnergyData {
    public static int energy = 0;
    public static int maxEnergy = 100;

    public static void set(int energy) {TWPlayerEnergyData.energy = energy;}
    public static void setMax(int maxEnergy) {TWPlayerEnergyData.maxEnergy = maxEnergy;}

    public static int get() {return energy;}
    public static int getMax() {return maxEnergy;}
    public static double getPercent() {return (double) get()/getMax();}
}