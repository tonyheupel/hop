package net.heupel.hop;

public class HopperProblem {
	final private String FAILED_SOLUTION = "failure";
	private int[] challenge;
	private Object[] solution;
	
	public HopperProblem(int[] challenge) {
		this.challenge = challenge;
	}
	
	public int[] getChallenge() {
		return this.challenge;
	}
	
	public String getChallengeString() {
		return join(this.challenge, ", ");
	}
	
	public Object[] getSolution() {
		return this.solution;
	}
	
	public String getSolutionString() {
		if (this.solution == null) {
			return "";
		}
		
		if (this.solution.length == 0) {
			return FAILED_SOLUTION;
		}
		
		return join(this.solution, ", ");
	}
	
	public Boolean isSolved() {
		return this.solution != null;
	}
	
	public Boolean isFailed() {
		return this.getSolutionString() == FAILED_SOLUTION;
	}
	
	public String solve() {
		ArrayHopper hopper = new ArrayHopper(this.challenge);
		Object[] route = hopper.shortestPathOut();

		this.solution = route;
    	
    	return getSolutionString();
	}
	
	public void clearSolution() {
		this.solution = null;
	}
	
	@Override
	public String toString() {
		return getChallengeString() + "\n\t" + (isSolved() ? getSolutionString() : "not solved yet");
	}
	
	
	private static String join(Object[] array, String separator) {
	    StringBuilder builder = new StringBuilder();
	    
	    for (int i = 0; i < array.length; i++) {
	        if (i > 0) builder.append(separator);
	        
	        builder.append(array[i]);
	    }
	    
	    return builder.toString();
	}
	
	// TODO: Make more generic so it's not duplicated
	private static String join(int[] array, String separator) {
	    StringBuilder builder = new StringBuilder();
	    
	    for (int i = 0; i < array.length; i++) {
	        if (i > 0) builder.append(separator);
	        
	        builder.append(array[i]);
	    }
	    
	    return builder.toString();
	}
}
