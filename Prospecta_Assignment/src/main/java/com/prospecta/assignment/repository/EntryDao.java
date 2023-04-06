package com.prospecta.assignment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prospecta.assignment.model.Entry;

@Repository
public class EntryDao {

	
	 @Autowired
	    private EntryRepo eRepo;

	 public List<Entry> getEntrysByCategory(String category) {
	        List<Entry> Entrys = eRepo.getEntrysByCategory(category);
	        for (Entry Entry : Entrys) {
	            if (Entry.getCategory() != null) {
	                System.out.println(Entry.getTitle() + " - " + Entry.getDescription());
	            }
	        }
	        return Entrys;
	    }

	    public Entry save(Entry Entry) {
	        return eRepo.save(Entry);
	    }
}
