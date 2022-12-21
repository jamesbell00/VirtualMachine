
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import slu.rvm.*;

public class VMSingleTaskTest {

	public static void testSingleTask() throws Exception {
		
		// Program			Inputs				 Output	 Page size
		// ---------------  -------------------  ------  ---------
		// fibonacci.txt	fibonacci(12)		  144		16
		// summation1.txt	summation(5)		   15		16
		// summation2.txt	summation(5)		   15		16
		// product.txt		product(4, 5)		   20		16
		// factorial.txt	factorial(5)		  120		16
		// quotient1.txt	quotient(10, 2)		    5		16
		// quotient2.txt	quotient(9, 2)		    4		16
		// remainder1.txt	remainder(10, 2)		0		16
		// remainder2.txt	remainder(9, 2)			1		16
		// power.txt		power(2, 8)			  256		16
				
		try {

			IVirtualMachine virtualMachine = new VirtualMachine("rvm single-task demo");
			
			int process;

			process = virtualMachine.load("multiply 3 to 5.txt", "multiply(3,5)");
			virtualMachine.run(process);
	
			process = virtualMachine.load("VirtualMachine\\fibonacci 12.txt", "fibonacci(12)");
			virtualMachine.run(process);
			
			process = virtualMachine.load("VirtualMachine\\summation 1 to 5 add.txt", "summation(5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("VirtualMachine\\summation 1 to 5 sub.txt", "summation(5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("VirtualMachine\\product 4x5.txt", "product(4, 5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("VirtualMachine\\quotient 10 div 2.txt", "quotient(10,2)");		
			virtualMachine.run(process);
			
			process = virtualMachine.load("VirtualMachine\\quotient 9 div 2.txt", "quotient(9,2)");		
			virtualMachine.run(process);

			process = virtualMachine.load("VirtualMachine\\remainder 10 mod 2.txt", "remainder(10,2)");		
			virtualMachine.run(process);
			
			process = virtualMachine.load("VirtualMachine\\remainder 9 mod 2.txt", "remainder(9,2)");		
			virtualMachine.run(process);

			process = virtualMachine.load("VirtualMachine\\factorial 5.txt", "factorial(5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("VirtualMachine\\power 2 pow 8.txt", "power(2,8)");		
			virtualMachine.run(process);
			
			virtualMachine.dump();
			virtualMachine.halt();
			
			System.out.println("The RISC Virtual Machine in single-task mode ended successfully!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		

	}

	public static void testMultitasking() throws Exception { // this is the proof of concept and now we are going to simulate the rest of the processes
		try {
			// make a queue of processes and if the state is terminated then we remove it from the queue
			// if they are not terminated then we enqueue again until it is terminated

			// if we have 5 processes in a queue:
			// take the 1st process out of the queue and run it, then when it is preempted we run process 2 and enqueue process 1 again unless it is terminated
			// then we continue this until all states are terminated 
			Queue<Integer> qu = new LinkedList<>();
			

			IVirtualMachine virtualMachine = new VirtualMachine("rvm multitask", 10); // if we do not set the quantum it is the same as the single task
				
			int process = virtualMachine.load("VirtualMachine\\fibonacci 12.txt", "fibonacci(12)"); // load one process 
			int process2 = virtualMachine.load("VirtualMachine\\summation 1 to 5 add.txt", "summation(5)");
			int process3 = virtualMachine.load("VirtualMachine\\summation 1 to 5 sub.txt", "summation(5)");	
			int process4 = virtualMachine.load("VirtualMachine\\product 4x5.txt", "product(4, 5)");		
			int process5 = virtualMachine.load("VirtualMachine\\quotient 10 div 2.txt", "quotient(10,2)");		
			int process6 = virtualMachine.load("VirtualMachine\\quotient 9 div 2.txt", "quotient(9,2)");		
			int process7 = virtualMachine.load("VirtualMachine\\remainder 10 mod 2.txt", "remainder(10,2)");		
			int process8 = virtualMachine.load("VirtualMachine\\remainder 9 mod 2.txt", "remainder(9,2)");		
			int process9 = virtualMachine.load("VirtualMachine\\factorial 5.txt", "factorial(5)");		
			int process10 = virtualMachine.load("VirtualMachine\\power 2 pow 8.txt", "power(2,8)");		
			
			qu.add(process);
			qu.add(process2);
			qu.add(process3);
			qu.add(process4);
			qu.add(process5);
			qu.add(process6);
			qu.add(process7);
			qu.add(process8);
			qu.add(process9);
			qu.add(process10);
			for(Iterator<Integer> ind = qu.iterator(); ind.hasNext(); ){
				Integer currentProcess = ind.next();
				System.out.println("Current process value: "+currentProcess);
				while (virtualMachine.getProcessState(currentProcess) != EProcessState.TERMINATED) { // this runs the process until the process is terminated
					virtualMachine.run(currentProcess); // we just run it here
				}
			}

			virtualMachine.dump();
			virtualMachine.halt();
			
			System.out.println("The RISC Virtual Machine in multitask mode ended successfully!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	public static void createSchedule(Map<Integer, List<Integer>> map){
		ArrayList<Integer> sortKeys = new ArrayList<Integer>(map.keySet());

		Collections.sort(sortKeys);

	// Getting value for each key and displaying
	// results.
		for (Integer x : sortKeys)
			System.out.println("Key = " + x + ", Value = " + map.get(x));
	}

	public static void priorityScheduling () throws Exception{
		try {
			VirtualMachine virtualMachine = new VirtualMachine("priorityScheduling"); // if we do not set the quantum it is the same as the single task
			
			int process = virtualMachine.load("VirtualMachine\\fibonacci 12.txt", "fibonacci(12)"); // load one process 
			int process2 = virtualMachine.load("VirtualMachine\\summation 1 to 5 add.txt", "summation(5)");
			int process3 = virtualMachine.load("VirtualMachine\\summation 1 to 5 sub.txt", "summation(5)");	
			int process4 = virtualMachine.load("VirtualMachine\\product 4x5.txt", "product(4, 5)");		
			int process5 = virtualMachine.load("VirtualMachine\\quotient 10 div 2.txt", "quotient(10,2)");		
			int process6 = virtualMachine.load("VirtualMachine\\quotient 9 div 2.txt", "quotient(9,2)");		
			int process7 = virtualMachine.load("VirtualMachine\\remainder 10 mod 2.txt", "remainder(10,2)");		
			int process8 = virtualMachine.load("VirtualMachine\\remainder 9 mod 2.txt", "remainder(9,2)");		
			int process9 = virtualMachine.load("VirtualMachine\\factorial 5.txt", "factorial(5)");		
			int process10 = virtualMachine.load("VirtualMachine\\power 2 pow 8.txt", "power(2,8)");		
			int process11 = virtualMachine.load("VirtualMachine\\multiply 3 to 5.txt", "multiply(3,5)");		
			int process12 = virtualMachine.load("VirtualMachine\\modulus_10_mod_2.txt", "modulus");		
			
			Process [] processTable = virtualMachine.getProcessTable();
			Map<Integer, List<Integer>> priority = new HashMap<>();
			System.out.println(processTable[0].getID());
			List<Integer> processIndexes;
			// the bound of this for loop must match the amount of processes to be run
			// these bounds are tricky because the process table length is always 12 
			// this adds the indexes to the value of the corresponding time bracket map, this is so that we do not have to create a new list as the value
			// each time we add a key value pair
			for(int i = 0; i < 12; i++){
				int currentProcessSize = processTable[i].getProcessSize();
				
				if(priority.containsKey(currentProcessSize)){
					processIndexes = priority.get(currentProcessSize);
					processIndexes.add(processTable[i].getID());
				}
				else{
					processIndexes = new ArrayList<>();
					processIndexes.add(processTable[i].getID());
					priority.put(currentProcessSize, processIndexes);
				}
			}
			createSchedule(priority);
			System.out.println(priority);

			for(Entry<Integer, List<Integer>> entry : priority.entrySet()){
				Integer processSizeBracket = entry.getKey();
				List<Integer> processesToRun = entry.getValue();
				for(Iterator<Integer> in = processesToRun.iterator(); in.hasNext(); ){
					Integer currentProcess = in.next();
					while (virtualMachine.getProcessState(currentProcess) != EProcessState.TERMINATED) { // this runs the process until the process is terminated
						// printing order of stuff running
						System.out.println("\n NEW PROCESS "+ currentProcess+ " Bracket: "+processSizeBracket);
						virtualMachine.run(currentProcess); // we just run it here
					}
				}
			}

			virtualMachine.dump();
			virtualMachine.halt();
			
			System.out.println("The RISC Virtual Machine in Priority Scheduling mode ended successfully!");

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// testSingleTask();
		// testMultitasking();
		priorityScheduling();
	}

	// we need to write another program in assembly or something and them implement another two and implement the round robin multi tasking 

	
}
