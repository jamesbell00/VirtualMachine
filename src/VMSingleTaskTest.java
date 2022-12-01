
import slu.rvm.*;

public class VMSingleTaskTest {

	public static void main(String[] args) {
		
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
	
			process = virtualMachine.load("fibonacci 12.txt", "fibonacci(12)");
			virtualMachine.run(process);
			
			process = virtualMachine.load("summation 1 to 5 add.txt", "summation(5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("summation 1 to 5 sub.txt", "summation(5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("product 4x5.txt", "product(4, 5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("quotient 10 div 2.txt", "quotient(10,2)");		
			virtualMachine.run(process);
			
			process = virtualMachine.load("quotient 9 div 2.txt", "quotient(9,2)");		
			virtualMachine.run(process);

			process = virtualMachine.load("remainder 10 mod 2.txt", "remainder(10,2)");		
			virtualMachine.run(process);
			
			process = virtualMachine.load("remainder 9 mod 2.txt", "remainder(9,2)");		
			virtualMachine.run(process);

			process = virtualMachine.load("factorial 5.txt", "factorial(5)");		
			virtualMachine.run(process);

			process = virtualMachine.load("power 2 pow 8.txt", "power(2,8)");		
			virtualMachine.run(process);
			
			virtualMachine.dump();
			virtualMachine.halt();
			
			System.out.println("The RISC Virtual Machine in single-task mode ended successfully!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
