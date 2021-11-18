package org.example.functions;

import org.example.supplier.BasicSupplier;

public class Waiting {

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean redo(BasicSupplier method, int times) {
        if (times > 0) {
            System.out.println("Attempts left: "+times);
            try {
                method.execute();
                return true;
            } catch (Exception error) {
                wait(2);
                redo(method, times-1 );
            }
        }
        return false;
    }

}
