package com.example.fujitsu.dagger2studyproject.di;

import android.database.DatabaseUtils;

import com.example.fujitsu.dagger2studyproject.ApplicationDatabase;
import com.example.fujitsu.dagger2studyproject.DatabaseHelper;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем. А аннотация
 *  @Provides указывает, что метод является поставщиком объекта и компонент может использовать
 *  его, чтобы получить объект. */
@Module
public class StorageModule {

    @Provides
    DatabaseHelper provideDatabaseHelper() {
        return new DatabaseHelper();
    }


    /**Модуль создает два объекта одного типа. При компиляции такого кода даггер выдаст ошибку,
     * т.к. не сможет определить какой из двух методов ему использовать для создания объекта
     * ApplicationDatabase. Аннотация Named решает эту проблему.В аннотации указываем любой текст,
     * соответствующий создаваемому объекту. Теперь для компонента это два разных объекта, хоть и
     * одного типа. И когда вам потребуется этот объект, вам необходимо будет указать компоненту,
     * который из них вам нужен */

    //@Named("prod")
    @DatabaseProd
    @Provides
    public ApplicationDatabase provideDatabaseUtils() {
        return new ApplicationDatabase("database.db");
    }

    //@Named("test")
    @DatabaseTest
    @Provides
    public ApplicationDatabase provideDatabaseUtilsTest() {
        return new ApplicationDatabase("test.db");
    }

}