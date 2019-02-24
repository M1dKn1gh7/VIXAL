package com.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize(builder = SystemReport.SystemReportBuilder.class)
public class SystemReport {

    private final String systemName;
    private final String spectralClass;
    private final Integer spectralId;
    private final String starImageUrl;

    public SystemReport(SystemReportBuilder systemReportBuilder) {
        this.systemName = systemReportBuilder.systemName;
        this.spectralClass = systemReportBuilder.spectralClass;
        this.spectralId = systemReportBuilder.spectralId;
        this.starImageUrl = systemReportBuilder.starImageUrl;
    }


    public String getSpectralClass() {
        return spectralClass;
    }

    public int getSpectralId() {
        return spectralId;
    }

    public String getStarImageUrl() {
        return starImageUrl;
    }

    public String getSystemName() {
        return systemName;
    }

    @JsonPOJOBuilder
    public static class SystemReportBuilder {

        String systemName;

        String spectralClass = null;
        Integer spectralId = null;
        String starImageUrl = null;

        public SystemReportBuilder(@JsonProperty("systemName") String systemName){
            this.systemName = systemName;
        }

        public SystemReportBuilder withSpectralClass(String spectralClass){
            this.spectralClass = spectralClass;
            return this;
        }

        public SystemReportBuilder withSpectralId(int spectralId){
            this.spectralId = spectralId;
            return this;
        }

        public SystemReportBuilder withStarImageUrl(String starImageUrl){
            this.starImageUrl  = starImageUrl;
            return this;
        }

        public SystemReport build(){
            return new SystemReport(this);
        }
    }
}
