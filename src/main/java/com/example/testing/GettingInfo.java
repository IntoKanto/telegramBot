package com.example.testing;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.zip.GZIPInputStream;

public class GettingInfo {

    public PortCall[] getInfo() {
        LocalDate date = LocalDate.now();
        
        DateTimeFormatter dateF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String depdate = date.format(dateF);
        String arrdate = date.minusDays(1).format(dateF);
        System.out.println(arrdate + depdate);
        
        try {
            URL urlObj = new URL("https://meri.digitraffic.fi/api/port-call/v1/port-calls?etaFrom="+ arrdate + "T00%3A00%3A00.000Z&etaTo=" + depdate + "T23%3A00%3A00.000Z");
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Encoding", "gzip");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                System.out.println("Response Code: " + responseCode);
                String encoding = conn.getContentEncoding();
                InputStream inputStream = conn.getInputStream();

                // Check for gzip encoding
                if ("gzip".equalsIgnoreCase(encoding)) {
                    inputStream = new GZIPInputStream(inputStream);
                    System.out.println("IT IS GZIP");
                }

                StringBuilder response = new StringBuilder();
                
                try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

                

                // Parse the JSON response using org.json
            JSONObject jsonObject = new JSONObject(response.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("portCalls");

            // Configure ObjectMapper to ignore unknown properties
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            // Convert JSONArray to PortCall[]
            PortCall[] portCalls = mapper.readValue(jsonArray.toString(), PortCall[].class);
            
            
            /*List<Arrivals> vessels = new ArrayList<>();
            for(PortCall portcall: portCalls) {
                vessel.setName(portcall.getVesselName());
                List<PortAreaDetails> portDetails = portcall.getPortAreaDetails();
                for(PortAreaDetails details: portDetails) {
                    vessel.setEta(details.getEta());
                    vessel.setEtd(details.getEtd());
                    vessels.add(vessel);
                }
            }
            System.out.println(vessels.size());
            */
              // Example of accessing the data
          /*  for (PortCall portCall : portCalls) {
            if (portCall.getVesselName().equals("Megastar") ||portCall.getVesselName().equals("Finlandia") ||portCall.getVesselName().equals("MyStar")) {
                Vessel vessel = new Vessel();
                vessel.setName(portCall.getVesselName());
                List<PortAreaDetails> portAreaDetails = portCall.getPortAreaDetails();
                for(PortAreaDetails details : portAreaDetails ) {
                    vessel.setEta(details.getEta());
                    vessel.setEtd(details.getEtd());
                }
                
                
                vessels.add(vessel);
            }
            
        } */
            
            return portCalls; // Convert PortCall[] to String
            } else {
                System.out.println("Failed to connect, response code: " + responseCode);
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    
}
