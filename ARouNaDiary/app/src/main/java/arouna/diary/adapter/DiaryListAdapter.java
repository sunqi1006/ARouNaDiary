package arouna.diary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import arouna.diary.R;
import arouna.diary.bean.DiaryListBean;

/**
 * Created by SunQi on 2016/2/3.
 */
public class DiaryListAdapter extends BaseAdapter {



    private List<DiaryListBean> list;

    private Context context;

   private LayoutInflater inflater;
    public DiaryListAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public List<DiaryListBean> getList() {
        return list;
    }

    public void setList(List<DiaryListBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {

        if(list!=null){

            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder mHolder;

        if(convertView==null){

            mHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_diary_list,null);
            mHolder.tv_content= (TextView) convertView.findViewById(R.id.tv_content);
            mHolder.tv_date= (TextView) convertView.findViewById(R.id.tv_date);
            mHolder.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(mHolder);


        }else {

            mHolder= (ViewHolder) convertView.getTag();
        }


        mHolder.tv_title.setText(list.get(position).getTitle());
        mHolder.tv_content.setText(list.get(position).getContent());
        mHolder.tv_date.setText(list.get(position).getDate());
        return convertView;
    }


    class ViewHolder{

        private TextView tv_title;
        private TextView tv_date;
        private TextView tv_content;

    }
}
