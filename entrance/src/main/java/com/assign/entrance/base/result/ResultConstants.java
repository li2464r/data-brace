package com.assign.entrance.base.result;

/**
 * @author Administrator
 * @date 2022/4/14 0014 11:05
 */
public class ResultConstants {

    public enum RESULT {
        CODE("code", "code"),
        STATUS("status", "status"),
        MESSAGE("message", "message"),
        DATA("data", "data");

        private final String code;
        private final String name;

        RESULT(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    public enum RESULT_VALUE {
        SUCCESS("SUCCESS", "成功"),
        FAIL("FAIL", "失败");

        private final String code;
        private final String name;

        RESULT_VALUE(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

}
