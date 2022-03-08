package io.metadevs.dkorelin;

public interface IdealCompany {
    void hireWorker(Worker worker);
    void fireWorker(Worker worker);
    String printAllStuff();
    String printRoomAccessList(int roomAccessLevel);
    default int grantStar() {return 0;}
}
