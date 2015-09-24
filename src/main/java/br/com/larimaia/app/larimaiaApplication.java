package br.com.larimaia.app;


import br.com.larimaia.rest.ClienteResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Usuario on 23/09/2015.
 */
public class larimaiaApplication extends Application {
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ClienteResource.class);
        return classes;
    }
}
