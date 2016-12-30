package ip.il.ac.tau.cs.sw1.ip;

public class IPAddressShort implements IPAddress {


	IPAddressShort(short[] address) {
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
