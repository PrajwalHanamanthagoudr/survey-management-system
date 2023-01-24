package com.ty.dto;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DistributeSurvey {

	@ManyToOne
	@JoinColumn
	private List<Survey> list;
	
}
