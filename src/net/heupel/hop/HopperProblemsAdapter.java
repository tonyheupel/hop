package net.heupel.hop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HopperProblemsAdapter extends ArrayAdapter<HopperProblem> {
	
	private int itemLayoutId;
	private HopperProblem[] hopperProblems;
	
	public HopperProblemsAdapter(Context context, int itemLayoutId, HopperProblem[] hopperProblems) {
		super(context, itemLayoutId, hopperProblems);
		this.itemLayoutId = itemLayoutId;
		this.hopperProblems = hopperProblems;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(this.itemLayoutId, parent, false);
		TextView challengeTextView = (TextView) rowView.findViewById(R.id.challengeTextView);
		TextView solutionTextView = (TextView) rowView.findViewById(R.id.solutionTextView);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.challengeSolvedImageView);
		HopperProblem problem = this.hopperProblems[position];
		
		challengeTextView.setText(problem.getChallengeString());
		solutionTextView.setText(problem.getSolutionString());
		imageView.setImageResource(getSolvedImageResourceIdForProblem(problem));
		imageView.setVisibility(getImageVisibility(problem));
		
		return rowView;
	}
	
	private int getImageVisibility(HopperProblem problem) {
		return problem.isSolved() ? View.VISIBLE : View.INVISIBLE;
	}
	
	private int getSolvedImageResourceIdForProblem(HopperProblem problem) {
		return problem.isSolved() && problem.isFailed() ? R.drawable.red_x : R.drawable.check;
	}
}
