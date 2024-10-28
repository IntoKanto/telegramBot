package com.example.testing;

public class Departures {
    private String name;
    private String port;
    private String etd;
    

    public String getName() {
        return name;
    }public String getPort() {
        return port;
    }
    public String getEtd() {
        return etd;}
    
    public void setName(String name) {
        this.name = name;
    }public void setPort(String port) {
        this.port = port;
    
    }public void setEtd(String etd) {
        this.etd = etd; }
   


    @Override
    public String toString() {
        
        return name + etd;
    }
}
