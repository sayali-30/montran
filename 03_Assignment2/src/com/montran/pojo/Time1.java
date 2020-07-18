package com.montran.pojo;

public class Time1
{
	public int hours, minutes;
	
	public void setTime1(int hours, int minutes)
	{
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public Time1 showTime1()
	{
		return this;
	}
	
	public Time1 sumTime1(Time1 time1, Time1 time2)
	{
		minutes = time1.minutes + time2.minutes;
		hours = time1.hours + time2.hours + minutes/60;
		minutes = minutes % 60;
		
		return  this;
	}

	@Override
	public String toString() 
	{
		return "Time1 [hours=" + hours + ", minutes=" + minutes + "]";
	}
}

