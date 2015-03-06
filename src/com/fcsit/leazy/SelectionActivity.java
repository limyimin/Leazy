package com.fcsit.leazy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class SelectionActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.frame);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {

			SelectionFragment selectionfragment = new SelectionFragment();
			Bundle extra = getIntent().getExtras();
			selectionfragment.setArguments(extra);

			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction().add(
					R.id.fragment_container, selectionfragment);

			ft.commit();

		}

	}

}
