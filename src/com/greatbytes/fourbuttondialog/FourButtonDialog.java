package com.greatbytes.fourbuttondialog;

import android.os.Bundle;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FourButtonDialog extends Dialog implements OnClickListener {
	OnFourButtonClickListener listener;
	String title;
	String message;
	String button1;
	String button2;
	String button3;
	String button4;

	private static final int BUTTON_1 = 1;
	private static final int BUTTON_2 = 2;
	private static final int BUTTON_3 = 3;
	private static final int BUTTON_4 = 4;

	public FourButtonDialog(Context context, OnFourButtonClickListener listener, String title, String message, String button1, String button2, String button3, String button4) {
		super(context);
		this.listener = listener;
		this.title = title;
		this.message = message;
		this.button1 = button1;
		this.button2 = button2;
		this.button3 = button3;
		this.button4 = button4;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Context context = getContext();

		LinearLayout ll = new LinearLayout(context);
		ll.setOrientation(LinearLayout.VERTICAL);

		TextView tvMessage = new TextView(context);
		tvMessage.setPadding(8, 8, 8, 8);
		tvMessage.setText(message);
		ll.addView(tvMessage);

		LinearLayout buttons = new LinearLayout(context);
		buttons.setOrientation(LinearLayout.VERTICAL);

		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1.0f);

		Button btnButton1 = new Button(context);
		btnButton1.setId(BUTTON_1);
		btnButton1.setText(button1);
		btnButton1.setOnClickListener(this);
		btnButton1.setLayoutParams(layoutParams);
		buttons.addView(btnButton1);

		Button btnButton2 = new Button(context);
		btnButton2.setId(BUTTON_2);
		btnButton2.setText(button2);
		btnButton2.setOnClickListener(this);
		btnButton2.setLayoutParams(layoutParams);
		buttons.addView(btnButton2);

		Button btnButton3 = new Button(context);
		btnButton3.setId(BUTTON_3);
		btnButton3.setText(button3);
		btnButton3.setOnClickListener(this);
		btnButton3.setLayoutParams(layoutParams);
		buttons.addView(btnButton3);

		Button btnButton4 = new Button(context);
		btnButton4.setId(BUTTON_4);
		btnButton4.setText(button4);
		btnButton4.setOnClickListener(this);
		btnButton4.setLayoutParams(layoutParams);
		buttons.addView(btnButton4);

		ll.addView(buttons);

		setCancelable(true);
		setCanceledOnTouchOutside(true);
		setTitle(title);
		setContentView(ll);
	}

	@Override
	public void onClick(View v) {
		listener.onButtonClick(this, v.getId());
		dismiss();
	}

	static class CancelOnClickListener implements
	android.view.View.OnClickListener {

		private Dialog dialog;

		private CancelOnClickListener(Dialog dialog) {
			this.dialog = dialog;
		}

		@Override
		public void onClick(View v) {
			dialog.cancel();
		}
	}

}