package com.fcsit.leazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fcsit.leazy.widget.PagerSlidingTabStrip;


public class MainActivity extends ActionBarActivity {

	private ShareActionProvider mShareActionProvider;

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	private SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;
	private PagerSlidingTabStrip tabs;

//	@Override
//	protected void attachBaseContext(Context newBase) {
//		super.attachBaseContext(new CalligraphyContextWrapper(newBase, R.attr.fontPath));
//	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		mViewPager = (ViewPager) findViewById(R.id.pager);

		Log.d("tag", "mSectionsPagerAdapter=" + (mSectionsPagerAdapter == null));

		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(PageChangeListener);
		tabs.setViewPager(mViewPager);

		mViewPager.setCurrentItem(0);

	}

	private final OnPageChangeListener PageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {
			getSupportActionBar().setTitle(
					mSectionsPagerAdapter.getPageTitle(position));

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int state) {
			// TODO Auto-generated method stub

		}
	};

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLE = { "VIDEOS", "NEWS","LOGIN", "ABOUT"};

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).

			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new VideoFragment();
				break;

			case 1:
				fragment = new NewsFragment();
				break;
				
			case 2:
				fragment = new HomeFragment();
				break;	
				
			case 3:
				fragment = new AboutFragment();
				break;	
			}

			return fragment;

		}

		@Override
		public int getCount() {

			return TITLE.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			return TITLE[position];
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			TextView textView = (TextView) rootView
					.findViewById(R.id.section_label);
			textView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
