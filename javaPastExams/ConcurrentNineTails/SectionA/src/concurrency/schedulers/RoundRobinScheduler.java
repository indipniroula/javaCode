package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;

import java.util.Set;

import static java.util.Collections.min;

public class RoundRobinScheduler implements Scheduler {

    private boolean isFirstChoice = true;
    private int lastThreadId;


    @Override
    public int chooseThread(ConcurrentProgram program) throws DeadlockException {
        if (program.getEnabledThreadIds().size() == 0) {
            throw new DeadlockException();
        }

        if (isFirstChoice) {
            isFirstChoice = false;
            return min(program.getEnabledThreadIds());
        } else {
            Set<Integer> enabledIds = program.getEnabledThreadIds();
            int result = 0;
            for (Integer i: enabledIds) {
                if (i > lastThreadId) {
                    result = i;
                }
            }
            if (result == 0) {
                return min(enabledIds);
            } else {
                lastThreadId = result;
                return result;
            }

        }




    }
}
