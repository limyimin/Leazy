package com.fcsit.leazy;

import com.fcsit.leazy.heartmonitor.HeartRateMonitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
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
		
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//btnStart fires the camera to scan finger.
				Intent heartIntent = new Intent(getActivity(), HeartRateMonitor.class);
				startActivity(heartIntent);
			}
		});
		
		
		
		
		return v; 
	}

}
