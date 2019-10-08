package similar.data;

import javafx.animation.Animation;
import similar.core.Activity;

import java.util.Objects;

public class Navigation {

    private Intent intent;

    private Animation in;
    private Animation out;

    private Activity current;

    private Navigation(Activity activity){
        current=activity;
    }

    public static Navigation from(Activity activity){
        Objects.requireNonNull(activity);
        return new Navigation(activity);
    }



    public Navigation inAnim(Animation in){
        this.in=in;
        return this;
    }

    public Navigation outAnim(Animation out){
        this.out=out;
        return this;
    }

    public void go(Class<? extends Activity> activity){
        current.startActivity(Activity.ACTIVITY_STANDARD, new Intent(current,activity));
    }

    public void goSingleTask(Class<? extends Activity> activity){
        current.startActivity(Activity.ACTIVITY_SINGLE_TASK, new Intent(current,activity));
    }

    public void goSingleTop(Class<? extends Activity> activity){
        current.startActivity(Activity.ACTIVITY_SINGLE_TOP, new Intent(current,activity));
    }
}