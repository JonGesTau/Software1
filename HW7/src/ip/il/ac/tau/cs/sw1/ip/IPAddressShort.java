package ip.il.ac.tau.cs.sw1.ip;

public class IPAddressShort implements IPAddress {
	short[] address;

	IPAddressShort(short[] address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 4; i++) {
			result += Short.toString(address[i]) + (i < 3 ? "." : "");
		}

		return result;
	}

	@Override
	public boolean equals(IPAddress other) {
		return this.toString().equals(other.toString());
	}

	@Override
	public int getOctet(int index) {
		return (int) (address[index]);
	}

	@Override
	public boolean isPrivateNetwork(){
		return (getOctet(0) == 10 ||
				(getOctet(0) == 172 && (getOctet(1) >= 16 && getOctet(1) <= 31)) ||
				getOctet(0) == 192 && getOctet(1) == 168
		);
	}
	
}
