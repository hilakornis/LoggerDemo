package com.mgroup.loggerdemo;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.mgroup.mgaa.MGLog;
public final class MGLog {

    private static final String regrexLegalVariableAndFunctionNames = "[a-zA-Z<][a-zA-Z0-9_>]";
    private static final String regexCaptureUntilFirstOpenBracket = "[\\s\\S]*?(?=\\([\\w\\W])";
    private static final String regexClassAndFunctionName = regrexLegalVariableAndFunctionNames +"*."+ regrexLegalVariableAndFunctionNames +"*$";
    private static final String regrexFunctionName = "(?<=((\\.))).*";
    private static final String regrexClassName = regrexLegalVariableAndFunctionNames +"*?(?=\\.)";

    private static Configuration configuration = new Configuration();

    public MGLog(Configuration configuration) {
        this.configuration = configuration;
    }

    public MGLog() {
    }

    public static class Configuration {
        protected boolean isPrintAsLogRegularOn = false;
        protected int level_in_stack_trace = 4;
        protected String delimiter = " ";

        public Configuration(boolean isPrintAsLogRegularOn, int level_in_stack_trace, String delimiter) {
            this.isPrintAsLogRegularOn = isPrintAsLogRegularOn;
            this.level_in_stack_trace = level_in_stack_trace;
            this.delimiter = delimiter;
        }

        public Configuration() {
        }

        public Configuration(boolean isPrintAsLogRegularOn) {
            this.isPrintAsLogRegularOn = isPrintAsLogRegularOn;
        }

        public Configuration(int level_in_stack_trace) {
            this.level_in_stack_trace = level_in_stack_trace;
        }

        public Configuration(String delimiter) {
            this.delimiter = delimiter;
        }


        public Configuration(boolean isPrintAsLogRegularOn, int level_in_stack_trace) {
            this.isPrintAsLogRegularOn = isPrintAsLogRegularOn;
            this.level_in_stack_trace = level_in_stack_trace;
        }

        public Configuration(int level_in_stack_trace, String delimiter) {
            this.level_in_stack_trace = level_in_stack_trace;
            this.delimiter = delimiter;
        }

        public Configuration(boolean isPrintAsLogRegularOn, String delimiter) {
            this.isPrintAsLogRegularOn = isPrintAsLogRegularOn;
            this.delimiter = delimiter;
        }
    }

    public static void  setConfiguration(Configuration configuration1){
        configuration = configuration1;
    }

    private static String getStringWithRegrex(String regrexPattern, String input) {
        String res = "";
        Pattern pattern = Pattern.compile(regrexPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String foundString = matcher.group(0);
            res = foundString;
        }

        //            assert (!Objects.equals(res, ""));

        return res;
    }

    private static String printClassAndFunctionName() {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String lineToParse = ste[configuration.level_in_stack_trace].toString();




        String lineNoBrackets = getStringWithRegrex(regexCaptureUntilFirstOpenBracket, lineToParse);
        String lineOnlyFunctionAndClassName = getStringWithRegrex(regexClassAndFunctionName, lineNoBrackets);
        String onlyFunctionName = getStringWithRegrex(regrexFunctionName, lineOnlyFunctionAndClassName);
        String onlyClassName = getStringWithRegrex(regrexClassName, lineOnlyFunctionAndClassName);

        return "[" + onlyClassName +configuration.delimiter+ ":" + MGLog.configuration.delimiter + onlyFunctionName + "]";
    }

    public static void d(String TAG, String msg) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.d(TAG, msgToPrint);
    }
    public static void i(String TAG, String msg) {
        String s = TAG + MGLog.configuration.delimiter + ":" + MGLog.configuration.delimiter + printClassAndFunctionName();

        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.i(TAG, msgToPrint);
    }
    public static void v(String TAG, String msg) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.v(TAG, msgToPrint);
    }
    public static void e(String TAG, String msg) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.e(TAG, msgToPrint);
    }
    public static void w(String TAG, String msg) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.w(TAG, msgToPrint);
    }
    public static void wtf(String TAG, String msg) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }
        Log.wtf(TAG, msgToPrint);
    }

    public static void d(String TAG, String msg, Throwable throwable) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.d(TAG, msgToPrint, throwable);
    }
    public static void i(String TAG, String msg, Throwable throwable) {
        String s = TAG + MGLog.configuration.delimiter + ":" + MGLog.configuration.delimiter + printClassAndFunctionName();

        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.i(TAG, msgToPrint, throwable);
    }
    public static void v(String TAG, String msg, Throwable throwable) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.v(TAG, msgToPrint, throwable);
    }
    public static void e(String TAG, String msg, Throwable throwable) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.e(TAG, msgToPrint, throwable);
    }
    public static void w(String TAG, String msg, Throwable throwable) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }

        Log.w(TAG, msgToPrint, throwable);
    }
    public static void wtf(String TAG, String msg, Throwable throwable) {
        String msgToPrint = "";
        if(!MGLog.configuration.isPrintAsLogRegularOn){
            msgToPrint = printClassAndFunctionName() + MGLog.configuration.delimiter + msg;
        }
        else {
            msgToPrint = msg;
        }
        Log.wtf(TAG, msgToPrint, throwable);
    }




}
