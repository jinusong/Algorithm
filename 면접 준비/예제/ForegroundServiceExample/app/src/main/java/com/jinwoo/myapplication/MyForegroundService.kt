package com.jinwoo.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import java.util.*

class MyForegroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificationIntent = Intent(this, ForegroundServiceActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        val builder: NotificationCompat.Builder

        // 안드로이드 O 버전 이상에서부터는 채널 ID를 지정해주어야 합니다.
        builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(
                NotificationChannel("Test", "Test", NotificationManager.IMPORTANCE_DEFAULT)
            )

            NotificationCompat.Builder(this, "Test")
        } else {
            NotificationCompat.Builder(this)
        }

        val notification = builder
            .setContentTitle("Title")
            .setContentText("Body")
            .setContentIntent(pendingIntent)
            .build()

        // startForeground()에 지정하는 정수 ID는 0이면 안됩니다.
        startForeground(1, notification)

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}