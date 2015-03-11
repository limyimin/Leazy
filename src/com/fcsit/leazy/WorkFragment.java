package com.fcsit.leazy;

import java.util.List;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
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
import android.widget.Toast;

public class WorkFragment extends Fragment implements OnItemSelectedListener {

	// Spinner element
	Spinner spinner;

	// Add button
	Button btnAddBurnedCal;

	// Input text
	EditText inputLabel;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_work, container, false);

		// Spinner element
		spinner = (Spinner) v.findViewById(R.id.spinner_work);
		btnAddBurnedCal = (Button) v
				.findViewById(R.id.btn_quick_add_burned_calories);

		loadSpinnerData();

		// Spinner click listener
		spinner.setOnItemSelectedListener(this);

		btnAddBurnedCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(getActivity());
				dialog.setContentView(R.layout.burned_calories_to_add);
				dialog.setTitle("Calories To Add");

				// get the References of views
				final EditText editTextAddBurnedCal = (EditText) dialog
						.findViewById(R.id.editText_burned_cal_to_add);

				Button btn_burned_add_cal = (Button) dialog
						.findViewById(R.id.button_done_burned_add_cal);

				// Set On ClickListener
				btn_burned_add_cal
						.setOnClickListener(new View.OnClickListener() {

							public void onClick(View v) {
								// get The User name and Password
								String addBurnedCal = editTextAddBurnedCal
										.getText().toString();

								// fetch the Password form database for
								// respective user
								// name
								// String storedPassword = loginDataBaseAdapter
								// .getSinlgeEntry(userName);

								// check if the Stored password matches with
								// Password
								// entered by
								// user
								// if (password.equals(storedPassword)) {
								// Toast.makeText(getActivity(),
								// "Congrats: Login Successful",
								// Toast.LENGTH_LONG).show();
								// dialog.dismiss();
								//
								// Intent intent = new Intent(getActivity(),
								// SelectionActivity.class);
								// startActivity(intent);
								// } else {
								// Toast.makeText(getActivity(),
								// "User Name or Password does not match",
								// Toast.LENGTH_LONG).show();
								// }
							}
						});

				dialog.show();

			}
		});

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

	/**
	 * Function to load the spinner data from SQLite database
	 * */
	private void loadSpinnerData() {
		// database handler
		DatabaseHandler db = new DatabaseHandler(getActivity());

		// Spinner Drop down elements
		List<String> lables = db.getAllLabels();

		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, lables);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);
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

//
// import java.util.List;
//
// import android.app.Activity;
// import android.content.Context;
// import android.os.Bundle;
// import android.view.View;
// import android.view.inputmethod.InputMethodManager;
// import android.widget.AdapterView;
// import android.widget.AdapterView.OnItemSelectedListener;
// import android.widget.ArrayAdapter;
// import android.widget.Button;
// import android.widget.EditText;
// import android.widget.Spinner;
// import android.widget.Toast;
//
// public class AndroidSpinnerFromSQLiteActivity extends Activity implements
// OnItemSelectedListener {
//
// // Spinner element
// Spinner spinner;
//
// // Add button
// Button btnAdd;
//
// // Input text
// EditText inputLabel;
//
// @Override
// public void onCreate(Bundle savedInstanceState) {
// super.onCreate(savedInstanceState);
// setContentView(R.layout.main);
//
// // Spinner element
// spinner = (Spinner) findViewById(R.id.spinner);
//
// // add button
// btnAdd = (Button) findViewById(R.id.btn_add);
//
// // new label input field
// inputLabel = (EditText) findViewById(R.id.input_label);
//
// // Spinner click listener
// spinner.setOnItemSelectedListener(this);
//
// // Loading spinner data from database
// loadSpinnerData();
//
// /**
// * Add new label button click listener
// * */
// btnAdd.setOnClickListener(new View.OnClickListener() {
//
// @Override
// public void onClick(View arg0) {
// String label = inputLabel.getText().toString();
//
// if (label.trim().length() > 0) {
// // database handler
// DatabaseHandler db = new DatabaseHandler(
// getApplicationContext());
//
// // inserting new label into database
// db.insertLabel(label);
//
// // making input filed text to blank
// inputLabel.setText("");
//
// // Hiding the keyboard
// InputMethodManager imm = (InputMethodManager)
// getSystemService(Context.INPUT_METHOD_SERVICE);
// imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);
//
// // loading spinner with newly added data
// loadSpinnerData();
// } else {
// Toast.makeText(getApplicationContext(), "Please enter label name",
// Toast.LENGTH_SHORT).show();
// }
//
// }
// });
// }
//
// /**
// * Function to load the spinner data from SQLite database
// * */
// private void loadSpinnerData() {
// // database handler
// DatabaseHandler db = new DatabaseHandler(getApplicationContext());
//
// // Spinner Drop down elements
// List<String> lables = db.getAllLabels();
//
// // Creating adapter for spinner
// ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
// android.R.layout.simple_spinner_item, lables);
//
// // Drop down layout style - list view with radio button
// dataAdapter
// .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
// // attaching data adapter to spinner
// spinner.setAdapter(dataAdapter);
// }
//
// @Override
// public void onItemSelected(AdapterView<?> parent, View view, int position,
// long id) {
// // On selecting a spinner item
// String label = parent.getItemAtPosition(position).toString();
//
// // Showing selected spinner item
// Toast.makeText(parent.getContext(), "You selected: " + label,
// Toast.LENGTH_LONG).show();
//
// }
//
// @Override
// public void onNothingSelected(AdapterView<?> arg0) {
// // TODO Auto-generated method stub
//
// }
// }
