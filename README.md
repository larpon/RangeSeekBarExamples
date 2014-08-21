RangeSeekBarExamples
====================

Collection of examples using the [RangeSeekBar](https://github.com/Larpon/RangeSeekBar) Android view

---
## Examples

Sparse usage examples are included in the repository.

To see how it is used with XML see the [res/layout/main.xml](https://github.com/Larpon/RangeSeekBarExamples/blob/master/res/layout/main.xml).

A typical use from a Main activity would look like:

```
public class Main extends Activity {
	private static final String TAG = "Main";

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
				((TextView) findViewById(R.id.hello)).setText("index: "+index+" val: "+rounded);
			}

			
		});
	}

}
```

to instantiate a RangeSeekBar from code without the use of XML do:
```RangeSeekBar rangeSeekBar = new RangeSeekBar(Context);```
or
```RangeSeekBar rangeSeekBar = new RangeSeekBar(Context,AttributeSet);```
