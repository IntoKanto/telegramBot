package com.example.testing;



public class Arrivals {
    private String name;
    private String port;
    private String etd;
    private String eta;
  

    public String getName() {
        return name;
    }public String getPort() {
        return port;
    }public String getEta() {
        return eta;
    }public String getEtd() {
        return etd;}
    
    public void setName(String name) {
        this.name = name;
    }public void setPort(String port) {
        this.port = port;
    }public void setEta(String eta) {
        this.eta = eta;
    }public void setEtd(String etd) {
        this.etd = etd; }
   


    @Override
    public String toString() {
        
        return name + eta;
    }
}
