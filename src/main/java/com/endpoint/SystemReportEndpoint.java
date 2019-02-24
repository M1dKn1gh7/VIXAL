package com.endpoint;

import com.report.SystemReport;
import com.service.SystemReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/system_report")
public class SystemReportEndpoint {

    private final SystemReportService systemReportService;

    public SystemReportEndpoint(SystemReportService systemReportService){
        this.systemReportService = systemReportService;
    }

    @GetMapping(path = "get_current_system", produces = "application/json")
    public SystemReport getCurrentSystem(){
      return this.systemReportService.getCurrentSystem();
    }
}
