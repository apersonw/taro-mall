package org.rxjava.common.bus;

/**
 * @author happy 2019-06-04 10:30
 * 接收者
 */
public interface BusReceiver {
    void receiveMessage(BusEvent busEvent);
}
