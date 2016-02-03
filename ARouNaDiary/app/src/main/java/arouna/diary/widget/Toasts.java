package arouna.diary.widget;


import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

import arouna.diary.app.BaseApplication;


public class Toasts {


   public static Toast  toast;
    private Toasts() {
    }

    public static void show(CharSequence text) {
        if (text.length() < 10) {



            toast=Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {

            toast= Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }

    public static void show(@StringRes int resId) {
        show(BaseApplication.getInstance().getString(resId));
    }

}
