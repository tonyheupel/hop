package net.heupel.hop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class HopActivity 
					extends Activity
					implements OnItemClickListener {
	
	private HopperProblem[] problems;
	private HopperProblemsAdapter problemsAdapter;
	private ListView resultsListView;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.problems = new HopperProblem[] {
        		new HopperProblem(new int[] { 5, 6, 0, 4, 2, 4, 1, 0, 0, 4 }),	// 0, 5, 9, out
        		new HopperProblem(new int[] { 5, 6, 0, 4, 2, 1, 1, 0, 0, 4 }),	// failure
        		new HopperProblem(new int[] { 3, 20, 1, 1, 1, 1, 1 }),			// 0, 1, out
        		new HopperProblem(new int[] { 5, 2, 4, 2, 2, 0, 3, 0, 0, 4 })	// 0, 4, 6, 9, out (backtrack)
        };
		
		this.problemsAdapter = new HopperProblemsAdapter(this, R.layout.problem_list_view_item, this.problems);
		this.resultsListView = getResultsListView();
		this.resultsListView.setOnItemClickListener(this);
		this.resultsListView.setAdapter(this.problemsAdapter);
    }

    
	private ListView getResultsListView() {
		return (ListView)findViewById(R.id.resultsList);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		HopperProblem item = this.problemsAdapter.getItem(position);
		
		if (item.isSolved()) {
			item.clearSolution();
		} else { 
			item.solve();
		}
		
		this.problemsAdapter.notifyDataSetChanged();
	}
}
