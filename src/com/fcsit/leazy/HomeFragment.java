package com.fcsit.leazy;

import com.google.android.gms.internal.bm;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeFragment extends Fragment {

	Button btnLogin, btnSignUp, btnProceed;
	LoginDataBaseAdapter loginDataBaseAdapter;
	Context context;
	EditText editTextUserName, editTextPassword;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		

		View v = inflater.inflate(R.layout.login, container, false);

		// create a instance of SQLite Database
		loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		editTextUserName = (EditText) v
				.findViewById(R.id.editTextUserNameToLogin);
		editTextPassword = (EditText) v
				.findViewById(R.id.editTextPasswordToLogin);

		btnLogin = (Button) v.findViewById(R.id.buttonLogin);
		btnSignUp = (Button) v.findViewById(R.id.buttonSignUp);
		btnProceed = (Button) v.findViewById(R.id.btn_proceed);

		// Get The Reference Of Buttons
		// btnSignIn = (Button) v.findViewById(R.id.button_signin);
		// btnSignUp = (Button) v.findViewById(R.id.button_signup);
		// btnProceed = (Button) v.findViewById(R.id.btn_proceed);
		//
		btnLogin.setOnClickListener(onClickListener);
		btnSignUp.setOnClickListener(onClickListener);
		btnProceed.setOnClickListener(onClickListener);

		return v;

		// btnSignUp.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		//
		// // / Create Intent for SignUpActivity and Start The Activity
		// Intent intentSignUP = new Intent(getActivity(),
		// SignUpFragment.class);
		// startActivity(intentSignUP);
		// }
		// });

	}

	final OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v == btnSignUp) {
				// / Create Intent for SignUpActivity and Start The Activity
				Intent intentSignUP = new Intent(getActivity(),
						SignUpActivity.class);
				startActivity(intentSignUP);

			} else if (v == btnLogin) {
				// myUtils.showDialog(context, loginDataBaseAdapter);
				// final EditText editTextUserName = (EditText) v
				// .findViewById(R.id.editTextUserNameToLogin);
				// final EditText editTextPassword = (EditText) v
				// .findViewById(R.id.editTextPasswordToLogin);

				String userName = editTextUserName.getText().toString();
				Log.d("HF", "userName=" + userName);
				String password = editTextPassword.getText().toString();
				Log.d("HF", "password=" + password);
				
				
//				Data data = getArguments().getParcelable("data");
//				data.getUsername();
//				data.getPassword();
//				data.getAge();
//				data.getWeight();
//				data.getHeight();
				// fetch the Password form database for respective user
				// nameS

				String storedPassword = loginDataBaseAdapter
						.getSinlgeEntry(userName);
				Log.d("HF", "storedPassword=" + storedPassword);// not exist

				
				
				int storedWeight = loginDataBaseAdapter
						.getSinlgeWeight(userName);
				Log.d("HF", "storedWeight=" + storedWeight);

				
				int storedHeight = loginDataBaseAdapter
						.getSinlgeHeight(userName);
				Log.d("HF", "storedHeight=" + storedHeight);

				
				
				// check if the Stored password matches with Password
				// entered by user
				if ("".equals(userName)) {
					editTextUserName.setError("Please enter your username");
				} else if ("".equals(password)) {
					editTextPassword.setError("Please enter your password");
				}

				else if (password.equals(storedPassword)) {
					Toast.makeText(getActivity(), "Congrats: Login Successful",
							Toast.LENGTH_LONG).show();
					//success login --> count user's bmi
				
					Data bmiData = new Data();
					int bmi = bmiData.bmi(storedWeight, storedHeight);
					Log.d("HF","bmi="+bmi);
					Intent bmiIntent = new Intent();
					bmiIntent.putExtra("bmi", bmi); //*not yet passed*
					Log.i("data", "HFbmi=" +bmiData);
					
					// dialog.dismiss();
			
					Intent intent = new Intent(getActivity(),
							SelectionActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(getActivity(),
							"User Name or Password does not match",
							Toast.LENGTH_LONG).show();
				}

			} else if (v == btnProceed) {
				Intent intent = new Intent(getActivity(),
						SelectionActivity.class);
				startActivity(intent);
			}

		

		}

		// private void showDialog() {
		// // TODO Auto-generated method stub
		// final Dialog dialog = new Dialog(getActivity());
		// dialog.setContentView(R.layout.login);
		// dialog.setTitle("Login");
		//
		// // get the References of views
		// final EditText editTextUserName = (EditText) dialog
		// .findViewById(R.id.editTextUserNameToLogin);
		// final EditText editTextPassword = (EditText) dialog
		// .findViewById(R.id.editTextPasswordToLogin);
		//
		// Button btnSignIn = (Button) dialog
		// .findViewById(R.id.buttonSignIn);
		//
		// // Set On ClickListener
		// btnSignIn.setOnClickListener(new View.OnClickListener() {
		//
		// public void onClick(View v) {
		// // get The User name and Password
		// String userName = editTextUserName.getText().toString();
		// Log.d("HF","userName="+userName);
		// String password = editTextPassword.getText().toString();
		// Log.d("HF","password="+password);
		//
		// // fetch the Password form database for respective user
		// // nameS
		//
		// String storedPassword = loginDataBaseAdapter
		// .getSinlgeEntry(userName);
		// Log.d("HF","storedPassword="+storedPassword);//not exist
		//
		//
		// // check if the Stored password matches with Password
		// // entered by
		// // user
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
		// }
		// });
		//
		// dialog.show();
		// }
	};
}

// public void signUp(View Vsignup){
// btnSignUp.setOnClickListener(new OnClickListener() {
// public void onClick(View v) {
// // TODO Auto-generated method stub
//
// // / Create Intent for SignUpActivity and Start The Activity
// Intent intentSignUP = new Intent(getActivity(),
// SignUpFragment.class);
// startActivity(intentSignUP);
// }
// });
// }
//
// // Methos to handleClick Event of Sign In Button
// public void signIn(View Vsignin) {
// final Dialog dialog = new Dialog(getActivity());
// dialog.setContentView(R.layout.login);
// dialog.setTitle("Login");
//
// // get the References of views
// final EditText editTextUserName = (EditText) dialog
// .findViewById(R.id.editTextUserNameToLogin);
// final EditText editTextPassword = (EditText) dialog
// .findViewById(R.id.editTextPasswordToLogin);
//
// Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);
//
// // Set On ClickListener
// btnSignIn.setOnClickListener(new View.OnClickListener() {
//
// public void onClick(View v) {
// // get The User name and Password
// String userName = editTextUserName.getText().toString();
// String password = editTextPassword.getText().toString();
//
// // fetch the Password form database for respective user name
// String storedPassword = loginDataBaseAdapter
// .getSinlgeEntry(userName);
//
// // check if the Stored password matches with Password entered by
// // user
// if (password.equals(storedPassword)) {
// Toast.makeText(getActivity(),
// "Congrats: Login Successful", Toast.LENGTH_LONG)
// .show();
// dialog.dismiss();
//
// Intent intent = new Intent(getActivity(),
// SelectionFragment.class);
// startActivity(intent);
// } else {
// Toast.makeText(getActivity(),
// "User Name or Password does not match",
// Toast.LENGTH_LONG).show();
// }
// }
// });
//
// dialog.show();
// }
//
// @Override
// public void onDestroy() {
// super.onDestroy();
// // Close The Database
// loginDataBaseAdapter.close();
// }
// }

//
//
// @Override
// protected void onDestroy() {
// super.onDestroy();
// // Close The Database
// loginDataBaseAdapter.close();
// }
// }
