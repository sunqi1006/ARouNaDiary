package arouna.diary.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import arouna.diary.R;
import arouna.diary.app.AppManager;
import arouna.diary.ui.BaseFragment;
import arouna.diary.ui.activity.DiaryListActivity;

/**
 * Created by SunQi on 2016/2/3.
 */
public class HomeFragment extends BaseFragment {



    private LinearLayout ll_mydiary;

    @Override
    protected void initView(Bundle savedInstanceState) {

        setContentView(R.layout.fragment_home);

        ll_mydiary=getViewById(R.id.ll_mydiary);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

        ll_mydiary.setOnClickListener(this);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.ll_mydiary:

                AppManager.getAppManager().startNextActivity(getActivity(), DiaryListActivity.class);
                break;

        }
    }
}
