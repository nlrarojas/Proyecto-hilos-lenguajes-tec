package core;

/**
 *
 * @author nelson
 */
public class SynchronizedBuffer implements Buffer {

    public Figure figure;
    
    @Override
    public synchronized void set(int value) {

    }

    @Override
    public synchronized Figure get() {
        return figure;
    }
}
