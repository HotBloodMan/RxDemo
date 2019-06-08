package com.jackli.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jackli.greendao.test.CreditCardDao;
import com.jackli.greendao.test.StudentDao;

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
//    HistoryDataDao historyDataDao;
    StudentDao studentDao;
    CreditCardDao creditCardDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//         historyDataDao = MyApplication.getmDaoSession().getHistoryDataDao();
      studentDao = MyApplication.getmDaoSession().getStudentDao();
      creditCardDao = MyApplication.getmDaoSession().getCreditCardDao();
    }

    @OnClick({R.id.btn_insert,R.id.btn_delete,R.id.btn_find})
    public void doClick(View v){

        Log.d("TAG","doClick");
        switch (v.getId()){
            case R.id.btn_insert:
//                historyDataDao.insert(new HistoryData("A","data1"));
                Student student = new Student();
                student.setStudentNo(2);
                student.setAge(11);
                student.setName("lisi2");
                studentDao.insert(student);
//                for(int i=0;i<10;i++){
                    CreditCard creditCard = new CreditCard();
                    creditCard.setCardNum(11+"");
                    creditCard.setUserName("lisi2");
                    creditCardDao.insert(creditCard);
//                }

                break;
            case R.id.btn_delete:
//                historyDataDao.delete(new HistoryData());
                break;
            case R.id.btn_find:
//                List<Student> students = studentDao.loadAll();
//                List<CreditCard> creditCards = creditCardDao._queryStudent_CardList(2l);
//                Log.d("TAG","doClick creditCards="+creditCards.get(0).getCardNum()+":"+creditCards.get(0).getUserName()+":"+creditCards.get(0).getCardNum());
//                for(int i=0;i<students.size();i++){
//                    Log.d("TAG","doClick load="+students.get(i).toString());
//                }
                List<Student> list = studentDao.queryBuilder().where(StudentDao.Properties.StudentNo.eq("2")).list();
                Log.d("TAG"," list= "+list.size());


//                List<HistoryData> historyData = historyDataDao.loadAll();
//                if(historyData.size()<=0){
//                    Log.d("TAG","doClick data null");
//                }
//                for(int i=0;i<historyData.size();i++){
//                    String date = historyData.get(i).getDate();
//                    if(date!=null){
//                        Log.d("TAG","doClick date="+date);
//                    }else{
//                        Log.d("TAG","doClick null");
//                    }
//                }
                break;
        }

    }

}
