package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rams0516
 *         Date: 1/24/2018
 *         Time: 11:42 AM
 */
public class ActivitySelection {

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(0,6));
        activities.add(new Activity(3,4));
        activities.add(new Activity(1,2));
        activities.add(new Activity(5,9));
        activities.add(new Activity(5,7));
        activities.add(new Activity(8,9));

        /* Sort Activity list based on the value of finish time*/
        Collections.sort(activities, ((o1, o2) -> o1.getFinish() - o2.getFinish()));

        activitySelection(activities);
    }

    static void activitySelection(List<Activity> activities) {
        System.out.println("The sorted list of activity map");
        for(Activity activity : activities) {
            System.out.println(activity.getStart()+"->"+activity.getFinish());
        }
        int i = 0;
        System.out.println("The activities selected are as below");

        /* First activity is always selected by default*/
        System.out.println(activities.get(0).getStart()+"->"+activities.get(0).getFinish());

        /* If the start time of the current activity is greater than equal to the previous activity, then eligible*/
        for(int j = 1 ; j < activities.size() ; j++) {
            if(activities.get(j).start >= activities.get(i).finish) {
                System.out.println(activities.get(j).getStart()+"->"+activities.get(j).getFinish());
                i++;
            }
        }
    }
}

/**
 * Activity blue print with values of start and finish time
 */
class Activity {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }
}