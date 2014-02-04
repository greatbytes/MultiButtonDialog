package com.greatbytes.multibuttondialog;

import com.greatbytes.fourbuttondialog.R;
import com.greatbytes.multibuttondialog.ui.MultiButtonDialog;
import com.greatbytes.multibuttondialog.ui.OnMultiButtonClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context mContext = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button btnDemo = (Button)findViewById(R.id.button_demo);
		btnDemo.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				MultiButtonDialog mDialog = new MultiButtonDialog(mContext, mListener, "Quick user survey", "Do you agree that Android is the most flexible platform eva?", new String[]{"It sure is, Mike!", "Yes", "Maybe?"});
				mDialog.show();
			}
		});
	}
	
	OnMultiButtonClickListener mListener = new OnMultiButtonClickListener() {
		@Override
		public void onButtonClick(MultiButtonDialog multiButtonDialog, int which) {
			Toast.makeText(mContext, "You drunkenly tapped on button " + which, Toast.LENGTH_SHORT).show();
		}
	};

}
