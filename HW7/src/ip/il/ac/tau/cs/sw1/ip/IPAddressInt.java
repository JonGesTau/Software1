package ip.il.ac.tau.cs.sw1.ip;

import java.nio.ByteBuffer;

public class IPAddressInt implements IPAddress {
	int address;
	ByteBuffer byteAddress;

	IPAddressInt(int address) {
		this.address = address;
		this.byteAddress = intToByteBuffer(address);
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 4; i++) {
			int number = byteAddress.get(i) & 0xFF;
			result += Integer.toString(number) + (i < 3 ? "." : "");
		}

		return result;
	}

	@Override
	public boolean equals(IPAddress other) {
		return this.toString().equals(other.toString());
	}

	@Override
	public int getOctet(int index) {
		return (int) (byteAddress.get(index) & 0xFF);
	}

	@Override
	public boolean isPrivateNetwork(){
		return (getOctet(0) == 10 ||
				(getOctet(0) == 172 && (getOctet(1) >= 16 && getOctet(1) <= 31)) ||
				getOctet(0) == 192 && getOctet(1) == 168
		);
	}

	private ByteBuffer intToByteBuffer(int address) {
		ByteBuffer result = ByteBuffer.allocate(4);
		result.putInt(address);

		return result;
	}

}
