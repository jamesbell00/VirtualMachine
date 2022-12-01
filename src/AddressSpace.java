import slu.rvm.IAddressSpace;

public class AddressSpace implements IAddressSpace {

    private int baseAddress;
    private int limitAdress;

    public AddressSpace(int baseAddress, int size) {
        this.baseAddress = baseAddress;
        this.limitAdress = baseAddress + (size-1);
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
