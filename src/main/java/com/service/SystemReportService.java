package com.service;

import com.report.SystemReport;
import me.apemanzilla.edjournal.events.FSDJump;
import org.springframework.stereotype.Component;

@Component
public class SystemReportService {

    private final EDJournalService edJournalService;
    private final EDSMService edsmService;

    public SystemReportService(EDJournalService edJournalService, EDSMService edsmService) {
        this.edJournalService = edJournalService;
        this.edsmService = edsmService;
    }

    public SystemReport getCurrentSystem(){
        String currentSystemName = "Maia";

        return new SystemReport.SystemReportBuilder(currentSystemName)
                .withSpectralClass(lookUpSpectralClass(currentSystemName))
                .withSpectralId(lookUpSpectralId(lookUpSpectralClass(currentSystemName)))
                .withStarImageUrl(buildStarImageUrl(lookUpSpectralId(lookUpSpectralClass(currentSystemName)))).build();
    }

    private String buildStarImageUrl(int spectralId) {
        return EDSMService.STAR_IMAGE_URL + spectralId + ".png";
    }

    private Integer lookUpSpectralId(String spectralClass) {
        //look at the returned report from edsm, lookup the star class in a db table with ids and the id that matches is the right one
        return 0;
    }

    private String lookUpSpectralClass(String currentSystemName) {
        //call edsm and get its report and pull it from there
        return null;
    }

    private String getCurrentSystemName() {
       return this.edJournalService.getJournalInstance().lastEventOfType(FSDJump.class)
                .map(FSDJump::getStarSystem)
                .orElse("Unknown location");
    }
}
