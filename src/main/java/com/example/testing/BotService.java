package com.example.testing;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BotService {

    public String getArrivials() {
        PortCall[] calls = new GettingInfo().getInfo();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    
        List<Arrivals> vessels = new ArrayList<>();
        for(PortCall portCall : calls) {
            if(portCall.getVesselName().equals("Finlandia") 
                || portCall.getVesselName().equals("MyStar")
                || portCall.getVesselName().equals("Megastar")
                || portCall.getVesselName().equals("Victoria I")) {
                    Arrivals vessel = new Arrivals();
                    
                    vessel.setName("\nVessel: m/s " + portCall.getVesselName() + " ");
                    List<PortAreaDetails> portAreaDetails = portCall.getPortAreaDetails();
                    for(PortAreaDetails details: portAreaDetails) {
                        ZonedDateTime eta = ZonedDateTime.parse(details.getEta(), inputFormatter)
                            .withZoneSameInstant(ZoneId.of("Europe/Helsinki"));
                    
                        String formattedEta = eta.format(outputFormatter);
                        System.out.println(formattedEta);
                        
                        vessel.setEta("\nTime: " + formattedEta);
                    }
                    
                    vessels.add(vessel);
                }
        }

        vessels.sort(Comparator.comparing(Arrivals::getEta));



        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Arrivals: ").append("\n");
        for(Arrivals vessel: vessels) {
            messageBuilder.append(vessel.toString()).append("\n");
        }
        return messageBuilder.toString();
}

public String getDepartures() {
    PortCall[] calls = new GettingInfo().getInfo();
    DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    LocalDate date = LocalDate.now();

    List<Departures> vessels = new ArrayList<>();
    for(PortCall portCall : calls) {
        if(portCall.getVesselName().equals("Finlandia") 
            || portCall.getVesselName().equals("MyStar")
            || portCall.getVesselName().equals("Megastar")
            || portCall.getVesselName().equals("Victoria 1")
            ) {
               
                List<PortAreaDetails> portAreaDetails = portCall.getPortAreaDetails();
               // vessel.setName("\nVessel: m/s " + portCall.getVesselName() + " ");
                
                for(PortAreaDetails details: portAreaDetails) {
                    LocalDate etdDate = ZonedDateTime.parse(details.getEtd(), inputFormatter).toLocalDate();
                    if(etdDate.getDayOfYear() == date.getDayOfYear()) {
                    Departures vessel = new Departures();
                    vessel.setName(portCall.getVesselName());
                    
                    ZonedDateTime etd = ZonedDateTime.parse(details.getEtd(), inputFormatter)
                        .withZoneSameInstant(ZoneId.of("Europe/Helsinki"));
                
                        String formattedEtd = etd.format(outputFormatter);
                    
                        vessel.setEtd("\nTime: " + formattedEtd);
                    }
                        
                }
               
                vessels.add(vessel);
                
            }
            
    }
    System.out.println(vessels);
    vessels.sort(Comparator.comparing(Departures::getEtd));
    



    StringBuilder messageBuilder = new StringBuilder();
    messageBuilder.append("Departures: ").append("\n");
    for(Departures vessel: vessels) {
        messageBuilder.append(vessel.toString()).append("\n");
    }
    return messageBuilder.toString();
}



}
