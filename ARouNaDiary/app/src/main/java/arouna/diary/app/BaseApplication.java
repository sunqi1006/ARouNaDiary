package arouna.diary.app;

import android.app.Application;

/**
 * Created by SunQi on 2016/2/3.
 */
public class BaseApplication extends Application{

    private static BaseApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();

        instance=this;
    }

    public static BaseApplication getInstance() {

        return instance;
    }

}
