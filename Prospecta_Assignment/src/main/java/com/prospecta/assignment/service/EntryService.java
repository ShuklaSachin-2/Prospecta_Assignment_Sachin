package com.prospecta.assignment.service;

import java.util.List;

import com.prospecta.assignment.dto.EntryDTO;
import com.prospecta.assignment.exceptions.EntryException;
import com.prospecta.assignment.model.Entry;

public interface EntryService {

	
	 List<EntryDTO> getAllEntryByCategory(String category) throws EntryException;

	    EntryDTO saveEntry(Entry entry) throws EntryException;

}
