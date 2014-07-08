package jp.ycn.haraitter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fragmenttest2.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HelpView extends LinearLayout {
	private Context mContext;
	private String mName;
	private String mDate;
	private String mComment;
	private String mImageUrl;

	public HelpView(Context context) {
		super(context);
		mContext = context;
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context);
		View baselayout = LayoutInflater.from(context).inflate(
				R.layout.help_base, this);
	}

	public HelpView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public HelpView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
}