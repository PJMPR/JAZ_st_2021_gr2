package org.example;

public class Actions {

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean redo(Provider method, int times) {
        if (times > 0) {
            System.out.println("Attempts left: "+times);
            try {
                method.execute();
                return true;
            } catch (Exception err) {
                wait(2);
                redo(method, times-1 );
            }
        }
        return false;
    }

}