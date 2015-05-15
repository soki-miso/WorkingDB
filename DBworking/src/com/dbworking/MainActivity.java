package com.dbworking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.dbworking.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.activity_main);

        
        
        /** Getting data from DB **/
        
        
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sokirka.com/nelly_kecanie", "nelly_kecalek", "Kecalek1");
	        String name = "jaba java";
	        String insert = "INSERT INTO test VALUES ('3', '" + name + " ')";
	        Statement stmt = (Statement) con.createStatement();
	        stmt.executeUpdate(insert);		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        
        
        /**Statement stmt = (Statement) con.createStatement();
        String select = "SELECT * from test";
        
        
        //String name = "java";
        //String insert = "INSERT INTO test VALUES ('1', '" + name + " ')";
        //stmt.executeUpdate(insert);
        
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next())
            {
                //int number = rs.getInt("id");
                String name = rs.getString("text");
                //System.out.format("%s %s\n", number, name);

            }

**/
        

        TextView textView = new TextView(this);
        textView.setTextSize(40);
		String name = "gsgdsgsdg";
        textView.setText(name);
		//setting text view as the activity layout
		setContentView(textView);
    
    
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent intent = new Intent (this, SettingsActivity.class);
        	startActivity(intent);
        	
        	
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    
    /**Called when user clicks Klikni button **/
    public void sendMessage(View view) {
    
    	Intent intent = new Intent (this, DisplayMessageActivity.class);
    	EditText editText =  (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }



}
