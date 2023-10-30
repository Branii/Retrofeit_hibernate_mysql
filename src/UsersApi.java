import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi {
    
    @GET("users")
    Call<List<Users>> getUsers();

}
