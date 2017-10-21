package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.api;

import retrofit2.Call;
import retrofit2.http.GET;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.GetStrongWeakCurrencyModel;

public interface APIClient {

    @GET("fxservice/strongweak")
    Call<GetStrongWeakCurrencyModel> getStrongWeakCurrencyModel();

}