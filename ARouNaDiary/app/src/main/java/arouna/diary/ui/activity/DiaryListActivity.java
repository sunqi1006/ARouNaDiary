package arouna.diary.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import arouna.diary.R;
import arouna.diary.adapter.DiaryListAdapter;
import arouna.diary.app.BaseActivity;
import arouna.diary.bean.DiaryListBean;
import arouna.diary.view.titlebar.BGATitlebar;

/**
 * Created by SunQi on 2016/2/3.
 */
public class DiaryListActivity extends BaseActivity {


   private ListView mListView;
    private DiaryListAdapter mAdapter;
    private BGATitlebar mTitleBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<DiaryListBean> listData;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_diary_list;
    }

    @Override
    protected void findViews() {

        mSwipeRefreshLayout=getView(R.id.mSwipeRefreshLayout);
        mListView=getView(R.id.mListView);
        mTitleBar=getView(R.id.mTitleBar);
    }

    @Override
    protected void setViews() {

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.main_color));
        mAdapter=new DiaryListAdapter(DiaryListActivity.this);


        mTitleBar.setDelegate(new BGATitlebar.BGATitlebarDelegate(){

            @Override
            public void onClickLeftCtv() {
                super.onClickLeftCtv();

                finish();
            }
        });


        initData();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }


    private void initData(){
        listData=new ArrayList<>();


        for (int i=0;i<10;i++){
            DiaryListBean diaryListBean=new DiaryListBean();
            diaryListBean.setTitle("还有两天回家");
            diaryListBean.setContent("今天星期三");
            diaryListBean.setDate("2016-02-03");
            listData.add(diaryListBean);

        }


        mAdapter.setList(listData);

        mListView.setAdapter(mAdapter);

    }
}
