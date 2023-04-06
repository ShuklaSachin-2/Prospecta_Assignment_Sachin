package com.prospecta.assignment.dto;

import java.io.Serializable;
import java.util.List;

import com.prospecta.assignment.model.Entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AllEntryDTO implements Serializable {

	 private Integer count;
	    private List<Entry> entries;
//	    private String category;
	
}
