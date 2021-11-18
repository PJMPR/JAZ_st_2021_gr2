package org.example;

public interface HandlerOfErrors {
    String getMessage();
    boolean canHandle(Exception e);
    boolean handle(Exception e, SupplierOfErrors method);
    void log();

}
