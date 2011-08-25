package com.t2.compassionDB;

import java.util.ArrayList;

import spine.datamodel.MindsetData;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.t2.compassionMeditation.Constants;

@DatabaseTable
public class BioSession {

	public static final String USER_ID_FIELD_NAME = "user_id";	
	
	
	// id is generated by the database and set on the object automagically
	@DatabaseField(generatedId = true)
	int id;	
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = USER_ID_FIELD_NAME)
	private BioUser bioUser;
	
	
	@DatabaseField
	public long time;
	@DatabaseField
	private double valueSum = 0.00;
	@DatabaseField
	private int count = 0;

	
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public int[] minFilteredValue = new int[Constants.MAX_KEY_ITEMS];
	
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public int[] maxFilteredValue = new int[Constants.MAX_KEY_ITEMS];
	
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public int[] avgFilteredValue = new int[Constants.MAX_KEY_ITEMS];
	
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public String[] keyItemNames = new String[Constants.MAX_KEY_ITEMS];
	
//	@DatabaseField
//	public String mindsetBandOfInterest = "";

	@DatabaseField
	public int mindsetBandOfInterestIndex = 0;

//	@DatabaseField
//	public String bioHarnessParameterOfInterest = "";

	@DatabaseField
	public int bioHarnessParameterOfInterestIndex = 0;

	
	
	@DatabaseField
	public String comments = "";

	@DatabaseField
	public String category = "";

	@DatabaseField
	public int secondsCompleted = 0;
	
	@DatabaseField
	public int precentComplete = 0;
	
	@DatabaseField
	public String logFileName = "";
	

	@DatabaseField(dataType=DataType.SERIALIZABLE)
	private ArrayList<Double> values = new ArrayList<Double>();
	
	public BioSession() {
		// needed by ormlite
	}
	
	public BioSession(BioUser bioUser, long time) {
		this.bioUser = bioUser;
		this.time = time;
	}
	
//	public void addValue(double val) {
//		values.add(val);
//		valueSum += val;
//		++count;
//		
//		if(val > maxValue || count == 1) {
//			maxValue = val;
//		}
//		
//		if(val < minValue || count == 1) {
//			minValue = val;
//		}
//	}
	
//	public double getAverageValue() {
//		if(valueSum == 0 && count == 0) {
//			return defaultValue;
//		}
//		return valueSum / count;
//	}
	
	public double[] getValues() {
		double[] out = new double[values.size()];
		for(int i = 0; i < values.size(); ++i) {
			out[i] = values.get(i);
		}
		return out;
	}
}
