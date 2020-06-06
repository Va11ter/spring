package test.event;

import test.dto.Food;
import test.service.ZooService;

import java.util.Iterator;

public class HungryEvent extends ZooEvent{
    private final ZooService zooService;

    public HungryEvent(Object source, ZooService zooService){
        super(source, "Hungry Animals");
        this.zooService = zooService;
    }

    public ZooService getZooService() {
        return zooService;
    }
}
