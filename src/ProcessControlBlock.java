import slu.rvm.IProcessControlBlock;

public class ProcessControlBlock implements IProcessControlBlock {

    int pc;
    int[] registers;

    @Override
    public int getPC() {
        return pc;
    }

    @Override
    public int[] getRegisters() {
        return registers;
    }
    
}
