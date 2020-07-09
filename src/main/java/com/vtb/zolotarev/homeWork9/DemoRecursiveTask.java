package com.vtb.zolotarev.homeWork9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DemoRecursiveTask extends RecursiveTask<Integer> {
    private Integer[] data;

    public DemoRecursiveTask(Integer[] data) {
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if (this.data.length > 25_000_000) {
            List<DemoRecursiveTask> subtasks = createSubtasks();
            for (DemoRecursiveTask subtask : subtasks) {
                subtask.fork();
            }
            int maxValue = Integer.MIN_VALUE;
            for (DemoRecursiveTask subtask : subtasks) {

                int result = subtask.join();

                if (result > maxValue) {
                    maxValue = result;
                }
            }
            return maxValue;
        } else {
            return Arrays.stream(data).max(Comparator.comparingInt(o -> o)).get();
        }
    }

    private List<DemoRecursiveTask> createSubtasks() {
        return new ArrayList<>(Arrays.asList(
                new DemoRecursiveTask(Arrays.copyOfRange(data, 0, data.length / 2)),
                new DemoRecursiveTask(Arrays.copyOfRange(data, data.length / 2, data.length))
        ));
    }
}
