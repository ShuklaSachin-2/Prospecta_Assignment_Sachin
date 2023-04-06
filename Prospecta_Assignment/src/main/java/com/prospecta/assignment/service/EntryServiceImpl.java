package com.prospecta.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.assignment.dto.AllEntryDTO;
import com.prospecta.assignment.dto.EntryDTO;
import com.prospecta.assignment.exceptions.EntryException;
import com.prospecta.assignment.model.Entry;
import com.prospecta.assignment.repository.EntryRepo;

@Service
public class EntryServiceImpl implements EntryService{

	
//	 private static final String BASE_URL = "https://api.publicapis.org/entries?category=";
	    private RestTemplate restTemplate = new RestTemplate();
	    
	    @Autowired
	    private EntryRepo eDao;

	    @Override
	    public List<EntryDTO> getAllEntryByCategory(String category) throws EntryException {

	        AllEntryDTO allEntryDTO = restTemplate.getForObject("https://api.publicapis.org/entries" , AllEntryDTO.class);
	        System.out.println(allEntryDTO);
	        List<EntryDTO> entries = new ArrayList<>();

	        if (allEntryDTO.getEntries().isEmpty()) throw new EntryException("No Entry found to load!");

	        for (Entry entry : allEntryDTO.getEntries()) {
	            if (entry.getCategory().equalsIgnoreCase(category)) {
	                EntryDTO dto = new EntryDTO();
	                dto.setDescription(entry.getDescription());
	                dto.setTitle(entry.getTitle());
	                entries.add(dto);
	            }
	        }

	        return entries;
	    }

	    @Override
	    public EntryDTO saveEntry(Entry entry) throws EntryException {
	        return null;
	    }
}
