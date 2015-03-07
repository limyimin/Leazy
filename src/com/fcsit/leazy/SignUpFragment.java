package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpFragment extends Fragment {
	EditText editTextUserName, editTextPassword, editTextConfirmPassword,
			editTextWeight, editTextHeight, editTextAge;
	Button btnCreateAccount;
	RadioButton radioBtnMale, radioBtnFemale;

	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.signup, container, false);

//		 ActionBar actionBar = getSupportActionBar();
//		 actionBar.setDisplayHomeAsUpEnabled(true);

		// get Instance of Database Adapter
		loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		// Get References of Views
		editTextUserName = (EditText) v.findViewById(R.id.edittext_username);
		editTextPassword = (EditText) v.findViewById(R.id.edittext_password);
		editTextConfirmPassword = (EditText) v
				.findViewById(R.id.edittext_confirm_password);
		editTextWeight = (EditText) v.findViewById(R.id.edittext_weight);
		editTextHeight = (EditText) v.findViewById(R.id.edittext_height);
		editTextAge = (EditText) v.findViewById(R.id.edittext_age);
		radioBtnMale = (RadioButton) v.findViewById(R.id.radio_male);
		radioBtnFemale = (RadioButton) v.findViewById(R.id.radio_female);

		btnCreateAccount = (Button) v.findViewById(R.id.button_create_account);
		btnCreateAccount.setOnClickListener(new View.OnClickListener() {

			public void onRadioButtonClicked(View view) {
				// Is the button now checked?
				boolean checked = ((RadioButton) view).isChecked();

				// Check which radio button was clicked
				switch (view.getId()) {
				case R.id.radio_male:
					if (checked)
						// Pirates are the best
						break;
				case R.id.radio_female:
					if (checked)
						// Ninjas rule
						break;
				}
			}

			public void onClick(View v) {
				// TODO Auto-generated method stub

				String userName = editTextUserName.getText().toString();
				String password = editTextPassword.getText().toString();
				String confirmPassword = editTextConfirmPassword.getText()
						.toString();
				String age = editTextAge.getText().toString();
				String weight = editTextWeight.getText().toString();
				String height = editTextHeight.getText().toString();

				// check if any of the fields are vacant
				if (userName.equals("") || password.equals("")
						|| age.equals("") || confirmPassword.equals("")
						|| weight.equals("") || height.equals("")) {
					Toast.makeText(getActivity(), "Field Vaccant",
							Toast.LENGTH_LONG).show();
					return;
				}
				// check if both password matches
				if (!password.equals(confirmPassword)) {
					Toast.makeText(getActivity(), "Password does not match",
							Toast.LENGTH_LONG).show();
					return;

				} else {
					// Save the Data in Database
					loginDataBaseAdapter.insertEntry(userName, password);
					Toast.makeText(getActivity(),
							"Account Successfully Created ", Toast.LENGTH_LONG)
							.show();
				}
			}
		});

		return v;
	}

}
