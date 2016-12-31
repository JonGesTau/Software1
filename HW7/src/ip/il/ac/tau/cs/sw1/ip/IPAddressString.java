package ip.il.ac.tau.cs.sw1.ip;

public class IPAddressString implements IPAddress {
	String address;

	IPAddressString(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return address;
	}

	@Override
	public boolean equals(IPAddress other) {
		return address.equals(other.toString());
	}

	@Override
	public int getOctet(int index) {
		return Integer.parseInt(address.split("\\.")[index]);
	}

	@Override
	public boolean isPrivateNetwork(){
		return (getOctet(0) == 10 ||
				(getOctet(0) == 172 && (getOctet(1) >= 16 && getOctet(1) <= 31)) ||
				getOctet(0) == 192 && getOctet(1) == 168
		);
	}
	
}
