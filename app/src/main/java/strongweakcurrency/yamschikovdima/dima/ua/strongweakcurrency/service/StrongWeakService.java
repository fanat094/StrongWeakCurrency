package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.MainActivity;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.R;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.presenter.Presenter;

public class StrongWeakService extends IntentService {

    private static final String TAG = "StrongWeakService";
    private static final int POLL_INTERVAL = 5000 * 60; // 60 секунд1

    public static Intent newIntent(Context context) {
        return new Intent(context, StrongWeakService.class);
    }

    public StrongWeakService() {
        super(TAG);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Received an intent: " + intent);

        new Presenter().M15_graph_service();
        addNotification();

        if (!isNetworkAvailableAndConnected()) {
            return;
        }
    }

    private boolean isNetworkAvailableAndConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        boolean isNetworkAvailable = cm.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvailable &&
                cm.getActiveNetworkInfo().isConnected();
        return isNetworkConnected;
    }

    public static void setServiceAlarm(Context context, boolean isOn) {
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

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_strongweak)
                        .setContentTitle("New StrongWeak data")
                        .setSound(Uri.EMPTY)
                        .setLights(Color.BLUE, 3000, 3000)
                        .setAutoCancel(true)
                        .setContentText("Refresh data every five minutes");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
