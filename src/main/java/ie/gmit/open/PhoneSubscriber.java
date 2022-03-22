package ie.gmit.open;

import java.util.List;

public class PhoneSubscriber {

    Data data = new Data();

    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(data.getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration* data.getBaseRate()/100;
    }



}