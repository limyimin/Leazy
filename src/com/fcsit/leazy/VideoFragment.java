package com.fcsit.leazy;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_video, container, false);
		// TODO Auto-generated method stub
		VideoView vv = (VideoView)v.findViewById(R.id.videoview);
		Uri uri = Uri.parse("android.resource://com.fcsit.leazy/"+R.raw.movie);
        MediaController mc = new MediaController(getActivity());
        vv.setMediaController(mc);
        vv.setVideoURI(uri);
        //vv.start();
		
		return v;
	}

}
