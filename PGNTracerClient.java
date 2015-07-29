package PGNTracer;

class PGNTracerClient {
	public static String moves = "1. e4 e5 2. Nf3 Nc6 3. Bb5 a6";
	
	public static void main(String[] args) {
		PGNTracer pgnTracer = new PGNTracer();
		// Reads the file move by move and calls the addMove function in PGNTracer
		
		String[] splits = moves.split(" ");
		for(int i=0 ; i< splits.length ; i = i+3 ) {
			pgnTracer.makeWhiteMove(split[i+1]);
			pgnTracer.makeBlackMove(split[i+2]);
		}
		

	}

}
