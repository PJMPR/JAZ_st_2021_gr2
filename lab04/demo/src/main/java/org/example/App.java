package org.example;

import org.example.caching.Cache;
import org.example.caching.loaders.DictionaryCacheLoader;
import org.example.model.Dictionary;

public class App {

    public static void main(String[] args){

        int number = 10;
        System.out.println(number);
        double d1 = number;
        System.out.println(d1);
        Double d = new SafeCaster().cast(number, Double.class);
        //if(d!=null)
        System.out.println(d);
        Object tst = "test";
        String s = new SafeCaster().cast(tst, String.class);
        System.out.println(s);
        new DictionaryCacheLoader().load();
        Dictionary object = Cache.getInstance().get("object",Dictionary.class);
        System.out.println(object.getId());

        Cache.getInstance().add("test","Test");
        Cache.getInstance().add("number",1);
        Cache.getInstance().add("object", new Dictionary(1,2, "3","4","5"));
    }
}

class SafeCaster{

    public <T,E> T cast(E obj, Class<T> clazz){

        T result = null;
        try{
            if(obj != null) result = clazz.cast(obj);
        return result;
        }

            catch (ClassCastException ex){
                //ex.printStackTrace();
            }
        return null;
    }

}