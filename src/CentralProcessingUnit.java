import java.io.PrintWriter;

import slu.rvm.EProcessState;
import slu.rvm.ICentralProcessingUnit;
import slu.rvm.IProcess;

public class CentralProcessingUnit implements ICentralProcessingUnit{

    public static final int REGISTERS = 0;

    public CentralProcessingUnit(PrintWriter logFile, int quantum) {
    }

    @Override
    public void dump() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getMemory(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getPC() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getQuantum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int[] getRegisters() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EProcessState run(IProcess arg0) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setMemory(int arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPC(int arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setQuantum(int arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setRegisters(int[] arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
