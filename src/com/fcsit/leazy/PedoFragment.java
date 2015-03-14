package com.fcsit.leazy;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationListener;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PedoFragment extends Fragment implements
LocationListener, GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d("pedof","pedof");
		
		View v = inflater.inflate(R.layout.fragment_pedo, container, false);
		
		return v;
	}
	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}