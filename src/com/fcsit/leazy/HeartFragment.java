package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HeartFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_heart_front, container, false);
		
		Button btnStart = (Button) v.findViewById(R.id.button_start);
		TextView tvBpm = (TextView) v.findViewById(R.id.textView_bpm);
		
		
		
		//btnStart fires the camera to scan finger.
		
		
		return v; 
	}

}
