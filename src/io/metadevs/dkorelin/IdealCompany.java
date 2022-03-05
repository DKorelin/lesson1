package io.metadevs.dkorelin;

public interface IdealCompany {
    void hireWorker(Worker worker);
    void fireWorker(Worker worker);
    void printAllStuff();
    void printRoomAccessList(int roomAccessLevel);
    default void grantStar() {System.out.println("Hail to our champ! Here's your star!");}
}
