import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/12.
 */
public class Task {

    private int id;
    private String jobName;
    private int time;
    private int priority;
    private int remainingTime;
    private int startTime;
    private boolean isFinished = false;
    private ArrayList<String> runningTimes = new ArrayList<String>();

    @Override
    public String toString() {
        String lastTime = Integer.parseInt(runningTimes.get(runningTimes.size() - 1).split("-")[1]) - startTime + "";
        String str = "";
        for(String s : runningTimes)
            str = str + " " + s;
        return  id + " " +
                jobName + " " +
                startTime + " " +
                time + " " +
                priority + " " +
                lastTime + " " +
                str;
    }

    public void setRunningTimes(String fromTo){
        runningTimes.add(fromTo);
    }

    public Task(int id, String jobName, int startTime,int time, int priority) {
        this.id = id;
        this.jobName = jobName;
        this.startTime = startTime;
        this.time = time;
        this.priority = priority;
        this.remainingTime = time;
    }

    public boolean isFinished(){
        return remainingTime == 0;
    }

    public void run(int time){
        remainingTime = remainingTime - time > 0 ? remainingTime - time : 0;
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
