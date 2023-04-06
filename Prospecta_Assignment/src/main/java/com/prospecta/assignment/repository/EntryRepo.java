package com.prospecta.assignment.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.prospecta.assignment.model.Entry;

public interface EntryRepo  extends JpaRepository<Entry, String>{
	List<Entry> getEntrysByCategory(String category);
}
