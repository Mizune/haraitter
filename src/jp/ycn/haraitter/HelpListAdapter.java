package jp.ycn.haraitter;

import java.util.List;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmenttest2.R;

public class HelpListAdapter extends ArrayAdapter<Data> {

	public HelpListAdapter(Context context, int textViewResourceId,
			List<Data> objects) {
		super(context, textViewResourceId, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Data item = getItem(position);

		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.help_base, parent, false);
			holder = new ViewHolder(item, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// holder.userImageView.setText(item.imgUrl);
		holder.dateView.setText(item.date + "時間前にhelpCallしました。");
		holder.userNameView.setText(item.name);
		// holder.userImageView.setImageBitmap(image);

		return convertView;
	}

	private class ViewHolder {
		public ImageView userImageView;
		public TextView userNameView;
		public TextView dateView;

		public ViewHolder(Data item, View convertView) {
			this.userImageView = (ImageView) convertView
					.findViewById(R.id.help_icon);
			this.dateView = (TextView) convertView.findViewById(R.id.help_date);
			this.userNameView = (TextView) convertView
					.findViewById(R.id.help_username);
		}

	}

}