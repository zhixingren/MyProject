package com.mysummary.myproject.android_basis.rxjava2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.rxjava2.bean.Person;
import com.mysummary.myproject.android_basis.rxjava2.bean.Plan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/*
    很好的rxjava文档：
    https://juejin.im/post/5b17560e6fb9a01e2862246f#heading-84
 */
public class Rxjava2Activity extends AppCompatActivity {


    private String TAG = "Rxjava2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);
        demo1();

    }


    private void demo1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                e.onNext(1);
//                Log.e(TAG, "subscribe: .e" + Thread.currentThread().getName());
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "数字 --- " + integer);
                        Log.e(TAG, "subscribe: .e" + Thread.currentThread().getName());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    //如果用map处理
    public void mapAsflagMap() {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("za", new ArrayList<Plan>()));

        Observable.fromIterable(personList)
                .map(new Function<Person, List<Plan>>() {
                    @Override
                    public List<Plan> apply(Person person) throws Exception {
                        return person.getPlanList();
                    }
                })
                .subscribe(new Observer<List<Plan>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Plan> plans) {
                        for (Plan plan : plans) {
                            List<String> planActionList = plan.getActionList();
                            for (String action : planActionList) {
                                Log.d(TAG, "==================action " + action);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void flagMap() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("za", new ArrayList<Plan>()));

        Observable.fromIterable(personList).flatMap(new Function<Person, ObservableSource<Plan>>() {
            @Override
            public ObservableSource<Plan> apply(Person person) throws Exception {

                return Observable.fromIterable(person.getPlanList());
            }
        }).flatMap(new Function<Plan, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Plan plan) throws Exception {

                return Observable.fromIterable(plan.getActionList());
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void fromCallable() {
        //fromCallable 把返回结果返回给观察者
        Observable.fromCallable(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "================accept " + integer);
            }
        });

    }

    public void just() {

        //fromArray
//        Integer array[] = {1, 2, 3, 4};
//        Observable.fromArray(array).subscribe(new );

        //just
        Observable.just(1, 2, 3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


}
