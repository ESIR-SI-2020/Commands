package user.json;

public class ModifyPasswordRequest {
    private String oldPassword;
    private String newPassword;

    public ModifyPasswordRequest(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
