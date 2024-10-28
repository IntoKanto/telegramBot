package com.example.testing;

import java.util.ArrayList;
import java.util.List;

public class BuildingVessels {
    
    public List<Arrivals> vesselslist() {
        PortCall[] call = new GettingInfo().getInfo();
        List<Arrivals> vessels = new ArrayList<>();

        System.out.println(call.length);

          // Example of accessing the data
          for (PortCall portCall : call) {
            if (portCall.getVesselName().equals("Megastar") ||portCall.getVesselName().equals("Megastar") ||portCall.getVesselName().equals("MyStar")) {
                Arrivals vessel = new Arrivals();
                vessel.setName(portCall.getVesselName());
                List<PortAreaDetails> portAreaDetails = portCall.getPortAreaDetails();
                for(PortAreaDetails details : portAreaDetails ) {
                    vessel.setEta(details.getEta());
                    vessel.setEtd(details.getEtd());
                }
                vessels.add(vessel);
            }
            
        } 

        return vessels;
    }
}
