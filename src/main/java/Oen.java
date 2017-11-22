import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Oen {

    public static void main(String[] args) {
        OenScheduler scheduler = new OenScheduler();
        int currentTime = 0;
        String[][] input = {
//                {"1","P1","0","8","1"},
//                {"2","P2","0","4","1"},
//                {"3","P3","2","3","2"},
//                {"4","P4","3","1","1"}

//                {"1","P1","0","8","1"},
//                {"2","P2","1","4","1"},
//                {"3","P3","2","3","2"}
                {"1","P1","2","11","1"},
                {"2","P2","2","11","2"},
                {"3","P3","2","11","3"},
                {"4","P3","2","1","0"}
        };
        ArrayList<Task> tasks = getTasks(input);
        Task runningTask = null;
        int from = 0;

        while (!allFinished(tasks)){
            for(Task task : tasks){
                if(task.getStartTime() == currentTime){
                    scheduler.addTask(task);
                }
            }
            Task currentTask = scheduler.schedule();
            if(currentTask != runningTask){
                if(runningTask != null){
//                    System.out.println("Task" + runningTask.getJobName() + " run from " + from + " to " + currentTime);
                    runningTask.setRunningTimes("" + from + "-" + currentTime);
                    if(runningTask.isFinished()){
                        System.out.println(runningTask.toString());
                    }
                }

                runningTask = currentTask;
                from = currentTime;
            }


            if(currentTask != null){
                currentTask.run(1);
//                System.out.println("task" + currentTask.getJobName() + "run from " + currentTime + " to " + (currentTime + 1));
                if(currentTask.isFinished()){
                    scheduler.removeTask(currentTask);
                }
            }

            currentTime ++;
        }

        runningTask.setRunningTimes("" + from + "-" + currentTime);
//        System.out.println("Task" + runningTask.getJobName() + " run from " + from + " to " + currentTime);
        System.out.println(runningTask.toString());

    }

    public static boolean allFinished(ArrayList<Task> tasks){
        for(Task task : tasks){
            if(!task.isFinished())
                return false;
        }
        return true;
    }

    public static ArrayList<Task> getTasks(String[][] input){
        ArrayList<Task> tasks = new ArrayList<Task>();
        for(int i = 0; i < input.length; i++){
            tasks.add(new Task(Integer.parseInt(input[i][0]),input[i][1],Integer.parseInt(input[i][2]),Integer.parseInt(input[i][3]),Integer.parseInt(input[i][4])));
        }
        return tasks;
    }
}
