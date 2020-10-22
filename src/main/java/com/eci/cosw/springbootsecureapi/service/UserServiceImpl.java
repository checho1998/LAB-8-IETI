package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add(
                new User( "test@mail.com", "password", "Andres", "Perez" ) );
        users.add( new User( "sergio@hotmail.com", "0000", "Sergio", "Nuñez" ) );
    }


    @Override
    public List<User> getUsers() { return users; }

    @Override
    public User getUser( String mail, String contra )
    {
        User usu = null;
        for(User us: users){
            if(us.getEmail().equals(mail) && us.getPassword().equals(contra)){
                usu = us;
            }
        }
        return usu;
    }

    @Override
    public User createUser( User user )
    {
        return users.get( 0 );
    }

    @Override
    public User findUserByEmail( String email )
    {
        return users.get( 0 );
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        return users.get( 0 );
    }

}
