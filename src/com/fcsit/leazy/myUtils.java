//package com.fcsit.leazy;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class myUtils {
//	
//	static void showDialog(Context c,  LoginDataBaseAdapter loginDataBaseAdapter){
//		
//		loginDataBaseAdapter = new LoginDataBaseAdapter(c);
//		loginDataBaseAdapter = loginDataBaseAdapter.open();
//		
//		
//		final Dialog dialog = new Dialog(c);
//		dialog.setContentView(R.layout.login);
//		dialog.setTitle("Login");
//
//		// get the References of views
//		final EditText editTextUserName = (EditText) dialog
//				.findViewById(R.id.editTextUserNameToLogin);
//		final EditText editTextPassword = (EditText) dialog
//				.findViewById(R.id.editTextPasswordToLogin);
//
//		Button btnSignIn = (Button) dialog
//				.findViewById(R.id.buttonSignIn);
//
//		// Set On ClickListener
//		btnSignIn.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//				// get The User name and Password
//				String userName = editTextUserName.getText().toString();
//				Log.d("HF","userName="+userName);
//				String password = editTextPassword.getText().toString();
//				Log.d("HF","password="+password);
//
//				// fetch the Password form database for respective user
//				// nameS
//				
//				String storedPassword = loginDataBaseAdapter
//						.getSinlgeEntry(userName);
//				Log.d("HF","storedPassword="+storedPassword);//not exist
//			
//
//				// check if the Stored password matches with Password
//				// entered by
//				// user
//				if (password.equals(storedPassword)) {
//					Toast.makeText(,
//							"Congrats: Login Successful",
//							Toast.LENGTH_LONG).show();
//					dialog.dismiss();
//
//					Intent intent = new Intent(c,
//							SelectionActivity.class);
//					c.startActivity(intent);
//				} else {
//					Toast.makeText(c,
//							"User Name or Password does not match",
//							Toast.LENGTH_LONG).show();
//				}
//			}
//		});
//
//		dialog.show();
//	}
//
//}
