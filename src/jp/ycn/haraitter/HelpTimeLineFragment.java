package jp.ycn.haraitter;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.fragmenttest2.R;

public class HelpTimeLineFragment extends Fragment {
	ListView mTimeLineView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_timeline, container, false);
		mTimeLineView = (ListView) v.findViewById(R.id.timeLine);

		@SuppressWarnings("unchecked")
		ArrayList<Data> list = (ArrayList<Data>) getArguments().get("list");
		mTimeLineView.setAdapter(new AdviceListAdapter(getActivity(),
				R.layout.help_base, list));

		return v;
	}

	@Override
	public void onResume() {
		// Network通信とadapte更新系をここに書く
	}

}
