package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ResultFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_result, container, false);
		
		Data bmiData = new Data();
//		float bmi = bmiData.calBMI(storedWeight, storedHeight);
		
		return v;
	}
	
	

}
