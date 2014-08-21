package larpon.android.example.rangeseekbar;

import com.sc.android.example.rangeseekbar.R;

import larpon.android.view.RangeSeekBar;
import larpon.android.view.RangeSeekBar.RangeSeekBarListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final RangeSeekBar rsb = (RangeSeekBar) findViewById(R.id.rangeSeekBarView1);
        rsb.setListener(new RangeSeekBarListener(){

            @Override
            public void onCreate(int index, float value) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onSeek(int index, float value) {
                float f = 0.5f;
                float rounded = f * Math.round(value/f);
                ((TextView) findViewById(R.id.hello)).setText("index:"+index+" val: "+rounded);
            }

        });

        rsb.setThumbWidth(100);
        rsb.setThumbValue(0, 10);
        rsb.setThumbValue(1, 90);
    }
}