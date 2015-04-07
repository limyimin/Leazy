package com.fcsit.leazy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
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
	Context myContext;
	
	String gender;

	Data suData;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.signup, container, false);

		// ActionBar actionBar = getSupportActionBar();
		// actionBar.setDisplayHomeAsUpEnabled(true);

		// get Instance of Database Adapter
		loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		// Get References of Views
		editTextUserName = (EditText) v.findViewById(R.id.edittext_username);
		// if (condition) {
		//
		// }
		editTextPassword = (EditText) v.findViewById(R.id.edittext_password);
		editTextConfirmPassword = (EditText) v
				.findViewById(R.id.edittext_confirm_password);
		editTextWeight = (EditText) v.findViewById(R.id.edittext_weight);
		editTextHeight = (EditText) v.findViewById(R.id.edittext_height);
		editTextAge = (EditText) v.findViewById(R.id.edittext_age);
		radioBtnMale = (RadioButton) v.findViewById(R.id.radio_male);
		radioBtnFemale = (RadioButton) v.findViewById(R.id.radio_female);

		btnCreateAccount = (Button) v.findViewById(R.id.button_create_account);

		suData = new Data();

		btnCreateAccount.setOnClickListener(new View.OnClickListener() {

			public String onRadioButtonClicked(View view) {
				// Is the button now checked?
				boolean checked = ((RadioButton) view).isChecked();

				// Check which radio button was clicked
				gender = "";
				switch (view.getId()) {
				case R.id.radio_male:
					if (checked)
						gender = "M";
						
						break;
				case R.id.radio_female:
					if (checked)
						gender = "F";
						
						break;
				}
				return gender;
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


				isAllFieldsValid();

				// check if any of the fields are vacant
				if (userName.equals("") || password.equals("")
						|| age.equals("") || confirmPassword.equals("")
						|| weight.equals("") || height.equals("")) {
					// Toast.makeText(getActivity(), "Field Vaccant",
					// Toast.LENGTH_LONG).show();
					return;
				}
				// check if both password matches
				if (!password.equals(confirmPassword)) {
					Toast.makeText(getActivity(), "Password does not match",
							Toast.LENGTH_LONG).show();
					return;

				} else {
					
					//Pass data to the page with login activity
					Data data = getData();
					Intent intent = new Intent(getActivity(), MainActivity.class);
					intent.putExtra("data", data); //which contains 6 (age...bmi)
					startActivity(intent);
					//equivalent to:
//					suData.setUsername(userName);
//					suData.setPassword(password);
//					suData.setAge(su_age);
//					suData.setGender(gender);
//					suData.setWeight(su_weight);
//					suData.setHeight(su_height);
					

					loginDataBaseAdapter.insertEntry(data);
					Toast.makeText(getActivity(),
							"Account Successfully Created ", Toast.LENGTH_LONG)
							.show();
					// myUtils.showDialog(myContext, loginDataBaseAdapter);
				}
			}

		});

		return v;
	}

	private boolean isAllFieldsValid() {
		boolean valid = true;
		String trim_userName = editTextUserName.getText().toString().trim();
		if ("".equals(trim_userName)) {
			editTextUserName.setError("Please enter your username");
			valid = false;
		}
		String trim_pasword = editTextPassword.getText().toString().trim();
		if ("".equals(trim_pasword)) {
			editTextPassword.setError("Please enter your password");
			valid = false;
		}
		String trim_confirm_pwd = editTextConfirmPassword.getText().toString()
				.trim();
		if ("".equals(trim_confirm_pwd)) {
			editTextConfirmPassword
					.setError("Please enter your confirmed password");
			valid = false;
		}
		String trim_weight = editTextWeight.getText().toString().trim();
		if ("".equals(trim_weight)) {
			editTextWeight.setError("Please enter your weight");
			valid = false;
		}
		String trim_height = editTextHeight.getText().toString().trim();
		if ("".equals(trim_height)) {
			editTextHeight.setError("Please enter your height");
			valid = false;
		}
		String trim_age = editTextAge.getText().toString().trim();
		if ("".equals(trim_age)) {
			editTextAge.setError("Please enter your age");
			valid = false;
		}
		if (radioBtnFemale.isChecked() == false
				&& radioBtnMale.isChecked() == false) {
			Toast.makeText(getActivity(), "Please select your gender",
					Toast.LENGTH_SHORT).show();
			;
			return false;
		}
		return valid;
	}
	
	private Data getData() {
		// TODO Auto-generated method stub
		
		String userName = editTextUserName.getText().toString();
		String password = editTextPassword.getText().toString();
//		String confirmPassword = editTextConfirmPassword.getText()
//				.toString();
		int su_age = Integer.valueOf(editTextAge.getText().toString());
		int su_weight = Integer.valueOf(editTextWeight.getText().toString());

		int su_height = Integer.valueOf(editTextHeight.getText().toString());
		
//		Data data = new Data();
//		int h = data.getHeight();
//		int w = data.getWeight();
//		int bmi = data.bmi(w, h);
		
		Data allData = new Data(userName, password, su_age, su_weight, su_height);
		Log.i("all data", "signup="+ allData.toString());
		return allData;
		
	}
}
