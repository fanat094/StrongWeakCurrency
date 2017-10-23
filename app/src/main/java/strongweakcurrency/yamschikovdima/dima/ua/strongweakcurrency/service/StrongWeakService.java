package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;

import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.MainActivity;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.R;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.presenter.Presenter;

public class StrongWeakService extends IntentService {

    private static final String TAG = StrongWeakService.class.getName();
    private static final int POLL_INTERVAL = 5000 * 60; // 5 хв (інтервал зверення до данних)

    public static Intent newIntent(Context context) {
        return new Intent(context, StrongWeakService.class);
    }

    public StrongWeakService() {
        super(TAG);
    }
    @Override
    protected void onHandleIntent(Intent intent) {

        addNotification(); //засуск сповіщення

        if (!isNetworkAvailableAndConnected()) { //перевірка мереєі Інтернет
            return;
        }
    }

    private boolean isNetworkAvailableAndConnected() { //процедура перевірка мереєі Інтернет
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        boolean isNetworkAvailable = cm.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvailable &&
                cm.getActiveNetworkInfo().isConnected();
        return isNetworkConnected;
    }

    public static void setServiceAlarm(Context context, boolean isOn) { //процедура повторення сервісу
        Intent i = StrongWeakService.newIntent(context);
        PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
        AlarmManager alarmManager = (AlarmManager)
                context.getSystemService(Context.ALARM_SERVICE);
        if (isOn) {

            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime()+POLL_INTERVAL, POLL_INTERVAL, pi);

        } else {
            alarmManager.cancel(pi);
            pi.cancel();
        }

    }

    private void addNotification() { //процедура сповіщення
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_strongweak)
                        .setContentTitle(getString(R.string.notificationstrongwegtitle))
                        .setSound(Uri.EMPTY)
                        .setAutoCancel(true)
                        .setContentText(getString(R.string.otificationstrongweakcontent));

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // додавання сповіщення
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

        new Presenter().M15_graph_service(); //запуск процедури запиту даних дл діаграми і запису даних в SharedPrefence
        new Presenter().H1_graph_service();
        new Presenter().H4_graph_service();
        new Presenter().D1_graph_service();
        new Presenter().SymbolIndex_graph_service();
    }
}
