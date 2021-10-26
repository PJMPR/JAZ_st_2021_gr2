package org.example.observators;

@FunctionalInterface
public interface Subscriber {

    default void execute(int number){};
    void execute2(int number);
}
