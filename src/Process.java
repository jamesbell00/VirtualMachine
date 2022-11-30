import slu.rvm.EProcessState;
import slu.rvm.IAddressSpace;
import slu.rvm.IProcess;
import slu.rvm.IProcessControlBlock;

public class Process implements IProcess {

    private int id;
    private String name;
    private EProcessState state;
    private IAddressSpace addressSpace;
    private IProcessControlBlock pcb;

    public Process(int id, String name, EProcessState state, IAddressSpace addressSpace, IProcessControlBlock pcb) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.addressSpace = addressSpace;
        this.pcb = pcb;
    }

    @Override
    public int getBaseAddress() {
        return this.addressSpace.getBaseAddress();
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getLimitAddress() {
        return this.addressSpace.getLimitAddress();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IProcessControlBlock getPCB() {
        return this.pcb;
    }

    @Override
    public EProcessState getState() {
        return this.state;
    }

    @Override
    public void setPCB(IProcessControlBlock pcbNew) {
        this.pcb = pcbNew;
    }

    @Override
    public void setState(EProcessState stateNew) {
        this.state = stateNew;
    }

}
