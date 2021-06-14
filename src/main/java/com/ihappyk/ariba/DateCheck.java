package com.ihappyk.ariba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class CustomDates {
	private Date validFrom;
	private Date validTo;
	private int price;

	public CustomDates()
	{

	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "customDates [validFrom=" + validFrom + ", validTo=" + validTo + "]\n";
	}
}


public class DateCheck {

	public static void main(String[] args) throws ParseException
	{
		/*Map<String,String> map1 = new HashMap<String,String>();
		map1.put("1", "ONE");
		map1.put("2","TWO");

		System.out.println("--"+map1.toString());

		Map<String,String> map2 = new HashMap<>(map1);

		System.out.println("--"+map2.toString());*/

		List<CustomDates> datesList = new ArrayList<CustomDates>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		CustomDates cs = new CustomDates();
		cs.setValidFrom(toDate("01-09-2017",sdf));
		cs.setValidTo(toDate("15-09-2017",sdf));
		cs.setPrice(20);
		datesList.add(cs);


		CustomDates cs1 = new CustomDates();
		cs1.setValidFrom(toDate("16-09-2017",sdf));
		cs1.setValidTo(toDate("30-09-2017",sdf));
		cs1.setPrice(30);
		datesList.add(cs1);

		CustomDates cs2 = new CustomDates();
		cs2.setValidFrom(toDate("16-11-2017",sdf));
		cs2.setValidTo(toDate("30-11-2017",sdf));
		cs2.setPrice(30);

		datesList.add(cs2);

		/*
		CustomDates cs3 = new CustomDates();
		cs3.setValidFrom(toDate("16-10-2016",sdf));
		cs3.setValidTo(toDate("30-10-2016",sdf));
		cs3.setPrice(30);

		datesList.add(cs3);*/

		System.out.println(datesList);
		Collections.sort(datesList, new Comparator<CustomDates>() {
		    @Override
		    public int compare(CustomDates lhs, CustomDates rhs) {
		        if (lhs.getValidFrom().getTime() < rhs.getValidFrom().getTime() )
		            return 1;
		        else if (lhs.getValidFrom().getTime() == rhs.getValidFrom().getTime() )
		            return 0;
		        else
		            return -1;
		    }
		});

		System.out.println(datesList);


		Date today = new Date();
		System.out.println(today);
		for(CustomDates s : datesList){
			if(today.compareTo(s.getValidFrom()) >=0){
				System.out.println("--"+s);
				break;
			}
		}

		/*System.out.println(getLatestPrice(datesList));
		Date today = new Date();
		System.out.println("Current Date-"+today);
		System.out.println("Previous Date-"+gerPreviousMonth(today));*/
	}

	private static Date toDate(String sDate,SimpleDateFormat simpleDateFormat) throws ParseException
	{
		Date date = simpleDateFormat.parse(sDate);
		return date;
	}

	private static boolean dateOverlapCheck(List<CustomDates> dateList,Date start,Date End)
	{
		boolean flag = false;
		for(CustomDates cdate:dateList){
			if((cdate.getValidFrom().compareTo(End)<=0) && (start.compareTo(cdate.getValidTo())<=0) ){
				//ranges overlap
				System.out.println("date Overlapped");
				System.out.println(cdate.toString());
				flag = true;
				break;
			}
		}
		return flag;
	}

	private static int getLatestPrice(List<CustomDates> datelist){
		int price = 0;
		Date Today = new Date();
		for(CustomDates cd : datelist){
			if(Today.compareTo(cd.getValidFrom()) >= 0 && Today.compareTo(cd.getValidTo()) <= 0){
				price = cd.getPrice();
				break;
			}
		}
		return price;
	}

	public static Date gerPreviousMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		date = c.getTime();
		return date;
	}
}
