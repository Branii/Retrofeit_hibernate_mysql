public class test {
    
         Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://example.com/dev/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

        UsersApi usersApi = retrofit.create(UsersApi.class);
        
        Call<List<UserClass>> userRequest = usersApi.getUsers(30);
        userRequest.enqueue(new Callback<List<UserClass>>() {
            @Override
            public void onResponse(Call<List<UserClass>> call, Response<List<UserClass>> response) {
                
                if(!response.isSuccessful()){
                    System.out.println("Code: " + response.code());
                    return;
                }
                List<UserClass> users = response.body();
                System.out.println("\n-------------------------------");
                for(UserClass user:users){
                    System.out.println("UserId: " + user.getUserid() +
                     "\nFirstname: " + user.getFirstname() +
                     "\nLastname: " + user.getLastname() + 
                     "\nEmail: " + user.getEmail() + 
                     "\nMobile: " + user.getMobile() + "\n-------------------------------");
                }
            }

            @Override
            public void onFailure(Call<List<UserClass>> call, Throwable t) {
                System.out.println("Error => " + t.getMessage());
            }
        });
    }


    