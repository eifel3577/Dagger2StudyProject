package com.example.fujitsu.dagger2studyproject;

import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.fujitsu.dagger2studyproject.di.DatabaseProd;
import com.example.fujitsu.dagger2studyproject.di.DatabaseTest;

import java.util.Set;
import java.util.Timer;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";


    /**Аннотациями @Inject мы помечаем поля, которые компонент должен заполнить. При вызове метода
     *  injectsMainActivity компонент вытащит из модулей объекты DatabaseHelper и NetworkUtils
     *  и поместит их в поля MainActivity */
    //@Inject
    //DatabaseHelper databaseHelper;

    //@Inject
    //NetworkUtils networkUtils;

    //@Named("prod")
    @DatabaseProd
    @Inject
    ApplicationDatabase mDatabaseUtils;

    //@Named("test")
    @DatabaseTest
    @Inject
    ApplicationDatabase mDatabaseUtilsTest;

    @Inject
    Set<EventHandler> eventHandlers;

    /**При запуске приложения объекты будут созданы даггером */
    //DatabaseHelper databaseHelper;
    //NetworkUtils networkUtils;

    /**При вызове injectsMainActivity компонент не будет создавать объект NetworkUtils. Вместо
     * этого он вернет нам провайдер. Когда нам понадобится объект NetworkUtils мы вызываем у
     * провайдера метод get. Только в этот момент провайдер создает и возвращает этот объект. Все
     * последующие вызовы get будут возвращать один и тот же объект. */
    //@Inject
    //Lazy<NetworkUtils> mNetworkUtilsProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseHelper = App.getComponent().getDatabaseHelper();
        //networkUtils = App.getComponent().getNetworkUtils();
        App.getComponent().injectsMainActivity(this);

        Log.d(TAG,"mDatabaseUtils is null? "+String.valueOf(mDatabaseUtils==null));

        Log.d(TAG,"mDatabaseUtilsTest is null? "+String.valueOf(mDatabaseUtilsTest==null));

        Log.d(TAG,"set size = "+String.valueOf(eventHandlers.size()));
        if(eventHandlers.iterator().hasNext()){
            Log.d(TAG,"class =  "+String.valueOf(eventHandlers.iterator().next().getClass()));
        }

    }


}
