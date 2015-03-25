package com.lyh.drawer;

import com.lyh.drawer.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private Button toggle_btn;

	private View itemToolBar;

	private final int EXPAND = 0;// togleviewչ��
	private final int COLLAPSE = 1;// togleview�ر�

	private int type = EXPAND;

	private LayoutInflater inflater = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		View parent = inflater.inflate(R.layout.activity_main, null);
		setContentView(parent);
		toggle_btn = (Button) findViewById(R.id.expandable_toggle_button);
		itemToolBar = findViewById(R.id.expandable);
		itemToolBar.measure(parent.getWidth(), parent.getHeight());
		int height = itemToolBar.getMeasuredHeight();
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) itemToolBar.getLayoutParams();
		lp.bottomMargin = -height;
		itemToolBar.setLayoutParams(lp);
		itemToolBar.requestLayout();
		toggle_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				animateView(itemToolBar, type);
			}
		});
	}

	/**
	 * togleview tools
	 * 
	 * @param target
	 * @param type
	 */
	private void animateView(final View target, int type) {
		Animation anim = new ExpandCollapseAnimation(target, type);
		anim.setDuration(330);
		target.startAnimation(anim);
		if (this.type == EXPAND) {
			this.type = COLLAPSE;
		} else {
			this.type = EXPAND;
		}
	}
}
