package com.fcsit.leazy;


import java.util.List;

import nl.matshofman.saxrssreader.RssItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class NewsAdapter extends ArrayAdapter<RssItem>{

	public NewsAdapter(Context context, List<RssItem> items){
		super(context, 0, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if(convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
			holder = new ViewHolder();
			holder.itemTitle = (TextView) convertView. findViewById(R.id.textView1);
			holder.itemDescription = (TextView) convertView. findViewById(R.id.textView2);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		RssItem item = getItem(position);

		holder.itemTitle.setText(item.getTitle());
		holder.itemDescription.setText(item.getDescription());

		return convertView;
	}

	static class ViewHolder{
		TextView itemTitle, itemDescription;
//		ImageView itemImage;
	}

}
