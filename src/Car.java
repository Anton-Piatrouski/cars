
public class Car implements Runnable {

	private static final long MAX_DISTANCE = 10000;
	private long friction;
	private long distance;
	private String name;
	private static volatile String winner = "";
	private static volatile int carCounter = 0;
	
	public Car(String name, long friction) {
		this.name = name;
		this.friction = friction;
	}
	
	public static String getWinner() {
		return winner;
	}
	
	public static int getCarCounter() {
		return carCounter;
	}
	
	@Override
	public void run() {
		try {
			while (distance < MAX_DISTANCE) {
				Thread.sleep(friction);
				distance += 100;
				System.out.println(name + '\t' + distance);
			}
			if (winner.isEmpty()) {
				winner = name;
			}
			carCounter++;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
