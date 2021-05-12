package com.example.communicator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableLayout.LayoutParams;

public class CommunicatorActivity extends Activity implements OnClickListener
{
	
	Button btnAddLineToRow;
	Button btnSend;
	EditText editText1;
	EditText editText2;
	EditText editText3;
	EditText editText4;
	ArrayList<String[]> listOfArrayOfString;
	TableLayout tl;
	TableRow row;
	EditText edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.communicator_layout);
		
		initializeListOfArrayOfString();
		edit = (EditText)findViewById(R.id.vpName);
		
		btnAddLineToRow = (Button)findViewById(R.id.buttonAddRow);
		btnAddLineToRow.setOnClickListener(this);

		btnSend = (Button)findViewById(R.id.buttonSend);
		btnSend.setOnClickListener(this);
	}

	private void initializeListOfArrayOfString()
	{
		listOfArrayOfString = new ArrayList<String[]>();
		
		String [] title = {"Col1","Col2"};
		String [] row1 = {"Col11","Col12"};
		String [] row2 = {"Col21","Col22"};
		
		listOfArrayOfString.add(title);
		listOfArrayOfString.add(row1);
		listOfArrayOfString.add(row2);
	}

	public void onClick(View v)
	{
		if(v == btnAddLineToRow)
		{
			//Toast.makeText(getApplicationContext(), "go go go", Toast.LENGTH_SHORT).show();
			
			 tl = (TableLayout)findViewById(R.id.tableLayoutActivity1);
			 row = new TableRow(this);
			
			//TextView t1 = new TextView(this);
			editText1 = new EditText(this);

			editText1.setHint("Enter No");
			//t1.setTypeface(null,1);

			editText1.setTextSize(10);
			editText1.setWidth(20);
			//t1.setPadding(20, 0, 0, 0);

			editText2 = new EditText(this);
			
			//t2.setText("New content");
			//t2.setTypeface(null,1);
			editText2.setHint("Enter Name");
			editText2.setTextSize(10);
			editText2.setWidth(20);
			//t2.setPadding(20, 0, 0, 0);

			editText3 = new EditText(this);
			
			//t3.setText("New content");
			//t3.setTypeface(null,1);
			editText3.setHint("Enter Task");
			editText3.setTextSize(10);
			editText3.setWidth(20);
			//t2.setPadding(20, 0, 0, 0);

			editText4 = new EditText(this);

			//t3.setText("New content");
			//t3.setTypeface(null,1);
			editText4.setHint("Enter ID");
			editText4.setTextSize(10);
			editText4.setWidth(20);
			
			row.addView(editText1);
			row.addView(editText2);
			row.addView(editText3);
			row.addView(editText4);
			
			tl.addView(row, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			//tl.setBackgroundColor(getResources().getColor(R.color.gray));
		}else if(v == btnSend){
			//System.out.println(" tl.getChildCount()"+tl.getChildCount());
			Log.i("Easy getChildCount",Integer.toString(row.getVirtualChildCount()));
			/*for(int i=0; i<row.getVirtualChildCount(); i++){
				Log.i("Easy getChildCount","before row");
				row= (TableRow)tl.getChildAt(i);
				Log.i("Easy getChildCount","after row");
				editText1=(EditText ) row.getVirtualChildAt(i);
				Log.i("Easy getChildCount","after edittext");
				String text1=editText1.getText().toString();
				Log.i("Easy text1",text1);*/

				String to=edit.getText().toString();
				//String subject=editTextSubject.getText().toString();
				//String message=editTextMessage.getText().toString();


				Intent email = new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
				email.putExtra(Intent.EXTRA_SUBJECT, "Hi");
				email.putExtra(Intent.EXTRA_TEXT, "Please work");

				//need this to prompts email client only
				//email.setType("message/
				email.setType("text/plain");

				startActivity(Intent.createChooser(email, "Choose an Email client :"));
			//}

		}
		
	}
}
