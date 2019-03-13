package com.athensoft.content.event.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A concrete class of event, represents an activity
 * 
 * @author Athens
 * @version 1.0 
 */
@Getter
@Setter
@ToString
public class Activity extends Event {
	
	/**
	 * the start date of the activity, a timestamp
	 */
	private Date activityStartDate;
	
	/**
	 * the end date of the activity, a timestamp
	 */
	private Date activityEndDate;
	
	/**
	 * the location of the activity
	 */
	private String activityLocation;
	
}
