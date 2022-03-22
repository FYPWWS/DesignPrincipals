package ie.gmit.open;

import java.util.List;

public class ISPSubscriber {

    Data data = new Data();

    public ISPSubscriber() {

    }

    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(data.getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - data.getFreeUsage();
        return chargeableData*data.getBaseRate()/100;
    }
}