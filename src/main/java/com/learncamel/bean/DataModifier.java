package com.learncamel.bean;

import java.util.logging.Logger;

public class DataModifier {

    Logger log = Logger.getLogger(DataModifier.class.getName());

    public String map(String input) throws Exception {
        String newBody = null;
        try {
            newBody = input.replace(",", "*");
        } catch (RuntimeException e) {
            log.severe("RuntimeException: " + e);
            throw e;
        } catch (Exception e) {
            log.severe("Exception: " + e);
            throw e;
        }
        return newBody;
    }

    public String mapOnException(String input) throws ArrayIndexOutOfBoundsException, RuntimeException, Exception {
        String newBody = null;
        char charBody;
        try {
            newBody = input.replace(",", "*");
            charBody = newBody.toCharArray()[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            log.severe("ArrayIndexOutOfBoundsException: " + e);
            throw e;
        } catch (RuntimeException e) {
            log.severe("RuntimeException: " + e);
            throw e;
            //throw new ApplicationException(e.getMessage());
        } catch (Exception e) {
            log.severe("Exception: " + e);
            throw e;
        }
        return Character.toString(charBody);
    }
}
