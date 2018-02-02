package homeWork7;

public class client_program_for_Good_Bad_Queue {
	public static void main(String[] args) {
		NaughtyLLQueue<Integer> bad = new NaughtyLLQueue<Integer>();
		goodImplement<Integer> good = new goodImplement<Integer>();
		
		int players = 100000;
		
		// Measure time to enqueue 100000 players using "Bad"
		long startBad1 = System.currentTimeMillis();
		for(int i = 1; i< players+1;i++) {
			bad.enqueue(i);
		}
		long endBad1 = System.currentTimeMillis();
		long timeAddBad = endBad1 - startBad1;
		System.out.println("Time to enqueue " + players + " players using \"BAD\" is: " + timeAddBad + " MilliSeconds");
		
		// Measure time to dequeue 100000 players using "Bad"
		long startBad2 = System.currentTimeMillis();
		for(int i = 1; i < players+1; i++) {
			bad.dequeue();
		}
		long endBad2 = System.currentTimeMillis();
		long timeRemoveBad = endBad2 - startBad2;
		System.out.println("Time to dequeue " + players + " players using \"BAD\" is: " + timeRemoveBad+ " MilliSeconds");
		
		// Measure time to enqueue 100000 players using "Good"
		long startGood1 = System.currentTimeMillis();
		for(int i = 1; i< players+1;i++) {
			good.enqueue(i);
		}
		long endGood1 = System.currentTimeMillis();
		long timeAddGood = endGood1 - startGood1;
		System.out.println("Time to enqueue " + players + " players using \"GOOD\" is: " + timeAddGood + " MilliSeconds");
		
		// Measure time to dequeue 100000 players using "Bad"
		long startGood2 = System.currentTimeMillis();
		for(int i = 1; i < players+1; i++) {
			good.dequeue();

		}
		long endGood2 = System.currentTimeMillis();
		long timeRemoveGood = endGood2 - startGood2;
		System.out.println("Time to dequeue " + players + " players using \"GOOD\" is: " + timeRemoveGood + " MilliSeconds");
	}
}
