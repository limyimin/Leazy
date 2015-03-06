package com.fcsit.leazy;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeFragment extends Fragment {

	Button btnSignIn, btnSignUp;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.main, container, false);

		// create a instance of SQLite Database
		loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		// Get The Reference Of Buttons
		btnSignIn = (Button) v.findViewById(R.id.buttonSignIN);
		btnSignUp = (Button) v.findViewById(R.id.buttonSignUP);

		btnSignUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// / Create Intent for SignUpActivity and Start The Activity
				Intent intentSignUP = new Intent(getActivity(),
						SignUpFragment.class);
				startActivity(intentSignUP);
			}
		});

		return v;

	}

	// Methos to handleClick Event of Sign In Button
	public void signIn(View V) {
		final Dialog dialog = new Dialog(getActivity());
		dialog.setContentView(R.layout.login);
		dialog.setTitle("Login");

		// get the References of views
		final EditText editTextUserName = (EditText) dialog
				.findViewById(R.id.editTextUserNameToLogin);
		final EditText editTextPassword = (EditText) dialog
				.findViewById(R.id.editTextPasswordToLogin);

		Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

		// Set On ClickListener
		btnSignIn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// get The User name and Password
				String userName = editTextUserName.getText().toString();
				String password = editTextPassword.getText().toString();

				// fetch the Password form database for respective user name
				String storedPassword = loginDataBaseAdapter
						.getSinlgeEntry(userName);

				// check if the Stored password matches with Password entered by
				// user
				if (password.equals(storedPassword)) {
					Toast.makeText(getActivity(),
							"Congrats: Login Successfull", Toast.LENGTH_LONG)
							.show();
					dialog.dismiss();

					Intent intent = new Intent(getActivity(),
							SelectionFragment.class);
					startActivity(intent);
				} else {
					Toast.makeText(getActivity(),
							"User Name or Password does not match",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		dialog.show();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// Close The Database
		loginDataBaseAdapter.close();
	}
}

//
//
// @Override
// protected void onDestroy() {
// super.onDestroy();
// // Close The Database
// loginDataBaseAdapter.close();
// }
// }
