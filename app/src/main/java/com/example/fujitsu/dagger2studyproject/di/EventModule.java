package com.example.fujitsu.dagger2studyproject.di;

import com.example.fujitsu.dagger2studyproject.AnalyticsManager;
import com.example.fujitsu.dagger2studyproject.EventHandler;
import com.example.fujitsu.dagger2studyproject.Logger;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;


/**Если нам необходимо от компонента получить несколько однотипных объектов, мы можем запросить их
 * сразу как Set.Рассмотрим на небольшом примере. Пусть у нас есть какое-то глобальное событие Event,
 * и мы хотим пропускать его через несколько обработчиков EventHandler. Для этого было бы удобно сразу
 * получать список обработчиков, а не собирать их по одному.Пусть у нас есть два обработчика
 * AnalyticsManager и Logger.И мы хотим получить их от даггера сразу в один Set<EventHandler>.
 Для этого мы в модуле используем аннотацию @intoSet для методов которые возвращают эти объекты,а
 в Activity описываем Set.При инджекте компонент создаст объекты AnalyticsManager и Logger и
 поместит в этот Set, т.к. они являются объектами типа EventHandler.*/
@Module
public class EventModule {

    @Provides
    @IntoSet
    EventHandler provideAnalyticsManager() {
        return new AnalyticsManager();
    }

    @Provides
    @IntoSet
    EventHandler provideLogger() {
        return new Logger();
    }
}