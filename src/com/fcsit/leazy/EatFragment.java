package com.fcsit.leazy;

import android.app.Dialog;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EatFragment extends Fragment implements OnItemSelectedListener {

	// Spinner element
	Spinner spinner;

	// Add button
	Button btnAddCal, btnAllCal;
	TextView tvTotalCal;
	String[] display;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_eat, container, false);

		// Spinner element
		spinner = (Spinner) v.findViewById(R.id.spinner_eat);
		// Integer[] calories = new Integer[] { 100, 200, 300, 400, 500 };
		// System.out.print(calories[0]);
		// int a = calories[0];
		Resources res = getResources();
		String[] item_food = res.getStringArray(R.array.items_food);
		String[] item_kcal = res.getStringArray(R.array.items_kcal);

		int len = Math.min(item_food.length, item_kcal.length);
		display = new String[len];
		for (int i = 0; i < len; i++) {
			display[i] = String.format("%s %skcal", item_food[i], item_kcal[i]);
		}

		// display = new String[] { (item_food[0]+" " + item_kcal[0] + "kcal"),
		// (item_food[1] +" "+ item_kcal[1] + "kcal"),
		// (item_food[2] +" "+ item_kcal[2] + "kcal"),
		// (item_food[3] +" "+ item_kcal[3] + "kcal"),
		// (item_food[4] +" "+ item_kcal[4] + "kcal"),
		// (item_food[5] +" "+ item_kcal[5] + "kcal") };
		// Log.d("EatFragment", "display food [0]= " + display[0]);

		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
				getActivity(), android.R.layout.simple_spinner_item, display);
		spinner.setAdapter(adapter);

		String cal = (String) spinner.getSelectedItem();
		String str = cal.replaceAll("(.*\\s)(\\d)(.*)", "$2");
		Log.d("ef", "str=" + str);

		btnAddCal = (Button) v.findViewById(R.id.btn_quick_add_calories);
		btnAllCal = (Button) v.findViewById(R.id.btn_total_calories);
		tvTotalCal = (TextView) v.findViewById(R.id.textview_total_calories);

		// loadSpinnerData();

		btnAddCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(getActivity());
				dialog.setContentView(R.layout.calories_to_add);
				dialog.setTitle("Calories To Add");

				// get the References of views
				final EditText editTextAddCal = (EditText) dialog
						.findViewById(R.id.editText_cal_to_add);

				Button btn_add_cal = (Button) dialog
						.findViewById(R.id.button_done_add_cal);

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
				btn_add_cal.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// get The User name and Password
						String addCal = editTextAddCal.getText().toString();

						int cal = Integer.valueOf(addCal);
						Log.d("ef", "valueOf=" + cal);

					}
				});

				dialog.show();

			}
		});

		btnAllCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// display TextView of Total Calories

			}
		});

		// Spinner click listener
		spinner.setOnItemSelectedListener(this);

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
	// private void loadSpinnerData() {
	// // database handler
	// DatabaseHandler db = new DatabaseHandler(getActivity());
	//
	// // Spinner Drop down elements
	// List<String> lables = db.getAllLabels();
	//
	// // Creating adapter for spinner
	// ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
	// getActivity(), android.R.layout.simple_spinner_item, lables);
	//
	// // Drop down layout style - list view with radio button
	// dataAdapter
	// .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	//
	// // attaching data adapter to spinner
	// spinner.setAdapter(dataAdapter);
	// }

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
