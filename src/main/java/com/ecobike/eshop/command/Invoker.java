package com.ecobike.eshop.command;

public interface Invoker<K, V> {

    void setCommand(K key, V value);

    void invokeCommand(K key);
}
