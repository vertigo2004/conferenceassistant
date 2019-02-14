package ifit.cluster.cassistant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {

    private static Logger log = LoggerFactory.getLogger(LoggerDemo.class);

    public static void main(String[] args) {

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warning");
        log.error("error");
    }
}
