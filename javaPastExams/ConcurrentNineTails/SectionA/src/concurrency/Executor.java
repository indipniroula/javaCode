package concurrency;

import java.util.LinkedList;
import java.util.List;

import concurrency.schedulers.Scheduler;

public class Executor {

	private ConcurrentProgram program;
	private Scheduler scheduler;

	public Executor(ConcurrentProgram program, Scheduler scheduler) {
		this.program = program;
		this.scheduler = scheduler;
	}

	/**
	 * Executes program with respect to scheduler
	 *
	 * @return the final state and history of execution
	 */
	public String execute() {
		List<Integer> history = new LinkedList<>();
		boolean deadlockOccurred = false;

		// TODO: Add code here to complete Question 3

		StringBuilder result = new StringBuilder();
		result.append("Final state: " + program + "\n");
		result.append("History: " + history + "\n");
		result.append("Termination status: "
				+ (deadlockOccurred ? "deadlock" : "graceful") + "\n");
		return result.toString();
	}

	// An incorrect attempt at overriding the equals method
	// of Object
	public boolean equals(Executor that) {
		return program.toString() == that.program.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Executor)) {
			return false;
		}

		Executor other = (Executor) obj;
		return (program.toString().equals(other.program.toString()));
	}

	@Override
	public int hashCode() {
		return program.toString().hashCode();
	}

	
}
