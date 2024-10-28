package com.example.testing;

import java.util.List;

public class PortCall {
    private long portCallId;
    private String vesselName;
    private String vesselNamePrefix;
    private String prevPort;
    private String portToVisit;
    private String nextPort; 
    private List<PortAreaDetails> portAreaDetails;
    private List<ImoInformation> imoInformation;
    private String dataUpdatedTime; // Add this field

    // Getters and Setters
    public long getPortCallId() {
        return portCallId;
    }

    public void setPortCallId(long portCallId) {
        this.portCallId = portCallId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVesselNamePrefix() {
        return vesselNamePrefix;
    }

    public void setVesselNamePrefix(String vesselNamePrefix) {
        this.vesselNamePrefix = vesselNamePrefix;
    }

    public String getPrevPort() {
        return prevPort;
    }

    public void setPrevPort(String prevPort) {
        this.prevPort = prevPort;
    }

    public String getPortToVisit() {
        return portToVisit;
    }

    public void setPortToVisit(String portToVisit) {
        this.portToVisit = portToVisit;
    }

    public String getNextPort() {
        return nextPort;
    }

    public void setNextPort(String nextPort) {
        this.nextPort = nextPort;
    }

    public List<PortAreaDetails> getPortAreaDetails() {
        return portAreaDetails;
    }

    public void setPortAreaDetails(List<PortAreaDetails> portAreaDetails) {
        this.portAreaDetails = portAreaDetails;
    }

    public List<ImoInformation> getImoInformation() {
        return imoInformation;
    }

    public void setImoInformation(List<ImoInformation> imoInformation) {
        this.imoInformation = imoInformation;
    }

    public String getDataUpdatedTime() {
        return dataUpdatedTime;
    }

    public void setDataUpdatedTime(String dataUpdatedTime) {
        this.dataUpdatedTime = dataUpdatedTime;
    }
  

   


}
