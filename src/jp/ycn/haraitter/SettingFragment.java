package jp.ycn.haraitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmenttest2.R;

public class SettingFragment extends Fragment implements OnClickListener {
	public Button mLoginButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v;
		// if(isLogin){
		// v = inflater.inflate(R.layout.fragment_setting, container,false);
		// //ログインしていたら別のLayoutを置く
		// }else

		v = inflater.inflate(R.layout.fragment_setting, container, false);
		mLoginButton = (Button) v.findViewById(R.id.SettingLogin);
		mLoginButton.setOnClickListener(this);

		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.SettingLogin:
			Intent intent = new Intent();
			intent.setClass(getActivity(), MainActivity.class);// 別のactiivtyに
			break;

		default:
			break;
		}

	}

}
