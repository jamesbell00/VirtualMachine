import slu.rvm.EProcessState;
import slu.rvm.IProcess;
import slu.rvm.IProcessControlBlock;

public class Process implements IProcess {

    @Override
    public int getBaseAddress() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getLimitAddress() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IProcessControlBlock getPCB() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EProcessState getState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPCB(IProcessControlBlock arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setState(EProcessState arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
