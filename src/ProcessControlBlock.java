import slu.rvm.IProcessControlBlock;

public class ProcessControlBlock implements IProcessControlBlock {
	private int [] registers;
	private int pc;
	
	public ProcessControlBlock(int [] registers, int pc) {
		this.registers = registers.clone();
		this.pc = pc;
	}
	
	public int [] getRegisters() {
		return this.registers;
	}
	
	public int getPC() {
		return this.pc;
	}
}
