package io.metadevs.dkorelin;

public interface RoomAccess {
    default boolean checkRoomAccessLevel(int roomAccessLevel){return false;}
}
