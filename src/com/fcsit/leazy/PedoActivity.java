package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class PedoActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.frame);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {

			PedoFragment pedofragment = new PedoFragment();
			Bundle extra = getIntent().getExtras();
			pedofragment.setArguments(extra);

			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction().add(R.id.fragment_container, pedofragment);

			ft.commit();

		}

	}


}
