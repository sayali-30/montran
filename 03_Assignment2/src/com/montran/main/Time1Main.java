package com.montran.main;

import com.montran.pojo.Time1;

public class Time1Main 
{
	public static void main(String[] args) 
	{
		Time1 t1 = new Time1();
		Time1 t2 = new Time1();
		Time1 t3 = new Time1();
		
		t1.setTime1(2, 45);
		t2.setTime1(1, 45);
	
		t3.sumTime1(t1, t2);
		
		System.out.println("\nTime 1 : " + t1.showTime1());
		System.out.println("\nTime 2 : " + t2.showTime1());
		System.out.println("\nSum : " + t3.showTime1());
	}
}


/***** OUTPUT *****

Time 1 : Time1 [hours=2, minutes=45]

Time 2 : Time1 [hours=1, minutes=45]

Sum : Time1 [hours=4, minutes=30]

*/