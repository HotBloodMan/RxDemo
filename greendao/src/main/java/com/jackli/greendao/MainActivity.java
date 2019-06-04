package com.jackli.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jackli.greendao.test.HistoryDataDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_find)
    Button btnFind;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_insert)
    Button btnInsert;
    HistoryDataDao historyDataDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         historyDataDao = MyApplication.getmDaoSession().getHistoryDataDao();
    }

    @OnClick({R.id.btn_insert,R.id.btn_delete,R.id.btn_find})
    public void doClick(View v){

        Log.d("TAG","doClick");
        switch (v.getId()){
            case R.id.btn_insert:
                historyDataDao.insert(new HistoryData("A","data1"));
                break;
            case R.id.btn_delete:
                historyDataDao.delete(new HistoryData());
                break;
            case R.id.btn_find:
                List<HistoryData> historyData = historyDataDao.loadAll();
                if(historyData.size()<=0){
                    Log.d("TAG","doClick data null");
                }
                for(int i=0;i<historyData.size();i++){
                    String date = historyData.get(i).getDate();
                    if(date!=null){
                        Log.d("TAG","doClick date="+date);
                    }else{
                        Log.d("TAG","doClick null");
                    }
                }
                break;
        }

    }

}
