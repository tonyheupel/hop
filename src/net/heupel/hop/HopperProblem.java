package net.heupel.hop;

public class HopperProblem {
	final private String FAILED_SOLUTION = "failure";
	private int[] challenge;
	private String solution;
	
	public HopperProblem(int[] challenge) {
		this.challenge = challenge;
	}
	
	public int[] getChallenge() {
		return this.challenge;
	}
	
	public String getChallengeString() {
		return join(this.challenge, ", ");
	}
	
	public String getSolutionString() {
		return this.solution;
	}
	
	public Boolean isSolved() {
		return this.solution != null;
	}
	
	public Boolean isFailed() {
		return this.solution == FAILED_SOLUTION;
	}
	
	public String solve() {
		ArrayHopper hopper = new ArrayHopper(this.challenge);
		Object[] route = hopper.shortestPathOut();
    	
    	if (route == ArrayHopper.FAILURE_ROUTE) {
    		this.solution = FAILED_SOLUTION;
    	} else {
    		this.solution = join(route, ", ");
    	}
    	
    	return this.solution;
	}
	
	public void clearSolution() {
		this.solution = null;
	}
	
	@Override
	public String toString() {
		return getChallengeString() + "\n\t" + (isSolved() ? this.solution : "not solved yet");
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
