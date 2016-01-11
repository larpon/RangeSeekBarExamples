package larpon.android.example.rangeseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import larpon.android.view.RangeSeekBar;
import larpon.android.view.RangeSeekBar.RangeSeekBarListener;

public class ExampleActivity extends AppCompatActivity {

    public final static String TAG = "ExampleActivity";

    private RangeSeekBar rangeSeekBar1;
    private RangeSeekBar rangeSeekBar2;
    private RangeSeekBar rangeSeekBar3;
    private RangeSeekBar rangeSeekBar4;

    private RangeSeekBarListener exampleListener = new RangeSeekBarListener(){

        @Override
        public void onCreate(RangeSeekBar rangeSeekBar, int index,
                             float value) {
            Log.i(TAG, "RangeSeekBar " + rangeSeekBar.getId() + " - Created " + index + " " + value);
        }

        @Override
        public void onSeek(RangeSeekBar rangeSeekBar, int index,
                           float value) {
            Log.i(TAG, "RangeSeekBar "+rangeSeekBar.getId()+" - onSeek "+index+" "+value);

            // Round the thumb_flashy value
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        setupBar1();
        setupBar2();
        setupBar3();
        setupBar4();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        rangeSeekBar4.setRangeDrawable(getResources().getDrawable(R.drawable.rangegradient));
        rangeSeekBar4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rangeseekbar));
        rangeSeekBar4.setThumbDrawable(getResources().getDrawable(R.drawable.thumb));
        rangeSeekBar4.setTrackDrawable(getResources().getDrawable(R.drawable.trackgradient));

        rangeSeekBar4.setScaleRangeMin(0);
        rangeSeekBar4.setScaleRangeMax(100);

        rangeSeekBar4.setScaleStep(5);

        // Set custom thumb_flashy width and height
        rangeSeekBar4.setThumbWidth(40);
        rangeSeekBar4.setThumbHeight(30);

        rangeSeekBar4.initThumbs(3);

        // Set thumb_flashy values
        rangeSeekBar4.setThumbValue(0, 10);
        rangeSeekBar4.setThumbValue(1, 90);
    }
}
