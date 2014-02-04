package com.greatbytes.multibuttondialog.ui;

import android.os.Bundle;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MultiButtonDialog extends Dialog implements OnClickListener {
	OnMultiButtonClickListener listener;
	String title;
	String message;
	String[] buttonLabels;

	public MultiButtonDialog(Context context, OnMultiButtonClickListener listener, String title, String message, String[] buttonLabels) {
		super(context);
		this.listener = listener;
		this.title = title;
		this.message = message;
		this.buttonLabels = buttonLabels;
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

		for (int i=0; i < buttonLabels.length; i++){
			Button button = new Button(context);
			button.setId(i);
			button.setText(buttonLabels[i]);
			button.setOnClickListener(this);
			button.setLayoutParams(layoutParams);
			buttons.addView(button);
		}
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