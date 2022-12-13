import slu.rvm.*;

public class Process implements IProcess {
	private int id;
	private String name;
	private EProcessState state;
	private IAddressSpace addressSpace;
	private IProcessControlBlock pcb;
	private int processSize;
		
	public Process(int id, String name, IAddressSpace addressSpace) {
		this.id = id;
		this.name = name;
		this.state = EProcessState.NEW;
		this.addressSpace = addressSpace;
		this.pcb = new ProcessControlBlock(new int[CentralProcessingUnit.REGISTERS], this.addressSpace.getBaseAddress());
		this.processSize = 0;
	}
	
	public int getID() {
		return this.id;
	}

	public int getProcessSize(){
		return this.processSize;
	}

	public String getName() {
		return this.name;
	}

	public EProcessState getState() {
		return this.state;
	}
	
	public void setState(EProcessState state) {
		this.state = state;
	}
	
	public IProcessControlBlock getPCB() {
		return this.pcb;
	}

	public void setPCB(IProcessControlBlock pcb) {
		this.pcb = pcb;
	}
	
	public int getBaseAddress() {
		return this.addressSpace.getBaseAddress();
	}

	public int getLimitAddress() {
		return this.addressSpace.getLimitAddress();
	}

	public void setProcessSize(int size){
		this.processSize = size;
	}
}


