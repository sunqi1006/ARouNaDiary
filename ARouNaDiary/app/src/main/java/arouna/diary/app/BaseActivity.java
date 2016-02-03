package arouna.diary.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by SunQi on 2016/2/3.
 */
public abstract class BaseActivity  extends AppCompatActivity implements View.OnClickListener {




    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        beforeSetContentView();
        if (getContentViewId() != 0) {
            setContentView(getContentViewId());
        }
        findViews();
        setListener();
        setViews();

    }
    /**
     * 在setContentView之前触发的方法
     */
    protected void beforeSetContentView() {

    }

    /**
     * 如果没有布局，那么就返回0
     *
     * @return activity的布局文件
     */
    protected abstract int getContentViewId();
    protected abstract void findViews();

    protected abstract void setViews();



    /**
     * 通过泛型来简化findViewById
     */
    protected final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }
    protected abstract void setListener();
}
