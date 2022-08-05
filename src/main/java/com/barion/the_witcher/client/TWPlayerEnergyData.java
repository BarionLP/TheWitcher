package com.barion.the_witcher.client;

public class TWPlayerEnergyData {
    public static float energy = 0;
    public static int maxEnergy = 100;

    public static void set(float energy) {TWPlayerEnergyData.energy = energy;}
    public static void setMax(int maxEnergy) {TWPlayerEnergyData.maxEnergy = maxEnergy;}

    public static float get() {return energy;}
    public static int getMax() {return maxEnergy;}
    public static float getPercent() {return get()/getMax();}
}