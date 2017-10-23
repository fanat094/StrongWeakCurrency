package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.api;

import android.app.Application;
import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    static APIClient strongweakApi;
    private Retrofit retrofit;

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://34.197.213.118:20019/") //Базовая частина адреси
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необхідний для для перетвореняня JSON'а в обєкти
                .client(httpClient.build())
                .build();
        strongweakApi = retrofit.create(APIClient.class); // Объект, за допомогою якого киконуються запити
    }

    public static APIClient getApi() {
        return strongweakApi;
    }
}
