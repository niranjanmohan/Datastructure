package confroomreservation;

import java.util.Date;

public class TimeSlot{
	Date startDateTime;
	Date endDateTime;
	Float duration;
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	
	public boolean isInBetween(TimeSlot timeslot){
		if(this.startDateTime.after(timeslot.getEndDateTime()) || this.endDateTime.before(timeslot.startDateTime))
			return false;
		return true;
	}
	
}
