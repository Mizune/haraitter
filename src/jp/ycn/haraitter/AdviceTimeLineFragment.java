package jp.ycn.haraitter;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.fragmenttest2.R;

public class AdviceTimeLineFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_timeline, container, false);
		ListView timeLine = (ListView) v.findViewById(R.id.timeLine);

		@SuppressWarnings("unchecked")
		ArrayList<Data> list = (ArrayList<Data>) getArguments().get("list");
		timeLine.setAdapter(new AdviceListAdapter(getActivity(),
				R.layout.advice_base, list));

		return v;
	}

}
