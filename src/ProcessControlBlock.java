import slu.rvm.IProcessControlBlock;

public class ProcessControlBlock implements IProcessControlBlock {

    private int[] registers;
    private int pc;

    public ProcessControlBlock(int[] registers, int pc) {
        this.registers = registers;
        this.pc = pc;
    }

    @Override
    public int getPC() {

        return this.pc;
    }

    @Override
    public int[] getRegisters() {

        return this.registers;
    }

}
