package arouna.diary.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arouna.diary.app.BaseApplication;

/**
 * Created by SunQi on 2016/2/3.
 */
public abstract class BaseFragment  extends Fragment implements View.OnClickListener{


    /**
     * Fragment title
     */
    public String fragmentTitle;
    /**
     * 是否可见状态
     */
    protected boolean isVisible;
    /**
     * 标志位，View已经初始化完成。
     */
    protected boolean isPrepared;
    /**
     * 是否第一次加载
     */
    protected boolean isFirstLoad = true;
    protected  String TAG;
    protected View mContentView;
    protected ProgressDialog mLoadingDialog;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
            onUserVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected void onInvisible() {
    }
    /**
     * 要实现延迟加载Fragment内容,需要在 onCreateView
     * isPrepared = true;
     */
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || !isFirstLoad) {
            return;
        }
        isFirstLoad = false;
        initData();
    }


    /**
     * 设置View
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    /**
     * 设置监听
     */
    protected abstract void setListener();

    /**
     * 业务逻辑
     * @param savedInstanceState
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    /**
     * fragment可见的时候，处理网络数据
     */
    protected abstract void onUserVisible();
    protected <VT extends View> VT getViewById(@IdRes int id) {
        return (VT) mContentView.findViewById(id);
    }
    protected void setContentView(@LayoutRes int layoutResID) {
        mContentView = LayoutInflater.from(BaseApplication.getInstance()).inflate(layoutResID, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        isFirstLoad = true;
        isPrepared = true;

        if(mContentView==null){
            initView(savedInstanceState);
            lazyLoad();
            setListener();
            processLogic(savedInstanceState);
        }else {
            ViewGroup parent= (ViewGroup) mContentView.getParent();
            if(parent!=null){

                parent.removeView(mContentView);
            }
        }
        return  mContentView;
    }
}
