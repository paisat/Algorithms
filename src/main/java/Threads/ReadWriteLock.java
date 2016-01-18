package Threads;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 27/12/15.
 * <p/>
 * <p/>
 * ========= Reentrance Lock ===========
 * <p/>
 * Synchronized blocks in Java are reentrant.
 * This means, that if a Java thread enters a synchronized block of code, and thereby take the lock on the monitor object the block is synchronized on,
 * the thread can enter other Java code blocks synchronized on the same monitor object.
 * <p/>
 * <p/>
 * Simple Lock :
 * <p/>
 * Readers get access if there are no writers writing and there are no pending write requests
 * Writers get access if there are no current readers reading and there are no writers writing.
 * <p/>
 * <p/>
 * ============ Read Re entrance ======================
 * <p/>
 * if a thread has a read lock it can get reentrance regardless of the number of write requests.
 * <p/>
 * ========== Write Reentrance ==============
 * <p/>
 * Write re entrance is given if the thread already has write access
 * <p/>
 * <p/>
 * ======== Read to write re-entrance =========
 * <p/>
 * A reader can be granted write access if its the only reader
 * <p/>
 * <p/>
 * ======= Write to read reentrance ============
 * <p/>
 * if thread is a writing thread it should be granted read access
 */

public class ReadWriteLock {

    private Map<Thread, Integer> readingThreads =
            new HashMap<Thread, Integer>();

    private int writeAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;


    public synchronized void lockRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (!canGrantReadAccess(callingThread)) {
            wait();
        }

        readingThreads.put(callingThread,
                (getReadAccessCount(callingThread) + 1));
    }

    private boolean canGrantReadAccess(Thread callingThread) {
        if (isWriter(callingThread)) return true;
        if (hasWriter()) return false;
        if (isReader(callingThread)) return true;
        if (hasWriteRequests()) return false;
        return true;
    }


    public synchronized void unlockRead() {
        Thread callingThread = Thread.currentThread();
        if (!isReader(callingThread)) {
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold a read lock on this ReadWriteLock");
        }
        int accessCount = getReadAccessCount(callingThread);
        if (accessCount == 1) {
            readingThreads.remove(callingThread);
        } else {
            readingThreads.put(callingThread, (accessCount - 1));
        }
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        Thread callingThread = Thread.currentThread();
        while (!canGrantWriteAccess(callingThread)) {
            wait();
        }
        writeRequests--;
        writeAccesses++;
        writingThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException {
        if (!isWriter(Thread.currentThread()) ){
            throw new IllegalMonitorStateException("Calling Thread does not" +
                    " hold the write lock on this ReadWriteLock");
        }
        writeAccesses--;
        if (writeAccesses == 0) {
            writingThread = null;
        }
        notifyAll();
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if (isOnlyReader(callingThread)) return true;
        if (hasReaders()) return false;
        if (writingThread == null) return true;
        if (!isWriter(callingThread)) return false;
        return true;
    }


    private int getReadAccessCount(Thread callingThread) {
        Integer accessCount = readingThreads.get(callingThread);
        if (accessCount == null) return 0;
        return accessCount.intValue();
    }


    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }

    private boolean isReader(Thread callingThread) {
        return readingThreads.get(callingThread) != null;
    }

    private boolean isOnlyReader(Thread callingThread) {
        return readingThreads.size() == 1 &&
                readingThreads.get(callingThread) != null;
    }

    private boolean hasWriter() {
        return writingThread != null;
    }

    private boolean isWriter(Thread callingThread) {
        return writingThread == callingThread;
    }

    private boolean hasWriteRequests() {
        return this.writeRequests > 0;
    }

}
