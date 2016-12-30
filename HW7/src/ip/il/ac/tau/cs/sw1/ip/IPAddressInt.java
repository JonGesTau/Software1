package ip.il.ac.tau.cs.sw1.ip;

public class IPAddressInt implements IPAddress {

	IPAddressInt(int address) {
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(IPAddress other) {
		return false;
	}

	@Override
	public int getOctet(int index) {
		return 0;
	}

	@Override
	public boolean isPrivateNetwork(){
		return false;
	}
	
}
