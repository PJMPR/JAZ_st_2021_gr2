package org.example.errors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class InternetConnectionLost implements ErrorHandler {
    private Logger logger = LogManager.getLogger(getClass().getSimpleName());
    @Override
    public String errorMessage() {
        return "Internet connection lost!";
    }

    @Override
    public boolean tryDoIt() {
        try
        {
            Socket s = new Socket("gdansk.pja.edu.pl/pl/",80);
            DataOutputStream os = new DataOutputStream(s.getOutputStream());
            DataInputStream is = new DataInputStream(s.getInputStream());
            while (true)
            {
                os.writeBytes("GET /index.html HTTP/1.0\n\n");
                is.available();
                Thread.sleep(1000);
            }

        }
        catch (IOException | InterruptedException e)
        {
            return false;
        }

    }

    @Override
    public void fix() {
        if (!tryDoIt()) {
            System.out.println(errorMessage());
            System.out.println("waiting 10seconds and trying again...");
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
             tryDoIt();
            logger.info(errorMessage());
        }

    }
}
