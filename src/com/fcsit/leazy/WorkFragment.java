package com.fcsit.leazy;


import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WorkFragment extends Fragment implements OnItemSelectedListener {

	// Spinner element
	Spinner intent_work_spinner, unintent_work_spinner, time_spinner;

	// Add button
	Button btnAddBurnCal, btnTotalBurnCal;
	TextView tvTotalCal;
	String[] display;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_work, container, false);

		// Spinner element
		intent_work_spinner = (Spinner) v.findViewById(R.id.spinner_intent_work);
		unintent_work_spinner = (Spinner) v.findViewById(R.id.spinner_unintent_work);
		time_spinner = (Spinner) v.findViewById(R.id.spinner_time);
	
		Resources res = getResources();
		String[] item_exercise_intent = res.getStringArray(R.array.items_exercise_burn_intent);
		String[] item_exercise_unintent = res.getStringArray(R.array.items_exercise_burn_unintent);
		String[] item_time = res.getStringArray(R.array.items_time);

		int ex_intent_len = item_exercise_intent.length;
		display = new String[ex_intent_len];
		for (int i = 0; i < ex_intent_len; i++) {
			display[i] = String.format("%s" , item_exercise_intent[i]);
		}
		
		int ex_unintent_len = item_exercise_unintent.length;
		display = new String[ex_unintent_len];
		for (int i = 0; i < ex_unintent_len; i++) {
			display[i] = String.format("%s" , item_exercise_unintent[i]);
		}

		int time_len = item_time.length;
		display = new String[time_len];
		for (int i = 0; i < time_len; i++) {
			display[i] = String.format("%s" , item_time[i]);
		}
		

		ArrayAdapter<CharSequence> intent_adapter = new ArrayAdapter<CharSequence>(
				getActivity(), android.R.layout.simple_spinner_item, item_exercise_intent);
		ArrayAdapter<CharSequence> unintent_adapter = new ArrayAdapter<CharSequence>(
				getActivity(), android.R.layout.simple_spinner_item, item_exercise_unintent);
		ArrayAdapter<CharSequence> time_adapter = new ArrayAdapter<CharSequence>(
				getActivity(), android.R.layout.simple_spinner_item, item_time);
		
		intent_work_spinner.setAdapter(intent_adapter);
		unintent_work_spinner.setAdapter(unintent_adapter);
		time_spinner.setAdapter(time_adapter);

//		String cal = (String) spinner.getSelectedItem();
//		String str = cal.replaceAll("(.*\\s)(\\d)(.*)", "$2");
//		Log.d("ef", "str=" + str);

		btnAddBurnCal = (Button) v.findViewById(R.id.btn_quick_add_burned_calories);
		btnTotalBurnCal = (Button) v.findViewById(R.id.btn_total_calories_burned);
		tvTotalCal = (TextView) v.findViewById(R.id.textview_total_calories_burned);

		// loadSpinnerData();

		btnAddBurnCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(getActivity());
				dialog.setContentView(R.layout.calories_burned_to_add);
				dialog.setTitle("Calories Burned To Add");

				// get the References of views
				final EditText editTextAddBurnedCal = (EditText) dialog
						.findViewById(R.id.editText_cal_burned_to_add);

				Button btn_add_burn_cal = (Button) dialog
						.findViewById(R.id.button_done_add_burn_cal);

				Button btn_cancel = (Button) dialog
						.findViewById(R.id.button_cancel);

				btn_cancel.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});

				// Set On ClickListener
				btn_add_burn_cal.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// get The User name and Password
						String addBurnedCal = editTextAddBurnedCal.getText().toString();

						int burned_cal = Integer.valueOf(addBurnedCal);
						Log.d("ef", "valueOf=" + burned_cal);

					}
				});

				dialog.show();

			}
		});

		btnTotalBurnCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// display TextView of Total Calories

			}
		});

		// Spinner click listener
		intent_work_spinner.setOnItemSelectedListener(this);
		unintent_work_spinner.setOnItemSelectedListener(this);
		time_spinner.setOnItemSelectedListener(this);

		// // Loading spinner data from database
		// loadSpinnerData();
		DoneBar.setupActionBar((ActionBarActivity) getActivity(),
				new DoneBar.OnSaveActionListener() {

					@Override
					public void onSave() {
						// TODO Auto-generated method stub

					}

					@Override
					public void onCancel() {
						// TODO Auto-generated method stub
						getActivity().finish();

					}
				});

		return v;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// On selecting a spinner item
		String label = parent.getItemAtPosition(position).toString();

		// Showing selected spinner item
		Toast.makeText(parent.getContext(), "You selected: " + label,
				Toast.LENGTH_LONG).show();

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}



//package com.fcsit.leazy;
//
//import java.util.List;
//
//import android.app.Dialog;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.ActionBarActivity;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.View.OnClickListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemSelectedListener;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//public class WorkFragment extends Fragment implements OnItemSelectedListener {
//
//	// Spinner element
//	Spinner spinner;
//
//	// Add button
//	Button btnAddBurnedCal;
//
//	// Input text
//	EditText inputLabel;
//
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		View v = inflater.inflate(R.layout.fragment_work, container, false);
//
//		// Spinner element
//		spinner = (Spinner) v.findViewById(R.id.spinner_work);
//
//		Integer[] calories_burned = new Integer[] { 100, 200, 300, 400, 500 };
//		ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
//				getActivity(), android.R.layout.simple_spinner_item,
//				calories_burned);
//		spinner.setAdapter(adapter);
//		Log.d("WorkFragment", "spinner work");
//		btnAddBurnedCal = (Button) v
//				.findViewById(R.id.btn_quick_add_burned_calories);
//
////		loadSpinnerData();
//
//		// Spinner click listener
//		spinner.setOnItemSelectedListener(this);
//
//		btnAddBurnedCal.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				final Dialog dialog = new Dialog(getActivity());
//				dialog.setContentView(R.layout.burned_calories_to_add);
//				dialog.setTitle("Calories To Add");
//
//				// get the References of views
//				final EditText editTextAddBurnedCal = (EditText) dialog
//						.findViewById(R.id.editText_burned_cal_to_add);
//
//				Button btn_burned_add_cal = (Button) dialog
//						.findViewById(R.id.button_done_burned_add_cal);
//
//				// Set On ClickListener
//				btn_burned_add_cal
//						.setOnClickListener(new View.OnClickListener() {
//
//							public void onClick(View v) {
//								// get The User name and Password
//								String addBurnedCal = editTextAddBurnedCal
//										.getText().toString();
//
//								// fetch the Password form database for
//								// respective user
//								// name
//								// String storedPassword = loginDataBaseAdapter
//								// .getSinlgeEntry(userName);
//
//								// check if the Stored password matches with
//								// Password
//								// entered by
//								// user
//								// if (password.equals(storedPassword)) {
//								// Toast.makeText(getActivity(),
//								// "Congrats: Login Successful",
//								// Toast.LENGTH_LONG).show();
//								// dialog.dismiss();
//								//
//								// Intent intent = new Intent(getActivity(),
//								// SelectionActivity.class);
//								// startActivity(intent);
//								// } else {
//								// Toast.makeText(getActivity(),
//								// "User Name or Password does not match",
//								// Toast.LENGTH_LONG).show();
//								// }
//							}
//						});
//
//				dialog.show();
//
//			}
//		});
//
//		// // Loading spinner data from database
//		// loadSpinnerData();
//		DoneBar.setupActionBar((ActionBarActivity) getActivity(),
//				new DoneBar.OnSaveActionListener() {
//
//					@Override
//					public void onSave() {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onCancel() {
//						// TODO Auto-generated method stub
//						getActivity().finish();
//
//					}
//				});
//
//		return v;
//	}
//
//	/**
//	 * Function to load the spinner data from SQLite database
//	 * */
//	private void loadSpinnerData() {
//		// database handler
//		DatabaseHandler db = new DatabaseHandler(getActivity());
//
//		// Spinner Drop down elements
//		List<String> lables = db.getAllLabels();
//
//		// Creating adapter for spinner
//		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
//				getActivity(), android.R.layout.simple_spinner_item, lables);
//
//		// Drop down layout style - list view with radio button
//		dataAdapter
//				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//		// attaching data adapter to spinner
//		spinner.setAdapter(dataAdapter);
//	}
//
//	@Override
//	public void onItemSelected(AdapterView<?> parent, View view, int position,
//			long id) {
//		// On selecting a spinner item
//		String label = parent.getItemAtPosition(position).toString();
//
//		// Showing selected spinner item
//		Toast.makeText(parent.getContext(), "You selected: " + label,
//				Toast.LENGTH_LONG).show();
//
//	}
//
//	@Override
//	public void onNothingSelected(AdapterView<?> arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
//
