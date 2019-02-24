package com.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EDSMService {

    /**
     * Service designed to call the https://www.edsm.net/en_GB/api-v1 service
     * **/

    private final static String EDSM_URL = "https://www.edsm.net/en_GB/api-v1/system?systemName=";
    private final static String showId  = "&showId=1";
    private final static String showCoordinates = "&showCoordinates=1";
    private final static String showPermit = "&showPermit=1";
    private final static String showInformation = "&showInformation=1";
    private final static String showPrimaryStar = "&showPrimaryStar=1";
    private final static String includeHidden = "includeHidden=1";
    public static  final String STAR_IMAGE_URL = "https://www.edsm.net/img/bodies/stars/";

    private final RestTemplate restTemplate;

    public EDSMService(){
        this.restTemplate = new RestTemplate();
    }

    public Object getSystemInformation(String systemName){
        return this.restTemplate.getForObject(EDSM_URL
                + systemName
                + showId
                + showCoordinates
                + showPermit
                + showInformation
                + showPrimaryStar
                + includeHidden,Object.class);
    }
}
