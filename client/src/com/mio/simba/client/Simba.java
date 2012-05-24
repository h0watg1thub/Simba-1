package com.mio.simba.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Simba extends Activity implements OnClickListener {
	//final static String MOD_NAME = "GCIXMPP";
	final static int SPEEDCAM_FIXED = 1;
	final static int SPEEDCAM_MOVED = 2;
	final static int SPEEDCAM_POLICECAR = 3;
	final static int POLICE_CHECKPOINT = 11;
	
	public GCI conn;
	private Button button1, button2, button3, button4, buttonGpsRefresh;
	private EditText editTextLatitude, editTextLongitude, editTextDirection, editTextRange;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button1 = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);
        button3 = (Button) this.findViewById(R.id.button3);
        button4 = (Button) this.findViewById(R.id.button4);
        buttonGpsRefresh = (Button) this.findViewById(R.id.button5);
        
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        buttonGpsRefresh.setOnClickListener(this);
        
        editTextLatitude = (EditText) this.findViewById(R.id.editText1);
        editTextLongitude = (EditText) this.findViewById(R.id.editText2);
        editTextDirection = (EditText) this.findViewById(R.id.editText3);
        editTextRange = (EditText) this.findViewById(R.id.editText4);
        
        /*try {
			conn = (GCI)Class.forName(MOD_NAME).newInstance();
			conn.init();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        conn = (GCI)new GCIXMPP();
        conn.init();
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == button1) {
			conn.sendPOI(Float.parseFloat(editTextLongitude.getText().toString()), Float.parseFloat(editTextLatitude.getText().toString()), Float.parseFloat(editTextDirection.getText().toString()), SPEEDCAM_FIXED);
		}
	}
}