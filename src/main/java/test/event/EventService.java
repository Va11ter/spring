package test.event;

import com.sun.corba.se.spi.extension.ZeroPortPolicy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.Zoo;
import test.dto.Food;
import test.service.ZooService;

import java.util.Iterator;

@Service
public class EventService {

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        System.out.println("onApplicationEvent handler" + zooEvent.getMessage());
    }

    @EventListener(HungryEvent.class)
    public void onHungryEvent(HungryEvent hungryEvent){
        System.out.println("HungryEvent handler");
        ZooService zooService = hungryEvent.getZooService();
        Iterator<Food> nextFoodIterator = zooService.getNextFoodIterator();
        if (nextFoodIterator.hasNext()) {
            zooService.feed(nextFoodIterator.next());
        }
    }
}
