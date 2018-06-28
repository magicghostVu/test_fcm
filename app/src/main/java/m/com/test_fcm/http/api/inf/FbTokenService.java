package m.com.test_fcm.http.api.inf;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Fresher on 28/06/2018.
 */

public interface FbTokenService {

    @POST("/update-token-firebase-uid")
    Call<ResponseBody> postTokenAndUid(@Body Map<String, Object> tokenUid);

}
