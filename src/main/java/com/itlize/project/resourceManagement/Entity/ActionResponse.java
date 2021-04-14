package com.itlize.project.resourceManagement.Entity;

import java.util.List;

public class ActionResponse {

        private Boolean success;
        private String message;
        private List<?> errorList;
        public ActionResponse(){ }
        public ActionResponse(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

    public ActionResponse(Boolean success, String message, List<?> list) {
        this.success = success;
        this.message = message;
        this.errorList = list;
    }
        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    public List<?> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<?> errorList) {
        this.errorList = errorList;
    }
}
