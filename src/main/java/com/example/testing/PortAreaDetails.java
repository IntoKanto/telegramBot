package com.example.testing;



public class PortAreaDetails {
    private String eta;
    private String etd;
    private String portAreaName;

    public String getEta() {
        return eta;
    }
    public String getEtd() {
        return etd;
    }
    public String getPortAreaName() {
        return portAreaName;
    }public void setEta(String eta) {
        this.eta = eta;
    }public void setEtd(String etd) {
        this.etd = etd;
    }public void setPortAreaName(String portAreaName) {
        this.portAreaName = portAreaName;
    }

    @Override
    public String toString() {
        return "Port Area Name: " + portAreaName + "ETA:" + eta;
    }


}
