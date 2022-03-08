package io.metadevs.dkorelin;

public interface Worker {
    String getName();
    double getSalary();
    boolean checkRoomAccessLevel(int roomAccessLevel);
}
