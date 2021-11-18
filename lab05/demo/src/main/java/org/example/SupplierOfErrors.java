package org.example;
@FunctionalInterface
public interface SupplierOfErrors {
    void execute() throws Exception;
}