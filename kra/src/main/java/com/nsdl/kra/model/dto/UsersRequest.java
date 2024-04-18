package com.nsdl.kra.model.dto;

import lombok.Data;

@Data
public class UsersRequest {
    private String id;
    private String userName;
    private Long groupId;
    private String status;
    private Long miId;

    public boolean validateRequest() {
        if ((this.id != null && !this.id.isEmpty() && this.userName != null && !this.userName.isEmpty())
                || (this.userName != null && !this.userName.isEmpty()) || (this.id != null && !this.id.isEmpty())) {
            return false;
        }
        return true;
    }

}
