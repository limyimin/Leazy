package com.fcsit.leazy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import nl.matshofman.saxrssreader.RssFeed;
import nl.matshofman.saxrssreader.RssItem;
import nl.matshofman.saxrssreader.RssReader;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsFragment extends Fragment {
	private ListView newsList;
	private View progress;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		View v = inflater.inflate(R.layout.fragment_news, container, false);
		newsList = (ListView) v.findViewById(R.id.listView1);
		progress = v.findViewById(R.id.progressbar);


		new AsyncTask<String, Void, List<RssItem>>() {

			@Override
			protected List<RssItem> doInBackground(String... params) {
				List<RssItem> rssItems = Collections.<RssItem> emptyList();
				try {
					URL url = new URL(params[0]);
					Log.i("rss", "fetching");
					RssFeed feed = RssReader.read(url);
					Log.i("rss", "read");
					rssItems = feed.getRssItems();
					Log.i("rss", "rss size = " + rssItems.size());

				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return rssItems;
			}

			@Override
			protected void onPostExecute(java.util.List<RssItem> result) {
				for (RssItem rssItem : result) {
					Log.i("rss", "title = " + rssItem.getTitle());
				}
				newsList.setAdapter(new NewsAdapter(getActivity(), result));
				newsList.setOnItemClickListener(new ListListener(result, getActivity()));
				progress.setVisibility(View.GONE);
			};

			class ListListener implements OnItemClickListener {
				// Our listener will contain a reference to the list of RSS Items
				// List item's reference
				List<RssItem> listItems;
				// And a reference to a calling activity
				// Calling activity reference
				Activity activity;

				/** We will set those references in our constructor. */
				public ListListener(List<RssItem> aListItems, Activity anActivity) {
					listItems = aListItems;
					activity = anActivity;
				}

				/** Start a browser with url from the rss item. */
				@Override
				public void onItemClick(AdapterView parent, View view, int pos, long id) {
					// We create an Intent which is going to display data
					Intent i = new Intent(Intent.ACTION_VIEW);
					// We have to set data for our new Intent
					i.setData(Uri.parse(listItems.get(pos).getLink()));
					// And start activity with our Intent
					activity.startActivity(i);
				}
			}

		}.execute("http://feeds.feedburner.com/livelifedrive");

		// for(RssItem rssItem : rssItems) {
		// Log.i("RSS Reader", rssItem.getTitle());
		// }
		// Start download RSS task
		// http://www.itcuties.com/feed/
		// http://www.livelifedrive.com/malaysia/news/feed/
		// http://www.livelifedrive.com/feed/


		return v;
	}

//	 public static String html2text(String html) {
//		    return Jsoup.parse(html).text();
//		}

	//String noHTMLString = htmlString.replaceAll("\\<.*?>","");

}
