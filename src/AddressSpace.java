import slu.rvm.IAddressSpace;

public class AddressSpace implements IAddressSpace {

    final int baseAddress;
    final int limitAddress;

    public AddressSpace(int baseAddress, int limitAddress) {
        this.baseAddress = baseAddress;
        this.limitAddress = limitAddress;
    }

    @Override
    public int getBaseAddress() {
        return baseAddress;
    }

    @Override
    public int getLimitAddress() {
        return limitAddress;
    }
    
}
