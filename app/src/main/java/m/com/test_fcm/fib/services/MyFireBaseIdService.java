package m.com.test_fcm.fib.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.HashMap;
import java.util.Map;

import m.com.test_fcm.http.api.inf.FbTokenService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fresher on 28/06/2018.
 */

public class MyFireBaseIdService extends FirebaseInstanceIdService implements Callback<String> {


    private String TAG = "MyFireBaseIdService";


    @Override
    public void onFailure(Call<String> call, Throwable t) {

    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        Log.d(TAG, response.body());
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        //todo: lấy token rồi gửi lên server


        String url = "http://192.168.1.126:8080/update-token-uid/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        FbTokenService fbTokenService = retrofit.create(FbTokenService.class);


        Map<String, Object> dataPost = new HashMap<>();


        dataPost.put("token", refreshedToken);

        dataPost.put("uid", 1235435);


        Call<ResponseBody> res = fbTokenService.postTokenAndUid(dataPost);

        //res.


        try {
            Response<ResponseBody> _res = res.execute();

            Log.d(TAG, _res.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
