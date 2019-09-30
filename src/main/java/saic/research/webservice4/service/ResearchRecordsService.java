package saic.research.webservice4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import saic.research.webservice4.domain.ResearchRecords;

@Service
public interface ResearchRecordsService {
	
	public  ResearchRecords getResearchRecordById(Integer id);
	public  List<ResearchRecords> getAllResearchRecords();
	public void saveResearchRecords(ResearchRecords researchRecords);	
}
