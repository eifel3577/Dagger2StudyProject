package com.example.fujitsu.dagger2studyproject.di;

import com.example.fujitsu.dagger2studyproject.NetworkUtils;

import dagger.Module;
import dagger.Provides;

/**Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем. А аннотация
 *  @Provides указывает, что метод является поставщиком объекта и компонент может использовать
 *  его, чтобы получить объект. */
@Module
public class NetworkModule {

    @Provides
    NetworkUtils provideNetworkUtils() {
        return new NetworkUtils();
    }



}