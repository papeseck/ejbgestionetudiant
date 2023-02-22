package com.groupeisi.dao;
import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Year;



@Local
public interface IYear   {
	public Year addYear(Year y);
	public Year getYearByID(int id);
	public Year updateYear(Year y);
	public int removeYear(int id);
	public List<Year> getAllYears();
	
}

