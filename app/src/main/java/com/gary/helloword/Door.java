package com.gary.helloword;

public class Door {

    DoorCallback doorCallback;

    interface  DoorCallback{
        void openDoor();
        void lockDoor();
    }

    public Door(DoorCallback doorCallback){
        this.doorCallback = doorCallback;
    }

    public Door(){

    }

    public void OpenDoor(){
        doorCallback.openDoor();
    }

    public void lockDoor(){
        doorCallback.lockDoor();
    }

}
