package DesignParkingSystem;
import java.util.*;

class ParkingSystem {
	int[] parkingSlots = new int[3];
	public ParkingSystem(int big, int medium, int small) {
		parkingSlots[0] = big;
		parkingSlots[1] = medium;
		parkingSlots[2] = small;
	}

	public boolean addCar(int carType) {
		if (parkingSlots[carType - 1] == 0) {
			return false;
		}
		parkingSlots[carType - 1] -= 1;
		return true;
	}
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
