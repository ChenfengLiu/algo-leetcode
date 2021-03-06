package practice_utils;

public class Bit_Manipulation_Util {
	public boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}

	public int setBit(int num, int i) {
		return num | (1 << i);
	}

	public int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

	public int ClearBitsMSBthroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}

	public int ClearBitsIthrough0(int num, int i) {
		int mask = (-1 << (i + 1));
		return num & mask;
	}

	public int updateBit(int num, int i, boolean bitIs1) {
		int value = bitIs1 ? 1 : 0;
		int mask = ~(1 << i);
		return (num & mask) | (value << i);
	}

	public int ClearLastBit(int num) {
		return num & (num - 1);
	}
}
