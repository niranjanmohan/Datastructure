package confroomreservation;

import java.util.List;

public class Room {
	RoomSize size;
	int roomNumber;
	List<TimeSlot> timeSlots;
	boolean isMaintanenance;
	
	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public RoomSize getSize() {
		return size;
	}
	public void setSize(RoomSize size) {
		this.size = size;
	}
	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(List<TimeSlot> timeSlots) {
		
		this.timeSlots = timeSlots;
	}
	public boolean isMaintanenance() {
		return isMaintanenance;
	}
	public void setMaintanenance(boolean isMaintanenance) {
		this.isMaintanenance = isMaintanenance;
	}	
	
	
	

}
