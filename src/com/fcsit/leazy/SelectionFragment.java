package com.fcsit.leazy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SelectionFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_activity_selection, container, false);

		((ActionBarActivity) getActivity()).getSupportActionBar().hide();

		Button eat = (Button)v.findViewById(R.id.button_eat);
		Button work = (Button)v.findViewById(R.id.button_work);
		Button heart = (Button)v.findViewById(R.id.button_heart);
		Button pedo = (Button)v.findViewById(R.id.button_pedo);
		Button result = (Button)v.findViewById(R.id.button_result);

		eat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent eatIntent = new Intent(getActivity(), EatActivity.class);
				startActivity(eatIntent);

			}
		});

		work.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent workIntent = new Intent(getActivity(), WorkActivity.class);
				startActivity(workIntent);

			}
		});

		heart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent heartIntent = new Intent(getActivity(), HeartActivity.class);
				startActivity(heartIntent);

			}
		});

		pedo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent pedoIntent = new Intent(getActivity(), PedoActivity.class);
				startActivity(pedoIntent);

			}
		});

		result.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent resultIntent = new Intent(getActivity(), ResultActivity.class);
				startActivity(resultIntent);

			}
		});

		
		return v;
	}

}
