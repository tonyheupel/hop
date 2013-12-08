package net.heupel.hop;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HopActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        int[][] problems = new int[][] {
        		{ 5, 6, 0, 4, 2, 4, 1, 0, 0, 4 },	// 0, 5, 9, out
        		{ 5, 6, 0, 4, 2, 1, 1, 0, 0, 4 },	// failure
        		{ 3, 20, 1, 1, 1, 1, 1 },			// 0, 1, out
        		{ 5, 2, 4, 2, 2, 0, 3, 0, 0, 4 }	// 0, 4, 6, 9, out (backtrack)
        };

        ArrayList<String> results = new ArrayList<String>();
        for (int[] problem : problems) {
        	results.add(join(problem, ", ") + "\n\t" + calculatePathOut(problem));	
        }
        
		setResults(join(results.toArray(), "\n"));
    }

    
	private void setResults(String value) {
		TextView resultsView = getResultsView();
		resultsView.setText(value);
	}

	
	private TextView getResultsView() {
		return (TextView)findViewById(R.id.results);
	}

	
    private String calculatePathOut(int[] array) {
    	ArrayHopper hopper = new ArrayHopper(array);
    	
    	Object[] result = hopper.shortestPathOut();
    	
    	if (result == ArrayHopper.FAILURE_ROUTE) {
    		return "failure";
    	}
    	
    	return join(result, ", ");
    }
    
    private static String join(int[] array, String separator) {
    	Object[] objects = new Object[array.length];
    	for (int i=0; i < array.length; i++) {
    		objects[i] = array[i];
    	}
    	
    	return join(objects, separator);
    }
	
	private static String join(Object[] array, String separator) {
	    StringBuilder builder = new StringBuilder();
	    
	    for (int i = 0; i < array.length; i++) {
	        if (i > 0) builder.append(separator);
	        
	        builder.append(array[i]);
	    }
	    
	    return builder.toString();
	}
}
