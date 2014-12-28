package confroomreservation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class EmployeeImpl implements Employee{
	int id;
	String name;
	Map<String,Integer> hasReservation;
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		// TODO Auto-generated method stub
		
	}
	public boolean canReserve(int roomNo,Date date){
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = s.format(date);
		if (hasReservation.containsKey(sDate))
			return false;
		else
			return true;
		
	}
	
	public void setReservation(int roomNo,Date date){
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = s.format(date);
		hasReservation.put(sDate, roomNo);
	}
	public boolean removeReservation(Date date){
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = s.format(date);
		if(hasReservation.containsKey(sDate))
			hasReservation.remove(sDate);
		else
			return false;
		return true;
	}

}
