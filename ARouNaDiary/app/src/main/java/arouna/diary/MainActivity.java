package arouna.diary;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import arouna.diary.app.BaseActivity;
import arouna.diary.ui.fragment.CommunityFragment;
import arouna.diary.ui.fragment.DiscoverFragment;
import arouna.diary.ui.fragment.HomeFragment;
import arouna.diary.ui.fragment.MessageFragment;
import arouna.diary.ui.fragment.MineFragment;

public class MainActivity extends BaseActivity {




    private ImageView img_home,img_discover,img_community,img_message,img_mine;
    private FrameLayout mFrameLayout;
    private FragmentManager mFragmentmanager;
    private HomeFragment mHomeFragment;
    private DiscoverFragment mDiscoverFragment;
    private CommunityFragment mCommunityFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected void findViews() {

        mFrameLayout=getView(R.id.mFrameLayout);
        img_home=getView(R.id.img_home);
        img_discover=getView(R.id.img_discover);
        img_community=getView(R.id.img_community);
        img_message=getView(R.id.img_message);
        img_mine=getView(R.id.img_mine);



    }
    @Override
    protected void setListener() {
        img_home.setOnClickListener(this);
        img_discover.setOnClickListener(this);
        img_community.setOnClickListener(this);
        img_message.setOnClickListener(this);
        img_mine.setOnClickListener(this);
    }

    @Override
    protected void setViews() {



        mFragmentmanager=getSupportFragmentManager();
        selectFragment(0);
    }

    private void selectFragment(int index) {

        FragmentTransaction mTransaction=mFragmentmanager.beginTransaction();

        hideFragment(mTransaction);

        switch (index){

            case 0:



                if(mHomeFragment==null){

                    mHomeFragment=new HomeFragment();
                    mTransaction.add(R.id.mFrameLayout,mHomeFragment);
                }else {

                    mTransaction.show(mHomeFragment);
                }
                break;

            case 1:
                if(mDiscoverFragment==null){

                    mDiscoverFragment=new DiscoverFragment();
                    mTransaction.add(R.id.mFrameLayout,mDiscoverFragment);
                }else {

                    mTransaction.show(mDiscoverFragment);
                }
                break;

            case 2:
                if(mCommunityFragment==null){

                    mCommunityFragment=new CommunityFragment();
                    mTransaction.add(R.id.mFrameLayout,mCommunityFragment);
                }else {

                    mTransaction.show(mCommunityFragment);
                }
                break;

            case 3:
                if(mMessageFragment==null){

                    mMessageFragment=new MessageFragment();
                    mTransaction.add(R.id.mFrameLayout,mMessageFragment);
                }else {

                    mTransaction.show(mMessageFragment);
                }

                break;

            case 4:
                if(mMineFragment==null){

                    mMineFragment=new MineFragment();
                    mTransaction.add(R.id.mFrameLayout,mMineFragment);
                }else {

                    mTransaction.show(mMineFragment);
                }
                break;
        }

        mTransaction.commit();

    }

    private void hideFragment(FragmentTransaction mTransaction) {

        if(mHomeFragment!=null){

            mTransaction.hide(mHomeFragment);
        }
        if(mDiscoverFragment!=null){

            mTransaction.hide(mDiscoverFragment);
        }
        if(mCommunityFragment!=null){

            mTransaction.hide(mCommunityFragment);
        }
        if(mMessageFragment!=null){

            mTransaction.hide(mMessageFragment);
        }
        if(mMineFragment!=null){

            mTransaction.hide(mMineFragment);
        }



    }


    @Override
    public void onClick(View v) {


        resetImg();
        switch (v.getId()){


            case R.id.img_home:

                selectFragment(0);

                img_home.setImageResource(R.mipmap.s3_plaza2);

                break;

            case R.id.img_discover:

                selectFragment(1);
                img_discover.setImageResource(R.mipmap.sns_discover2);
                break;

            case R.id.img_community:


                selectFragment(2);

                break;

            case R.id.img_message:

                selectFragment(3);

                img_message.setImageResource(R.mipmap.s3_feed2);

                break;

            case R.id.img_mine:



                selectFragment(4);

                img_mine.setImageResource(R.mipmap.s3_mine2);

                break;
        }

    }



    private void  resetImg(){

        img_home.setImageResource(R.mipmap.s3_plaza);
        img_discover.setImageResource(R.mipmap.sns_discover1);
        img_message.setImageResource(R.mipmap.s3_feed);
        img_mine.setImageResource(R.mipmap.s3_mine);
    }
}
