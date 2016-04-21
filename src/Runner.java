
public class Runner {

	private static int carsNumber = 0;
	
	public static void main(String[] args) throws InterruptedException {
		// create cars
		Thread[] cars = {
			new Thread(new Car("car1", 120)),
			new Thread(new Car("car2", 120)),
			new Thread(new Car("car3", 100)),
			new Thread(new Car("car4", 100)),
			new Thread(new Car("car5", 130))
		};
		// the number of cars in the race
		carsNumber = cars.length;
		// start cars one by one
		for (Thread car : cars) {
			car.start();
		}
		
		Thread.sleep(5000);
		// disqualify third and fourth cars in 5 seconds
		disqualify(cars[2], cars[3]);
		
		// wait for the race end
		while (Car.getCarCounter() < carsNumber);
		// race result
		System.out.println("Winner is " + Car.getWinner() + "!");
	}
	
	private static void disqualify(Thread... threads) {
		for (Thread thread : threads) {
			thread.interrupt();
			carsNumber--;
		}
	}

}
