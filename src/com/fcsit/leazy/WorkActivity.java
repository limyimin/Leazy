package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class WorkActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.frame);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);

		if (savedInstanceState == null) {

			WorkFragment workfragment = new WorkFragment();
			Bundle extra = getIntent().getExtras();
			workfragment.setArguments(extra);

			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction().add(R.id.fragment_container, workfragment);

			ft.commit();

		}

	}


}
