import slu.rvm.EProcessState;
import slu.rvm.IAddressSpace;
import slu.rvm.IProcess;
import slu.rvm.IProcessControlBlock;

public class Process implements IProcess {

    int id;
    String name;
    EProcessState state;
    IAddressSpace addressSpace;
    IProcessControlBlock pcb;

    // does this need a constructor? probably

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
    public void setPCB(IProcessControlBlock pcb) {
        this.pcb = pcb;
    }

    @Override
    public void setState(EProcessState state) {
        this.state = state;
    }
    
}
