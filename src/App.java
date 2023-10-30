import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class app {
   
    public static void main(String[] args)  {
        //start retrofit
        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseurl.geturl())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        System.out.println("Requesting data please wait...");
        service apiservice = retrofit.create(service.class);

        Call<List<users>> userRequest = apiservice.getUsers();
        userRequest.enqueue(new Callback<List<users>>() {
            @Override
            public void onResponse(Call<List<users>> call, Response<List<users>> response) {
                
                if(!response.isSuccessful()){
                    System.out.println("Code: " + response.code());
                    return;
                }
                
                List<users> users = response.body();
                for (users usersList : users){
                    model.save(usersList);
                }
                System.out.println("Data inserted successfully");

            }

            @Override
            public void onFailure(Call<List<users>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}



