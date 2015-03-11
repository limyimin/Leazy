package com.fcsit.leazy;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PedoFragment extends Fragment implements LocationListener,
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener {

	private static View v;
	private LocationRequest lr;
	private LocationClient lc;
	private LatLng point;
	SupportMapFragment mapFragment;
	GoogleMap map;

	float mLat, mLng;
	Marker marker;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("location", "onCreateView");
		DoneBar.setupActionBar((ActionBarActivity) getActivity(),
				new DoneBar.OnSaveActionListener() {

					@Override
					public void onSave() {

					}

					@Override
					public void onCancel() {
						// TODO Auto-generated method stub
						getActivity().finish();
					}
				});

		if (v != null) {
			ViewGroup parent = (ViewGroup) v.getParent();
			if (parent != null)
				parent.removeView(v);
		}

		try {
			v = inflater.inflate(R.layout.fragment_pedo, container, false);
			mapFragment = ((SupportMapFragment) getActivity()
					.getSupportFragmentManager().findFragmentById(R.id.map));

			map = mapFragment.getMap();
			map.getUiSettings().setAllGesturesEnabled(true);
			map.getUiSettings().setRotateGesturesEnabled(true);
			map.getUiSettings().setMyLocationButtonEnabled(true);
			map.setMyLocationEnabled(true);
			map.getUiSettings().setZoomControlsEnabled(true);

			map.setOnMapClickListener(new OnMapClickListener() {

				@Override
				public void onMapClick(LatLng point) {
					map.animateCamera(CameraUpdateFactory.newLatLng(point));

					// Toast.makeText(getActivity(), point.toString(),
					// Toast.LENGTH_SHORT).show();

				}

			});

			map.setOnMapLongClickListener(new OnMapLongClickListener() {

				@Override
				public void onMapLongClick(LatLng point) {

//					if (marker != null) {
//						marker.remove();
//					}
//
//					marker = map.addMarker(new MarkerOptions().position(point)
//							.title(point.toString()));
//
//					// Toast.makeText(getActivity(), "New marker added@" +
//					// point.toString(),Toast.LENGTH_LONG).show();
//
//					mLat = (float) point.latitude;
//					Log.d("tag", "mLat=" + mLat);
//					mLng = (float) point.longitude;
//					Log.d("location", "mLng=" + mLng);
				}

			});

			// CameraPosition cameraPosition = new
			// CameraPosition.Builder().target(
			// new LatLng(4.210484, 101.97576600000002)).zoom(0).build();
			//
			// map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

			MapsInitializer.initialize(this.getActivity());
		}
		/*
		 * catch (GooglePlayServicesNotAvailableException e) {
		 * Toast.makeText(getActivity(), "Google Play Services missing !",
		 * Toast.LENGTH_LONG).show(); }
		 */
		catch (InflateException e) {
			Toast.makeText(getActivity(), "Problems inflating the view !",
					Toast.LENGTH_LONG).show();
		} catch (NullPointerException e) {
			Toast.makeText(getActivity(), "Google Play Services missing !",
					Toast.LENGTH_LONG).show();
		}

		return v;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		Log.d("location", "onCreate");
		lr = LocationRequest.create();
		// lr.setInterval(1000);
		lr.setNumUpdates(2);
		lc = new LocationClient(this.getActivity().getApplicationContext(),
				this, this);
		lc.connect();

	}

	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		// if (connectionResult.hasResolution()) {
		// try {
		// // Start an Activity that tries to resolve the error
		// connectionResult.startResolutionForResult(
		// getActivity(),
		// CONNECTION_FAILURE_RESOLUTION_REQUEST);
		// /*
		// * Thrown if Google Play services canceled the original
		// * PendingIntent
		// */
		// } catch (IntentSender.SendIntentException e) {
		// // Log the error
		// e.printStackTrace();
		// }
		// } else {
		// /*
		// * If no resolution is available, display a dialog to the user with
		// * the error.
		// */
		// showErrorDialog(connectionResult.getErrorCode());
		// }
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		Log.d("location", "onConnected");
		Toast.makeText(getActivity(), "You may long tap to set your location.",
				Toast.LENGTH_LONG).show();
		lc.requestLocationUpdates(lr, this);

	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		Log.d("location", "onDisconnected");
		Toast.makeText(getActivity(), "Disconnected. Please re-connect.",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onLocationChanged(Location arg0) {
//		// TODO Auto-generated method stub
//		// lc.requestLocationUpdates(lr, this);
//		Log.d("location", "onLocationChanged" + arg0.toString());
//		// Toast.makeText(getActivity(), arg0.toString(), Toast.LENGTH_SHORT)
//		// .show();
//		CameraPosition cameraPosition = new CameraPosition.Builder()
//				.target(new LatLng(arg0.getLatitude(), arg0.getLongitude()))
//				.zoom(15).build();
//		Log.d("location", "myLatLng=" + cameraPosition);
//
//		map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//		// mLat = (float) arg0.getLatitude();
//		// Log.d("lym", "bbb" + mLat);
//		// mLng = (float) arg0.getLongitude();
//		// Log.d("lym", "ccc" + mLng);
//		point = new LatLng(arg0.getLatitude(), arg0.getLongitude());
//		mLat = (float) point.latitude;
//		Log.d("tag", "mLat=" + mLat);
//		mLng = (float) point.longitude;
//		Log.d("location", "mLng=" + mLng);
//		myMarker();
//		Log.d("location", "do you run?" + "do you run?");

	}

	// add a new marker
	public Marker myMarker() {
//		marker = map.addMarker(new MarkerOptions().position(point).title(
//				point.toString()));
		return marker;

	}

}