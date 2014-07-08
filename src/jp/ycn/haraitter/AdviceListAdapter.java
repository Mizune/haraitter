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

/**
 * GridView の Adapter.
 */
public class AdviceListAdapter extends ArrayAdapter<Data> {

	public AdviceListAdapter(Context context, int textViewResourceId,
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
			convertView = inflater.inflate(R.layout.advice_base, parent, false);
			holder = new ViewHolder(item, convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.userNameView.setText(item.name);
		holder.commentTextView.setText(item.comment);
		holder.dateView.setText(item.date);
		// this.userImageView.setText(item.imgUrl);

		return convertView;
	}

	/**
	 * ViewHolder.
	 */
	private class ViewHolder {
		public ImageView userImageView;
		public TextView userNameView;
		public TextView dateView;
		public TextView commentTextView;

		public ViewHolder(Data item, View convertView) {
			this.userImageView = (ImageView) convertView
					.findViewById(R.id.icon);
			this.dateView = (TextView) convertView
					.findViewById(R.id.advice_date);
			this.commentTextView = (TextView) convertView
					.findViewById(R.id.advice_comment);
			this.userNameView = (TextView) convertView
					.findViewById(R.id.advice_username);
		}

	}

}