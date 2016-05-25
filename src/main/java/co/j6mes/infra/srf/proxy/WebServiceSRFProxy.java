package co.j6mes.infra.srf.proxy;


import co.j6mes.infra.srf.registration.ServiceRegistry;
import co.j6mes.infra.srf.registration.SimpleServiceRegistry;

import java.io.IOException;

/**
 * Created by james on 12/05/2016.
 */
public class WebServiceSRFProxy {
    public static void main(String[] args) throws IOException {
        ServiceRegistry sr = new SimpleServiceRegistry(args[0]);

        for(int i = 1; i<args.length; i+=3) {
            sr.register(args[i],"http",args[i+1],Integer.parseInt(args[i+2]));
        }

        sr.up();

        while(true) {
            try {
                Thread.sleep(10000000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
