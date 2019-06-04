package com.jackli.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.reactivestreams.Subscription;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                initData();
                test();
            }
        });
    }

    private void initData() {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(10);
        items.add(100);
        items.add(1000);
        Observable<String> just = Observable.just(hello());

        PublishSubject<String> objectPublishSubject = PublishSubject.create();
        objectPublishSubject.subscribeActual(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("TAG","onSubscribe");
            }

            @Override
            public void onNext(String value) {
                Log.d("TAG","onNext");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG","onComplete");
            }
        });

    }

    public String hello(){
        return "hello";
    }

    public void test(){
       Observable.create(new ObservableOnSubscribe<Integer>() {
           @Override
           public void subscribe(ObservableEmitter<Integer> e) throws Exception {
             e.onNext(20);
             e.onComplete();
           }
       })
       .subscribeOn(Schedulers.io())
       .map(new Function<Integer, String>() {
           @Override
           public String apply(Integer integer) throws Exception {
               String result=integer+""+1;
               return result;
           }
       }).subscribe(new Consumer<String>() {
           @Override
           public void accept(String s) throws Exception {
               Log.d("TAG","accept s="+s);
           }
       });
    }

}