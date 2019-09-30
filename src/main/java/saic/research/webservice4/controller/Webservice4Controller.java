package saic.research.webservice4.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import saic.research.webservice4.domain.ResearchRecords;
import saic.research.webservice4.service.ResearchRecordsService;


@RestController
public class Webservice4Controller {

    private static final Logger logger = LoggerFactory.getLogger(Webservice4Controller.class);
    
    @Autowired
	private ResearchRecordsService researchRecordsService;
    
    
    @RequestMapping (value="/health", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<String> healthCheck()
    {
		return ResponseEntity.status(HttpStatus.OK).body("Webservice4 researchRecordsService is healthy.");
    }
    
   
    
    @RequestMapping(value="/persistRecord" ,method=RequestMethod.POST, produces="application/json")
    public ResponseEntity<String> persistFile
    (@RequestParam("title") String title, @RequestParam("status") String status, @RequestParam("findings") String findings)
    {  		
    		ResearchRecords researchRecords = new ResearchRecords();
    		researchRecords.setTitle(title);
    		researchRecords.setStatus(status);
    		researchRecords.setFindings(findings);
    		researchRecords.setRecordDate(new Date());
    		researchRecordsService.saveResearchRecords(researchRecords);
    		return ResponseEntity.status(HttpStatus.OK).body("Research record successfully saved.");
	}	
    
    @RequestMapping(value="/ResearchRecord" ,method=RequestMethod.POST, produces="application/json")
    public ResponseEntity<ResearchRecords> fetchResearchRecords
    (@RequestParam(value = "id", required=false) Integer id)
    {  		
    		ResearchRecords researchRecords = researchRecordsService.getResearchRecordById(id);
    		return ResponseEntity.status(HttpStatus.OK).body(researchRecords);
	}	
}

