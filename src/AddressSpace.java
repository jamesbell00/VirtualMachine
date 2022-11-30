import slu.rvm.IAddressSpace;

public class AddressSpace implements IAddressSpace {

    private int baseAddress;
    private int limitAdress;

    public AddressSpace(int baseAddress, int limitAddress) {
        this.baseAddress = baseAddress;
        this.limitAdress = limitAddress;
    }

    @Override
    public int getBaseAddress() {
        return this.baseAddress;
    }

    @Override
    public int getLimitAddress() {
        return this.limitAdress;
    }

}
