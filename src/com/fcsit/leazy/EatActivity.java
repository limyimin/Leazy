package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class EatActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.frame);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);

		if (savedInstanceState == null) {

			EatFragment eatfragment = new EatFragment();
			Bundle extra = getIntent().getExtras();
			eatfragment.setArguments(extra);

			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction().add(R.id.fragment_container, eatfragment);

			ft.commit();

		}

	}


}
