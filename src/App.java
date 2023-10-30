import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {

    public static void main(String[] args)  {

        new BaseUrl();
        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BaseUrl.getUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        System.out.println("Requesting data please wait...");
        UsersApi usersApi = retrofit.create(UsersApi.class);
        
        Call<List<Users>> userRequest = usersApi.getUsers();
        userRequest.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                
                if(!response.isSuccessful()){
                    System.out.println("Code: " + response.code());
                    return;
                }
                try {

                    Configuration configuration = HibernateConfig.configureHibernate();
                    SessionFactory sessionFactory = configuration.buildSessionFactory();
                    Session session = sessionFactory.openSession();
                    Transaction transaction = session.beginTransaction();
                   
                    List<Users> users = response.body();
                    for (Users usersList : users){
                        session.persist(usersList);
                    }
                    
                    transaction.commit();
                    session.close();
                    System.out.println("Data saved successfully");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}



