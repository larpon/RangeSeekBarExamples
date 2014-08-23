package larpon.android.example.rangeseekbar;

import larpon.android.view.RangeSeekBar;
import larpon.android.view.RangeSeekBar.RangeSeekBarListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity {
	
	public final static String TAG = "Main";
	
	private RangeSeekBar rangeSeekBar1;
	private RangeSeekBar rangeSeekBar2;
	private RangeSeekBar rangeSeekBar3;
	private RangeSeekBar rangeSeekBar4;
	
	private RangeSeekBarListener exampleListener = new RangeSeekBarListener(){

        @Override
        public void onCreate(RangeSeekBar rangeSeekBar, int index,
        		float value) {
            Log.i(TAG, "RangeSeekBar "+rangeSeekBar.getId()+" - Created "+index+" "+value);
        }

        @Override
        public void onSeek(RangeSeekBar rangeSeekBar, int index,
        		float value) {
        	Log.i(TAG, "RangeSeekBar "+rangeSeekBar.getId()+" - onSeek "+index+" "+value);
        	
        	// Round the thumb value
            float f = 0.5f;
            float rounded = f * Math.round(value/f);
            
            
            ((TextView) findViewById(R.id.hello)).setText("index:"+index+" val: "+rounded);
        }

		@Override
		public void onSeekStart(RangeSeekBar rangeSeekBar, int index,
				float value) {
			Log.i(TAG, "RangeSeekBar "+rangeSeekBar.getId()+" - onSeekStart "+index+" "+value);
		}

		@Override
		public void onSeekStop(RangeSeekBar rangeSeekBar, int index,
				float value) {
			Log.i(TAG, "RangeSeekBar "+rangeSeekBar.getId()+" - onSeekStop "+index+" "+value);
		}

    };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupBar1();
        setupBar2();
        setupBar3();
        setupBar4();
    }
    
    private void setupBar1() {
    	rangeSeekBar1 = (RangeSeekBar) findViewById(R.id.rangeSeekBar1);
        
    	rangeSeekBar1.setListener(exampleListener);
    }
    
    private void setupBar2() {
    	// Programmatically add seekbar to layout
    	rangeSeekBar2 = new RangeSeekBar(this);
    	rangeSeekBar2.setListener(exampleListener);
    	
    	LinearLayout layout = (LinearLayout) findViewById(R.id.container);
    	layout.addView(rangeSeekBar2);
    	
    }
    
    private void setupBar3() {
    	rangeSeekBar3 = (RangeSeekBar) findViewById(R.id.rangeSeekBar3);
        
    	rangeSeekBar3.setListener(exampleListener);
    }
    

    private void setupBar4() {
    	rangeSeekBar4 = (RangeSeekBar) findViewById(R.id.rangeSeekBar4);
        
    	rangeSeekBar4.setListener(exampleListener);

    	rangeSeekBar4.setLimitThumbRange(true);
    	rangeSeekBar4.setOrientation(RangeSeekBar.HORIZONTAL);
    	rangeSeekBar4.setRange(getResources().getDrawable(R.drawable.rangegradient));
    	rangeSeekBar4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rangeseekbar));
    	rangeSeekBar4.setThumb(getResources().getDrawable(R.drawable.thumb));
    	rangeSeekBar4.setTrack(getResources().getDrawable(R.drawable.trackgradient));
        
    	rangeSeekBar4.setScaleRangeMin(0);
    	rangeSeekBar4.setScaleRangeMax(100);
    	
    	rangeSeekBar4.setScaleStep(5);
    	
    	// Set custom thumb width and height
        rangeSeekBar4.setThumbWidth(40);
        rangeSeekBar4.setThumbHeight(30);
        
        rangeSeekBar4.initThumbs(3);
        
        // Set thumb values
        rangeSeekBar4.setThumbValue(0, 10);
        rangeSeekBar4.setThumbValue(1, 90);
    }
}