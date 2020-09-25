package com.playground;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandling {
    /**
     * Iterate through each line of input.
     */
    private static String processInput(String input) {

        Map<String, Severity> mapping = new HashMap<>();
        mapping.put("IOException", new Severity(100,"High"));
        mapping.put("MemoryException", new Severity(110,"High"));
        mapping.put("ThreadAbortException", new Severity(200,"Medium"));
        mapping.put("ResponseTimeoutException", new Severity(300,"Low"));
        mapping.put("ParameterException", new Severity(301,"Low"));

        String[] inputArray = input.split("\\|");
        String exception = inputArray[0];
        String message = inputArray[1];


        return mapping.get(exception).getSeverity()+"|"+ mapping.get(exception).getCode()+"|"+message;
    }

    static class Severity {
        Integer code;
        String severity;
        public Severity(Integer code, String severity) {
            this.code = code;
            this.severity = severity;
        }

        public Integer getCode() {
            return code;
        }
        public String getSeverity() {
            return severity;
        }
    }

    public static void main(String[] args) {
        System.out.println(processInput("IOException|The file requested does not exist"));

    }
}