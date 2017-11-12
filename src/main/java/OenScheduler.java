import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12.
 */
public class OenScheduler {
    ArrayList<Task> tasks = new ArrayList<Task>();

    public Task schedule(){
        int minTime = Integer.MAX_VALUE,maxPriority = 0,maxPriorityIndex = 0;
        ArrayList<Integer> minTimeIndexs = new ArrayList<Integer>();
        if(tasks.isEmpty())
            return null;

        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getRemainingTime() < minTime){
                minTime = tasks.get(i).getRemainingTime();
                minTimeIndexs.clear();
                minTimeIndexs.add(i);
            }else if(tasks.get(i).getRemainingTime() == minTime){
                minTimeIndexs.add(i);
            }
        }

        for(int i : minTimeIndexs){
            if(tasks.get(i).getPriority() > maxPriority){
                maxPriorityIndex = i;
                maxPriority = tasks.get(i).getPriority();
            }
        }
        return tasks.get(maxPriorityIndex);
    }


    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }
}
