package com.prospecta.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.assignment.dto.AllEntryDTO;
import com.prospecta.assignment.dto.EntryDTO;
import com.prospecta.assignment.exceptions.EntryException;
import com.prospecta.assignment.model.Entry;
import com.prospecta.assignment.repository.EntryDao;

import com.prospecta.assignment.service.EntryService;

@RestController
public class EntryController {
	
//
    @Autowired
    private EntryService entryService;
    
    @Autowired
    private EntryDao eDao;
//
    @GetMapping("/{category}")
    public ResponseEntity<List<EntryDTO>> getAllEntryByCategoryHandler(@RequestParam("category") String category) throws EntryException {
        return new ResponseEntity<List<EntryDTO>>(entryService.getAllEntryByCategory(category), HttpStatus.OK);
    }
	
	 	

	  

	    @PostMapping("/Entry")
	    public Entry saveEntry() {
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<Entry>> response = restTemplate.getForEntity("https://Entry.publicEntrys.org/entries", Entry.class);
	        
	        Entry EntryResponse = response.getBody();
	        Entry Entry = new Entry();
	        Entry.setTitle(EntryResponse.getTitle());
	        Entry.setDescription(EntryResponse.getDescription());
	        Entry.setAuth(EntryResponse.getAuth());
//	        Entry.setHttps(EntryResponse.getHttps());
	        Entry.setCors(EntryResponse.getCors());
	        Entry.setLink(EntryResponse.getLink());
	        return eDao.save(Entry);
	    }

}
