package m.com.test_fcm.fib.services;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Fresher on 28/06/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String data = remoteMessage.getNotification().getBody();

        Log.d("msgFromFirebase", data);
    }
}
